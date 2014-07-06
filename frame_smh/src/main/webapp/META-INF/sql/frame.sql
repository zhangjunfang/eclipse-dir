/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : frame

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2014-03-14 16:44:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `smh_test`
-- ----------------------------
DROP TABLE IF EXISTS `smh_test`;
CREATE TABLE `smh_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smh_test
-- ----------------------------
INSERT INTO `smh_test` VALUES ('1', null, '根节点');
INSERT INTO `smh_test` VALUES ('2', '1', '子节点');
INSERT INTO `smh_test` VALUES ('3', '2', '下级节点');
INSERT INTO `smh_test` VALUES ('4', '2', '下级节点');
