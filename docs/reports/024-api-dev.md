# 第 24 回 API 開発 2022/04/17 14:00-17:00

https://javajo.doorkeeper.jp/events/134787

## 議事録作成者
maaya

## 参加者(敬称略)
- yu-ki
- mii
- aya
- maaya

## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - お気に入りのガジェットやデスク周りのアイテムを自慢してください！
- 前回のおさらい
- 今日やること
  - ExceptionHandlerで例外を拾えるようにする(宿題)
  - 独自例外を実装する。
  - エラーのレスポンスを実装する。

## 議事内容
### 実装していたExceptionHandlerの有効化
https://github.com/java-women/Ponsyukey/pull/30    
    
前回のデバッグ作業の際、exceptionをcatchした状態でexceptionHandlerにthrowされない！とわちゃわちゃしていたが、そもそもcatchしちゃってたらHandlerでは拾えないですね？と思い直しデバッグ方法を修正。無事ExceptionHandlerで拾えるようになりました。    
    
メソッドの引数関連も整理し、ついでに全APIをREST APIとしてreturnできるように@Controller -> @RestControllerに変更。    

#### 参考exception図
![image](https://user-images.githubusercontent.com/10239748/163704842-86324e16-5c4b-4c3c-ba10-9ef11298cf79.png)

#### 懸念事項
- Exception/RuntimeExceptionというバカでかいthrowを期待したつくりになってる
- thowさせようとするとInterfaceに追記が発生する。open-api generatorとの兼ねあいの検討が必要


## 今回の成果
ExceptionHandlerができたよー

## next action(タスク洗い出し)
- container実行してSQLとの連携テスト
- 2-3人グループくらいに分かれて、それぞれ別APIを実装

## 議事録作成者の感想ひとこと
もうしばらくexceptionに対してこんなに議論することはないとおもう。

### 次回アイスブレイクのお題
ゴールデンウィーク何しましたか
