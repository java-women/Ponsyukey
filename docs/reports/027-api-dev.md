# 第 27 回 API 開発 2022/07/17 14:00-17:00

https://javajo.doorkeeper.jp/events/139068

## 議事録作成者
maaya

## 参加者(敬称略)
- yokona
- aya
- mao
- mii
- maaya

## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - 好きなアイスについて熱弁してください。
- 前回のおさらい
- 今日やること
  - 酒情報一覧取得API
    - SQLファイルの作成
    - DomaでMap型で返却できないか検討する
    - NameでBreweryを特定しちゃってるので、IDを使えるようにデータの持ち方検討
  - 新しいAPIに着手する

## 議事内容(概要)
- 酒情報一覧取得API
    - NameでBreweryを特定しちゃってるので、IDを使えるようにデータの持ち方検討
        - SakeBreweryモデルにbreweryIdを追加した内部DTOを作成する方針で進める(ドメインモデル型の採用)
        - そのためにrecordを利用したい
        - Java17へバージョンアップ作業実施
        - Stream().map().collect()していたためにbreweryIdを利用できていなかったので、Stream().collect(この中でデータの詰替え作業を行う)という形に変更することでドメインモデル型の採用を引き伸ばすことに決定
            - https://github.com/java-women/Ponsyukey/blob/add-getSake/src/main/java/javajo/ponsyukey/repository/SakeRepository.java#L90  

### 今回の成果
- Javaバージョンアップ完了
- コンフリクト解消
- 新しいデータモデル方針決定

### next action(タスク洗い出し)
- 酒情報一覧取得APIの動作確認を行う
    - https://github.com/java-women/Ponsyukey/pull/33
- 新しいAPIに着手する


### 議事録作成者の感想ひとこと
三連休中日によく頭を使った議論をしました。

## 次回アイスブレイクのお題
最近買った便利なもの
