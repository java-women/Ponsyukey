# 第 32 回 API 開発 2023/01/15 14:00-17:00

[https://javajo.doorkeeper.jp/events/148803](https://javajo.doorkeeper.jp/events/148803)

## 議事録作成者
maaya

## 参加者(敬称略)
- mii
- robo
- shino
- maaya

## 議題にしたいこと or 前回の next action
★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - 年末年始に食べたおいしいもの

- 前回のおさらい
- 今日やること
  - 会員登録APIの動作確認をする
  - 前回から持ち越したissueを解消する
    - https://github.com/java-women/Ponsyukey/issues/39
    - https://github.com/java-women/Ponsyukey/issues/40
    - https://github.com/java-women/Ponsyukey/issues/41

## 議事内容(概要)
- M2 mac / Windows のSQL Server on Docker 環境を各自整備する
    - 前回各テーブルにcreate at / update atを追加したにも関わらずダミーデータやテーブルDDLに反映していなかったためエラー続出
        - https://github.com/java-women/Ponsyukey/pull/42 で修正済み。マージ待ち。
    - M2 macでSQL Serverが立ち上がらない事象発生・・・？
        - SQL Server バージョンアップで動くようになるかも？
            - miiが次回までに検証実施予定
- 現在実装完了済みの4APIの動作確認を行う
    - https://github.com/java-women/Ponsyukey/pull/42 にて既存のAPIバグ修正中
        - 次回イベントまでにmaayaが修正対応

### 今回の成果
linux環境・windows環境でのSQL server on docker環境が整いました。

### next action(タスク洗い出し)
- 持ち帰り案件進捗確認
    - M2 macでSQL Serverが立ち上がらない事象(mii)
    - 既存のAPIバグ修正(maaya)
- 前回から持ち越したissueを解消する
    - https://github.com/java-women/Ponsyukey/issues/39
    - https://github.com/java-women/Ponsyukey/issues/40
    - https://github.com/java-women/Ponsyukey/issues/41

### 議事録作成者の感想ひとこと
私が一番docker環境にハマってなかなか動かなかったのを深く反省しています

## 次回アイスブレイクのお題
2023年のうちに「これは絶対やるぞ！」と思っていること
