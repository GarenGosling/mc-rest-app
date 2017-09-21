/*
Navicat MySQL Data Transfer

Source Server         : 旅行家测试数据库
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-09-21 12:13:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for partner_link
-- ----------------------------
DROP TABLE IF EXISTS `partner_link`;
CREATE TABLE `partner_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '合作商家',
  `img_md5` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '图片md5值',
  `url` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '合作链接ur',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` int(1) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='合作链接';
