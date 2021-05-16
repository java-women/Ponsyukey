# 第 14 回 API 開発 2021/05/16 14:00-17:00

[https://javajo.doorkeeper.jp/events/120904](https://javajo.doorkeeper.jp/events/120904)

## 議事録作成者



## 参加者(敬称略)
- maaya
- manami
- mii
- aya
- yuki
- chiaki
- yokona

## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - 最近一番美味しかったもの
- 前回のおさらい
- 今日やること
  - 引き続き酒情報取得APIを作成
  - レスポンスデータが空の時空のレスポンスボディを返すかエラーを返すか決める
 
## 議事内容
1. API作成 酒情報取得APIを作成(引き続きTDDを実践)
- レスポンス内容が正しいことをテストケースを用意する
    - JUnit 5のお作法で、期待値と実際の値の比較は`assertEquals`で行う
    - expected = 生のJSON, actual = APIを呼び出した結果のレスポンスとなるようテストを書いていく
    - DBとのアクセス部分はモックを使うので、TDDといえどServiceレイヤーの実装をある程度決めておく必要がある
    - 【質問】テストデータに使う値は本番データに近い方がいいか？→はじめは出来る範囲(例えば都道府県には都道府県以外の文字列を入れないとか)で本番に近いデータで書いていこう
- tasteオブジェクトの仕様を決める
    - ハッシュタグみたいな感じでキーワードの集合にしよう(レスポンスとしてはListを使う。内部的にはSetがベターかな)

学び
- TDDのt_wadaさん、Javaメモのhishidamaさん
- `List#of`メソッドでListが初期化出来る [https://www.baeldung.com/java-init-list-one-line]
- Swaggerでarrayを定義する際は要素の型も指定できる

```
type: array
items:
  type: string
```

## 今回の成果


## next action(タスク洗い出し)


## 議事録作成者の感想ひとこと

