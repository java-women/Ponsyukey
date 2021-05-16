package javajo.ponsyukey.service;

import javajo.ponsyukey.model.SakeResponse;
import org.springframework.stereotype.Service;

/*
酒情報取得に関するロジックをまとめたクラス
 */
@Service
public class SakeService {
    public SakeResponse getSakeResponse() {
        return new SakeResponse();
    }
}
