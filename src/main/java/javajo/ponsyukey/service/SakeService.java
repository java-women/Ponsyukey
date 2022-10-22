package javajo.ponsyukey.service;

import javajo.ponsyukey.dto.Sake;
import javajo.ponsyukey.repository.SakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/*
酒情報取得に関するロジックをまとめたクラス
 */
@Service
public class SakeService {
    private static final int RESPONSE_LIMIT = 100;
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
        // 酒IDに紐づく酒情報を取得する
        Sake sake = sakeRepository.getSake(sakeId);
        SakeResponse sakeResponse = new SakeResponse();
        sakeResponse.id(UUID.fromString(sake.id()));
        sakeResponse.name(sake.name());
        sakeResponse.image(sake.image());

        SakeResponseBrewery sakeResponseBrewery = new SakeResponseBrewery();
        sakeResponseBrewery.name(sake.sakeBrewery().name());
        sakeResponseBrewery.prefecture(sake.sakeBrewery().prefecture());
        sakeResponse.brewery(sakeResponseBrewery);

        sakeResponse.alcohol(sake.alcohol());
        sakeResponse.polishingRatio(sake.polishingRatio());
        sakeResponse.type(sake.type());
        sakeResponse.description(sake.description());
        sakeResponse.taste(sake.taste());

        return sakeResponse;
    }

    /**
     * limit, offsetで指定した件数分の酒情報一覧を取得する
     * ただし返す酒情報には件数上限を設ける
     * @param limit
     * @param offset
     * @return 酒情報一覧
     */
    public SakeListResponse getSakeResponses(int limit, int offset){
        if (RESPONSE_LIMIT < limit) {
            limit = RESPONSE_LIMIT;
        }

        List<SakeResponse> sakeList = sakeRepository.getSakeList(limit, offset);
        return new SakeListResponse()
                .sakeList(sakeList)
                .totalCount(sakeList.size());
    }
}