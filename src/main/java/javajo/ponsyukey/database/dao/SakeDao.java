package javajo.ponsyukey.database.dao;

import javajo.ponsyukey.database.AppConfig;
import javajo.ponsyukey.database.entity.Sake;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

@Dao(config = AppConfig.class)
public interface SakeDao {

    @Select
    Sake selectById(String id);
}
