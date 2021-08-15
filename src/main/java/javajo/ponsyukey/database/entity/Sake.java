package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.util.Optional;

@Entity
public class Sake {
    /** id: 酒ID UUID, アプリで生成する */
    @Id
    String id;  // 自動生成はされない

    /** name: 酒の名前 */
    String name;

    /** image: 画像へのURL */
    Optional<String> image;

    /** breweryId: 醸造所ID */
    String breweryId;

    /** alcohol: アルコール度数（パーセント) */
    Optional<Float> alcohol;

    /** polishingRatio: 精米歩合（パーセント） */
    Optional<Float> polishingRatio;

    /** type: 特定名称 (例)吟醸酒、大吟醸など */
    Optional<String> type;

    /** description: 味情報は固定カラムを持たずに、自由入力 */
    Optional<String> description;

}
