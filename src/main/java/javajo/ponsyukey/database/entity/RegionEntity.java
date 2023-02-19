package javajo.ponsyukey.database.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 *  リージョンEntity
 */
@Entity
@Table(name = "region")
public class RegionEntity {
    @Id
    Integer id;

    Integer countryId;

    Integer prefectureId;

    public Integer getId() {
        return id;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public Integer getPrefectureId() {
        return prefectureId;
    }
}
