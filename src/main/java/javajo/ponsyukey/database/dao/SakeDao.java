package javajo.ponsyukey.database.dao;

import javajo.ponsyukey.database.entity.SakeEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface SakeDao {

    @Select
    SakeEntity selectById(String id);
}
