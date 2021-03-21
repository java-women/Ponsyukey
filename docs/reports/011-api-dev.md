# 第 11 回 API 設計-開発 2021/02/21 14:00-17:00

[https://javajo.doorkeeper.jp/events/117036](https://javajo.doorkeeper.jp/events/117036)

## 議事録作成者

- きの子

## 参加者(敬称略)

- robo maaya あや Mutsum Yuki きの子


## 議題にしたいこと or 前回の next action

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - 最近の気になるニュース
    - 政治、covid、地元ニュース、天気、新発売デバイス・・・なんでもよいです
- 前回のおさらい
- API 開発

## 議事内容

### アイスブレイク

最近のみんなの気になるニュース

- ポケモン
- COVID-19, COCOA
- Clubhouse
- どろろがYoutubeで無料公開中
- 花粉がひどい・・・

### 環境準備

ハッカソン時に共同利用できる開発環境をMicrosoft Azureに準備したため、Microsoft Remote Desktopでリモート利用。

### API実装開始

#### 方針

簡単なAPIを1本作りながら設計方針を固めていく。

#### OpenAPI Documentからコード生成

Swaggerを利用して作成したOpenAPI Documentから、下記Gradleプラグインでコード生成。

openapi-generator/modules/openapi-generator-gradle-plugin at master · OpenAPITools/openapi-generator
https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin

今後Swaggerドキュメント変更時に、ソースコードと極力同期を取りたい。同期が煩雑にならないようにする。

プラグインのREADMEを見ながら、build.gradleに設定を書いてコード生成。

54b85af5013ca633f1a5951c9f490cd5c378815b

#### 設計

方針：オニオンアーキテクチャーっぽい感じで。

Presentationにする?Controllerにする??
PresentationはUIを含みそうなのでControllerで。

ひとまず `javajo.ponsyukey.controller` パッケージを作成し、生成されたコードを配置。 サブパッケージ構成はあとから考える。

テストコードも生成できそうだけど、できていないようなので、あとから。

実装をすすめようとしたが、一部参照ライブラリが存在せず、Importエラー。`spring-boot-starter-web` をGradleの依存関係に追加。

```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	...
```

Java EE から Jakarta EE への名称変更に伴うパッケージ名変更の影響がありそう？

あんまりハマるようなら、使うのやめましょう。

`import javajo.ponsyukey.model.UNKNOWN_BASE_TYPE` が解決できない。

ドキュメントをなおせばよさそう。

解決しなかったので次回の宿題！


## 今回の成果

- リモート開発環境での共同作業ができる状態になった
- 開発方針決定
- OpenAPI(Swagger)からのコード生成
- 設計方針がふんわり決まった

## next action(タスク洗い出し)

- とりあえずビルドが通る状態にする


## 議事録作成者の感想ひとこと

- めっちゃ進捗でててすごい。