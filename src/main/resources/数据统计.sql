CREATE TABLE `sn_same_name` (
`keyId` varchar(64) NOT NULL COMMENT '主键ID',
`sameName` varchar(32) NOT NULL COMMENT '统计名称',
`countProvince` varchar(255) NOT NULL COMMENT '各个省份的数量统计，逗号隔开的，int',
`createTime` datetime NOT NULL COMMENT '创建时间',
PRIMARY KEY (`keyId`) 
)
COMMENT='同名表';

CREATE TABLE `sn_province` (
`keyId` varchar(64) NOT NULL COMMENT '主键ID',
`name` varchar(32) NOT NULL COMMENT '省份的名称',
`code` smallint NOT NULL COMMENT '省份所国家统一编号',
`createTime` datetime NOT NULL COMMENT '创建时间',
PRIMARY KEY (`keyId`) 
)
COMMENT='省份排序';

CREATE TABLE `sn_query_count` (
`keyId` varchar(64) NOT NULL COMMENT '主键ID',
`sameName` varchar(32) NOT NULL COMMENT '姓名外键',
`count` int NOT NULL COMMENT '查询次数统计',
`createTime` datetime NOT NULL COMMENT '创建时间',
`updateTime` datetime NOT NULL COMMENT '最后更新时间',
PRIMARY KEY (`keyId`) 
)
COMMENT='同名表查询统计';

CREATE TABLE `sn_same_name_error` (
`keyId` varchar(64) NOT NULL COMMENT '主键ID',
`sameName` varchar(32) NOT NULL COMMENT '统计名称',
`countProvince` varchar(255) NOT NULL COMMENT '各个省份的数量统计，逗号隔开的，int',
`count` int NOT NULL COMMENT '错误统计次数',
`createTime` datetime NOT NULL COMMENT '创建时间',
`updateTime` datetime NOT NULL COMMENT '最后更新时间',
PRIMARY KEY (`keyId`) 
)
COMMENT='异常同名表';

