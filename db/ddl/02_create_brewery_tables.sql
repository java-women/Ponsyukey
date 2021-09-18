/*
    create country table
    create prefecture table
    create region table (country, prefectureへの外部キーを設定する)
    create brewery table (regionへの外部キーを設定する)
*/
USE ponsyukey;
GO

CREATE TABLE country
(
    id              smallint        NOT NULL,
    name            varchar(100)    NOT NULL
);
ALTER TABLE country ADD CONSTRAINT pk_country_id PRIMARY KEY CLUSTERED (id);
GO

CREATE TABLE prefecture
(
    id              smallint        NOT NULL,
    name            varchar(40)    NOT NULL
);
ALTER TABLE prefecture ADD CONSTRAINT pk_prefecture_id PRIMARY KEY CLUSTERED (id);
EXEC sys.sp_addextendedproperty
    @name=N'MS_Description',  @value=N'都道府県または海外',
    @level0type=N'SCHEMA',  @level0name=N'ponsyukey',
    @level1type=N'TABLE',  @level1name=N'prefecture',
    @level2type=N'COLUMN',  @level2name=N'name'
;
GO

CREATE TABLE region
(
    id              smallint    NOT NULL,
    country_id      smallint    NOT NULL,
    prefecture_id   smallint  NOT NULL
);
ALTER TABLE region ADD CONSTRAINT pk_region_id PRIMARY KEY CLUSTERED (id);
-- regionからcountryへの外部キーを設定
ALTER TABLE region ADD CONSTRAINT fk_region_country FOREIGN KEY (country_id)
    REFERENCES country (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
-- regionからprefectureへの外部キーを設定
ALTER TABLE region ADD CONSTRAINT fk_region_prefecture FOREIGN KEY (prefecture_id)
    REFERENCES prefecture (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
EXEC sys.sp_addextendedproperty
    @name=N'MS_Description',  @value=N'countryが日本の場合は都道府県を指定、日本以外の場合は海外を指定',
    @level0type=N'SCHEMA',  @level0name=N'ponsyukey',
    @level1type=N'TABLE',  @level1name=N'region',
    @level2type=N'COLUMN',  @level2name=N'prefecture_id'
;
GO

CREATE TABLE brewery
(
    id              uniqueidentifier    NOT NULL,
    name            varchar(100)        NOT NULL,
    region_id       smallint   NOT NULL
);
ALTER TABLE brewery ADD CONSTRAINT pk_brewery_id PRIMARY KEY CLUSTERED (id);
-- breweryからregionへの外部キーを設定
ALTER TABLE brewery ADD CONSTRAINT fk_brewery_region FOREIGN KEY (region_id)
    REFERENCES region (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
EXEC sys.sp_addextendedproperty
    @name=N'MS_Description',  @value=N'UUIDはアプリで生成する前提です。',
    @level0type=N'SCHEMA',  @level0name=N'ponsyukey',
    @level1type=N'TABLE',  @level1name=N'brewery',
    @level2type=N'COLUMN',  @level2name=N'id'
;
GO
