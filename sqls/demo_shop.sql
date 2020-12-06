/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : demo_shop

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 03/12/2020 10:09:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coupon
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
-- Table structure for goods
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
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `user_id` int(64) DEFAULT NULL,
  `order_status` char(1) DEFAULT NULL,
  `pay_status` char(1) DEFAULT NULL,
  `good_id` int(64) DEFAULT NULL,
  `good_num` int(64) DEFAULT NULL,
  `good_price` decimal(10,2) DEFAULT NULL,
  `order_total` decimal(10,2) DEFAULT NULL,
  `coupon_id` int(64) DEFAULT NULL,
  `coupon_paid` decimal(10,2) DEFAULT NULL,
  `money_paid` decimal(10,2) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `confirm_time` varchar(255) DEFAULT NULL,
  `pay_time` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
