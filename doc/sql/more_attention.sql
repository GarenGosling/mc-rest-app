/*
Navicat MySQL Data Transfer

Source Server         : 旅行家
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-27 14:06:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for more_attention
-- ----------------------------
DROP TABLE IF EXISTS `more_attention`;
CREATE TABLE `more_attention` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '链接',
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '关注网站描述信息',
  `md5` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '图片MD5值',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态（0：不显示；1：显示）',
  `order_by` int(11) NOT NULL COMMENT '排列顺序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `status` (`status`),
  KEY `order_by` (`order_by`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
