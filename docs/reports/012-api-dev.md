# 第 12 回 API 設計-開発 2021/03/21 14:00-17:30

[https://javajo.doorkeeper.jp/events/118778](https://javajo.doorkeeper.jp/events/118778)

## 議事録作成者
Akiko Fukunaga


## 参加者(敬称略)
- maaya
- manami
- aya
- mutumi
- yuki
- mii
- robo
- maaya
- yokona
- akiko


## 議題にしたいこと or 前回の next action

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - おすすめお花見スポット
- 前回のおさらい
  -  リモートデスクトップ接続の手順
- API 開発
  -  リモートデスクトップ接続の手順
  -  API作成開始
 
 
## 議事内容
1. エラー対応：import javajo.ponsyukey.model.UNKNOWN_BASE_TYPE
- 議論内容
  OPEN APIの出力でエラーになっているのではないか？(参考)https://github.com/OpenAPITools/openapi-generator/issues/2236  
  2020年10月に一部Updateがあった。  
  
  Swagerの方で提示する必要がある？  
  OpenApi.yamlの修正を実施。$refは、、Schemaの直下に持ってくるのがいいのでは(下記参照)。  
  
  記載例
  ```
  "responses": {
    "200": {
      "description": "The response",
      "schema": {　
        "$ref": "#/components/schemas/user" 　
      }
    }
  }
   ```

- 対応方法 
  1.Open APIのバージョンを修正
  2.OpenApi.yamlを修正
    propertiesの中身を直下に直接記載できない仕様。  
    properties配下の項目をcomponentsに移動。propertiesの外に出したcomponentsを$refするように修正。  
    $refは、Schemaの直下に記載する。(参考)　https://swagger.io/docs/specification/using-ref/  

    記載例
    ```schema:
      &ref: /"#/components/schemas/user"
    ```
  
2. エラー対応：jacksonエラーの対応
- 議論内容
  SaketomowithAuth.javaでjacksonエラーが発生。optimize importを実施し、削除を実施。  
  org.openapitools.jacksonは削除するが、 OpenApi.yamlを修正しOpenAPI generatorを実行すれば、再び現れるのではないか。  
  インターフェース以外は、OpenAPIGeneraterを実行しても上書きしない。運用に困ったら見直す。  

- 対応方法
  1. OpenAPI generator実行時、Generate対象外ソースの設定を実施
    openapi-generator-ignoreを修正。Generate対象外のJavaコードを掲載。  
     
  2. modelの中身自体をoptimize⇒importする。

3. エラー対応：Servletエラーの対応
- 議論内容
  単純にサーブレットが読めていない問題。  
  ApiUtil.javaは残す必要があるのか？APIの標準設定？  
  参照が不足している。APIのライブラリが合っていない。  
  
- 対応方法
  build.gradle を修正
  - spring-boot-starter-web　の参照を追加  
  - springfox-spring-web　の参照を追加  
  - configOptions配下に、openApiNullable: "false"を追加。  
    Nullableクラスがjacksonと、Springの両方から提供されている。  
    jacksonからは使わないように修正。  


## 今回の成果
下記のエラーが解消された
1. import javajo.ponsyukey.model.UNKNOWN_BASE_TYPEエラー
2. jacksonエラー
3. Servletエラー

## next action(タスク洗い出し)
- 宿題：Googleのlibraryが呼び出される問題の解消
  - 直した人はPullリクをしてください.
- エラー対応後、中身を作成予定。

## 議事録作成者の感想ひとこと
ひたすら不具合と向き合う回でした。今回は宿題もあるみたいです
