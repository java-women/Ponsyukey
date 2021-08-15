# 第 17 回 API 開発 2021/08/15 14:00-17:00

[https://javajo.doorkeeper.jp/events/124785](https://javajo.doorkeeper.jp/events/124785)

## 議事録作成者
- robo

## 参加者(敬称略)

- yokona
- aya
- robo
- yuki
- maaya （遅刻のため挨拶なし)


## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - 2021年下半期の目標
- 前回のおさらい
- 今日やること
    - APIのサービスの中身の作成
    - テーブルのコメントが流れないのでどうにかする

## 議事内容

- SAKE API 作成の続き
  - ORマッパーの選定  
    - 資料  
    Java ORマッパー選定のポイント #jsug  
    https://www.slideshare.net/masatoshitada7/java-or-jsug

    - DOMA を選択  
    選択理由 ⇒ ネット上に情報が多く、有識者に確認もできる。

- DOMA 公式資料  
  - Welcome to Doma  
  https://doma.readthedocs.io/en/2.19.2/  

  - Welcome to Doma 2  
  https://doma.readthedocs.io/en/2.47.1/  


- Ponshukey プロジェクトに DOMA 環境をインストール  
公式資料にしたがって、Gradle プロジェクトに DOMA ORマッパー環境をインストールします。 
 
  - build.gradle の dependencies にプラグインを追加  
    - 資料  
    Gradle を使ったビルド  
    https://doma.readthedocs.io/en/2.4.1/build/  
    *build.gradle の設定*

- SAKE Entity 作成  
前回までに作成した SAKEテーブルや SAKEレスポンスの定義を参考にEntityやDAOを定義します。

  - Ponsyukey/db/ddl/03_create_sake_tables.sql  
  https://github.com/java-women/Ponsyukey/blob/master/db/ddl/03_create_sake_tables.sql  

  - Ponsyukey/src/main/java/javajo/ponsyukey/model/SakeResponse.java  
  https://github.com/java-women/Ponsyukey/blob/master/src/main/java/javajo/ponsyukey/model/SakeResponse.java

  - Entity 作成  
    - 資料  
    エンティティクラス  
    https://doma.readthedocs.io/en/2.4.1/entity/  
    
    - Ponsyukey/src/main/java/javajo/ponsyukey/ の下に database/AppConfig.java を作成  
    https://github.com/java-women/Ponsyukey/blob/master/src/main/java/javajo/ponsyukey/database/AppConfig.java  

    - Ponsyukey/src/main/java/javajo/ponsyukey/ の下に database/entity/sake.java を作成  
    https://github.com/java-women/Ponsyukey/blob/master/src/main/java/javajo/ponsyukey/database/entity/Sake.java  


  - DAO 作成  
  DOMA-Gen ツールで、DAO を自動生成します。  

    - 資料  
    Gen タスク  
    https://doma-gen.readthedocs.io/en/2.6.1/gen/  

    - 参考資料  
    SpringBoot＊doma-genでエンティティ/Daoを自動生成する手順  
    https://springhack.com/springboot%EF%BC%8Adoma-gen%E3%81%A7%E3%82%A8%E3%83%B3%E3%83%86%E3%82%A3%E3%83%86%E3%82%A3-dao%E3%82%92%E8%87%AA%E5%8B%95%E7%94%9F%E6%88%90/  

    - ビルドエラー修正
    Gradleメニュー > Tasks > doma-gen > gen から DAO を自動生成させるとビルドエラーが発生した。

      - ビルドが通るように修正  
      build.gradle と src/test/java/com/javajo/ponshukey/PonshukeyApplicationTests.java を修正。  
      - 修正コミット  
      https://github.com/java-women/Ponsyukey/commit/313796e35e7a622f47365ec044c824cd5e0576d2  


  - Entity 作成２  
  SakeBrewery.java を新規追加します。  
  前回までに作成した Sake Brewery テーブルやモデルの定義を参考にEntityを定義します。

    - Ponsyukey/db/ddl/02_create_brewery_tables.sql  
    https://github.com/java-women/Ponsyukey/blob/master/db/ddl/02_create_brewery_tables.sql  

    - Ponsyukey/src/main/java/javajo/ponsyukey/model/SakeBrewery.java  
    https://github.com/java-women/Ponsyukey/blob/master/src/main/java/javajo/ponsyukey/model/SakeBrewery.java  

    Sake Brewery エンティティクラス
    - Ponsyukey/src/main/java/javajo/ponsyukey/database/entity/SakeBrewery.java  
    https://github.com/java-women/Ponsyukey/tree/master/src/main/java/javajo/ponsyukey/database/entity/SakeBrewery.java  


- **エンティティ結合アーキテクチャとして、ORマッパ上の Application Join を採用します。**  
  - 採用理由  
  エンティティ結合については、データ量が多いと結合コストの観点から SQL で Join する方法が一般的ですが、  
  今回は、Java プログラム開発を目的とするプロジェクトのため Application Join を採用します。



## 今回の成果


## next action(タスク洗い出し)


## 議事録作成者の感想ひとこと
