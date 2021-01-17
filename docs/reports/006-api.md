# 第6回 API設計 2020/09/20 14:00-17:00

[https://javajo.doorkeeper.jp/events/110615](https://javajo.doorkeeper.jp/events/110615)  

## 議事録作成者
むつみ

## 参加者(敬称略)
Akiko
aya
Massya Ishida
Yuki
いちご
きの子
らん
合志
robo

## 議題にしたいこと or 前回の next action
- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - シルバーウィークなにしてますか・何する予定ですか
- 前回のおさらい
- API設計つづき
  - 作成した会員登録API定義の見直し
  
## 議事内容
- 前回のおさらい
	APIの作成
	必要なAPI一覧を作成
	mockを１つswaggerで作成完了
	openAPI.yaml
	今回は出来上がったAPIをレビューする
	会員登録APIの設計からスタート
	利用者の名前をSaketomoに決定
	API仕様書をモブプロで作成

- 環境情報の再確認
→環境のページを参照
https://github.com/java-women/Ponsyukey/blob/master/docs/reports/4-environment.md

  ※補足
	VisualStudioCodeを使うと何が便利？
	Extensionを入れると、塊ごと表示してくれる
	コードが長くなってきた時に便利
	ただ、実際の動きを見るのはswagger Editorが便利なので、一旦Swagger Editorで開発を続ける

- レビューの結果以下の内容を決めていく
	エラー設計（セキュリティがたりてない）
	パスワードが平文になっている。エンコードしたい
	→Swaggerの設計書にはどうかくのか？
	Requiredの書き方の修正
	バリデーションの設計

- Requiredの書き方
	components>shemas>propertiesと同じ階層にrequiredを作成
	何をrequiredに設定する？
	イメージは？
	defalut以外のものが来たら、よしなにdefaultに設定する？
	イメージは？勝手にdefault画像に設定する？
	requiredには入れない。
	enumにないあたい、もしくは空/nullの場合は、バリデーションチェックで対応。

- パスワードのエンコード
	パスワードいつもどんなlibrary使ってる？
	hash、base64、aes256
		→いったんHash化

- レスポンス
	バリデーションエラー時も200でレスポンスする
		→APIのレスポンスとしては、正しいものを返しているので、200で返し、レスポンスのボディーとして、エラーコードを返す
	ログイン時の認証失敗みたいな、エアーページに遷移させる必要がある場合、400系に設定する
	HTTP レスポンスステータスコード
	https://developer.mozilla.org/ja/docs/Web/HTTP/Status
	responseをcomponent化して、referenceで参照

- バリデーション
	エラーレスポンスの設計
  →正常パターンから決めましょう
	→responseとして何返す？
		次の画面を表示するのに必要な情報
		→name
		→id

  ”saketomo” model 会員登録のレスポンスにしか使わないのであれば、それ用のmodelにする？
	modelの用途を考える

  ※DBに合わせてsaketomoをmodel化（component化）するか、
	各APIの用途に合わせてモデル化するか
	共通化できるものだけcomponent化する？

  https://swagger.io/docs/specification/using-ref/
		→ユースケースごとに設計すべき
		→何度も出るものは共通化していく

  なるべく汎用的に使えるように構造化していく
		→requestを見直す
		→まずはそれぞれ書き出し、最後にリファクタリングする

- responseは何を返す？
	resultCode
	型は？integer? string?
	桁数、計算、前ゼロ欠ける問題、分析をする場合は数字はintegerにしておかないと途中でエラー起こったり。。
	今回は、このステータスコードが処理に使われることがないから、汎用時にstringにする
	response bodyとresultCodeは並列？
	複数スキーマを返すケース？
  
  saketomo IDは採番する？
	→user nameにローマ字しか入れないのは好まないので、IDは採番する。
	→type:integer fomat:int64 ※numberはlongと同様。今回は小数点は取り扱わないからint64
	名前と画像はSaketomoのプロフィール的な情報、email、pwはsaketomoの中で会員情報的なものauthとして定義
		→requestではsaketomoを指定、responseではsaketomoのauthを除いたものを返す。
    
## 今回の成果
  API設計正常系レスポンス

## next action(タスク洗い出し)
  API設計エラー系（サーバーエラー、バリデーションエラー、認証エラー等）のレスポンス設計

## 議事録作成者の感想ひとこと
  エラーコードの型をどうするか？それはなぜか？など、普段仕事でサンプルを見ながら設計している時にはあまり気にしなかったところでいろんな考えがあって議論したことが新鮮で、とても良い勉強になりました！
