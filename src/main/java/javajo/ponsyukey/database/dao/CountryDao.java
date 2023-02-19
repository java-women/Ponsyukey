package javajo.ponsyukey.database.dao;

import javajo.ponsyukey.database.entity.CountryEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface CountryDao {
    @Select
    CountryEntity selectById(int id);

    @Select
    List<CountryEntity> selectAll();
}
