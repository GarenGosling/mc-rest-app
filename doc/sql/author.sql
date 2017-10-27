/*
Navicat MySQL Data Transfer

Source Server         : 旅行家
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-27 14:05:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '作者编码',
  `user_code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户编码',
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '手机号，本站用户唯一手机号（实名制）',
  `id_num` varchar(18) COLLATE utf8_unicode_ci NOT NULL COMMENT '身份证号（实名制）',
  `real_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '真实姓名',
  `pen_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '笔名',
  `status` int(1) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `reject_reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '驳回原因',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_code` (`user_code`) USING BTREE,
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `id_num` (`id_num`),
  KEY `code` (`code`),
  KEY `pen_name` (`pen_name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='作者表';
