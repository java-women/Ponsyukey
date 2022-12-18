# 第 31 回 API 開発 2022/12/18 14:00-17:00

[https://javajo.doorkeeper.jp/events/148462](https://javajo.doorkeeper.jp/events/148462)

## 議事録作成者
mii

## 参加者(敬称略)
maaya, mii, robo

## 議題にしたいこと or 前回の next action
★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - サンタにお願いしたいプレゼント教えてください
      - 大人はお願いしたいプレゼントの金額がでかい
- 前回のおさらい
- 今日やること
  - 新しいAPIの作成

## 議事内容(概要)
### 酒情報登録APIを実装する
- 環境構築をがんばる
- SakeApiControllerにcreateSakeを実装する
- リクエストのバリデーションどうする？
  - OpenAPIにrequired設定してなさそう
  - required設定してる(saketomoとか)ところもジェネレートされてなさそう
- 会員登録APIがガワだけ作ってあるからこっち先にやったほうがよさそう

### 会員登録APIを実装する
- request, dto, entityの詰め替えをがんばる
  - entityのid, created_at, updated_atはrequestにないので自前で設定する
- entity, DDLのアヤシイところを直す
  - entityのcreated_at, updated_atのデータ型がLocalDateになってるけどLocalDateTimeにする
    - entityは自動生成じゃなかったはずなので手で書き換えてよさそう
  - created_at, updated_atがないテーブルがあるのでDDLを修正する
    - 既存のentityには、後で(POSTの実装をするときに)created_at, updated_atのフィールド追加する
  - saketomoEntityにコンストラクタをつくる
- database.dao.SaketomoDaoにinsertを実装する
  - insertはSQLを自動生成できる
- insertに失敗した場合のエラーハンドリングを検討
  - insertの戻りが1(更新件数1件)じゃない場合はSQLExceptionを投げる
  - (runtimeじゃない)exceptionを投げてexceptionHandlerでキャッチしようとすると、controllerにもthrowableを追加しないといけない(自動生成された定義に手が入る)
    - serviceでSQLExceptionをキャッチしてruntimeExceptionを投げるようにする。exceptionHandlerの動きはアヤシイのでこんどよくかんがえる
- serviceからSaketomoRequestResponseを返す
  - id(UUID)はrepositoryで生成してるので、repositoryからの戻りをid(UUID)にする(Responseの他の項目はserviceでも知ってるので)
- ビルドが通ったよ！

### 今回の成果
- 会員登録APIを実装した！
- DDLをなおした！

### next action(タスク洗い出し)
- 会員登録APIの動作確認をする
- 前回から持ち越したissueを解消する
  - https://github.com/java-women/Ponsyukey/issues/39
  - https://github.com/java-women/Ponsyukey/issues/40
  - https://github.com/java-women/Ponsyukey/issues/41

### 議事録作成者の感想ひとこと
DBも例外もかんがえることがおおいなあ

## 次回アイスブレイクのお題
年末年始に食べたおいしいもの
