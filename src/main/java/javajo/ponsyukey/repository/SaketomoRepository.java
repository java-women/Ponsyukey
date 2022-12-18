package javajo.ponsyukey.repository;

import javajo.ponsyukey.database.dao.*;
import javajo.ponsyukey.database.entity.*;
import javajo.ponsyukey.dto.CreateSaketomo;
import javajo.ponsyukey.model.SaketomoRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public class SaketomoRepository {

    private final SaketomoDao saketomoDao;

    @Autowired
    public SaketomoRepository(SaketomoDao saketomoDao) {
        this.saketomoDao = saketomoDao;
    }

    public SaketomoRequestResponse getSaketomo(String saketomoId){
        // TODO: Saketomo DTOに変更する
        //会員情報を取得する
        SaketomoEntity saketomoEntity = saketomoDao.selectById(saketomoId);

        //SaketomoEntityをSaketomoModelに変換する
        //TODO 空データ(null)の挙動についてあとで確認・修正
        return new SaketomoRequestResponse()
                .id(UUID.fromString(saketomoEntity.getId()))
                .name(saketomoEntity.getName())
                .image(SaketomoRequestResponse.ImageEnum.fromValue(saketomoEntity.getImage()));
    }

    public UUID insertSaketomo(CreateSaketomo createSaketomo) throws SQLException {
        UUID uuid = UUID.randomUUID();

        // TODO 2022/12/18 重複登録チェック validation を追加すること。
        SaketomoEntity saketomoEntity = new SaketomoEntity(
          uuid.toString(), // id
          createSaketomo.name(),
          createSaketomo.image(),
          createSaketomo.email(),
          createSaketomo.password(),
          LocalDateTime.now(), // createdAt
          LocalDateTime.now() // updatedAt
        );
        int result = saketomoDao.insert(saketomoEntity);
        if (result != 1) {
            throw new SQLException("SaketomoEntityの登録に失敗しました");
        }

        // uuid ⇒ id を返す
        return uuid;
    }

}
