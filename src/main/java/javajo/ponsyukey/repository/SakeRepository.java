package javajo.ponsyukey.repository;

import javajo.ponsyukey.database.dao.*;
import javajo.ponsyukey.database.entity.*;
import javajo.ponsyukey.database.dao.SakeDao;
import javajo.ponsyukey.dto.Sake;
import javajo.ponsyukey.dto.SakeBrewery;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class SakeRepository {
    private final SakeDao sakeDao;
    private final BreweryDao breweryDao;
    private final RegionDao regionDao;
    private final PrefectureDao prefectureDao;
    private final CountryDao countryDao;
    private final TasteDao tasteDao;
    private final TasteMapDao tasteMapDao;

    @Autowired
    public SakeRepository(SakeDao sakeDao,
                          BreweryDao breweryDao,
                          RegionDao regionDao,
                          PrefectureDao prefectureDao,
                          CountryDao countryDao,
                          TasteDao tasteDao,
                          TasteMapDao tasteMapDao
                          ) {
        this.sakeDao = sakeDao;
        this.breweryDao = breweryDao;
        this.regionDao = regionDao;
        this.prefectureDao = prefectureDao;
        this.countryDao = countryDao;
        this.tasteDao = tasteDao;
        this.tasteMapDao = tasteMapDao;
    }

    public Sake getSake(String sakeId){
        //酒情報を取得する
        SakeEntity sakeEntity = sakeDao.selectById(sakeId);

        // tasteを取得する
        List<String> taste = getTaste(sakeId);

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

        SakeBrewery sakeBrewery = new SakeBrewery(sakeBreweryEntity.getName(), name);
        return new Sake(sakeEntity.getId(),
                sakeEntity.getName(),
                sakeEntity.getImage().orElse(null),
                sakeBrewery,
                sakeEntity.getAlcohol().orElse(null),
                sakeEntity.getPolishingRatio().orElse(null),
                sakeEntity.getType().orElse(null),
                sakeEntity.getDescription().orElse(null),
                taste);
    }


    public List<Sake> getSakeList(int limit, int offset) {
        SelectOptions options = SelectOptions.get().limit(limit).offset(offset);
        List<SakeEntity> sakeEntities = sakeDao.selectAll(options);

        List<SakeBreweryEntity> sakeBreweryEntities = breweryDao.selectByIdList(
                sakeEntities.stream().map(SakeEntity::getId)
                        .distinct()
                        .collect(Collectors.toList())
        );

        // TODO: DomaでMapを返せるかもうちょっと調べる
        Map<Integer, RegionEntity> regionEntities = regionDao.selectAll().stream().collect(Collectors.toMap(RegionEntity::getId, regionEntity -> regionEntity));
        Map<Integer, PrefectureEntity> prefectureEntities = prefectureDao.selectAll().stream().collect(Collectors.toMap(PrefectureEntity::getId, prefectureEntity -> prefectureEntity));
        Map<Integer, CountryEntity> countryEntities = countryDao.selectAll().stream().collect(Collectors.toMap(CountryEntity::getId, countryEntity -> countryEntity));

        // TODO: IDをStringからUUIDに変更したい
        Map<String, SakeBrewery> breweries = sakeBreweryEntities.stream()
                .collect(Collectors.toMap(SakeBreweryEntity::getId, sakeBreweryEntity -> {
                    String name;
                    var regionEntity = regionEntities.get(sakeBreweryEntity.getRegionId());
                    if (regionEntity.getCountryId().equals("81")) {
                        PrefectureEntity prefectureEntity = prefectureEntities.get(regionEntity.getPrefectureId());
                        name = prefectureEntity.getName();
                    } else {
                        CountryEntity countryEntity = countryEntities.get(regionEntity.getCountryId());
                        name = countryEntity.getName();
                    }
                    return new SakeBrewery(sakeBreweryEntity.getName(), name);
                }));

        return sakeEntities.stream().map(sakeEntity ->
                new Sake(sakeEntity.getId(),
                        sakeEntity.getName(),
                        sakeEntity.getImage().orElse(null),
                        breweries.get(sakeEntity.getBreweryId()),
                        sakeEntity.getAlcohol().orElse(null),
                        sakeEntity.getPolishingRatio().orElse(null),
                        sakeEntity.getType().orElse(null),
                        sakeEntity.getDescription().orElse(null),
                        getTaste(sakeEntity.getId()))
        ).collect(Collectors.toList());
    }

    private List<String> getTaste(String sakeId) {
        // TODO: tasteいっぱい増えてきたら取り方再検討する
        List<TasteEntity> tasteEntities = tasteDao.selectAll();
        // taste map tableから酒IDに紐づくtasteIDを取得する
        List<String> tasteIds = tasteMapDao.selectTasteIdsBySakeId(sakeId);
        // taste map table の tasteId と taste table の tasteId を当てて taste word を取得して返却する
        return tasteEntities.stream()
                .filter(t -> tasteIds.contains(t.getId()))
                .map(TasteEntity::getValue)
                .toList();
    }
}
