/*
Navicat MySQL Data Transfer

Source Server         : mc
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-31 10:56:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `article_code` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '文章编码',
  `login_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '匿名' COMMENT '用户名',
  `content` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '评论内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
