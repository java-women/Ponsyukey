package javajo.ponsyukey.service;

import javajo.ponsyukey.database.dao.SakeDao;
import javajo.ponsyukey.model.Sake;
import javajo.ponsyukey.model.SakeResponse;
import javajo.ponsyukey.repository.SakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
酒情報取得に関するロジックをまとめたクラス
 */
@Service
public class SakeService {
    private final SakeRepository sakeRepository;

    @Autowired
    public SakeService(SakeRepository sakeRepository) {
        this.sakeRepository = sakeRepository;
    }

    /**
     * 指定した酒IDに紐づくお酒詳細情報を取得する
     * @param sakeId 酒ID
     * @return お酒詳細情報一式
     */
    public SakeResponse getSakeResponse(String sakeId) {
        //酒IDに紐づく酒情報を取得する
        Sake sake = sakeRepository.getSake(sakeId);

        return new SakeResponse()
                .sake(sake);
    }
}
