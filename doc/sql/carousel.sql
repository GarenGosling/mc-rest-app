/*
Navicat MySQL Data Transfer

Source Server         : 旅行家测试数据库
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-09-25 15:00:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `md5` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '轮播图图片url的md5值',
  `description` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `status` int(1) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='轮播图';
