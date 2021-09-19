# 第 18 回 API 開発 2021/09/19 14:00-17:00

[https://javajo.doorkeeper.jp/events/126021](https://javajo.doorkeeper.jp/events/126021)

## 議事録作成者

- ゆか

## 参加者(敬称略)

- まあや
- ゆか
- aya
- 西出
- ちあき
- robo
- mii
- akiko
- yokona
- yuki

## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - みんなワクチンもう打った？ワクチン体験トーク!
    - まだ打ってない人/打たない選択をしている人は今のお気持ちを！
- 前回のおさらい
- 今日やること
  - よこなさんの宿題共有
    - https://github.com/java-women/Ponsyukey/pull/21
  - DOMA ORマッパーで、DAO自動生成を行う。

## 議事内容

### DOMA2を動くようにするために何をしたか(yokona先生)

#### 前提として良い知識

- DAO
  - Data Access Objectの略
  - データベースに情報を取りに行くための方法をまとめたクラス
  - SakeDaoであれば、Sake情報からどういった情報をとってくるかを記載したクラス
- Spring特有の概念DI(Dependency Ingection)には下記がある 
  - field Ingection
  - Constractor Ingection：一番推奨されている手段
    - [推奨されていることが説明されている参考記事](https://qiita.com/kmuro/items/aead50c699fefe56c120)
  - xxx
- DOMAの書き方の特徴、**2waySQL**というのがある

#### 内容

- [DOMA2を動くようにしたのプルリク](https://github.com/java-women/Ponsyukey/pull/21)
- やろうとしたこと
  - Sakeテーブルからwhere句にIDを指定し、情報を取得する
- DOMA2で設定すべきこと
  1. Interfaceクラスを作る
  1. しかるべきSQLファイルを作る
  2. ただ、コレだけでは、動かなかった…
- 前回からやった実装
  - SQLファイルを作った
  - エンティティを直した
    - `@Column(name="brewary=id")`
      - カラム名と変数名が完全一致してないと、上の設定を加えないと動かない模様
      - 完全一致してれば、DOMAが同じカラムと認識し、動いてくれる
      - ただ、設定ファイルに追記することで、上記設定をしなくても動くので、今日対応していく
  - `@Autowired`をうまくいかず、下記修正をした
    - Daoに`@ConfigAutowireable`をつけることで、DAOをDIできるようになった
      - 上記を加えることで、DI対象として認識される
      - SpringとDomaを組み合わせて使うための便利アノテーション
      - なんとなくの参考記事:[SpringBoot2.0.0でDoma2を利用する](https://www.d-make.co.jp/blog/2018/04/07/springboot2-0-0%E3%81%A7doma2%E3%82%92%E5%88%A9%E7%94%A8%E3%81%99%E3%82%8B/)
    - DOMAで自動生成されたファイルには上記が記載されていない
  - 現状はDockerでSQL Serverが動かせるように、Dockerの手順を作っていただいた！
    - Localで実行するなら、Dockerを利用する良いかも

#### DBに関して決めないといけないこと

1. SQLServerへのアクセス方法
  - リモートデスクトップ環境からSQL Serverにアクセスする
  - LocalからSQL Serverへアクセスする
  - **LocalでDockerでSQL Serverを構築する**
    - コミュニティでの開発になるため、コレでやっていく方針になった
1. 各ローカル環境へのデータ挿入の方法
  - [フライウェイ](https://flywaydb.org/)
  - まとまったddlを挿入するShellを作って対応する
    - Shellを作る：よこなさん
    - Windowsでの動作確認：まーやさん

### 実装する

- 全体的な話
  - 全体的にRepository層を作成した 
    - アプリケーションジョインにしたため、このRepositoryクラス内でジョインする方針とした
  - Entity層のクラス名の末尾に`Entity`をつけた

下記を実装した
- SakeRepository.java
  - getSakeメソッド
- Daoファイル
  - PrefectureDao.java
  - ContryDao.java
  - RegionDao.java
- SQLファイル
  - RegionDao/selectById.sql
  - Brewery/selectById.sql
- SakeService.java
  - getSakeDetailメソッド
    - ただし、若干エラーがある状態

### 認識合わせ

- Prefecture 
  - 海外の場合は海外コードが入っている
  - 日本の場合は各都道府県のIDが入っている
- 国IDの値
  - 電話番号の頭の文字を入れる
    - 日本なら、81。

## 今回の成果

- 酒情報詳細を取得するEntityやDAOをいっぱい作った

## next action(タスク洗い出し)

- Dockerの準備をしておく
  - SQLServerをLocal環境で利用するため
  - [環境構築](https://github.com/java-women/Ponsyukey/blob/master/docs/reports/004-environment.md)
- [次回までの個人タスク]まとまったddlを挿入するShellを作って対応する
  - Shellを作る：よこなさん
  - Windowsでの動作確認：まーやさん
  - CountryとPrefectureとRegionのマスタデータを作る：まーやさん

## 議事録作成者の感想ひとこと

- 一年振り以上ぶりのぽんしゅきー参加で、時がとても流れていることを実感した
- DOMA2便利そう…
- 次回のお題
  - おすすめなサブスクリクションサービス
