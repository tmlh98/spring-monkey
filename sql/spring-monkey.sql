/*
Navicat MySQL Data Transfer

Source Server         : yun_sql
Source Server Version : 50725
Source Host           : tmlh.xyz:3306
Source Database       : tmlh-forum

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-16 16:28:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
`username`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`series`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`token`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`last_used`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`series`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户token信息'

;

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`create_time`  datetime NULL DEFAULT NULL ,
`operation`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`method`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`params`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL ,
`time`  bigint(20) NULL DEFAULT NULL ,
`ip`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_id`  int(11) NULL DEFAULT NULL COMMENT '对应的用户' ,
`url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求的路径' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4745

;

-- ----------------------------
-- Table structure for `tbl_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_admin`;
CREATE TABLE `tbl_admin` (
`id`  int(9) NOT NULL AUTO_INCREMENT ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`nackname`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称' ,
`username`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名' ,
`password`  char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `username` (`username`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `tbl_article`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_article`;
CREATE TABLE `tbl_article` (
`id`  int(9) NOT NULL AUTO_INCREMENT ,
`user`  int(11) NULL DEFAULT NULL COMMENT '用户id，外键' ,
`catalog`  mediumint(9) NOT NULL ,
`title`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题' ,
`keywords`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字' ,
`description`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述' ,
`content`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容' ,
`click_num`  mediumint(9) NOT NULL DEFAULT 0 COMMENT '点击量' ,
`create_time`  datetime NOT NULL COMMENT '发表日期' ,
`update_time`  datetime NULL DEFAULT NULL ,
`publish_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布的类型，文章或问答' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=27

;

-- ----------------------------
-- Table structure for `tbl_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_catalog`;
CREATE TABLE `tbl_catalog` (
`id`  int(9) NOT NULL AUTO_INCREMENT ,
`name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栏目名称' ,
`keywords`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栏目关键词' ,
`description`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '栏目描述' ,
`create_time`  datetime NOT NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=12

;

-- ----------------------------
-- Table structure for `tbl_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_comment`;
CREATE TABLE `tbl_comment` (
`id`  int(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`user_id`  int(10) NULL DEFAULT NULL COMMENT '用户id，外键' ,
`article_id`  int(20) NOT NULL COMMENT '文章id' ,
`content`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`comment_id`  int(11) NULL DEFAULT NULL COMMENT '评论id' ,
PRIMARY KEY (`id`),
FOREIGN KEY (`article_id`) REFERENCES `tbl_article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `art_com` (`article_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='用户评论表'
AUTO_INCREMENT=17

;

-- ----------------------------
-- Table structure for `tbl_message`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_message`;
CREATE TABLE `tbl_message` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`content`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL ,
`sender`  int(11) NULL DEFAULT NULL COMMENT '发送者用户id' ,
`receiver`  int(11) NULL DEFAULT NULL COMMENT '接收者用户id' ,
`status`  int(1) NULL DEFAULT 0 COMMENT '0 ：未读，1:以读' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`type`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=8

;

-- ----------------------------
-- Table structure for `tbl_social`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_social`;
CREATE TABLE `tbl_social` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`user_id`  int(11) NULL DEFAULT NULL COMMENT '用户id' ,
`follow`  int(11) NULL DEFAULT NULL COMMENT '关注的用户id' ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=17

;

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id' ,
`userconnection_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '社交账户userId' ,
`username`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名' ,
`email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱' ,
`image_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像' ,
`create_time`  datetime NOT NULL COMMENT '注册时间' ,
`last_login`  datetime NULL DEFAULT NULL COMMENT '最后一次登录时间' ,
`state`  tinyint(2) NOT NULL DEFAULT 0 COMMENT '用户状态 0:正常 1:冻结 2:注销' ,
`source`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源' ,
`detail`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息' ,
`signature`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '这个家伙很懒，什么都没留下...' COMMENT '签名' ,
`gender`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `idx_username` (`username`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户表'
AUTO_INCREMENT=27

;

-- ----------------------------
-- Table structure for `tbl_userconnection`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userconnection`;
CREATE TABLE `tbl_userconnection` (
`userId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`providerId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`providerUserId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' ,
`rank`  int(11) NOT NULL ,
`displayName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`profileUrl`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`imageUrl`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`accessToken`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`secret`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`refreshToken`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`expireTime`  bigint(20) NULL DEFAULT NULL ,
PRIMARY KEY (`userId`, `providerId`, `providerUserId`),
UNIQUE INDEX `UserConnectionRank` (`userId`, `providerId`, `rank`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='社交登陆中间表'

;
 