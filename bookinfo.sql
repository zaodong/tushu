/*
Navicat MySQL Data Transfer

Source Server         : mysql5.5
Source Server Version : 50555
Source Host           : localhost:3306
Source Database       : bookinfo

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2020-06-10 16:30:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `AID` int(11) NOT NULL AUTO_INCREMENT,
  `ALoginID` varchar(255) DEFAULT NULL,
  `ALoginPSW` varchar(255) DEFAULT NULL,
  `AName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('1', 'zhangsan', '123', '张三');

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `BID` int(11) NOT NULL AUTO_INCREMENT,
  `BTitle` varchar(255) DEFAULT NULL,
  `BAuthor` varchar(255) DEFAULT NULL,
  `BPrice` decimal(10,0) DEFAULT NULL,
  `BCategoryID` int(11) DEFAULT NULL,
  `BPublisher` varchar(255) DEFAULT NULL,
  `BPhoto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BID`),
  KEY `categry` (`BCategoryID`),
  CONSTRAINT `categry` FOREIGN KEY (`BCategoryID`) REFERENCES `categoryinfo` (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('1', '非洲的旋律', '李艳丽', '128', '1', '金山', 'img/9aab8a7fa9005ef918c9aa2d5f17c806.jpg');
INSERT INTO `bookinfo` VALUES ('10', '权力的游戏', '未知', '128', '13', '金山出版社', 'img/20151107204521.png');
INSERT INTO `bookinfo` VALUES ('13', '天道', '未知', '128', '9', '金山出版社', 'img/6f2493e6c6fe8e2485c407e5d75e3651.jpg');
INSERT INTO `bookinfo` VALUES ('16', '几何原理', '未知', '128', '19', '新华出版社', 'img/9aab8a7fa9005ef918c9aa2d5f17c806.jpg');

-- ----------------------------
-- Table structure for categoryinfo
-- ----------------------------
DROP TABLE IF EXISTS `categoryinfo`;
CREATE TABLE `categoryinfo` (
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  `CName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categoryinfo
-- ----------------------------
INSERT INTO `categoryinfo` VALUES ('1', '地图地理');
INSERT INTO `categoryinfo` VALUES ('9', '历史');
INSERT INTO `categoryinfo` VALUES ('13', '科学');
INSERT INTO `categoryinfo` VALUES ('14', '神学');
INSERT INTO `categoryinfo` VALUES ('18', '语文');
INSERT INTO `categoryinfo` VALUES ('19', '数学');
