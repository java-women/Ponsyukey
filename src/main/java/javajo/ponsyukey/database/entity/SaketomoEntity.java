package javajo.ponsyukey.database.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "saketomo")
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
    LocalDateTime createdAt;

    /** 更新日時 */
    LocalDateTime updatedAt;

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

    public LocalDateTime getCreatedAt() { return createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public SaketomoEntity() {
    }

    public SaketomoEntity(
            String id,
            String name,
            String image,
            String email,
            String password,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
