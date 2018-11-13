/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : appinfo

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-11-13 16:58:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for advertisement
-- ----------------------------
DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'APP广告表',
  `appInfoId` int(11) DEFAULT NULL COMMENT 'APP基本信息（外键，来源于：appInfo表的主键id）',
  `adPicPath` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '广告图片存储路径',
  `adPV` double DEFAULT NULL COMMENT '广告点击量',
  `carouselPosition` double DEFAULT NULL COMMENT '轮播位（1-n）',
  `startTime` datetime DEFAULT NULL COMMENT '起效时间',
  `endTime` datetime DEFAULT NULL COMMENT '失效时间',
  `createdBy` int(11) DEFAULT NULL COMMENT '创建者（外键，来源于backendUser后台用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` int(11) DEFAULT NULL COMMENT '更新者（外键，来源于backendUser后台用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of advertisement
-- ----------------------------

-- ----------------------------
-- Table structure for appinfos
-- ----------------------------
DROP TABLE IF EXISTS `appinfos`;
CREATE TABLE `appinfos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'APP基础信息表id（一个APP有多个版本信息，与APP版本信息（appVersion）是一对多的关系）',
  `softwareName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 软件名称',
  `APKName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'APK名称（唯一）',
  `supportROM` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '支持ROM(版本号)',
  `interfaceLanguageId` int(11) DEFAULT NULL COMMENT '界面语言id',
  `softwareSize` double DEFAULT NULL COMMENT ' 软件大小（单位：M）',
  `updateDate` datetime DEFAULT NULL COMMENT ' 更新日期',
  `devUserId` int(11) DEFAULT NULL COMMENT '   开发者id（外键，来源于devUser开发者信息表的用户id）',
  `appIntroduction` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '应用简介',
  `statusId` int(11) DEFAULT '1' COMMENT '审核状态（外键，来源于：statusId（APP来源平台表））',
  `frameId` int(11) DEFAULT '1' COMMENT '  上架状态（外键，来源于：frame表）',
  `onSaleDate` datetime DEFAULT NULL COMMENT '上架时间',
  `offSaleDate` datetime DEFAULT NULL COMMENT '下架时间',
  `flatformId` int(11) DEFAULT NULL COMMENT '所属平台（外键，来源于：flatform表）',
  `downloads` double DEFAULT '0' COMMENT '下载量（单位：次）',
  `createdBy` int(11) DEFAULT NULL COMMENT '创建者（外键，来源于devUser开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `firstAPPClassId` int(11) DEFAULT NULL COMMENT ' 所属一级分类（外键，来源于：firstAPPClass表）',
  `twoAPPClassId` int(11) DEFAULT NULL COMMENT '所属二级分类（外键，来源于：twoAPPClass表）',
  `threeAPPClassId` int(11) DEFAULT NULL COMMENT '所属三级分类（外键，来源于：threeAPPClass表）',
  `logoPicPath` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片url路径',
  `logoLocPath` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片的服务器存储路径',
  `versionId` int(11) DEFAULT NULL COMMENT '最新的版本id（外键，来源于：APP版本信息表：appVersion）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of appinfos
-- ----------------------------
INSERT INTO `appinfos` VALUES ('1', '劲乐团U:O2Jam U', 'com.momocorp.o2jamu', '2.3及更高版本', '1', '56', '2018-09-09 00:00:00', '1', '劲乐团U O2Jam U是一款音乐节拍游戏，跟着音乐的节奏点击屏幕即可，就是跳舞机，需要网络支持。\\r\\n注意：部分机型会卡死在启动界面或fc，结束进程后重新开启游戏就正常了。', '2', '1', null, null, '1', '0', '1', '2018-10-29 14:13:15', '2', '17', '10', null, null, '1');
INSERT INTO `appinfos` VALUES ('2', '测试123', 'com.yatxuan', '2.0版本', '1', '56', '2018-11-07 09:45:23', '1', '测试软件', '2', '2', '2018-11-07 09:44:32', '2018-11-07 09:44:29', '1', '0', '1', '2018-11-03 15:21:44', '2', '17', '10', null, null, '7');
INSERT INTO `appinfos` VALUES ('3', '测试软件', '测试APK', '测试ROM', '3', '15', null, '1', '用于测试平台添加功能', '3', '1', null, null, '1', '0', '1', '2018-11-06 14:13:01', '1', '17', '10', 'f:/test/io1.jpg', 'f:/test/io1.jpg', null);
INSERT INTO `appinfos` VALUES ('5', '1', '1', '1', '3', '12', null, '1', '123', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:23', '1', '1', '1', 'f:/test/io12.jpg', 'f:/test/io12.jpg', null);
INSERT INTO `appinfos` VALUES ('6', '2', '2', '2', '3', '2', null, '1', '2', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:42', '1', '1', '1', 'f:/test/io14.jpg', 'f:/test/io14.jpg', null);
INSERT INTO `appinfos` VALUES ('7', '劲乐团U:O2Jam U二', 'com.momocorp.o2jamu', '2.3及更高版本', '1', '56', '2018-09-09 00:00:00', '1', '劲乐团U O2Jam U是一款音乐节拍游戏，跟着音乐的节奏点击屏幕即可，就是跳舞机，需要网络支持。\\r\\n注意：部分机型会卡死在启动界面或fc，结束进程后重新开启游戏就正常了。', '1', '1', null, null, '1', '0', '1', '2018-10-29 14:13:15', '2', '17', '10', null, null, '1');
INSERT INTO `appinfos` VALUES ('8', '测试123二', 'com.yatxuan', '2.0版本', '1', '56', '2018-11-07 09:45:23', '1', '测试软件', '2', '2', '2018-11-07 09:44:32', '2018-11-07 09:44:29', '1', '0', '1', '2018-11-03 15:21:44', '2', '17', '10', null, null, '7');
INSERT INTO `appinfos` VALUES ('9', '测试软件二', '测试APK', '测试ROM', '3', '15', null, '1', '用于测试平台添加功能', '1', '1', null, null, '1', '0', '1', '2018-11-06 14:13:01', '1', '17', '10', 'f:/test/io1.jpg', 'f:/test/io1.jpg', null);
INSERT INTO `appinfos` VALUES ('10', '14', '14', '1', '3', '12', null, '1', '123', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:23', '1', '1', '1', 'f:/test/io12.jpg', 'f:/test/io12.jpg', null);
INSERT INTO `appinfos` VALUES ('11', '14', '13', '2', '3', '2', null, '1', '2', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:42', '1', '1', '1', 'f:/test/io14.jpg', 'f:/test/io14.jpg', null);
INSERT INTO `appinfos` VALUES ('12', '3', '3', '1', '3', '12', null, '1', '123', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:23', '1', '1', '1', 'f:/test/io12.jpg', 'f:/test/io12.jpg', null);
INSERT INTO `appinfos` VALUES ('13', '4', '4', '2', '3', '2', null, '1', '2', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:42', '1', '1', '1', 'f:/test/io14.jpg', 'f:/test/io14.jpg', null);
INSERT INTO `appinfos` VALUES ('14', '5', '5', '1', '3', '12', null, '1', '123', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:23', '1', '1', '1', 'f:/test/io12.jpg', 'f:/test/io12.jpg', null);
INSERT INTO `appinfos` VALUES ('15', '6', '6', '2', '3', '2', null, '1', '2', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:42', '1', '1', '1', 'f:/test/io14.jpg', 'f:/test/io14.jpg', null);
INSERT INTO `appinfos` VALUES ('16', '7', '7', '1', '3', '12', null, '1', '123', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:23', '1', '1', '1', 'f:/test/io12.jpg', 'f:/test/io12.jpg', null);
INSERT INTO `appinfos` VALUES ('17', '8', '8', '2', '3', '2', null, '1', '2', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:42', '1', '1', '1', 'f:/test/io14.jpg', 'f:/test/io14.jpg', null);
INSERT INTO `appinfos` VALUES ('18', '9', '9', '1', '3', '12', null, '1', '123', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:23', '1', '1', '1', 'f:/test/io12.jpg', 'f:/test/io12.jpg', null);
INSERT INTO `appinfos` VALUES ('19', '10', '10', '2', '3', '2', null, '1', '2', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:42', '1', '1', '1', 'f:/test/io14.jpg', 'f:/test/io14.jpg', null);
INSERT INTO `appinfos` VALUES ('20', '11', '11', '1', '3', '12', null, '1', '123', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:23', '1', '1', '1', 'f:/test/io12.jpg', 'f:/test/io12.jpg', null);
INSERT INTO `appinfos` VALUES ('21', '12', '12', '2', '3', '2', null, '1', '2', '1', '1', null, null, '1', '0', '1', '2018-11-07 13:02:42', '1', '1', '1', 'f:/test/io14.jpg', 'f:/test/io14.jpg', null);
INSERT INTO `appinfos` VALUES ('22', '33', '3', '3', '1', '3', null, '1', '123', '1', '1', null, null, '1', '0', '1', '2018-11-07 14:58:32', '1', '1', '2', 'f:/test/110.jpg', 'f:/test/110.jpg', null);

-- ----------------------------
-- Table structure for appversion
-- ----------------------------
DROP TABLE IF EXISTS `appversion`;
CREATE TABLE `appversion` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'APP版本信息表',
  `appInfoId` int(11) DEFAULT NULL COMMENT 'APP基本信息（外键，来源于：appInfo表的主键id）',
  `versionNo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本号',
  `versionInfo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本介绍',
  `releaseStatusId` int(11) DEFAULT '3' COMMENT '发布状态id（来源于：releaseStatus表）',
  `downloadLink` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '下载链接',
  `versionSize` double DEFAULT NULL COMMENT '版本大小（单位：M）',
  `modifyBy` int(11) DEFAULT NULL COMMENT '更新者（外键，来源于devUser开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `apkLocPath` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'apk文件的服务器存储路径',
  `apkFileName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上传的apk文件名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of appversion
