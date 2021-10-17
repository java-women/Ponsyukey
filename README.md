## 必要なもの
- Java 11
- Dockerクライアント ([Mac](https://docs.docker.com/desktop/mac/install/), [Windows](https://docs.docker.com/desktop/windows/install/))

## ローカルでのDB立ち上げ
セットアップ用シェルスクリプトを実行してください。Docker上でSQL Serverが立ち上がり、DDLが適用されます。
**セットアップシェルは本リポジトリのルートディレクトリから実行してください。**    
Windowsの方はGit Bashを使用してください。 (WLS2だと落ちます)
```shell
./setup/setup.sh
```

DBを落とすには以下を実行してください。なお、登録したデータは消えるので要注意！
```shell
docker-compose down
```

## アプリの実行
```shell
./gradlew bootRun
```
