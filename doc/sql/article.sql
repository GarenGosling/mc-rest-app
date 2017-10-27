/*
Navicat MySQL Data Transfer

Source Server         : 旅行家
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-27 14:05:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '文章编码',
  `title` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '标题',
  `summary` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '文章内容简述',
  `user_code` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户编码',
  `author_code` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '作者编码',
  `author_pen_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '作者笔名',
  `menu_full_code` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '全部菜单码以/分割',
  `menu_full_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '全部菜单名以/分割',
  `subject_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '专题名称',
  `md5` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '主题图片的md5值',
  `view_num` int(11) NOT NULL DEFAULT '0' COMMENT '查看数',
  `comment_num` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `publish_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `author_code` (`author_code`),
  KEY `code` (`code`),
  KEY `menu_code` (`menu_full_code`),
  KEY `menu_name` (`menu_full_name`),
  KEY `subject_name` (`subject_name`),
  KEY `view_num` (`view_num`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='文章表';
