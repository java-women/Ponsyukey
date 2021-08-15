package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class Prefecture {
    /** 都道府県ID(海外の場合は「海外(48)」を選択 */
    @Id
    Integer id;

    /** 都道府県名 */
    String name;
}
