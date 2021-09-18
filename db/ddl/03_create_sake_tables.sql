/*
    create sake table (breweryへの外部キーを設定する)
    create taste table
    create taste_map table (sake, tasteへの外部キーを設定する)
*/
USE ponsyukey;
GO

CREATE TABLE sake
(
    id              uniqueidentifier    NOT NULL,
    name            varchar(100)        NOT NULL,
    image           varchar(255),
    brewery_id      uniqueidentifier    NOT NULL,
    alcohol         decimal(4,2),
    polishing_ratio  decimal(4,2),
    type            varchar(100),
    description     varchar(2000)
);
ALTER TABLE sake ADD CONSTRAINT pk_sake_id PRIMARY KEY CLUSTERED (id);
-- sakeからbreweryへの外部キーを設定
ALTER TABLE sake ADD CONSTRAINT fk_sake_brewery FOREIGN KEY (brewery_id)
    REFERENCES brewery (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
EXEC sys.sp_addextendedproperty
    @name=N'MS_Description', @value=N'酒ID（UUIDはアプリで生成する前提）',
    @level0type=N'SCHEMA', @level0name=N'ponsyukey', @level1type=N'TABLE', @level1name=N'sake',
    @level2type=N'COLUMN', @level2name=N'id';

EXEC sys.sp_addextendedproperty
    @name=N'MS_Description', @value=N'画像（画像がない場合は空で登録する）',
    @level0type=N'SCHEMA', @level0name=N'ponsyukey', @level1type=N'TABLE', @level1name=N'sake',
    @level2type=N'COLUMN', @level2name=N'id';

EXEC sys.sp_addextendedproperty
    @name=N'MS_Description', @value=N'アルコール度数（パーセント）',
    @level0type=N'SCHEMA', @level0name=N'ponsyukey', @level1type=N'TABLE', @level1name=N'sake',
    @level2type=N'COLUMN', @level2name=N'alcohol';

EXEC sys.sp_addextendedproperty
    @name=N'MS_Description', @value=N'精米歩合（パーセント）',
    @level0type=N'SCHEMA', @level0name=N'ponsyukey', @level1type=N'TABLE', @level1name=N'sake',
    @level2type=N'COLUMN', @level2name=N'polishing_ratio';
GO

CREATE TABLE taste
(
    id              uniqueidentifier    NOT NULL,
    value           varchar(100)
);
ALTER TABLE taste ADD CONSTRAINT pk_taste_id PRIMARY KEY CLUSTERED (id);
GO

CREATE TABLE taste_map
(
    sake_id         uniqueidentifier    NOT NULL,
    taste_id        uniqueidentifier    NOT NULL
);
ALTER TABLE taste_map ADD CONSTRAINT pk_taste_map_ids PRIMARY KEY CLUSTERED (sake_id, taste_id);
-- taste_mapからsakeへの外部キーを設定
ALTER TABLE taste_map ADD CONSTRAINT fk_taste_map_sake FOREIGN KEY (sake_id)
    REFERENCES sake (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
-- taste_mapからtasteへの外部キーを設定
ALTER TABLE taste_map ADD CONSTRAINT fk_taste_map_taste FOREIGN KEY (taste_id)
    REFERENCES taste (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
GO
