package javajo.ponsyukey.database.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

/**
 *  リージョンEntity
 */
@Entity
public class RegionEntity {
    @Id
    Integer id;

    @Column(name="country_id")
    String countryId;

    @Column(name="prefecture_id")
    String prefectureId;

    public Integer getId() {
        return id;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getPrefectureId() {
        return prefectureId;
    }
}
