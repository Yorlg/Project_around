/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 127.0.0.1:3306
 Source Schema         : userdemo01

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 30/12/2021 15:49:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tab_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tab_user
-- ----------------------------
INSERT INTO `tab_user` VALUES (1, '123', '123');
INSERT INTO `tab_user` VALUES (13, '1', '1');
INSERT INTO `tab_user` VALUES (14, '2', '2');
INSERT INTO `tab_user` VALUES (15, '3', '3');
INSERT INTO `tab_user` VALUES (16, '4', '4');
INSERT INTO `tab_user` VALUES (17, '5', '5');
INSERT INTO `tab_user` VALUES (18, '6', '6');
INSERT INTO `tab_user` VALUES (19, '7', '7');
INSERT INTO `tab_user` VALUES (20, '8', '8');
INSERT INTO `tab_user` VALUES (21, '9', '9');
INSERT INTO `tab_user` VALUES (22, '1233', '1233');

SET FOREIGN_KEY_CHECKS = 1;
