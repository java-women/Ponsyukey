package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import java.time.LocalDate;

@Entity
public class SaketomoEntity {
    /** id: 会員ID UUID, アプリで生成する */
    @Id
    String id;  // 自動生成はされない

    /** name: 会員の名前 */
    String name;

    /** image: 画像へのURL */
    String image;

    /** email: メールアドレス */
    String email;

    /** password: パスワード */
    String password;

    /** 作成日時 */
    LocalDate createdAt;

    /** 更新日時 */
    LocalDate updatedAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() { return image; }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreatedAt() { return createdAt; }

    public LocalDate getUpdatedAt() { return updatedAt; }
}
