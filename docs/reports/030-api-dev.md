# 第 30 回 API 開発 2022/10/22 14:00-17:00

[https://javajo.doorkeeper.jp/events/140191](https://javajo.doorkeeper.jp/events/141892)

## 議事録作成者
あや(前半)
まあや(後半)

## 参加者(敬称略)
mii
shino
robo
maaya
aya

## 議題にしたいこと or 前回の next action
★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - 最近食べておいしかったもの
- 前回のおさらい
- 今日やること
  - SakeRepositoryのgetSake()に、tasteを持ってこれるように修正する
  - ほかサービスクラス、レポジトリ用にDTOクラスを作成する

## 議事内容(概要)
- SakeRepositoryのgetSake()に、tasteを持ってこれるように修正
  - Domaは土間さんだと思ったら違ったっぽい
  - taste、taste_mapテーブルから取得するため、Dao、entity、sqlファイルなど追加
  - getTaste()メソッド追加
  - ★一旦tasteテーブルは全件取得してからtaste_mapを取得するけど、データの件数が多くなってパフォーマンス悪くなったら全件取得ではなくてtaste_mapで絞ってtatsteをとるようにする
  - ↑の背景としては、前にDBでデータをいい感じに取得するか、アプリの方でデータをいい感じにするかを討論した結果、今回はアプリの方でデータをいい感じにする方針になったから
- ↑の動作確認
  - データの作成
  - 一発動作確認OK
- 前回の議事録の遺言である「ほかサービスクラス、レポジトリ用にDTOクラスを作成する」の対応
    - 作業者あやのパソコン凍結
    - 酒情報をresponse DTOに詰め替える実装は、取り急ぎprocessorもしくはmediateなどのクラスは作成せず、serviceクラス内にprivateクラスで実装。後で数が増えてきたり不都合が出てきたら別クラス化する
      - 最初、response DTO内にメソッドもしくはコンストラクタ追加をしたかったが、response DTOはopenAPI generatorで作成しているファイルであるため、断念
- saketomo DTOの取り扱いについて
  - OpenAPI.yaml上、saketomo スキーマのみリクエストからもレスポンスからも呼ばれている・・・のでネーミングを一旦 SamektomoRequestResponse(どっちやねん)として逃げることに
  - 今後もう少し良いネーミングあれば変更する

### 今回の成果
- 酒情報取得APIのgetTaste()
- Dataクラス系の整理

### next action(タスク洗い出し)
- 新しいAPIの作成

### 議事録作成者の感想ひとこと
サクサク進んだかいでした

## 次回アイスブレイクのお題
サンタにお願いしたいプレゼント教えてください
