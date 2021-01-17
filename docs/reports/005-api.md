# 第5回 API設計 2020/08/16 14:00-17:00

[https://javajo.doorkeeper.jp/events/109591](https://javajo.doorkeeper.jp/events/109591)  

## 議事録作成者
まなみ

## 参加者(敬称略)
- aya
- maaya8585
- robo
- mii
- きのこ
- yuki
- Ellie
- いちご
- mutsumi
- 真衣（ニックネームがわからなかったのでとりあえずFirstNameです）
- まなみ

## 議題にしたいこと or 前回の next action
- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - この夏にやりたかったこと
- 前回のおさらい
- JSフレームワーク調査報告
  - にしぐちさんお願いします！
- API設計
## 議事内容
### JSフレームワーク調査報告 
（by yukiさん）
- Vue.js
学習コストが低く、さくっと作るのに向いている。中国発祥でアジア圏中心に使われている。
- React
しっかりしたものが書けるが、その分学習コストが上がる。欧米を中心に使われている。

決選投票は実施せず。追々・・・？
### API設計
#### 必要そうなAPIの洗い出し
  - [miroの画面検討資料](https://miro.com/app/board/o9J_ktzRgdo=/)を見ながら、必要そうな一覧の洗い出しました。
  - 一旦はざっくり動くために必要なものだけ。洗い出し結果は[こちら](https://github.com/java-women/Ponsyukey/issues/9)

#### API仕様作成手順
  - ayaさんがSwagger経験者につきナビゲーターを勤めてもらい、みんなでモブプロ形式でyamlを作成。
  - 最初はサンプルから引用がいいね！ということでSwaggerのオンラインエディタを使って作成。
  - Visual Studio Codeの拡張機能もあるよ。
    - OpenAPI(Swagger)Editor
    - Swagger Viewer     

#### 会員登録APIの設計
  - 利用者の呼び方の議論。**酒友**に決定！投票結果は[こちら](https://github.com/java-women/Ponsyukey/issues/10)
  - 会員に関連するパラメタ名は「Saketomo」となりますが、複数形の「S」をつけるかは今後議論の予知あり。 
  - 規約の同意ステータスと年齢は、一旦APIに保持しない。
    - 同意にチェックしてもらったり、20才以上の場合登録ボタンを押せるなど、UI側で吸収させる予定。
  - XMLは不要とする。
  - エラー設計は先送り。 
  - 登録時はメール認証だけとしてパスワード不要にする？一般的な会員登録を調査する。

#### API 仕様作成作業の当日モブプロ手順 (参考資料)　
（Thank you roboさん！）
- オンライン Swagger Editer による API 作成
【作業概要】[OpenAPI](https://swagger.io/docs/specification/about/) のオンラインエディタ [Swagger Editor](https://editor.swagger.io/) を使い、
`ぽんしゅきー会員登録 API` を含む **ぽんしゅきー API仕様** [Ponsyukey/docs/api/openapi.yaml](https://github.com/java-women/Ponsyukey/blob/master/docs/api/openapi.yaml) ファイルを作成しました。

  - オンラインエディタ [Swagger Editor](https://editor.swagger.io/) を開きます。
  - 画面上部にある `Fire > Crear editor` を実行してエディタ内容をクリアします。
  - ブラウザをリロードして、デフォルトのサンプル API 仕様 ⇒ Swagger Petstore を表示させます。
  - デフォルトのSwagger Petstore は、swagger 2.0 フォーマットなので、OpenAPI 3 フォーマットに変換します。
  `Edit > Convert to OpenAPI 3` をクリックして、エディタ上部に表示される `Convert` をクリックします。
  変換が終わってエディタ上部に表示される `Close` をクリックしてコンバート作業を終了させます。
  - OpenAPI 公式の [Basic Structure](https://swagger.io/docs/specification/basic-structure/)  や [Adding Examples](https://swagger.io/docs/specification/adding-examples/) および [OpenAPI Specification](https://swagger.io/specification/) を参考に
  `info` `externalDocs` `paths` など基本的なセクションを編集して、 **ぽんしゅきー API 仕様** 雛形を作成。
  - 作成したAPI仕様雛形を `File > Save as YAML` で `openapi.yaml` ファイルとしてダウンロード。
  - [Github ぽんしゅきーリポジトリ](https://github.com/java-women/Ponsyukey/)で、 `Add file > Create new file` を実行して、
  `Ponsyukey/docs/api/openapi.yaml` を新規作成。（ダウンロードした YAML ファイルの内容を貼り付けます）

#### OpenAPI について
- OpenAPI 公式資料
  - What Is OpenAPI?
  https://swagger.io/docs/specification/about/
  OpenAPIは、Swagger 2.0を拡張して実装された RESTful APIを記述するためのフォーマットです。
  Swagger Editor は、OpenAPI フォーマットを用いて REST API を設計/作成するためのエディタです。
  YAMLまたはJSONで、利用可能なエンドポイントと、各エンドポイント（GET /users、POST /users）での操作、
  操作パラメータ各操作の入出力、認証方法、連絡先情報、ライセンス、利用規約、その他の情報
  …などの API 仕様全体を記述することができます。  
  　  
  完全なOpenAPI仕様は、GitHubで公開されています。
  https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md

- 参考資料
  - OpenAPI (Swagger) 超入門
  https://qiita.com/teinen_qiita/items/e440ca7b1b52ec918f1b
  - OpenAPI (Swagger) の基本的なあれこれ
    https://girigiribauer.com/tech/20190318/

## next action(タスク洗い出し)
- 作成した会員登録API定義の見直し
- 時間があれば次のAPI作成

## 議事録作成者の感想ひとこと
- APIの開発はある程度仕様が固まり始めてからしか経験がないので、今回は一から経験できてとても有意義でした。
- 懇親会が楽しかった〜！みなさんの発言にひたすら共感ばかり・・・いつかはリアルで実現したい！
- 懇親会の飲み物は、可愛くレモンサワーにしました。本性は徐々に出していく派です。（なんのこっちゃ）
