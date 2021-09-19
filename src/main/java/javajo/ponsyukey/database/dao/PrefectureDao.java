package javajo.ponsyukey.database.dao;

import javajo.ponsyukey.database.entity.PrefectureEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface PrefectureDao {
  @Select
    PrefectureEntity selectById(String id);
}
