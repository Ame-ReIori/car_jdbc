from Crypto.Random import random
from Crypto.Hash import SHA256

SALT_PREFIX = '::YYGQ_GROUP::'
USER_LIST = []
USER_TEL = []
CAR_LIST = []
ADMIN_LIST = []

CREATE_USER_TABLE = '''CREATE TABLE `USER_TABLE` (
  `USER_ID` BIGINT(50) NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
'''

CREATE_CAR_TABLE = '''CREATE TABLE `CAR_TABLE` (
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
    `IS_SOLD` BOOLEAN DEFAULT FALSE,
    `IS_ASSESS` BOOLEAN DEFAULT FALSE,
    `IS_CHECK` BOOLEAN DEFAULT FALSE,
    FOREIGN KEY(`OWNER_ID`) REFERENCES USER_TABLE(`USER_ID`),
    FOREIGN KEY(`OWNER_TEL`) REFERENCES USER_TABLE(`PHONE`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
'''

CREATE_ADMIN_TABLE = '''CREATE TABLE `ADMIN_TABLE` (
  `ADMIN_ID` BIGINT(50) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  `NAME` VARCHAR(30) NOT NULL UNIQUE COMMENT '管理员名',
  `STATUS` INT(2) NOT NULL DEFAULT 1 COMMENT '状态，-1：逻辑删除，0：禁用，1：启用',
  `PASSWORD` VARCHAR(64) NOT NULL COMMENT '加密后的密码',
  `SALT` VARCHAR(64) NOT NULL COMMENT '加密使用的盐',
  `PHONE` VARCHAR(15) NOT NULL UNIQUE COMMENT '手机号码',
  `IDENTITY_NUMBER` VARCHAR(64) COMMENT '身份证',
  `REAL_NAME` VARCHAR(10) COMMENT '真实姓名',
  `EMAIL` VARCHAR(50) COMMENT 'email',
  `CREATE_TIME` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `LAST_LOGIN_TIME` DATETIME DEFAULT NULL COMMENT '上次登录时间',
  `LAST_UPDATE_TIME` DATETIME NOT NULL DEFAULT NOW() COMMENT '上次更新时间',
  `MAC` VARCHAR(64) NOT NULL COMMENT '消息认证码',
  `AVATAR` VARCHAR(100) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';
'''

def userGen():
    global USER_LIST, USER_TEL 
    alpha = list('0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-~')
    username_length = random.randint(3, 10)
    username = ''.join([random.choice(alpha) for i in range(username_length)])
    password = '123'
    salt = hex(random.getrandbits(160))[2:]
    password_hash = SHA256.new((password + SALT_PREFIX + salt).encode('utf-8')).hexdigest()
    phone = '1' + ''.join([str(random.randint(0, 9)) for i in range(10)])
    money = 0
    status = 1
    hasId = random.randint(0, 1)
    identity_number = ''
    realname = ''
    email = ''.join([random.choice(alpha) for i in range(random.randint(7, 15))]) + '@buaa.edu.cn'
    USER_LIST.append(username)
    USER_TEL.append(phone)
    if hasId:
        identity_number = ''.join([str(random.randint(0, 9)) for i in range(17)]) + random.choice(list('0123456789X'))
        realname = ''.join([random.choice(alpha) for i in range(4)])
        identity_number = SHA256.new(identity_number.encode('utf-8')).hexdigest()
    data = username + password_hash + salt + phone + str(money) +realname + identity_number + str(status)
    mac = SHA256.new(data.encode('utf-8')).hexdigest()
    if hasId:
        return 'INSERT INTO `USER_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `MONEY`, `IDENTITY_NUMBER`, `REAL_NAME`, `EMAIL`, `STATUS`, `MAC`) VALUES (\'' + username + '\', \'' + password_hash + '\', \'' + salt + '\', \'' + phone + '\', ' + str(money) + ', \'' + identity_number + '\', \'' + realname + '\', \'' + email + '\', ' + str(status) + ', \'' + mac + '\');\n'
    else:
        return 'INSERT INTO `USER_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `MONEY`, `EMAIL`, `STATUS`, `MAC`) VALUES (\'' + username + '\', \'' + password_hash + '\', \'' + salt + '\', \'' + phone + '\', ' + str(money) + ', \'' + email + '\', ' + str(status) + ', \'' + mac + '\');\n'
    
