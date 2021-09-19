package javajo.ponsyukey.repository;

import javajo.ponsyukey.database.dao.BreweryDao;
import javajo.ponsyukey.database.dao.SakeDao;
import javajo.ponsyukey.database.entity.SakeBreweryEntity;
import javajo.ponsyukey.database.entity.SakeEntity;
import javajo.ponsyukey.model.Sake;
import javajo.ponsyukey.model.SakeBrewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SakeRepository {
    private final SakeDao sakeDao;
    private final BreweryDao breweryDao;

    @Autowired
    public SakeRepository(SakeDao sakeDao,
                          BreweryDao breweryDao
                          ) {
        this.sakeDao = sakeDao;
        this.breweryDao = breweryDao;
    }

    public Sake getSake(String sakeId){
        //酒情報を取得する
        SakeEntity sakeEntity = sakeDao.selectById(sakeId);

        //醸造所情報を取得する
        SakeBreweryEntity sakeBreweryEntity = breweryDao.selectById(sakeEntity.getBreweryId());

        //TODO teamB 当道府県情報を取得する

        SakeBrewery brewery = new SakeBrewery()
                .name(sakeBreweryEntity.getName())
                .prefecture(""); // TODO teamBからもらう

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
