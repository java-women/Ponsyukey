package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

/**
 * 国情報Entity
 */
@Entity
public class CountryEntity {

    /** 国ID */
    @Id
    Integer id;

    /** 国名 */
    String name;

}
