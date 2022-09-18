package javajo.ponsyukey.repository;

import javajo.ponsyukey.database.dao.*;
import javajo.ponsyukey.database.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SaketomoRepository {

    private final SaketomoDao saketomoDao;

    @Autowired
    public SaketomoRepository(SaketomoDao saketomoDao) {
        this.saketomoDao = saketomoDao;
    }

    public Saketomo getSaketomo(String saketomoId){
        //会員情報を取得する
        SaketomoEntity saketomoEntity = saketomoDao.selectById(saketomoId);

        //SaketomoEntityをSaketomoModelに変換する
        //TODO 空データ(null)の挙動についてあとで確認・修正
        return new Saketomo()
                .id(UUID.fromString(saketomoEntity.getId()))
                .name(saketomoEntity.getName())
                .image(Saketomo.ImageEnum.fromValue(saketomoEntity.getImage()));
    }

    public Saketomo insertSaketomo() {
        SaketomoEntity saketomoEntity = new SaketomoEntity();
        return new Saketomo();
    }

}
