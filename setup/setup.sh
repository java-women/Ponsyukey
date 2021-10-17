#!/bin/bash
set -e

# SQL Serverを起動する
/opt/mssql/bin/sqlservr

MSSQL_USER='sa'
MSSQL_PASSWORD='V}Q{kA*"zJlbuymS'

echo === DDLを適用する ===
# データベースを作成
/opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -Q "create database ponsyukey"
# DDLを適用
/opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /db/02_create_brewery_tables.sql
/opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /db/03_create_sake_tables.sql
/opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /db/01_create_saketomo_tables.sql
/opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /db/04_create_review_tables.sql

echo === 酒情報を1件登録する ===
/opt/mssql-tools/bin/sqlcmd -U $MSSQL_USER -P $MSSQL_PASSWORD -i /setup/insert-sake.sql

echo === おわり ===