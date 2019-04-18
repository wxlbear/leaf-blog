DROP TABLE IF EXISTS leaf;

CREATE TABLE leaf
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	created_at DATETIME  NULL COMMENT 'created_time',
	updated_at DATETIME  NULL COMMENT 'updated_time',
	status INT(2)  NULL COMMENT 'status',
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS article;

CREATE TABLE article
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	title VARCHAR(30) NULL DEFAULT NULL COMMENT '标题',
	content TEXT NULL DEFAULT NULL COMMENT '内容',
	author VARCHAR(50) NULL DEFAULT NULL COMMENT '作者',
	status INT(50) NULL DEFAULT NULL COMMENT '状态',
	created_at DATETIME NOT NULL COMMENT '创建时间',
	updated_at DATETIME NOT NULL COMMENT '更新时间',
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS picture;

CREATE TABLE picture
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '图片名称',
	path VARCHAR(30) NULL DEFAULT NULL COMMENT '图片相对路径',
	url VARCHAR(30) NULL DEFAULT NULL COMMENT 'oss 地址',
	author VARCHAR(30) NULL DEFAULT NULL COMMENT '图片上传者',
	description VARCHAR(30) NULL DEFAULT NULL COMMENT '图片描述',
	width INT(50) NULL DEFAULT NULL COMMENT '图片宽度',
	height INT(50) NULL DEFAULT NULL COMMENT '图片高度',
	size INT(50) NULL DEFAULT NULL COMMENT '图片大小',
	created_at DATETIME NOT NULL COMMENT '创建时间',
	updated_at DATETIME NOT NULL COMMENT '更新时间',
	status INT(50) NULL DEFAULT NULL COMMENT '状态',
	PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


CREATE TABLE story
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	title VARCHAR(100) NULL DEFAULT NULL COMMENT 'title',
	content TEXT NULL DEFAULT NULL COMMENT 'content',
	created_at DATETIME  NULL COMMENT 'created_time',
	updated_at DATETIME  NULL COMMENT 'updated_time',
	status INT(2)  NULL COMMENT 'status',
	PRIMARY KEY (id)
);