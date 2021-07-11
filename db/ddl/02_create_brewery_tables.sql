/*
    create country table
    create prefecture table
    create region table (country, prefectureへの外部キーを設定する)
    create brewery table (regionへの外部キーを設定する)
*/

CREATE TABLE country
(
    id              smallint        NOT NULL,
    name            varchar(40)    NOT NULL
);
ALTER TABLE country ADD CONSTRAINT pk_country_id PRIMARY KEY CLUSTERED (id);

CREATE TABLE prefecture
(
    id              smallint        NOT NULL,
    name            varchar(40)    NOT NULL
);
ALTER TABLE prefecture ADD CONSTRAINT pk_prefecture_id PRIMARY KEY CLUSTERED (id);

CREATE TABLE region
(
    id              smallint    NOT NULL,
    country_id      smallint    NOT NULL,
    prefecture_id   smallint
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

CREATE TABLE brewery
(
    id              uniqueidentifier    NOT NULL,
    name            varchar(100)        NOT NULL,
    region_id       smallint
);
ALTER TABLE brewery ADD CONSTRAINT pk_brewery_id PRIMARY KEY CLUSTERED (id);
-- breweryからregionへの外部キーを設定
ALTER TABLE brewery ADD CONSTRAINT fk_brewery_region FOREIGN KEY (region_id)
    REFERENCES region (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;