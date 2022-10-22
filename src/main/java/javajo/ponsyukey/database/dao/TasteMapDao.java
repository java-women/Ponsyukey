package javajo.ponsyukey.database.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface TasteMapDao {
    @Select
    List<String> selectTasteIdsBySakeId(String sakeId);
}
