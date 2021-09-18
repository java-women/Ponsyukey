/*
    create saketomo table
*/

USE ponsyukey;
GO

CREATE TABLE saketomo
(
    id              uniqueidentifier    NOT NULL,
    name            varchar(100)        NOT NULL,
    image           varchar(255)        NOT NULL,
    email           varchar(255)        NOT NULL,
    password        varchar(255)         NOT NULL,
    created_at      datetime            NOT NULL    DEFAULT GETDATE(),
    updated_at      datetime    NOT NULL    DEFAULT GETDATE() 
);
ALTER TABLE saketomo ADD CONSTRAINT pk_saketomo_id PRIMARY KEY CLUSTERED (id);
GO

EXEC sys.sp_addextendedproperty  
     @name=N'MS_Description',@value=N'UUIDはアプリで生成する前提です。'       
    ,@level0type=N'SCHEMA',@level0name=N'ponsyukey'  ,@level1type=N'TABLE' ,@level1name=N'saketomo' 
    ,@level2type=N'COLUMN',@level2name=N'id';
    
EXEC sys.sp_addextendedproperty  
	     @name=N'MS_Description',@value=N'画像がない場合は空で登録する'       
	    ,@level0type=N'SCHEMA',@level0name=N'ponsyukey'  ,@level1type=N'TABLE' ,@level1name=N'saketomo' 
	    ,@level2type=N'COLUMN',@level2name=N'image';   
    
EXEC sys.sp_addextendedproperty  
     @name=N'MS_Description',@value=N'emailアドレスは暗号化されて入ってきます。'       
    ,@level0type=N'SCHEMA',@level0name=N'ponsyukey'  ,@level1type=N'TABLE' ,@level1name=N'saketomo' 
    ,@level2type=N'COLUMN',@level2name=N'email';  
    
EXEC sys.sp_addextendedproperty  
     @name=N'MS_Description',@value=N'パスワードカラムは暗号化されて入ってきます。'       
    ,@level0type=N'SCHEMA',@level0name=N'ponsyukey'  ,@level1type=N'TABLE' ,@level1name=N'saketomo' 
    ,@level2type=N'COLUMN',@level2name=N'email';
GO
