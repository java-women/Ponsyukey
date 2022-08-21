package javajo.ponsyukey.database.dao;

import javajo.ponsyukey.database.entity.SakeBreweryEntity;
import javajo.ponsyukey.database.entity.SakeEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface BreweryDao {

    @Select
    SakeBreweryEntity selectById(String id);
}
