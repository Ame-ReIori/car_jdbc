INSERT INTO `USER_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `MONEY`, `IDENTITY_NUMBER`, `REAL_NAME`, `EMAIL`, `STATUS`, `MAC`, `AVATAR`) VALUES ('ame', '0123456789abcdeffedcba9876543210', '000102030405060708090a0b0c0d0e0f', '12988712343', '10000000000000000', '121321124124', 'gyw', '12312!@213.com', 1, '123214f1df312cf123', '1');

INSERT INTO `ASSESSOR_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `LEVEL`, `IDENTITY_NUMBER`,  `EMAIL`) VALUES ('wyznb', '666', '000102030405060708090a0b0c0d0e0f', '110', '999999', '121321124124', '123@qq.com');
INSERT INTO `ASSESSOR_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `LEVEL`, `IDENTITY_NUMBER`,  `EMAIL`) VALUES ('gywnb', '666', '100102030405060708090a0b0c0d0e0f', '111', '999999999', '121321124124125', '123456@qq.com');
INSERT INTO `ASSESSOR_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `LEVEL`, `IDENTITY_NUMBER`,  `EMAIL`) VALUES ('zyfnb', '666', '000102030405060708090a0b0c0d0e0f', '1101', '999999', '121321124', '123232@qq.com');
INSERT INTO `ASSESSOR_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `LEVEL`, `IDENTITY_NUMBER`,  `EMAIL`) VALUES ('fttnb', '666', '100102030405060708090a0b0c0d0e0f', '11124', '999999999', '121321124124', '123456@qq.com');

INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('1', '11', 'reiori', 1, '12988712343', -100000, 1, false, false );
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('2', '22', 'Porsche', 1, '12988712343', -10000000000000000, 1, false, false);
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('3', '33', 'Rolls-royce', 9, '18811171004', 100000000000000, 1, false, true);
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('4', '44', 'Ferrari', 9, '18811171004', 100000000000000, 1, false, true);
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('5', '55', 'Audi', 9, '18811171004', 100000000000000, 1, false, false );
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('6', '66', 'Lexus', 9, '18811171004', 100000000000000, 1, false, false);
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('7', '33', 'Rolls-royce', 9, '18811171004', 100000000000000, 1, false, true);
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('8', '44', 'Ferrari', 9, '18811171004', 100000000000000, 1, false, true);
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('9', '55', 'Audi', 9, '18811171004', 100000000000000, 1, false, true);
INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`) VALUES ('10', '66', 'Lexus', 9, '18811171004', 100000000000000, 1, false, false);

INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (1,1,1,'good','not bad','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (2,1,1,'bad','awful','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (3,1,1,'good','not bad','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (4,1,1,'bad','awful','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (5,1,1,'good','not bad','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (6,2,1,'bad','awful','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (7,1,'good','not bad','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (8,4,1,'bad','awful','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (9,1,1,'good','not bad','perfect','null','normal','perfect','good','good','normal');
INSERT INTO  `CAR_DETECTION_TABLE` (`CAR_ID`,`ASSESSOR_ID`,`ADMIN_ID`,`ENGINE`,`WINDOW`,`WHEEL`,`COLLISION`,`LIGHT`,`APPEARANCE`,`DASHBOARD`,`CHASSIS`,`SECURITY_SYSTEM`)VALUES (10,2,1,'bad','awful','perfect','null','normal','perfect','good','good','normal');

/*
INSERT INTO `ORDER_TABLE` (`CAR_ID`,`CUSTOMER_ID`,`SALER_ID`,`DEAL_PRICE`) VALUES (1,2,3,50000);
INSERT INTO `ORDER_TABLE` (`CAR_ID`,`CUSTOMER_ID`,`SALER_ID`,`DEAL_PRICE`) VALUES (1,2,4,50000);
*/