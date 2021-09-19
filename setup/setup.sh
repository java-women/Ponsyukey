#!/bin/bash
set -e

MSSQL_USER='sa'
MSSQL_PASSWORD='V}Q{kA*"zJlbuymS'

echo === SQL Server入りのDockerコンテナを立ち上げる ===
docker-compose up -d

# SQL Serverの起動待機(荒業)
# 3秒に1度SQLを投げてみて正常実行されるようになるのを待つ
while :
do
  sleep 3
  docker exec -it mssql-test /opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -Q "select top 1 name from SYS.DATABASES;" > /dev/null || {
    continue
  }
  break
done

echo === DDLを適用する ===
# コンテナ内にSQLファイルをお引越し
docker cp db/ddl/04_create_review_tables.sql `docker-compose ps -q mssql`:/tmp/
docker cp db/ddl/03_create_sake_tables.sql `docker-compose ps -q mssql`:/tmp/
docker cp db/ddl/02_create_brewery_tables.sql `docker-compose ps -q mssql`:/tmp/
docker cp db/ddl/01_create_saketomo_tables.sql `docker-compose ps -q mssql`:/tmp/
# データベースを作成
docker exec -it mssql-test /opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -Q "create database ponsyukey"
# DDLを適用
docker exec -it mssql-test /opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /tmp/02_create_brewery_tables.sql
docker exec -it mssql-test /opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /tmp/03_create_sake_tables.sql
docker exec -it mssql-test /opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /tmp/01_create_saketomo_tables.sql
docker exec -it mssql-test /opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /tmp/04_create_review_tables.sql

echo === 酒情報を1件登録する ===
# コンテナ内にSQLファイルをお引越し
docker cp setup/insert-sake.sql `docker-compose ps -q mssql`:/tmp/
# データを登録
docker exec -it mssql-test /opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /tmp/insert-sake.sql
