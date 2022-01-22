# 第 21 回 API 開発 2022/01/22 14:00-17:00

[https://javajo.doorkeeper.jp/events/131087](https://javajo.doorkeeper.jp/events/131087)

## 議事録作成者
maaya

## 参加者(敬称略)
- aya
- mutsumi
- yokona
- robo
- natsuki
- yu-ki
- mii


## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - 2022年の目標
- 前回のおさらい
- 今日やること
  - https://github.com/java-women/Ponsyukey/issues/26
  - log4j一応確認しておく？
  - getSakeDetail APIのException Handlerを完成させ、テストを通す
  - 他のAPIたちの実装に入る
  - 今後の進行方法を見直す議論する

## 議事内容
### 脆弱性対応
- https://github.com/java-women/Ponsyukey/issues/26 について内容確認。
  - ついでにlog4J脆弱性は何が起きてたのか確認
- 上記脆弱性指摘箇所を含むgradle.build内で呼び出している各種ライブラリのバージョンを最新にアップデート
  - ついでにbuild.gradleを整理
    - シングルコーテーションとダブルコーテーションが入り乱れてたのでダブルコーテーションに 
  - Open API Generator関連のファイルでビルドエラー発生中。 -> RelativePathProviderがない？
    -  宿題にします [https://github.com/java-women/Ponsyukey/issues/27](https://github.com/java-women/Ponsyukey/issues/27)
    -  https://github.com/java-women/Ponsyukey/tree/wip_lof4shell_patch_20220122

## 今回の成果
build.gradleの記法が整理されて綺麗になった

## next action(タスク洗い出し)
- 宿題の見直し＆レビュー
- APIテストの作成


## 議事録作成者の感想ひとこと
ライブラリバージョンアップ、何かしら落とし穴があって毎回毎回ぐぬぬぬってなる。
古いライブラリとかマイナーライブラリまじ要注意。。。
新しく参加してくれた人たちのフォローができてなくてほんまごめんねの気持ち。
