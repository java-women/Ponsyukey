package javajo.ponsyukey.service;

import javajo.ponsyukey.database.dao.SakeDao;
import javajo.ponsyukey.model.Sake;
import javajo.ponsyukey.model.SakeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
酒情報取得に関するロジックをまとめたクラス
 */
@Service
public class SakeService {
    private final SakeDao sakeDao;

    @Autowired
    public SakeService(SakeDao sakeDao) {
        this.sakeDao = sakeDao;
    }

    public SakeResponse getSakeResponse(String sakeId) {



        return new SakeResponse().resultCode().sake();
    }
}
