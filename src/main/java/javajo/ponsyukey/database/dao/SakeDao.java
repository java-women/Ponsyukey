package javajo.ponsyukey.database.dao;

import javajo.ponsyukey.database.entity.SakeEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import java.util.List;

@ConfigAutowireable
@Dao
public interface SakeDao {

    @Select
    SakeEntity selectById(String id);

    @Select
    List<SakeEntity> selectAll(SelectOptions options);
}
