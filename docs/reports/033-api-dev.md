# 第 33 回 API 開発 2023/01/15 14:00-17:00

https://javajo.doorkeeper.jp/events/151382

## 議事録作成者
maaya

## 参加者(敬称略)
- mii
- robo
- maaya


## 議題にしたいこと or 前回の next action
★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - 2023年のうちに「これは絶対やるぞ！」と思っていること

- 前回のおさらい
- 今日やること
  - 持ち帰り案件進捗確認
      - M2 macでSQL Serverが立ち上がらない事象(mii)
      - 既存のAPIバグ修正(maaya)
  - 前回から持ち越したissueを解消する
      - https://github.com/java-women/Ponsyukey/issues/39
      - https://github.com/java-women/Ponsyukey/issues/40
      - https://github.com/java-women/Ponsyukey/issues/41

## 議事内容(概要)
- https://github.com/java-women/Ponsyukey/pull/42
    - API4本の動作確認
        - 酒情報一覧取得API
            - Region/PrefectureのEntity内の各IDの型がStringになってしまっていたためIntegerに変更
            - 日本(81)判定のif文もInteger用に変更
        - 酒情報取得API
            - 日本(81)判定のif文もInteger用に変更
        - 会員登録API
            - controllerの返却値不備があったので修正
        - 会員取得API
- https://github.com/java-women/Ponsyukey/issues/39
    - 上記動作確認内で対応済み
- https://github.com/java-women/Ponsyukey/issues/41
    - 対応中にタイムアップ
    - エラーの種類と挙動をもう少しちゃんと設計する必要がある

### 今回の成果
- https://github.com/java-women/Ponsyukey/issues/42
- https://github.com/java-women/Ponsyukey/issues/39

をクローズ、masterマージできました。


### next action(タスク洗い出し)
- https://github.com/java-women/Ponsyukey/issues/41
- https://github.com/java-women/Ponsyukey/issues/40

### 議事録作成者の感想ひとこと
煮え切らない終わりでした。    
エラーの設計は未知数すぎて大変です。

## 次回アイスブレイクのお題
触ってみたいなと思ってまだ触れてない技術なんか１つ語ってください

