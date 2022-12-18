package javajo.ponsyukey.service;

import javajo.ponsyukey.dto.CreateSaketomo;
import javajo.ponsyukey.model.CreateSaketomoRequest;
import javajo.ponsyukey.model.SaketomoRequestResponse;
import javajo.ponsyukey.repository.SaketomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.UUID;

@Service
public class SaketomoService {

    private final SaketomoRepository saketomoRepository;

    @Autowired
    public SaketomoService(SaketomoRepository saketomoRepository) {
        this.saketomoRepository = saketomoRepository;
    }

    /**
     * 指定した会員IDに紐づく会員情報を取得する
     * @param saketomoId 会員ID
     * @return 会員情報一式
     */
    public SaketomoRequestResponse getSaketomoResponse(String saketomoId) {
        // 会員IDに紐づく会員情報を取得する
        return saketomoRepository.getSaketomo(saketomoId);
    }

    /**
     * 新しい会員情報を登録する
     * @param createSaketomoRequest 会員情報一式
     * @return 会員情報一式
     */
    public SaketomoRequestResponse createSaketomo(CreateSaketomoRequest createSaketomoRequest) {
        CreateSaketomo createSaketomo = new CreateSaketomo(
                createSaketomoRequest.getName(),
                createSaketomoRequest.getImage().getValue(),
                createSaketomoRequest.getAuth().getEmail(),
                createSaketomoRequest.getAuth().getPassword());

        UUID uuid;
        try {
            uuid = saketomoRepository.insertSaketomo(createSaketomo);
        } catch (SQLException exception)  {
            // TODO 2022/12/18 上層の Controller でエラーハンドリングする必要がある。
            throw new RuntimeException(exception);
        }

        SaketomoRequestResponse saketomo = new SaketomoRequestResponse();
        saketomo.id(uuid);
        saketomo.name(createSaketomo.name());
        saketomo.image(SaketomoRequestResponse.ImageEnum.fromValue(createSaketomo.image()));
        return saketomo;
    }
}