-- ----------------------------
INSERT INTO `appversion` VALUES ('1', '1', '2.0', '无', '1', null, '20', '1', '2018-10-29 14:15:54', 'www.yatxuan.com', 'YatXuan');
INSERT INTO `appversion` VALUES ('2', '2', '2.5', '无', '1', null, '15', '1', '2018-11-05 09:34:09', 'www.yatxuan.com', 'YatXuan');
INSERT INTO `appversion` VALUES ('5', '2', '2.3', '66', '3', null, '0.13', '1', '2018-11-05 16:36:16', 'f:/test', '217.jpg');
INSERT INTO `appversion` VALUES ('7', '5', '3', '3', '3', null, '0.04', '1', '2018-11-07 09:45:07', 'f:/test/io3.jpg', 'io3.jpg');

-- ----------------------------
-- Table structure for backenduser
-- ----------------------------
DROP TABLE IF EXISTS `backenduser`;
CREATE TABLE `backenduser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '后台用户表ID',
  `userCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户账号(唯一)',
  `userPassword` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `userName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of backenduser
-- ----------------------------
INSERT INTO `backenduser` VALUES ('1', 'admin', '0192023a7bbd73250516f069df18b500', '超级管理员', '2018-10-29 13:49:38');
INSERT INTO `backenduser` VALUES ('2', 'admin2', '101d9fd14b31a93b06a10421f14dd023', '测试人员', '2018-11-09 15:35:50');

-- ----------------------------
-- Table structure for backenduserrecordchange
-- ----------------------------
DROP TABLE IF EXISTS `backenduserrecordchange`;
CREATE TABLE `backenduserrecordchange` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '后台用户信息记录更改表Id',
  `backendUserId` int(10) DEFAULT NULL COMMENT '后台用户id(外键，来源于backendUser后台用户表)',
  `modifyBy` int(11) DEFAULT NULL COMMENT ' 更新者id（来源于backendUser后台用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT ' 最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of backenduserrecordchange
-- ----------------------------

-- ----------------------------
-- Table structure for devuser
-- ----------------------------
DROP TABLE IF EXISTS `devuser`;
CREATE TABLE `devuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '开发者用户表id',
  `devCode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 开发者帐号（唯一）',
  `devName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 开发者名称',
  `devPassword` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 开发者密码',
  `devEmail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 开发者电子邮箱',
  `devInfo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者简介',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of devuser
