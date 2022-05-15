# 第 25 回 API 開発 2022/05/15 14:00-17:00

https://javajo.doorkeeper.jp/events/136031

## 議事録作成者
- maaya(酒情報一覧取得API)
- aya(会員情報取得API)

## 参加者(敬称略)
- aya
- yu-ki
- robo
- よこな
- maaya
- ちあき


## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - ゴールデンウィーク何しましたか
- 前回のおさらい
- 今日やること
  - container実行してSQLとの連携テスト
  - 2-3人グループくらいに分かれて、それぞれ別APIを実装

## 議事内容(概要)

酒情報一覧取得APIと会員情報取得APIのチームに分かれて作業実施

- 酒情報一覧取得API
  - よこな
  - robo
  - maaya
- 会員情報取得API
  - aya
  - ちあき
  - yu-ki

## 議事録(酒情報一覧取得)
- GET /sake : 酒情報一覧取得API を作成する
- getSakeDetail APIでデータ系クラスがあるから大丈夫・・・と思いきや複数データを取得するときは微妙にないようが異なるため四苦八苦
- region/country/prefecture のデータとりあつかいをstreamで処理
  - 全体的にmapにしてkeyでデータ処理を実施
- DomaのselectOptionsを使用したlimit-offsetクエリを実装しているが、repositoryクラスにDBアクセス処理が記載されているところに若干の気持ち悪さを感じている。要検討。
- まだSQLファイル未実装

### 今回の成果
処理の全体像を構築できた(細かいところは未実装)

### next action(タスク洗い出し)
- SQLファイルの作成
- DomaでMap型で返却できないか検討する
- NameでBreweryを特定しちゃってるので、IDを使えるようにデータの持ち方検討

### 議事録作成者の感想ひとこと
テーブルデータ型を複雑にしすぎた感がある醸造所所在地情報・・・(maaya)

## 議事録(会員情報取得)
- GET /saketomo/{saketomoId} : 会員情報取得APIを作成
- SakeApiからパクってSaketomoController、SaketomoService、SaketomoRepository、SaketomoDaoを作った
- SakeResponseと同じようにするためにopenapi.yamlにSaketomoResponseの定義を追加した
- DBにデータ入れられなくて動作確認だけできてない（APIは大まかに作った
- feature/get-saketomoブランチにpushした
- プルリク https://github.com/java-women/Ponsyukey/pull/31

### 今回の成果
会員情報取得APIできた！（確認してないけど

### next action(タスク洗い出し)
DBにデータ入れて、動作確認する！

### 議事録作成者の感想ひとこと
案外スラスラできてよかったです(aya)


## 次回アイスブレイクのお題
夏休みにやりたいことはなんですか？！
