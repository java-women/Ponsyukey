package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "prefecture")
public class PrefectureEntity {
    /** 都道府県ID(海外の場合は「海外(48)」を選択 */
    @Id
    Integer id;

    /** 都道府県名 */
    String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
