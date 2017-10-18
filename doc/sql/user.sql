/*
Navicat MySQL Data Transfer

Source Server         : 旅行家
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-18 12:11:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增编号',
  `code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户编号',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '登陆用户名',
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '登陆密码',
  `md5` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头像图片地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` int(1) NOT NULL COMMENT '用户状态(默认是0）',
  `point` decimal(10,2) NOT NULL COMMENT '积分',
  PRIMARY KEY (`id`),
  KEY `code` (`code`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户表（hobby是兴趣标签，暂时定为以;分割；status是用户状态，默认是0，以后可能会有新的需求，比如禁止某个用户，或者会员之类的；live_province和live_city是地区表外键）';
