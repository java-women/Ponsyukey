## 必要なもの
- Java 17
- Dockerクライアント ([Mac](https://docs.docker.com/desktop/mac/install/), [Windows](https://docs.docker.com/desktop/windows/install/))  
(Linuxでは ディストリ別の [Docker engine](https://docs.docker.com/engine/install/) と [compose](https://docs.docker.com/compose/install/#install-compose-on-linux-systems) のインストールが必要です)

## ローカルでのDB立ち上げ
下記コマンドを実行してください。Docker上でSQL Serverが立ち上がり、DDLが適用されます。
**セットアップシェルは本リポジトリのルートディレクトリから実行してください。**    
Windowsの方はGit Bashもしくはdocker desktopのWLS 2インテグレーションを有効化した状態でWSL 2から実行してください。 
```shell
docker-compose up -d
```

DBを落とすには以下を実行してください。なお、登録したデータは消えるので要注意！
```shell
docker-compose down
```

## SQLServerの操作方法
dockerコンテナに入って下記のコマンドを実行してください。
```shell
/opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD
```

```sql
USE ponsyukey
GO
```

## postmanからAPI実行
postmanに設定ファイル`tools/Ponsyukey.postman_collection.json`をimportしてください。

## アプリの実行
```shell
./gradlew bootRun
```
