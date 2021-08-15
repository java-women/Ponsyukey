package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.util.Optional;

/**
 * 酒醸造所entity
 */
@Entity
public class SakeBrewery {

    /** 醸造所ID */
    @Id
    String id;

    /** 醸造所名 */
    String name;

    /** リージョンID (国×都道府県) */
    Integer regionId;


}
