/*
    create sake table (breweryへの外部キーを設定する)
    create taste table
    create taste_map table (sake, tasteへの外部キーを設定する)
*/

CREATE TABLE sake
(
    id              uniqueidentifier    NOT NULL,
    name            varchar(100)        NOT NULL,
    image           varchar(255),
    brewery_id      uniqueidentifier,
    alcohol         decimal(4,2),
    polishingRatio  decimal(4,2),
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

CREATE TABLE taste
(
    id              uniqueidentifier    NOT NULL,
    value           varchar(100)
);
ALTER TABLE taste ADD CONSTRAINT pk_taste_id PRIMARY KEY CLUSTERED (id);

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
