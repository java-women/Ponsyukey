package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class TasteEntity {

    @Id
    String id;

    /** value: 味情報は固定カラムを持たずに、自由入力。(例)ハッシュタグ **/
    String value;

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
