# 第 13 回 API 開発 2021/04/18 14:00-17:00

[https://javajo.doorkeeper.jp/events/119842](https://javajo.doorkeeper.jp/events/119842)

## 議事録作成者
Eri Uchiyama


## 参加者(敬称略)
- maaya
- manami
- aya
- mutumi
- yokona
- chiaki
- Yanagita
- yuki
- ellie

## 議題にしたいこと or 前回の next action

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - 最近の失敗談
- 前回のおさらい
- Githubのマージ方法について
  - マージはイシューを切った人が行うこととする
 
 
## 議事内容
1. API作成
　酒情報取得APIを作成
 
- SakeApiController.javaのテストを作成
    - JUnit5を使用しテストを生成
    - Mockmvc使用しモックを作成
- SakeApiController.javaに酒情報取得メソッドを記載
- Sakeresponceモデルを生成
    - openapi.ymlにコンポーネントを記載し、ジェネレート時に自動生成する仕様に変更
    - 前回エラー対策のためにAPIUtil.javaをジェネーレートから外したが、コンパイルエラーが発生したためignoreから削除

## 今回の成果
酒情報取得APIに正常系のテストを記載し、正常に完了することを確認した

## next action(タスク洗い出し)
- 引き続き酒情報取得APIを作成する
- レスポンスデータが空の時空のレスポンスボディを返すかエラーを返すか決める

## 議事録作成者の感想ひとこと
次回のアイスプレークは最近一番美味しかったもの
