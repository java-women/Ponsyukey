現状と理想

- ローカルでのDB立ち上げ
```shell
docker-compose up
```
FYI 上記にて立ち上がるDBへのログインの仕方
```shell
docker exec -it mssql-test /opt/mssql-tools/bin/sqlcmd -U sa -P 'V}Q{kA*"zJlbuymS'
```

- TODO(要相談): データを効率よく適用する方法どうする？ [Flyway](https://flywaydb.org/) のようなマイグレーションツールを入れてよい？
- アプリの実行
```shell
./gradlew bootRun
```
