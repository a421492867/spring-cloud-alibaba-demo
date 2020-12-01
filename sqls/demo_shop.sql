/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : demo_shop

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 12/01/2020 22:01:33 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `coupon`
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `coupon_price` decimal(10,2) DEFAULT NULL,
  `user_id` int(64) DEFAULT NULL,
  `order_id` int(64) DEFAULT NULL,
  `is_used` char(1) DEFAULT NULL,
  `used_time` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL COMMENT '库存量',
  `price` decimal(10,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `user_id` int(64) DEFAULT NULL,
  `order_status` char(1) DEFAULT NULL,
  `pay_status` char(1) DEFAULT NULL,
  `shipping_status` char(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `consigee` varchar(255) DEFAULT NULL COMMENT '收货人',
  `good_id` int(64) DEFAULT NULL,
  `good_num` int(64) DEFAULT NULL,
  `good_price` decimal(10,2) DEFAULT NULL,
  `good_amount` decimal(10,2) DEFAULT NULL,
  `shipping_fee` decimal(10,2) DEFAULT NULL,
  `order_amount` decimal(10,2) DEFAULT NULL,
  `coupon_id` int(64) DEFAULT NULL,
  `coupon_paid` decimal(10,2) DEFAULT NULL,
  `money_paid` decimal(10,2) DEFAULT NULL,
  `pay_amount` decimal(10,2) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `confirm_time` varchar(255) DEFAULT NULL,
  `pay_time` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
