package javajo.ponsyukey.service;

import javajo.ponsyukey.database.dao.SakeDao;
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

    public SakeResponse getSakeResponse() {
        // こんな感じで使えますという雰囲気のサンプル↓ (改修時に消してください)
        sakeDao.selectById("29892458-f103-89d5-a724-72f789e16e3b");
        return new SakeResponse();
    }
}
