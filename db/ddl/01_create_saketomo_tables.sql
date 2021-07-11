/*
    create saketomo table
*/

CREATE TABLE saketomo
(
    id              uniqueidentifier    NOT NULL,
    name            varchar(100)        NOT NULL,
    image           varchar(255)        NOT NULL,
    email           varchar(255)        NOT NULL,
    password        varchar(20)         NOT NULL,
    created_at      datetime            NOT NULL    DEFAULT GETDATE(),
    updated_at      datetime
);

ALTER TABLE saketomo ADD CONSTRAINT pk_saketomo_id PRIMARY KEY CLUSTERED (id);
