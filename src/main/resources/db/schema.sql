USE car;

DROP TABLE IF EXISTS `USER_TABLE`;

CREATE TABLE `USER_TABLE` (
  `USER_ID` BIGINT(50) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  `NAME` VARCHAR(30) NOT NULL UNIQUE COMMENT '用户名',
  `PASSWORD` VARCHAR(64) NOT NULL COMMENT '加密后的密码',
  `SALT` VARCHAR(64) NOT NULL COMMENT '加密使用的盐',
  `PHONE` VARCHAR(15) NOT NULL UNIQUE COMMENT '手机号码',
  `MONEY` BIGINT(30) NOT NULL DEFAULT 0 COMMENT '余额',
  `IDENTITY_NUMBER` VARCHAR(64) COMMENT '身份证',
  `REAL_NAME` VARCHAR(10) COMMENT '真实姓名',
  `EMAIL` VARCHAR(50) COMMENT 'email',
  `STATUS` INT(2) NOT NULL DEFAULT 1 COMMENT '状态，-1：逻辑删除，0：禁用，1：启用',
  `CREATE_TIME` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `LAST_LOGIN_TIME` DATETIME DEFAULT NULL COMMENT '上次登录时间',
  `LAST_UPDATE_TIME` DATETIME NOT NULL DEFAULT NOW() COMMENT '上次更新时间',
  `MAC` VARCHAR(64) NOT NULL COMMENT '消息认证码',
  `AVATAR` VARCHAR(100) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `CAR_TABLE`;

CREATE TABLE `CAR_TABLE` (
    `CAR_ID`  BIGINT(50) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `PICTURE` VARCHAR(100),
    `DETAIL_IMAGE1` VARCHAR(100),
    `DETAIL_IMAGE2` VARCHAR(100),
    `DETAIL_IMAGE3` VARCHAR(100),
    `DETAIL_IMAGE4` VARCHAR(100),
    `CAR_TYPE` VARCHAR(20) NOT NULL,
    `OWNER_ID` BIGINT(50),
    `OWNER_TEL` VARCHAR(15),
    `PRICE` BIGINT(30),
    `TRANSFER_TIME` INT(10) DEFAULT 1,
    `IS_SOLD` BOOLEAN,
    `IS_ASSESS` BOOLEAN,
    FOREIGN KEY(`OWNER_ID`) REFERENCES USER_TABLE(`USER_ID`),
    FOREIGN KEY(`OWNER_TEL`) REFERENCES USER_TABLE(`PHONE`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ASSESSOR_TABLE`;
CREATE TABLE `ASSESSOR_TABLE` (
  `ASSESS_ID` BIGINT(50) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  `NAME` VARCHAR(30) NOT NULL UNIQUE COMMENT '评估师名',
  `PASSWORD` VARCHAR(64) NOT NULL COMMENT '加密后的密码',
  `SALT` VARCHAR(64) NOT NULL COMMENT '加密使用的盐',
  `PHONE` VARCHAR(15) NOT NULL UNIQUE COMMENT '手机号码',
  `LEVEL` VARCHAR(20) NOT NULL DEFAULT '0' COMMENT '等级',
  `IDENTITY_NUMBER` VARCHAR(64) COMMENT '身份证',
  `EMAIL` VARCHAR(50) COMMENT 'email'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评估师表';


DROP TABLE IF EXISTS `CAR_DETECTION_TABLE`;
CREATE TABLE `CAR_DETECTION_TABLE` (
  `CAR_ID` BIGINT(50) NOT NULL PRIMARY KEY COMMENT '车辆id作为索引',
  `ASSESSOR_ID` BIGINT(50) NOT NULL COMMENT '该车辆评估师ID',
  `ADMIN_ID` BIGINT(50) COMMENT '审核该车辆的管理员id',
  `ENGINE` VARCHAR(50) NOT NULL,
  `WINDOW` VARCHAR(50) NOT NULL,
  `WHEEL` VARCHAR(50) NOT NULL,
  `COLLISION` VARCHAR(50) NOT NULL,
  `LIGHT` VARCHAR(50) NOT NULL,
  `APPEARANCE` VARCHAR(50) NOT NULL,
  `DASHBOARD` VARCHAR(50) NOT NULL,
  `CHASSIS` VARCHAR(50) NOT NULL,
  `SECURITY_SYSTEM` VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆评估表';


DROP TABLE IF EXISTS `ORDER_TABLE`;
CREATE TABLE `ORDER_TABLE` (
  `ORDER_ID` VARCHAR(80) NOT NULL PRIMARY KEY,
  `CREATED_TIME` DATETIME NOT NULL DEFAULT NOW(),
  `CAR_ID` BIGINT(50)NOT NULL,
  `CUSTOMER_ID` BIGINT(50)NOT NULL,
  `SALER_ID` BIGINT(50) NOT NULL,
  `DEAL_PRICE` BIGINT(50) NOT NULL,
  `ORDER_STATE` VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易单表';