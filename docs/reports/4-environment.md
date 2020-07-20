# 第4回 開発環境を整える 2020/07/19 14:00-17:00

[https://javajo.doorkeeper.jp/events/108210](https://javajo.doorkeeper.jp/events/108210)  

## 議事録作成者
robo


## 参加者(敬称略)
- らん
- maaya8585
- きのこ
- mii
- mutsumi
- まなみ
- robo
- aya
- yuki
- Ellie


## 議題にしたいこと or 前回の next action
- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - お家で食べる最近ブームの食べ物
- 前回のおさらい
  - [第3回 システム設計〜画面編2〜](https://github.com/java-women/Ponsyukey/blob/master/docs/reports/3-app-flow.md) 議事録参照
  - 前回作成画面の確認  
会員登録画面、ログイン画面、酒検索画面(TOP画面)、酒詳細画面、口コミ登録画面
- 画面モック作成内容共有
  - きのこ(ありがとう!)  
    [https://www.figma.com/proto/ibsaxm7kavmxhKUMPnvMoM/%E3%81%BD%E3%82%93%E3%81%97%E3%82%85%E3%81%8D%E3%83%BC?node-id=1%3A2&scaling=min-zoom](https://www.figma.com/proto/ibsaxm7kavmxhKUMPnvMoM/%E3%81%BD%E3%82%93%E3%81%97%E3%82%85%E3%81%8D%E3%83%BC?node-id=1%3A2&scaling=min-zoom)  
    *[figma](https://www.figma.com/) 無料版は、参照人数に制限がありませんが、編集者は２名に限られます。*
- 技術スタックの検討
  - [https://github.com/java-women/JavajoPonsyu/issues/6](https://github.com/java-women/JavajoPonsyu/issues/6)
- 開発環境の検討
  - docker? 手順書ベース? 
  - CIする？
- 開発環境構築 issueの作成


## 議事内容
### 技術スタック候補
- Webフロントエンド開発のフレームワーク選定  
React、Vue.js、Flutter から開発に採用するフレームワークを選定する。

- サーバサイド API開発のフレームワーク選定  
現状想定は、以下の通り。
  - API提供形式：REST API (GET/POST)  
  - 開発言語：Java11 LTS  
  - フレームワーク：Spring Boot2  
  - ORM：Doma2  
  - Database：SQL Server  
  - Cloud Service：Azure  

- サーバサイド開発環境の提供手段選定  
以下から、開発環境提供手段を選定する。
  - 手順書ベース各自作成  
  - Dockerコンテナ作成  
  - サーバ上サービス作成（Webブラウザ IDEで開発する）
  
### 技術スタック選定検討情報
- 各技術スタックの特徴詳細は、ISSUE [技術スタックを検討する #6](https://github.com/java-women/Ponsyukey/issues/6) を参照ください。

- Flutter 特徴
  - メリット  
  iOS、Android、Webアプリ(ベータ版)に対応できる。  
  【補足】Flutter for Web 勉強会説明資料  
  　[CSS も HTML も使わない Webアプリ開発](https://docs.google.com/presentation/d/1Vokoina0WFW4w4vwFSrDrfIP2bBaUHmxhtWcgFOORys/edit?usp=sharing) 

  - デメリット  
  Dart言語で開発する必要がある。  
  Google開発のフレームワークのため、Google技術活用が中心となる。

- Vue.js 特徴  
  - メリット  
  一通りのライブラリは、公式提供されている。  
  HTMLで UIコンポーネントを作り、HTMLを積み上げていく判りやすい開発形式。  
  【補足】Vue.js 特徴資料  
  　[Vue.js 他のフレームワークとの比較](https://jp.vuejs.org/v2/guide/comparison.html)   

  - デメリット  
  イベントアクションが双方向のため、複雑性が高まる恐れがある。

- React 特徴
  - メリット  
  コミュニティサイズは、3者の中で最大規模である。  
  イベントアクションが単方向のため、ビューとロジックを分離できる。  
  【補足】
   [React Native 公式サイト](https://reactnative.dev/)

  - デメリット  
  プラグインやライブラリは、コミュニティ（サードパーティ）が提供している。  
  JavaScriptで UIコンポーネントを作り、ロジックと組み上げていく玄人好みな開発形式。  


### 技術スタック決定
- Webフロントエンド開発のフレームワークは、 次回決勝戦に持ち越し。
  - 「 **React** と **Vue.js** をもう一度各自情報を集めて共有＆検討しましょう」ということになりました(決勝戦)。  
  先にREST APIを作成するので、API作成中に調査、API作成が落ち着いてきたタイミングで  
  フロントエンドの技術スタックを決定する予定です。
  - 備考
    - React と Vue.js のモチベーション差は僅差でした。
    - 両者ともに Webフロントエンド開発の標準である、JavaScript で開発できます。
    - プロジェクトをフォークして、他のフレームワークで作ることもOKです。  

- サーバサイド開発環境の提供手段は、 **Dockerコンテナ** に決定。  
  - サーバサイド開発デファクトスタンダードであり、  
  技術的チャレンジ性、実現性から選択されました。

  
### 開発環境構築
モブプロの手法を使って、開発環境を構築しました。

- モブプロとは？  
【引用元】  
[「挫折した人にも読んでほしい」  
　日本の第一人者に聞く、「モブプログラミング」の魅力とは？](https://type.jp/et/feature/10082#:~:text=%E3%80%8C%E3%83%A2%E3%83%96%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0%E3%80%8D%EF%BC%88%E4%BB%A5%E4%B8%8B%E3%80%81,%E3%81%97%E3%81%A6%E8%A1%8C%E3%81%86%E9%96%8B%E7%99%BA%E6%89%8B%E6%B3%95%E3%80%82&text=%E3%83%A2%E3%83%96%E3%83%97%E3%83%AD%E3%81%AE%E7%99%BA%E7%A5%A5%E3%81%AF%E3%80%812012,%E3%81%A7%E3%82%82%E6%99%AE%E5%8F%8A%E3%81%97%E5%A7%8B%E3%82%81%E3%81%9F%E3%80%82)  
  >「モブプログラミング」（以下、モブプロ）とは、  
３名から５名程度のエンジニアが１つのモニター、１つのPCを共有して行う開発手法。  
具体的には実際にコードを打ち込む「ドライバー」役が１人、  
それ以外は指示を出す「ナビゲーター」役となり、意見を交わしながら開発に取り組む。  
ドライバーは数十分おきに交代し、モブプロへの途中参加も途中退出も自由。  
もし作業中に問題が生じれば、その都度話し合って解決するため、  
手戻りが少なく、短時間でプログラミング品質の向上が見込める。  

- ぽんしゅきープロジェクトでのモブプロ  
本プロジェクトでは、ドライバーは「対象の作業をやったことがない人  
(あるテーマについてやったことない人)」にお願いしましょう  
～という方針で運用することになりました。


#### 構築した開発環境
1. Docker Desktop ツールのインストール
1. Spring Boot を使った、ぽんしゅきープロジェクト雛形作成
1. OpenJDK 11 インストール  
1. ぽんしゅきープロジェクトの初期設定
1. Java女子部リポジトリに、ぽんしゅきープロジェクト追加  

【注意】  
　開発に必要な手順は、Docker と OpenJDK11 のインストールのみです。  
　「ぽんしゅきープロジェクト」は、Java女子部リポジトリをクローンします。  
　*IntelliJ IDEA を使う場合は、Project SDK の java11 への変更を忘れないでください。*

#### 環境構築作業の当日モブプロ手順 (参考資料)
- Docker Desktop ツールのインストール  
【概要】  
　Mac OS環境の Docker Desktop ツールのインストールを行いました。
  - インストール説明ドキュメント  
  Mac に Docker Desktop をインストール  
  [http://docs.docker.jp/docker-for-mac/install.html](http://docs.docker.jp/docker-for-mac/install.html)

  - インストールファイルのダウンロード  
  下記 URL から **Get Docker Desktop for Mac (Stable)** をクリックして、  
  インストールファイルをダウンロードします。  
  Docker Desktop for Mac  
  [https://hub.docker.com/editions/community/docker-ce-desktop-mac/](https://hub.docker.com/editions/community/docker-ce-desktop-mac/)

  - Docker Desktop インストール  
  ダウンロードした **Docker.dmg** をダブルクリックして開き、  
  **Docker.app** を **Applications** にドラッグドロップします。  

  - インストール作業実行  
  Applications フォルダを開き、 **Docker.app** をダブルクリックします。  
  **Get started with Docker in a few easy steps!** ダイアログが開くので、  
  **Start** ボタンをクリックしてインストールを開始し、  
  以降は、 **Next Step** ボタンをクリックして、  
  インストール完了の **Done** まで進めます。
  
  - Docker 使い方紹介  
  Docker for Mac を始めよう  
  [http://docs.docker.jp/docker-for-mac/index.html](http://docs.docker.jp/docker-for-mac/index.html)

  - Windows 10 への Docker インストール (参考)  
  [Windows 10 Pro 64bit に Docker と Docker Compose をインストールする](https://qiita.com/ksh-fthr/items/6b1242c010fac7395a45)  
  [Windows10 HomeでDocker環境を導入する](https://qiita.com/zeffy1014/items/dda78f4ab0449989dfe1)

- Spring Boot を使った、ぽんしゅきープロジェクト雛形作成  
【概要】  
　Spring Boot の spring initializer サービスを使って、  
　ぽんしゅきープロジェクト雛形を作成します。

  - Spring Boot  
  [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)

  - spring initializer  
  [https://start.spring.io/](https://start.spring.io/)  

  - ぽんしゅきープロジェクト雛形設定作業  
  [spring initializer](https://start.spring.io/) ページで以下の設定を行います。  
    - Project：Gradle Project  
    - Language：Java  
    - Spring Boot：2.3.1  
    - **Project Metadata**  
    Group : com.javajo  
    Artifact：ponshukey  
    Name：ponshukey  
    Description：Sake SNS  
    Package name：com.javajo.ponshukey  
    Packageing：Jar  
    Java：11  

  - ぽんしゅきープロジェクト雛形作成  
  前ステップの設定が完了しましたら、  
  **GENERATE** ボタンをクリック（オプションは設定しません)します。  
  ぽんしゅきープロジェクト雛形（ **ponshukey.zip** ファイル）がダウンロードされます。

- OpenJDK 11 インストール  
【概要】  
　ぽんしゅきープロジェクト雛形で指定した、Java11 をインストールします。  

  - [SDKMAN!](https://sdkman.io/install) を使う場合は、[ハンズオン資料](https://github.com/java-women/HelloWorldHandsOn/blob/master/PITCHME.md) を参照してください。  
  
  - OpenJDK サイトからダウンロードする場合  
  [Archived OpenJDK](http://jdk.java.net/archive/) から OpenJDK 11 アーカイブをダウンロード。  
  ダウンロードした **openjdk-11.0.2_osx-x64_bin.tar.gz** を展開し、  
  環境変数 JAVA_HOME に jdk-11.jdk/Contents/Home/ を設定し、  
  環境変数 PATH に $JAVA_HOME/bin へのパスを通してください。

- ぽんしゅきープロジェクトの初期設定  
【概要】  
　Spring Boot で作成した、ぽんしゅきープロジェクトを展開し、  
　IDEでプロジェクトの gradleタスクの bootRun を実行します。

  - ぽんしゅきープロジェクトの展開  
   適当なディレクトリに ponshukey.zip ファイルを展開します。
   
  - IntelliJ IDEA コミュニティ版を利用する場合  
  IntelliJ IDEA コミュニティ版・ダウンロード  
  [https://www.jetbrains.com/ja-jp/idea/download/](https://www.jetbrains.com/ja-jp/idea/download/)

  - IDE を起動して、ぽんしゅきープロジェクトを開きます。
  
  - IDE の設定から、Project SDK を java8 から、  
  インストールした java11 に変更します。

  - IDE の Gradle ツールウィンドウを開き、  
  ponshukey > Tasks > application > bootRun を実行します。

- Java女子部リポジトリに、ぽんしゅきープロジェクト追加  
【概要】  
　初期設定を行った **プロジェクト** をリポジトリに追加しました。
  - Java女子部ぽんしゅきープロジェクトリポジトリ  
  [https://github.com/java-women/Ponsyukey](https://github.com/java-women/Ponsyukey)

### 開発環境構築 issueの作成
- 開発環境の作成 #7  
[https://github.com/java-women/Ponsyukey/issues/7](https://github.com/java-women/Ponsyukey/issues/7)


## next action(タスク洗い出し)
- 画面遷移 API開発  
Swaggerで、mockAPI作成を予定
- 宿題
  - みんなで開発環境をととのえる  
1.開発に必要なのは、Docker と OpenJDK11 のインストールのみです。  
2.Java女子部リポジトリの [ぽんしゅきープロジェクト](https://github.com/java-women/Ponsyukey) をクローンしてください。  
3.問題があったりアドバイスが必要な場合は、[Discord](https://discord.com/channels/701338785950203945/701338785950203948) で相談してくださいね。


## 議事録作成者の感想ひとこと
フレームワークの色々な話を聞けて刺激になりました。  
本日参加していない人でも開発環境を作ってもらえるよう、モブプロ作業をメモするのが大変でした。（笑）
