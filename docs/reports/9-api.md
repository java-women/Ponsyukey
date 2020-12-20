# 第9回 API設計 2020/12/20 14:00-17:00

[https://javajo.doorkeeper.jp/events/114170](https://javajo.doorkeeper.jp/events/114170)  

## 議事録作成者
櫻井幸恵

## 参加者(敬称略)
- maaya
- run
- robo
- aya
- yuki nishiguchi
- yukie
## 議題にしたいこと or 前回の next action
- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - おすすめしたいお酒とつまみのマリアージュ(日本酒以外でもいいよ！)
- 前回のおさらい
- API設計つづき
  - 粛々とAPIの設計継続
  - 酒情報編集APIのレスポンスから
  
## 議事内容
- 引き続きSwagger Editorを使ってモブプロでswaggerでAPIドキュメントを作成
 - 酒情報詳細について
 - 酒編集APIをおさらい　（日本酒の蔵元は英語でsake brewery）
 - 酒情報編集に関して「見ろ」を全員で確認する→付箋を見たら機能メニューに発見した
 - 管理画面どうする→一同ざわざわ→一旦なしになった！スコープをどうするか？
 - 仕様上残しますが、酒詳細編集APIはなしになりました。。。
 
- 口コミ情報取得APIのモデルのデータモデルを考察
  - コメントの名称どうするか？ revue？ word of mouse？
  - grapevineもどうか？
  - 意見は色々出たが「review」に決定
　-「見ろ」を見て新着レビューをどうするか考える
  - limitを追加
  - integerを追加
  - required:trueを追加
  - name sortを設定 →必ず日付順の降順に設定
  - review:Listにならないといけない
  - items:propertiesを追加
  - idが必要と判断　uuidを追加
  - 口コミの人　userid？ saketomoidにするか？saketomoidにした
  - 情報を呼ぶ回数は少ない方がいいですね→一同賛成！
  - Saketomo→saketomoリファクタリングをした。
  - description 登録者情報に決定。
  - createdAtを追加(おさまりがいい） type format 
  - rating 作成日時を追加
  - type　integerに設定
  - バリデーションチェックをしてみたらどうか？requirerdで何もない状態は避けるようにする。
  - レスポンスがあるためrepuire消去
  - commentを追加　
  - format date_timeを追加した。
  
- 口コミ情報登録APIを作成 （口コミ情報登録に必要な情報を取得する機能）
  - createReviewを利用
  - type objectに設定
  - description　登録者ID
  - required:true saketomo rating commentの3種類を登録する
  
- 口コミ情報削除APIを作成 （口コミ情報削除に必要な情報を削除する機能）  
  - 削除機能を追加する→delieteを使用せずpostを使用することにした
  - parametersを設定する
  - in:pathを追加
  - name:reviewId
　- schemaを追加
  - type Stringなど追加　←削除APIは、スッキリさせるためのAPIである。
  - postでdelieteをした際に更新はどうするか？→編集機能があるから大丈夫です
  - parameterにuseridにいるか？
  - 全部削除してしまういたずらができてしまうとのこと
  - 改善するにはsaketomoIdをpropatiesにする（登録者ではないので、削除できませんの機能を追加）
  
- 現在の時刻16:40なので、あと20分で全部できたAPIをリファクタリングをして見直し作業を開始！！
  - componentsを作成する
  - saketomonoのデータ使いまわせるか？→auth以外なら使える
  - authは会員編集はauth付きであるので、authなしとauth付きを作るのはどうか　←意見が採用になった
  - authだけ別モデルにしましょう！に決定
  - schemasから返ってくるのは、saketomoWithAuthからsaketomoAuthに決定　←とりあえず使用してみる
  - properties を追加
  - saketomo を追加
  - $ref:'#/components/schemas/saketomo'/を追加
  - saketomoをidから呼び出せるようにすればいいのではないか？
  - saketomoWithAuth
  - $ref:'#/components/schemas/saketomoWithAuth'/を追加
  - responsesに$ref:'#/components/schemas/saketomo'/を追加（authなし）
  - postはauth付きにする　$ref:'#/components/schemas/saketomo'/を追加
  - sake type:arrayにする
  - itemsに、$ref:'#/components/schemas/sake'/を追加する
  - sake 直下に$ref:'#/components/schemas/sake'/を追加する
  - items $ref:'#/components/schemas/review'/ 追加する
  - postのreviewの下に $ref:'#/components/schemas/review'/を追加する
  - 削除APIでrefは使わないようにする！！
  
  
  
  
  
## 今回の成果
- 酒情報登録APIおさらい 
- 口コミ情報取得API
- 口コミ情報削除API




## next action(タスク洗い出し)
APIは終了したので、次はJavaの入れるかもしれないです。

## 議事録作成者の感想ひとこと
- 初めての議事録作成でしたので、文章に不手際があるかもしれません。
- 間違っている箇所など、何かありましたら、ご指導ご鞭撻よろしくお願いします。