-- ----------------------------
INSERT INTO `devuser` VALUES ('1', 'user', '开发者测试用户', '6ad14ba9986e3615423dfca256d04e3f', '', null, null);

-- ----------------------------
-- Table structure for devuserrecordchange
-- ----------------------------
DROP TABLE IF EXISTS `devuserrecordchange`;
CREATE TABLE `devuserrecordchange` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '开发者用户信息记录更改表id',
  `backendUserId` int(11) DEFAULT NULL COMMENT '开发者用户id(外键，来源于devUser开发者用户表)',
  `modifyBy` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新者账号（来源于所有用户表的用户账号，可以是开发者用户表的用户账号，也可以是后台用户表的用户账号）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of devuserrecordchange
-- ----------------------------

-- ----------------------------
-- Table structure for firstappclass
-- ----------------------------
DROP TABLE IF EXISTS `firstappclass`;
CREATE TABLE `firstappclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '一级分类id',
  `firstAPPName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 一级分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of firstappclass
-- ----------------------------
INSERT INTO `firstappclass` VALUES ('1', '全部应用');
INSERT INTO `firstappclass` VALUES ('2', '全部游戏');

-- ----------------------------
-- Table structure for flatform
-- ----------------------------
DROP TABLE IF EXISTS `flatform`;
CREATE TABLE `flatform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'APP来源平台id ',
  `flatformName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'APP来源（1 手机 2 平板 3 通用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of flatform
