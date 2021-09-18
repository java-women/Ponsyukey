/*
    create review table (sakeへの外部キーを設定する)
    saketomoが退会した場合もreviewを残すことなどを考慮し、reviewからsaketomoへの外部キーは設定しない
*/
USE ponsyukey;
GO

CREATE TABLE review
(
    id              uniqueidentifier    NOT NULL,
    saketomo_id     uniqueidentifier    NOT NULL,
    sake_id         uniqueidentifier    NOT NULL,
    rating          tinyint,
    comment         varchar(2000),
    created_at      datetime            NOT NULL    DEFAULT GETDATE(),
    updated_at      datetime    NOT NULL    DEFAULT GETDATE()
);
ALTER TABLE review ADD CONSTRAINT pk_review_id PRIMARY KEY CLUSTERED (id);
-- reviewからsakeへの外部キーを設定
ALTER TABLE review ADD CONSTRAINT fk_review_sake FOREIGN KEY (sake_id)
    REFERENCES sake (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
GO

EXEC sys.sp_addextendedproperty 
      @name=N'MS_Description', @value=N'IDは生成後のSELECTを回避するためアプリ側から渡す'
    , @level0type=N'SCHEMA', @level0name=N'ponsyukey' , @level1type=N'TABLE', @level1name=N'review'
    , @level2type=N'COLUMN', @level2name=N'id';
                                                           
 EXEC sys.sp_addextendedproperty 
      @name=N'MS_Description', @value=N'ユーザが退会してもレビューは残したいので外部キー参照なし'
    , @level0type=N'SCHEMA', @level0name=N'ponsyukey' , @level1type=N'TABLE', @level1name=N'review'
    , @level2type=N'COLUMN', @level2name=N'saketomo_id';
GO
