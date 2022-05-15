package javajo.ponsyukey.database.dao;

import javajo.ponsyukey.database.entity.RegionEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface RegionDao {

    @Select
    RegionEntity selectById(int id);

    @Select
    List<RegionEntity> selectAll();
}