-- ----------------------------
INSERT INTO `flatform` VALUES ('1', '手机');
INSERT INTO `flatform` VALUES ('2', '平板');
INSERT INTO `flatform` VALUES ('3', '通用');

-- ----------------------------
-- Table structure for frame
-- ----------------------------
DROP TABLE IF EXISTS `frame`;
CREATE TABLE `frame` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上架状态id',
  `frameType` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 上架状态（0 未上架 1 已上架 2 已下架）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of frame
-- ----------------------------
INSERT INTO `frame` VALUES ('1', '未上架');
INSERT INTO `frame` VALUES ('2', '已上架');
INSERT INTO `frame` VALUES ('3', '已下架');

-- ----------------------------
-- Table structure for interfacelanguage
-- ----------------------------
DROP TABLE IF EXISTS `interfacelanguage`;
CREATE TABLE `interfacelanguage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '界面语言表id',
  `language` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '语言',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of interfacelanguage
-- ----------------------------
INSERT INTO `interfacelanguage` VALUES ('1', '英语');
INSERT INTO `interfacelanguage` VALUES ('2', '中文');
INSERT INTO `interfacelanguage` VALUES ('3', '通用');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for permissionsrelation
-- ----------------------------
DROP TABLE IF EXISTS `permissionsrelation`;
CREATE TABLE `permissionsrelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户权限表id',
  `roles` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户角色',
  `permissions` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of permissionsrelation
-- ----------------------------

-- ----------------------------
-- Table structure for releasestatus
-- ----------------------------
DROP TABLE IF EXISTS `releasestatus`;
CREATE TABLE `releasestatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'APP发布状态',
  `releaseStatusName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发布状态：(1 未发布 2 已发布 3 预发布)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of releasestatus
-- ----------------------------
INSERT INTO `releasestatus` VALUES ('1', '未发布');
INSERT INTO `releasestatus` VALUES ('2', '已发布');
INSERT INTO `releasestatus` VALUES ('3', '预发布');

-- ----------------------------
-- Table structure for rolesrelation
-- ----------------------------
DROP TABLE IF EXISTS `rolesrelation`;
CREATE TABLE `rolesrelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户身份（角色）关系表id',
  `Code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `rolesId` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色表(userroles)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of rolesrelation
-- ----------------------------
INSERT INTO `rolesrelation` VALUES ('1', 'admin', '1');
INSERT INTO `rolesrelation` VALUES ('2', 'admin', '2');
INSERT INTO `rolesrelation` VALUES ('3', 'admin', '3');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '审核表id',
  `statusType` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审核状态（1 待审核 2 审核通过 3 审核不通过）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', '待审核');
INSERT INTO `status` VALUES ('2', '审核通过');
INSERT INTO `status` VALUES ('3', '审核不通过');

-- ----------------------------
-- Table structure for threeappclass
-- ----------------------------
DROP TABLE IF EXISTS `threeappclass`;
CREATE TABLE `threeappclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '三级分类',
  `threeAPPName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '三级分类名称',
  `twoAPPClassId` int(11) DEFAULT NULL COMMENT '对应二级分类的名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of threeappclass
