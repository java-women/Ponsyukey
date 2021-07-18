-- countryの初期データをInsertする

-- prefectureの初期データをInsertする
BULK INSERT prefecture
FROM 'db/data/bulk_insert_prefecture.csv'
WITH ( FIELDTERMINATOR =',' );
-- regionsの初期データをInsertする
