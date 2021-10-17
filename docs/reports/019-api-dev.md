# 第 19 回 API 開発 2021/10/17 14:00-17:00

[https://javajo.doorkeeper.jp/events/127484](https://javajo.doorkeeper.jp/events/127484)

## 議事録作成者
maaya

## 参加者(敬称略)
- mii
- aya
- ちあき
- maaya


## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - おすすめなサブスクリクションサービス
- 前回のおさらい
- 今日やること
  - DDLをShellでまとめて実行できるようにする！
    - よこなさんが作ってくれたShellを実行してみる！
      - https://github.com/java-women/Ponsyukey/pull/24
  - local環境のDockerでSQL Serverを起動してみる！
  - アプリケーションからSQL Serverにアクセスしてみる！

## 議事内容
### Windows Home 64bit 環境のDocker有効化作業フォロー
Hyper-Vの有効化作業をし、ローカルでdockerが動かせるようになりました。    
晴れて本日の参加者全員dockerが使える環境に。

### local環境用dockerファイル群のレビュー＆修正作業
- コンテナの外でshellを実行すると、めちゃくちゃ環境依存する
  - windows上でshell実行するにはWSL 2 や cygwin, gitbash など色々な方法があるが、それぞれによって各コマンドや仮想環境の構成が変わるため、環境ごとにshellの中身が動いたり動かなかったりした
    - 例えばgitbashでdocker execコマンドを実行する場合は execに対して事前にwinpty execを設定しておかなけばならなかったり・・・
    - > ローカルのOS環境に依存しないようにdockerコンテナ内の設定(今回の場合はDBデータの登録等)はdocker-compose.yaml内entrypointからDB起動＆データ登録用shellを起動することでローカル環境依存を排除した
- 今回のファイル編成の変更により・・・
  - WindowsでもLinuxでもdockerが動く環境であれば実行可能な状態を保つことができた(ような気がする)
  - SQL Serverの立ち上がりを待つwhile文を使わないコードスリム化に成功


## 今回の成果
ローカル用DB環境が皆作れるようになったよ。

## next action(タスク洗い出し)
- ローカル用DBとアプリの接続処理実装
- DB周りのJavaコーディング引き続き

## 議事録作成者の感想ひとこと
docker系のファイル構成をここまで紐解いて読み書きしたことなかったので超勉強になりました。    
知ったかぶり、よくない。
(maaya)
