/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.9-log : Database - springbootmybatisdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springbootmybatisdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springbootmybatisdb`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `provinceId` int(10) unsigned DEFAULT NULL COMMENT '省份编号',
  `cityName` varchar(20) DEFAULT NULL COMMENT '城市名称',
  `description` text COMMENT '城市描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`id`,`provinceId`,`cityName`,`description`) values (1,1,'北京','这是北京市的描述信息,北京这家伙是中国首都,百年帝都,政治经济文化中心,也将是世界的中心.'),(2,2,'郑州','这是郑州市的描述信息,郑州这家伙是河南省会,城市中的后起之秀,河南政治经济文化中心,也是中国的中心城市.'),(3,3,'ZhengZhou','这是郑州市的描述信息,郑州这家伙是河南省会,城市中的后起之秀,河南政治经济文化中心,也是中国的中心城市.');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
