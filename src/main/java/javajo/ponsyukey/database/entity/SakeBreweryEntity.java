package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 酒醸造所entity
 */
@Entity
@Table(name = "brewery")
public class SakeBreweryEntity {

    /** 醸造所ID */
    // TODO: idをUUIDに変更する
    @Id
    String id;

    /** 醸造所名 */
    String name;

    /** リージョンID (国×都道府県) */
    Integer regionId;

    /** 作成日時 */
    LocalDateTime createdAt;

    /** 更新日時 */
    LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRegionId() {
        return regionId;
    }
}
