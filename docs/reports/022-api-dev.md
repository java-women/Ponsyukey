# 第 22 回 API 開発 2022/02/20 14:00-17:00

[https://javajo.doorkeeper.jp/events/132420](https://javajo.doorkeeper.jp/events/132420)

## 議事録作成者
Takayama    
    
## 参加者(敬称略)    
- みい
- maaya
- Takayama


## 議題にしたいこと or 前回の next action
    
★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！    

- アイスブレイク
  - 名前
  - エンジニア的近況報告
  - 海外旅行行けるようになったら真っ先にどこ行きたいですか(または海外旅行に行きたくないでも)
- 前回のおさらい
- 今日やること
  - 誰も宿題やってなかったので宿題から・・・
    - [https://github.com/java-women/Ponsyukey/issues/27](https://github.com/java-women/Ponsyukey/issues/27)
    - [https://github.com/java-women/Ponsyukey/tree/wip_lof4shell_patch_20220122](https://github.com/java-women/Ponsyukey/tree/wip_lof4shell_patch_20220122)

## 今回の成果    
- SpringFox 2 -> 3 version up    
- sqlの生成がWindows, Macでdirectoryが違っていた？
```
drwxrwxr-x@ 3 tomoyo.takayama  INTRA\Domain Users   96 Feb 20 14:31 META-INF
drwxrwxr-x@ 3 tomoyo.takayama  INTRA\Domain Users   96 Feb 20 14:31 META-INF.javajo.ponsyukey.database.dao
drwxrwxr-x@ 3 tomoyo.takayama  INTRA\Domain Users   96 Feb 20 14:31 META-INF.javajo.ponsyukey.database.dao.PrefectureDao
-rw-rw-r--@ 1 tomoyo.takayama  INTRA\Domain Users  448 Feb 20 14:31 application.properties
```
- domaでのsql生成がエラーになっていたのでは？
```
processResources.destinationDir = compileJava.destinationDir
```

- compile error解消して、masterへマージできた
  - dependon の依存関係を整理した
  - duplicate storategy のエラーがでたのでinclude設定をしてとり急ぎ解決
    - 今後これのせいでエラーが出たらまた別途解決を行う

## next action(タスク洗い出し)
- getSakeDetailのエラー系テスト実装
- 他のAPIを並列で作成していきましょー


## 議事録作成者の感想ひとこと
gradle は、難しかった


