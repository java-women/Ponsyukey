package javajo.ponsyukey.repository;

import javajo.ponsyukey.database.dao.*;
import javajo.ponsyukey.database.entity.*;
import javajo.ponsyukey.database.dao.SakeDao;
import javajo.ponsyukey.model.Sake;
import javajo.ponsyukey.model.SakeBrewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SakeRepository {
    private final SakeDao sakeDao;
    private final BreweryDao breweryDao;
    private final RegionDao regionDao;
    private final PrefectureDao prefectureDao;
    private final CountryDao countryDao;

    @Autowired
    public SakeRepository(SakeDao sakeDao,
                          BreweryDao breweryDao,
                          RegionDao regionDao,
                          PrefectureDao prefectureDao,
                          CountryDao countryDao
                          ) {
        this.sakeDao = sakeDao;
        this.breweryDao = breweryDao;
        this.regionDao = regionDao;
        this.prefectureDao = prefectureDao;
        this.countryDao = countryDao;
    }

    public Sake getSake(String sakeId){
        //酒情報を取得する
        SakeEntity sakeEntity = sakeDao.selectById(sakeId);

        //醸造所情報を取得する
        SakeBreweryEntity sakeBreweryEntity = breweryDao.selectById(sakeEntity.getBreweryId());

        //都道府県情報を取得する
        RegionEntity regionEntity = regionDao.selectById(sakeBreweryEntity.getRegionId());
        String name;
        if (regionEntity.getCountryId().equals("81")) { // 日本の場合
            PrefectureEntity prefectureEntity = prefectureDao.selectById(regionEntity.getPrefectureId());
            name = prefectureEntity.getName();
        } else {
            CountryEntity countryEntity = countryDao.selectById(regionEntity.getCountryId());
            name = countryEntity.getName();
        }

        SakeBrewery brewery = new SakeBrewery()
                .name(sakeBreweryEntity.getName())
                .prefecture(name);

        //SakeEntityをSakeModelに変換する
        //TODO 空データ(null)の挙動についてあとで確認・修正
        return new Sake()
                .id(UUID.fromString(sakeEntity.getId()))
                .name(sakeEntity.getName())
                .image(sakeEntity.getImage().orElse(null))
                .alcohol(sakeEntity.getAlcohol().orElse(null))
                .polishingRatio(sakeEntity.getPolishingRatio().orElse(null))
                .type(sakeEntity.getType().orElse(null))
                .description(sakeEntity.getDescription().orElse(null))
                .brewery(brewery);
    }
}
