CREATE DATABASE kanban DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'db_id'@'%' IDENTIFIED BY 'db_pw';
CREATE USER 'db_id'@'localhost' IDENTIFIED BY 'db_pw';

USE mysql;

-- DB 별 권한 부여
INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','kanban','db_id','Y','Y','Y','Y','Y','Y','Y','Y');
INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','kanban','db_id','Y','Y','Y','Y','Y','Y','Y','Y');

FLUSH PRIVILEGES;