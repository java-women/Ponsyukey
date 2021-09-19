package javajo.ponsyukey.database.dao;

import javajo.ponsyukey.database.entity.CountryEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface CountryDao {
    @Select
    CountryEntity selectById(String id);
}
