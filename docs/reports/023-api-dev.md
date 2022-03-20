# 第 23 回 API 開発 2022/03/20 14:00-17:00

https://javajo.doorkeeper.jp/events/133647

## 議事録作成者
mii

## 参加者(敬称略)
- aya
- maaya
- mii
- robo
- takayama
- ちあき
- よこな

## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - 今一番勉強したいことはなんですか
- 前回のおさらい
- 今日やること
    - getSakeDetailのエラー系テスト実装
    - 他APIの開発

## 議事内容
### 独自の Exception と ExceptionHandler を追加
- 400のExceptionHandlerしか用意してなかったので、設計書に合わせて400と500のExceptionHandlerを実装したい。
  - 独自例外も実装してスローできるようにしよう！
  - 独自ExceptionHandlerで例外を拾えるようにしよう！

- Exceptionを確認するためにAPIを叩いてみる。
  - dockerでDBを立ち上げて、アプリケーションを実行(bootRun)する。
  - エラーが出た(Failed to start bean 'documentationPluginsBootstrapper')
    - application.properties にパラメータ追加したら動いた https://github.com/springfox/springfox/issues/3986

- 独自のExceptionを実装する。
  - 実装した。

- 独自例外のHandlerを実装する。
  - controller から exception のパッケージが見れなくてエラーになる。
    - exception を controller の下に移動した。
  - 実装したExceptionHandlerで例外が拾えてない。
    - 次回までの宿題！

## 今回の成果
- アプリケーションを実行してAPIの動作確認ができた！
- ExceptionとExceptionHandlerといっぱい戦った。

## next action(タスク洗い出し)
- ExceptionHandlerで例外を拾えるようにする(宿題)
- 独自例外を実装する。
- エラーのレスポンスを実装する。

## 議事録作成者の感想ひとこと
3年分くらい例外の話をした！

### 次回アイスブレイクのお題
お気に入りのガジェットやデスク周りのアイテムを自慢してください！
