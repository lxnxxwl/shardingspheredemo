/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 19/07/2021 13:26:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_1
-- ----------------------------
DROP TABLE IF EXISTS `product_1`;
CREATE TABLE `product_1` (
  `id` bigint NOT NULL,
  `store_id` bigint DEFAULT NULL,
  `product_status` varchar(2) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

SET FOREIGN_KEY_CHECKS = 1;
