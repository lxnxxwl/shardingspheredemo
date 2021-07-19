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

 Date: 19/07/2021 13:25:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dict_1
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_1`;
CREATE TABLE `sys_dict_1` (
  `dict_id` bigint NOT NULL,
  `status` varchar(2) DEFAULT NULL,
  `value` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

SET FOREIGN_KEY_CHECKS = 1;
