package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 国情報Entity
 */
@Entity
@Table(name = "country")
public class CountryEntity {

    /** 国ID */
    @Id
    Integer id;

    /** 国名 */
    String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
