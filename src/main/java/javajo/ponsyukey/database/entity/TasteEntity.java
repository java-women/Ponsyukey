package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "taste")
public class TasteEntity {

    @Id
    String id;

    /** value: 味情報は固定カラムを持たずに、自由入力。(例)ハッシュタグ **/
    String value;

    /** 作成日時 */
    LocalDateTime createdAt;

    /** 更新日時 */
    LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