-- ----------------------------
INSERT INTO `threeappclass` VALUES ('1', '输入法', '1');
INSERT INTO `threeappclass` VALUES ('2', '文件管理', '1');
INSERT INTO `threeappclass` VALUES ('3', '清理优化', '1');
INSERT INTO `threeappclass` VALUES ('4', '安全防护', '1');
INSERT INTO `threeappclass` VALUES ('5', '备份还原', '1');
INSERT INTO `threeappclass` VALUES ('6', '辅助加强', '1');
INSERT INTO `threeappclass` VALUES ('7', '桌面', '2');
INSERT INTO `threeappclass` VALUES ('8', '插件', '2');
INSERT INTO `threeappclass` VALUES ('9', '锁屏', '2');
INSERT INTO `threeappclass` VALUES ('10', '跳舞', '17');
INSERT INTO `threeappclass` VALUES ('11', '涂鸦', '17');
INSERT INTO `threeappclass` VALUES ('12', '虐心', '17');
INSERT INTO `threeappclass` VALUES ('13', '冒险', '17');
INSERT INTO `threeappclass` VALUES ('14', '消除', '18');
INSERT INTO `threeappclass` VALUES ('15', '解谜', '18');
INSERT INTO `threeappclass` VALUES ('16', '物理', '18');
INSERT INTO `threeappclass` VALUES ('17', '麻将', '19');
INSERT INTO `threeappclass` VALUES ('18', '扑克', '19');
INSERT INTO `threeappclass` VALUES ('19', '赛车', '20');
INSERT INTO `threeappclass` VALUES ('20', '足球', '20');
INSERT INTO `threeappclass` VALUES ('21', '篮球', '20');
INSERT INTO `threeappclass` VALUES ('22', '摩托', '20');

-- ----------------------------
-- Table structure for twoappclass
-- ----------------------------
DROP TABLE IF EXISTS `twoappclass`;
CREATE TABLE `twoappclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '二级分类',
  `twoAPPName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '二级分类名称',
  `firstAPPClassId` int(11) DEFAULT NULL COMMENT '对应一级分类的名称id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of twoappclass
-- ----------------------------
INSERT INTO `twoappclass` VALUES ('1', '系统工具', '1');
INSERT INTO `twoappclass` VALUES ('2', '桌面插件', '1');
INSERT INTO `twoappclass` VALUES ('3', '主题美化', '1');
INSERT INTO `twoappclass` VALUES ('4', '社交聊天', '1');
INSERT INTO `twoappclass` VALUES ('5', '资讯阅读', '1');
INSERT INTO `twoappclass` VALUES ('6', '通讯网络', '1');
INSERT INTO `twoappclass` VALUES ('7', '影音娱乐', '1');
INSERT INTO `twoappclass` VALUES ('8', '摄影图片 ', '1');
INSERT INTO `twoappclass` VALUES ('9', '生活服务', '1');
INSERT INTO `twoappclass` VALUES ('10', '实用工具 ', '1');
INSERT INTO `twoappclass` VALUES ('11', '文档商务', '1');
INSERT INTO `twoappclass` VALUES ('12', '金融财经', '1');
INSERT INTO `twoappclass` VALUES ('13', '运动健康', '1');
INSERT INTO `twoappclass` VALUES ('14', '学习教育 ', '1');
INSERT INTO `twoappclass` VALUES ('15', '旅行交通', '1');
INSERT INTO `twoappclass` VALUES ('16', '购物', '1');
INSERT INTO `twoappclass` VALUES ('17', '休闲游戏', '2');
INSERT INTO `twoappclass` VALUES ('18', '益智游戏', '2');
INSERT INTO `twoappclass` VALUES ('19', '棋牌游戏', '2');
INSERT INTO `twoappclass` VALUES ('20', '体育赛车', '2');
INSERT INTO `twoappclass` VALUES ('21', '动作射击', '2');
INSERT INTO `twoappclass` VALUES ('22', '掌上网游', '2');
INSERT INTO `twoappclass` VALUES ('23', '策略塔防', '2');
INSERT INTO `twoappclass` VALUES ('24', '角色扮演', '2');
INSERT INTO `twoappclass` VALUES ('25', '模拟经营 ', '2');
INSERT INTO `twoappclass` VALUES ('26', '音乐游戏 ', '2');

-- ----------------------------
-- Table structure for userroles
-- ----------------------------
DROP TABLE IF EXISTS `userroles`;
CREATE TABLE `userroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户类型表Id',
  `userType` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT ' 用户类型（分为：超管、财务、市场、运营、销售）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of userroles
-- ----------------------------
INSERT INTO `userroles` VALUES ('1', '超级管理员');
INSERT INTO `userroles` VALUES ('2', '人事');
INSERT INTO `userroles` VALUES ('3', 'APP管理人员');
