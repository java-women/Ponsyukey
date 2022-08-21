# 第 28 回 API 開発 2022/08/21 14:00-17:00

https://javajo.doorkeeper.jp/events/140191

## 議事録作成者
よこな

## 参加者(敬称略)
- みい
- あや
- まーや
- ろぼ
- よこな

## 議題にしたいこと or 前回の next action

★アイスブレイクの「今月のお題」は議事録作成者が決定する方向になりました！

- アイスブレイク
    - 名前
    - エンジニア的近況報告
    - 最近買った便利なもの
- 前回のおさらい
- 今日やること
  - 酒情報一覧取得APIの動作確認を行う
    - https://github.com/java-women/Ponsyukey/pull/33
  - 新しいAPIに着手する

## 議事内容(概要)

#### エラーとのバトル集

- ひとつめ
```
org.springframework.cglib.core.CodeGenerationException: java.lang.reflect.InaccessibleObjectException-->Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.P
rotectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @16394a1d                                                                                                  
at org.springframework.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:589) ~[spring-core-5.3.15.jar:5.3.15]                                                                                                              
at org.springframework.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:363) ~[spring-core-5.3.15.jar:5.3.15]                                                                                             
at org.springframework.cglib.proxy.Enhancer.generate(Enhancer.java:585) ~[spring-core-5.3.15.jar:5.3.15]                                                                                                                        
at org.springframework.cglib.core.AbstractClassGenerator$ClassLoaderData$3.apply(AbstractClassGenerator.java:110) ~[spring-core-5.3.15.jar:5.3.15]                                                                              
at org.springframework.cglib.core.AbstractClassGenerator$ClassLoaderData$3.apply(AbstractClassGenerator.java:108) ~[spring-core-5.3.15.jar:5.3.15]                                                                              
at org.springframework.cglib.core.internal.LoadingCache$2.call(LoadingCache.java:54) ~[spring-core-5.3.15.jar:5.3.15]                                                                                                           
at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264) ~[na:na]                                                                                                                                                  
at org.springframework.cglib.core.internal.LoadingCache.createEntry(LoadingCache.java:61) ~[spring-core-5.3.15.jar:5.3.15]                                                                                                      
at org.springframework.cglib.core.internal.LoadingCache.get(LoadingCache.java:34) ~[spring-core-5.3.15.jar:5.3.15]                                                                                                              
at org.springframework.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:134) ~[spring-core-5.3.15.jar:5.3.15]                                                                                  
at org.springframework.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:319) ~[spring-core-5.3.15.jar:5.3.15]                                                                                               
at org.springframework.cglib.proxy.Enhancer.createHelper(Enhancer.java:572) ~[spring-core-5.3.15.jar:5.3.15]                                                                                                                    
at org.springframework.cglib.proxy.Enhancer.createClass(Enhancer.java:419) ~[spring-core-5.3.15.jar:5.3.15]                                                                                                                     
at org.springframework.context.annotation.ConfigurationClassEnhancer.createClass(ConfigurationClassEnhancer.java:137) ~[spring-context-5.3.15.jar:5.3.15]                                                                       
at org.springframework.context.annotation.ConfigurationClassEnhancer.enhance(ConfigurationClassEnhancer.java:109) ~[spring-context-5.3.15.jar:5.3.15]                                                                           
at org.springframework.context.annotation.ConfigurationClassPostProcessor.enhanceConfigurationClasses(ConfigurationClassPostProcessor.java:447) ~[spring-context-5.3.15.jar:5.3.15]                                             
at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanFactory(ConfigurationClassPostProcessor.java:268) ~[spring-context-5.3.15.jar:5.3.15]                                                  
at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:325) ~[spring-context-5.3.15.jar:5.3.15]                                        
at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:147) ~[spring-context-5.3.15.jar:5.3.15]                                        
at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:746) ~[spring-context-5.3.15.jar:5.3.15]                                                      
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:564) ~[spring-context-5.3.15.jar:5.3.15]                                                                              
at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:145) ~[spring-boot-2.6.3.jar:2.6.3]                                                          
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:732) ~[spring-boot-2.6.3.jar:2.6.3]                                                                                                                
at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:414) ~[spring-boot-2.6.3.jar:2.6.3]                                                                                                         
at org.springframework.boot.SpringApplication.run(SpringApplication.java:302) ~[spring-boot-2.6.3.jar:2.6.3]                                                                                                                    
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1303) ~[spring-boot-2.6.3.jar:2.6.3]                                                                                                                   
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1292) ~[spring-boot-2.6.3.jar:2.6.3]                                                                                                                   
at javajo.ponsyukey.PonsyukeyApplication.main(PonsyukeyApplication.java:9) ~[main/:na]
Caused by: java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatE
rror accessible: module java.base does not "opens java.lang" to unnamed module @16394a1d                                                                                                                                                
        at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:354) ~[na:na]                                                                                                                       
        at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297) ~[na:na]                                                                                                                       
        at java.base/java.lang.reflect.Method.checkCanSetAccessible(Method.java:200) ~[na:na]                                                                                                                                           
        at java.base/java.lang.reflect.Method.setAccessible(Method.java:194) ~[na:na]                                                                                                                                                   
        at org.springframework.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:553) ~[spring-core-5.3.15.jar:5.3.15]                                                                                                              
        ... 27 common frames omitted  
```

→`build.gradle` に下記を追記
```
application {
	applicationDefaultJvmArgs = ['--add-opens', 'java.base/java.lang=ALL-UNNAMED']
}
```

- ふたつめ
```
The cause is as follows: com.microsoft.sqlserver.jdbc.SQLServerException: ドライバーが SSL (Secure Sockets Layer) 暗号化による SQL Server への安全な接続を確立できませんでした。エラー: "PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target"。 ClientConnectionId:2a907ab7-c7e4-4107-8c32-87dcf81e4fa3; ドライバーが SSL (Secure Sockets Layer) 暗号化による SQL Server への安全な接続を確立できませんでした。エラー: "PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target"。 ClientConnectionId:2a907ab7-c7e4-4107-8c32-87dcf81e4fa3; nested exception is com.microsoft.sqlserver.jdbc.SQLServerException: ドライバーが SSL (Secure Sockets Layer) 暗号化による SQL Server への安全な接続を確立できませんでした。エラー: "PKIX path building failed: sun
```

→SQLServerのSSL設定をいったんオフ

#### ブランチのマージいろいろ
`master`を信じれば良いようにマージした。ミスも発生したのでこまめに`master`に入れようね（今はまだ動かなくて良いので）

#### API動作確認

- カラム名とフィールド名を一致させる設定を入れた（以下、うらがみさんより）
```
たまたま目にしたからコメントするけどhttp://application.propertiesにdoma.naming=SNAKE_LOWER_CASEを書くと@ Columnでカラム名を明示しなくてもよくなるよ。
```

- SQLServerでテキストを入力する時は頭に `N` をつける必要があるので直した（これのおかげで文字化けしなくなったよ）

- PORT番号を`9898`にした。ちなみに`getSake`の動作確認は以下でできる
`http://localhost:9898/sake/29892458-f103-89d5-a724-72f789e16e3b`

### 今回の成果

getSake APIが動きました✨✨✨✨✨

### next action(タスク洗い出し)

- 酒情報登録API
- 会員情報登録API

### 議事録作成者の感想ひとこと

動いてよかったっぴ！！！そろそろ開発が楽しくなるねー。

## 次回アイスブレイクのお題

好きな音楽おしえてくださーい！
