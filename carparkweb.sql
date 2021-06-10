/*
Navicat MySQL Data Transfer

Source Server         : bishe
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : carparkweb

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-04-24 18:42:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '管理员', 'admin', 'admin');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('25', '2021-03-26 12:56:23', 'admin', '测试功能', '60ed3010849611eb4b329d62e9896419.jpg', '测试公告功能', null);
INSERT INTO `message` VALUES ('26', '2021-03-26 17:47:27', 'admin', '注意哒哒哒哒哒哒', '20210131213952.png', '发布公告', null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `rentId` int(13) DEFAULT NULL,
  `uid` varchar(125) DEFAULT NULL,
  `createTime` varchar(125) DEFAULT NULL,
  `charge` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('3', '1', 'ywwxAWx26NSC3YmY', '2021/04/24 04:36', '24');

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parkName` varchar(30) NOT NULL,
  `parkLocation` varchar(30) NOT NULL,
  `parkNumber` int(11) NOT NULL,
  `feeScale` varchar(12) NOT NULL,
  `userInfo` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of park
-- ----------------------------
INSERT INTO `park` VALUES ('1', '1号', '北京', '20', '3', '1,6,19');
INSERT INTO `park` VALUES ('4', '2号', '南京', '30', '5', null);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parkName` varchar(30) DEFAULT NULL,
  `location` varchar(30) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `inTime` varchar(30) DEFAULT NULL,
  `outTime` varchar(30) DEFAULT NULL,
  `isCharge` varchar(30) DEFAULT NULL,
  `charge` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('3', '1号', '北京', 'ywwxAWx26NSC3YmY', '2021/04/08 12:02', '2021/04/08 01:28', '已结算', '6');

-- ----------------------------
-- Table structure for rent
-- ----------------------------
DROP TABLE IF EXISTS `rent`;
CREATE TABLE `rent` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `parkStartTime` varchar(50) DEFAULT NULL,
  `uid` varchar(50) DEFAULT NULL,
  `parkEndTime` varchar(50) DEFAULT NULL,
  `parkAddress` varchar(150) DEFAULT NULL,
  `parkNum` varchar(50) DEFAULT NULL,
  `parkRentMoney` varchar(35) DEFAULT NULL,
  `parkUserName` varchar(50) DEFAULT NULL,
  `parkPhone` varchar(11) DEFAULT NULL,
  `parkYz` varchar(250) DEFAULT NULL,
  `park_img` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rent
-- ----------------------------
INSERT INTO `rent` VALUES ('1', '2021-04-23', 'ywwxAWx26NSC3YmY', '2021-04-25', '地址是什么', 'ABVD', '12', '1233', '1233423', '22344', 'KN27N2RudmGza76bc19745048bff57aaed83b5b62137.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('ywwxAWx26NSC3YmY', 'zhangsan', '男', '18728282323', 'zhangsan');
