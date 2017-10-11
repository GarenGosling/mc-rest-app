/*
Navicat MySQL Data Transfer

Source Server         : 旅行家测试数据库
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-11 15:57:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名',
  `url` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单链接',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单描述信息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` int(2) NOT NULL COMMENT '菜单状态',
  `level` int(1) NOT NULL COMMENT '菜单等级，暂时有三级菜单',
  `parent_code` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '父菜单编码',
  `order_by` int(11) NOT NULL COMMENT '菜单显示顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='板块表\r\ndefault_img_url显示在首页热门板块处，如果热门文章没有图片，那么显示默认的板块图片，否则显示热门文章的图片\r\nmenu_index和hot_index主要用于标示板块的位置，以后可以根据位置信息和用户的点击量分析页面排版对于用户点击量的影响作出相应的排版调整';
