USE car;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  `username` VARCHAR(32) NOT NULL UNIQUE COMMENT '用户名',
  `password` VARCHAR(100) NOT NULL COMMENT '加密后的密码',
  `salt` VARCHAR(32) NOT NULL COMMENT '加密使用的盐',
  `phone_number` VARCHAR(15) NOT NULL UNIQUE COMMENT '手机号码',
  `money` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '余额',
  `email` VARCHAR(32) UNIQUE COMMENT '邮箱',
  `identity_number` VARCHAR(18) COMMENT '身份证',
  `real_name` VARCHAR(10) COMMENT '真实姓名',
  `status` INT(2) NOT NULL DEFAULT 1 COMMENT '状态，-1：逻辑删除，0：禁用，1：启用',
  `create_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `last_login_time` DATETIME DEFAULT NULL COMMENT '上次登录时间',
  `last_update_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '上次更新时间',
  `mac` VARCHAR(64) NOT NULL COMMENT '消息认证码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';