def carGen():
    global CAR_LIST, USER_TEL
    alpha = list('0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-~')
    CAR_TPYE = ['Porsche', 'Lamborghini', 'Maybach', '大众', 'bmw', 'Bentley', 'Rolls-Royce', 'mercedes-benz']
    picture = ''.join(random.choice(alpha) for i in range(random.randint(3, 7)))
    isDetail = random.randint(0, 1)
    if isDetail:
        detailImage1 = ''.join(random.choice(alpha) for i in range(random.randint(3, 7)))

    car_type = random.choice(CAR_TPYE)
    owner_id = random.randint(1, len(USER_LIST))
    owner_tel = USER_TEL[owner_id - 1]
    price = random.randint(10000, 1000000000)
    transfer_time = 0
    isSold = False
    isAssess = False
    isCheck = False
    if isDetail:
        return 'INSERT INTO `CAR_TABLE` (`PICTURE`, `DETAIL_IMAGE1`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`, `IS_CHECK`) VALUES (\'' + picture + '\', \'' + detailImage1 + '\', \'' + car_type + '\', ' + str(owner_id) + ', \'' + owner_tel + '\', ' + str(price) + ', ' + str(transfer_time) + ', ' + str(isSold) + ', ' + str(isAssess) + ', ' + str(isCheck) + ');\n'
    else:
        return 'INSERT INTO `CAR_TABLE` (`PICTURE`, `CAR_TYPE`, `OWNER_ID`, `OWNER_TEL`, `PRICE`, `TRANSFER_TIME`, `IS_SOLD`, `IS_ASSESS`, `IS_CHECK`) VALUES (\'' + picture + '\', \'' + car_type + '\', ' + str(owner_id) + ', \'' + owner_tel + '\', ' + str(price) + ', ' + str(transfer_time) + ', ' + str(isSold) + ', ' + str(isAssess) + ', ' + str(isCheck) + ');\n'

def adminGen():
    global ADMIN_LIST
    alpha = list('0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-~')
    username_length = random.randint(3, 10)
    username = ''.join([random.choice(alpha) for i in range(username_length)])
    password = '123'
    salt = hex(random.getrandbits(160))[2:]
    password_hash = SHA256.new((password + SALT_PREFIX + salt).encode('utf-8')).hexdigest()
    phone = '1' + ''.join([str(random.randint(0, 9)) for i in range(10)])
    hasId = random.randint(0, 1)
    identity_number = ''
    realname = ''
    email = ''.join([random.choice(alpha) for i in range(random.randint(7, 15))]) + '@buaa.edu.cn'
    ADMIN_LIST.append(username)
    if hasId:
        identity_number = ''.join([str(random.randint(0, 9)) for i in range(17)]) + random.choice(list('0123456789X'))
        realname = ''.join([random.choice(alpha) for i in range(4)])
        identity_number = SHA256.new(identity_number.encode('utf-8')).hexdigest()
    data = username + password_hash + salt + phone + realname + identity_number
    mac = SHA256.new(data.encode('utf-8')).hexdigest()
    if hasId:
        return 'INSERT INTO `ADMIN_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `IDENTITY_NUMBER`, `REAL_NAME`, `EMAIL`, `MAC`) VALUES (\'' + username + '\', \'' + password_hash + '\', \'' + salt + '\', \'' + phone + '\', \'' + identity_number + '\', \'' + realname + '\', \'' + email + '\', \'' + mac + '\');\n'
    else:
        return 'INSERT INTO `ADMIN_TABLE` (`NAME`, `PASSWORD`, `SALT`, `PHONE`, `EMAIL`, `MAC`) VALUES (\'' + username + '\', \'' + password_hash + '\', \'' + salt + '\', \'' + phone + '\', \'' + email + '\', \'' + mac + '\');\n'

if __name__ == "__main__":
    schema = open('/Users/ame/Desktop/springstu/demo/src/main/resources/db/tables.sql', 'w')
    schema.write(CREATE_USER_TABLE)
    schema.write('\n\n')
    schema.write(CREATE_CAR_TABLE)
    schema.write('\n\n')
    schema.write(CREATE_ADMIN_TABLE)
    schema.close()

    simdata = open('/Users/ame/Desktop/springstu/demo/src/main/resources/db/simdata.sql', 'w')
    for i in range(10):
        simdata.write(userGen())
    simdata.write('\n')

    for i in range(15):
        simdata.write(carGen())
    simdata.write('\n')
    
    for i in range(5):
        simdata.write(adminGen())
    simdata.close()
