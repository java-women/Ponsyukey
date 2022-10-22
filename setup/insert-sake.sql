use ponsyukey;
insert into country values(81, N'日本');
insert into prefecture values(1, N'北海道');
insert into region values(1, 81, 1);
insert into brewery values('30149f16-ec9c-58a2-f7f5-78b0620d0dc7', N'じゃばじょ酒屋', '1');
insert into sake values('29892458-f103-89d5-a724-72f789e16e3b', N'ナイスお酒', 'https://image1.javajo.com', '30149f16-ec9c-58a2-f7f5-78b0620d0dc7', 10, 0.5, N'純米大吟醸', N'おいしいお酒です！');
insert into saketomo values('b1e9ad94-cee9-43e2-a6de-fa2da77348e1', 'name', 'icon1', 'email', 'password', '2022-06-25 15:15:00', '2022-06-25 15:15:00');
insert into taste values('B8B72C9C-DB56-43D4-BD2F-1380B04687AB', N'すっきり'), ('98E4326E-AEC3-4611-871B-10279BF2D0B6', N'淡麗'), ('C0B338BC-70B5-44D2-AB71-4BBDDC23AD72', N'華やか'), ('7708E166-AAA1-4115-994F-777499E020A8', N'甘口'), ('F084A0D8-9030-43D1-970B-DC574EEA331F', N'辛口');
insert into taste_map values('29892458-f103-89d5-a724-72f789e16e3b', 'B8B72C9C-DB56-43D4-BD2F-1380B04687AB'), ('29892458-f103-89d5-a724-72f789e16e3b', '98E4326E-AEC3-4611-871B-10279BF2D0B6'), ('29892458-f103-89d5-a724-72f789e16e3b', 'C0B338BC-70B5-44D2-AB71-4BBDDC23AD72'), ('29892458-f103-89d5-a724-72f789e16e3b', '7708E166-AAA1-4115-994F-777499E020A8'), ('29892458-f103-89d5-a724-72f789e16e3b', 'F084A0D8-9030-43D1-970B-DC574EEA331F');
go
