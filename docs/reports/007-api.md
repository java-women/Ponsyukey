# 第7回 API設計 2020/10/18 14:00-17:00

[https://javajo.doorkeeper.jp/events/113053](https://javajo.doorkeeper.jp/events/113053)  

## 議事録作成者
あや

## 参加者(敬称略)
- miyuki
- maaya
- aya
- yukie
- ellie
- robo
- むつみ
- まなみ
- よこな
- akiko

## 議題にしたいこと or 前回の next action
- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - 好きなお鍋はなんですか
- 前回のおさらい
- API設計つづき
  - API設計エラー系
  - 他のAPIの設計開始
  
## 議事内容
- 引き続き[Swagger Editor](https://editor.swagger.io/)を使ってモブプロでswaggerでAPIドキュメントを作成
- エラーコードは全部正常系を書いてから後でまとめて作る
- 会員取得APIから作成
    - GET /saketomo/{saketomoId}
    - [この辺](https://swagger.io/docs/specification/describing-parameters/)を見ながら作成
    - idは持たせる（他と同じ構造でやれるように
    - なんで?user=1みたいにパラメータで書かないで/user/1みたいにURLの中に書くの？
        - RESTの設計で、絶対に使う固定値みたいなのはURLの中に書いて、検索条件みたいなついたりつかなかったりするのはパラメータで書くみたい
- 会員編集APIも作成
    - POST /saketomo/{saketomoId}
    - 最初に全部getとpostで作ろうって話したからpostで作成する
    - request bodyをrequiredにするかどうか
        - そもそも会員情報をそのまま全部request bodyに入れて登録と同じように値を更新するか、編集したいもの（差分）だけをrequest body入れてそこだけを更新するか
            - いったん全部入れる方向性で！
            - もしフロントで不具合があったら変える
        - 故にrequest bodyのrequiredはtrue
- Zoomで画面に落書きできる！
    - 「オプションを表示」->「コメントをつける」
- 酒情報一覧取得APIも作成〜！
    - その前に[miro](https://miro.com/app/board/o9J_ktzRgdo=/)で復習
    - GET /sake
    - saketomoにURLの形を合わせて、ただのGET /sakeで酒情報一覧を取得する（個別の酒情報を取得する場合は/sake/1とかになる
    - ページングはlimitとoffsetでやる

## 今回の成果
- 会員取得API
- 会員編集API
- 酒情報一覧取得API（これは途中まで）

## next action(タスク洗い出し)
酒情報一覧取得APIのレスポンスから

## 議事録作成者の感想ひとこと
- Java女子部のメインの方のイベントが10/31にあるから来てね！
    - https://javajo.doorkeeper.jp/events/112450
- 慣れてきてAPI設計早くなってきた〜！！

