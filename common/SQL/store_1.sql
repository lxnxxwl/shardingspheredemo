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

 Date: 19/07/2021 15:05:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for store_1
-- ----------------------------
DROP TABLE IF EXISTS `store_1`;
CREATE TABLE `store_1` (
  `store_id` bigint NOT NULL,
  `store_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

SET FOREIGN_KEY_CHECKS = 1;
