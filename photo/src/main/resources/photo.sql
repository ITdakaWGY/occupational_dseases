/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.26 : Database - photo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`photo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `photo`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `aid` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `art_describe` varchar(255) DEFAULT NULL,
  `num_support` bigint(20) DEFAULT NULL,
  `num_nonsupport` bigint(20) DEFAULT NULL,
  `num_comment` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `clothes_order` */

DROP TABLE IF EXISTS `clothes_order`;

CREATE TABLE `clothes_order` (
  `clo_order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '衣服订单id',
  `clothes_id` bigint(20) DEFAULT NULL COMMENT '订单对应衣服id',
  `custmer_id` bigint(20) DEFAULT NULL COMMENT '租赁客户',
  `clothes_order_state` bigint(20) DEFAULT NULL COMMENT '订单状态',
  `clothes_order_date` date DEFAULT NULL,
  PRIMARY KEY (`clo_order_id`),
  KEY `clothes_id` (`clothes_id`),
  KEY `custmer_id` (`custmer_id`),
  KEY `clothes_order_state` (`clothes_order_state`),
  CONSTRAINT `clothes_order_ibfk_1` FOREIGN KEY (`clothes_id`) REFERENCES `rent_clothes` (`clo_id`),
  CONSTRAINT `clothes_order_ibfk_2` FOREIGN KEY (`custmer_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `clothes_order_ibfk_3` FOREIGN KEY (`clothes_order_state`) REFERENCES `clothes_order_state` (`cos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Table structure for table `clothes_order_state` */

DROP TABLE IF EXISTS `clothes_order_state`;

CREATE TABLE `clothes_order_state` (
  `cos_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cos_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `clothes_type` */

DROP TABLE IF EXISTS `clothes_type`;

CREATE TABLE `clothes_type` (
  `clo_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clo_type_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`clo_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `combo` */

DROP TABLE IF EXISTS `combo`;

CREATE TABLE `combo` (
  `co_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `co_name` varchar(20) DEFAULT NULL,
  `co_picture` varchar(255) DEFAULT NULL,
  `co_type` bigint(20) DEFAULT NULL,
  `co_desc` varchar(100) DEFAULT NULL,
  `detail_pic1` varchar(255) DEFAULT NULL,
  `detail_pic2` varchar(255) DEFAULT NULL,
  `detail_pic3` varchar(255) DEFAULT NULL,
  `detail_pic4` varchar(255) DEFAULT NULL,
  `detail_pic5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`co_id`),
  KEY `type` (`co_type`),
  CONSTRAINT `combo_ibfk_1` FOREIGN KEY (`co_type`) REFERENCES `combotype` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Table structure for table `combo_location` */

DROP TABLE IF EXISTS `combo_location`;

CREATE TABLE `combo_location` (
  `cid` bigint(20) NOT NULL,
  `lid` bigint(20) NOT NULL,
  `combo_price` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`cid`,`lid`),
  KEY `lid` (`lid`),
  CONSTRAINT `combo_location_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `combo` (`co_id`),
  CONSTRAINT `combo_location_ibfk_2` FOREIGN KEY (`lid`) REFERENCES `shooting_location` (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `combo_order` */

DROP TABLE IF EXISTS `combo_order`;

CREATE TABLE `combo_order` (
  `com_order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `price` double DEFAULT NULL COMMENT '订单总价格',
  `com_oder_date` date DEFAULT NULL COMMENT '订单生成日期',
  `start_date` varchar(10) DEFAULT '' COMMENT '摄影套餐拍摄开始日期',
  `combo_id` bigint(20) DEFAULT NULL COMMENT '关联摄影套餐的id',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '用户',
  `shootting_location_id` bigint(20) DEFAULT NULL COMMENT '摄影地点',
  `shooting_state` bigint(10) DEFAULT NULL COMMENT '订单完成状态',
  PRIMARY KEY (`com_order_id`),
  KEY `combo_id` (`combo_id`),
  KEY `customer_id` (`customer_id`),
  KEY `shootting_location_id` (`shootting_location_id`),
  KEY `shooting_state` (`shooting_state`),
  CONSTRAINT `combo_order_ibfk_1` FOREIGN KEY (`combo_id`) REFERENCES `combo` (`co_id`),
  CONSTRAINT `combo_order_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `combo_order_ibfk_3` FOREIGN KEY (`shootting_location_id`) REFERENCES `shooting_location` (`lid`),
  CONSTRAINT `combo_order_ibfk_4` FOREIGN KEY (`shooting_state`) REFERENCES `combo_order_state` (`os_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Table structure for table `combo_order_state` */

DROP TABLE IF EXISTS `combo_order_state`;

CREATE TABLE `combo_order_state` (
  `os_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `os_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`os_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `combotype` */

DROP TABLE IF EXISTS `combotype`;

CREATE TABLE `combotype` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT,
  `tname` varchar(50) DEFAULT NULL,
  `tdec` varchar(100) DEFAULT NULL,
  `tpicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `com_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(11) DEFAULT NULL,
  `com_content` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`com_id`),
  KEY `article_id_2` (`article_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`aid`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `cust_phone` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `header_pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `eid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `rid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `rid` (`rid`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Table structure for table `employee_role_rel` */

DROP TABLE IF EXISTS `employee_role_rel`;

CREATE TABLE `employee_role_rel` (
  `eid` bigint(20) NOT NULL,
  `rid` bigint(20) NOT NULL,
  PRIMARY KEY (`eid`,`rid`),
  KEY `rid` (`rid`),
  CONSTRAINT `employee_role_rel_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`eid`),
  CONSTRAINT `employee_role_rel_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `guest_photo` */

DROP TABLE IF EXISTS `guest_photo`;

CREATE TABLE `guest_photo` (
  `gu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gu_time` varchar(100) DEFAULT NULL,
  `gu_pic1` varchar(255) DEFAULT NULL,
  `gu_pic2` varchar(255) DEFAULT NULL,
  `gu_pic3` varchar(255) DEFAULT NULL,
  `gu_pic4` varchar(255) DEFAULT NULL,
  `gu_pic5` varchar(255) DEFAULT NULL,
  `gu_pic6` varchar(255) DEFAULT NULL,
  `gu_pic7` varchar(255) DEFAULT NULL,
  `gu_pic8` varchar(255) DEFAULT NULL,
  `gu_pic9` varchar(255) DEFAULT NULL,
  `gu_pic10` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) DEFAULT NULL,
  `presource` varchar(50) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Table structure for table `picture` */

DROP TABLE IF EXISTS `picture`;

CREATE TABLE `picture` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT,
  `ppic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `rent_clothes` */

DROP TABLE IF EXISTS `rent_clothes`;

CREATE TABLE `rent_clothes` (
  `clo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clo_name` varchar(50) DEFAULT NULL,
  `clo_price` double DEFAULT NULL,
  `clo_picture` varchar(255) DEFAULT NULL,
  `clo_amount` bigint(10) DEFAULT NULL COMMENT '衣服数量',
  `clo_type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`clo_id`),
  KEY `clo_type` (`clo_type`),
  CONSTRAINT `rent_clothes_ibfk_1` FOREIGN KEY (`clo_type`) REFERENCES `clothes_type` (`clo_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rid` bigint(20) NOT NULL,
  `rname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `role_permission_rel` */

DROP TABLE IF EXISTS `role_permission_rel`;

CREATE TABLE `role_permission_rel` (
  `rid` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  PRIMARY KEY (`rid`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `shooting_days_10` */

DROP TABLE IF EXISTS `shooting_days_10`;

CREATE TABLE `shooting_days_10` (
  `shooting_days_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `shooting_days` varchar(10) DEFAULT NULL,
  `shooting_location_id` bigint(5) DEFAULT NULL,
  `shooting_times` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`shooting_days_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `shooting_days_3` */

DROP TABLE IF EXISTS `shooting_days_3`;

CREATE TABLE `shooting_days_3` (
  `shooting_days_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `shooting_days` varchar(10) DEFAULT NULL,
  `shooting_location_id` bigint(5) DEFAULT NULL,
  `shooting_times` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`shooting_days_id`),
  KEY `shooting_location_id` (`shooting_location_id`),
  CONSTRAINT `shooting_days_3_ibfk_1` FOREIGN KEY (`shooting_location_id`) REFERENCES `shooting_location` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Table structure for table `shooting_days_5` */

DROP TABLE IF EXISTS `shooting_days_5`;

CREATE TABLE `shooting_days_5` (
  `shooting_days_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `shooting_days` varchar(10) DEFAULT NULL,
  `shooting_location_id` bigint(5) DEFAULT NULL,
  `shooting_times` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`shooting_days_id`),
  KEY `shooting_location_id` (`shooting_location_id`),
  CONSTRAINT `shooting_days_5_ibfk_1` FOREIGN KEY (`shooting_location_id`) REFERENCES `shooting_location` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `shooting_days_7` */

DROP TABLE IF EXISTS `shooting_days_7`;

CREATE TABLE `shooting_days_7` (
  `shooting_days_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `shooting_days` varchar(10) DEFAULT NULL,
  `shooting_location_id` bigint(5) DEFAULT NULL,
  `shooting_times` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`shooting_days_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `shooting_location` */

DROP TABLE IF EXISTS `shooting_location`;

CREATE TABLE `shooting_location` (
  `lid` bigint(20) NOT NULL AUTO_INCREMENT,
  `lname` varchar(255) DEFAULT NULL,
  `shooting_days` bigint(5) DEFAULT NULL,
  `time_limit` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
