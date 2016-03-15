/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.20 : Database - monstercombat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`monstercombat` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `monstercombat`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `account` */

insert  into `account`(`id`,`avatar_url`,`password`,`username`) values (16,NULL,'iman','Iman'),(17,NULL,'Christin','Christin'),(18,NULL,'veni','Veni'),(19,NULL,'idola','Idola'),(20,NULL,'sanny','Sanny');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap` int(11) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `dp` int(11) DEFAULT NULL,
  `hp` int(11) DEFAULT NULL,
  `kind` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `item` */

insert  into `item`(`id`,`ap`,`avatar_url`,`dp`,`hp`,`kind`,`name`,`price`) values (1,0,'AlchemistFlame.png',5,2,'armor','Alchemist Flame',500),(2,1,'AlchemistSpark.png',8,0,'armor','Alchemist Spark',900),(3,7,'gladiator_snare.png',0,0,'weapon','Gladiator Snare',700),(4,5,'hex.png',0,4,'weapon','Hex',700),(5,6,'poison_gland.png',2,10,'weapon','Poison Gland',900),(6,5,'radiator_rope.png',3,0,'weapon','Radiator Rope',600),(7,10,'rustedgrenade.png',0,0,'weapon','Rusted Grenade',700),(8,10,'unfair_advantage.png',0,100,'accessories','Unfair Advantage',3000);

/*Table structure for table `monster` */

DROP TABLE IF EXISTS `monster`;

CREATE TABLE `monster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap` int(11) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `dp` int(11) DEFAULT NULL,
  `hp` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `monster` */

insert  into `monster`(`id`,`ap`,`avatar_url`,`dp`,`hp`,`name`) values (1,3,'Djinn.png',2,25,'Djinn'),(2,4,'Firetaur.png',1,25,'Firetaur'),(3,3,'Freettle.png',2,25,'Freettle'),(4,2,'Haze.png',4,24,'Haze'),(5,2,'Durin.png',3,25,'Durin'),(6,3,'Komocat.png',0,27,'Komocat'),(7,2,'Molem.png',4,24,'Molem'),(8,3,'Bonbon.png',1,26,'Bonbon'),(9,2,'Pandaken.png',2,26,'Pandaken'),(10,3,'Pikacu.png',1,26,'Pikacu'),(11,3,'Tarzape.png',2,25,'Tarzape'),(12,4,'Thundenix.png',0,26,'Thundenix'),(13,2,'Hairy.png',2,26,'Hairy');

/*Table structure for table `monster_account` */

DROP TABLE IF EXISTS `monster_account`;

CREATE TABLE `monster_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ap` int(11) DEFAULT NULL,
  `coin` int(11) DEFAULT NULL,
  `dp` int(11) DEFAULT NULL,
  `hp` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `win_point` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `monster_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_monster_account_monster_id` (`monster_id`),
  KEY `FK_monster_account_account_id` (`account_id`),
  CONSTRAINT `FK_monster_account_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK_monster_account_monster_id` FOREIGN KEY (`monster_id`) REFERENCES `monster` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `monster_account` */

insert  into `monster_account`(`id`,`ap`,`coin`,`dp`,`hp`,`name`,`win_point`,`account_id`,`monster_id`) values (16,10,700,7,27,'Tarzape',30,16,11),(17,2,500,4,24,'Haze',5,17,4),(18,33,2300,2,25,'Freettle',19,18,3),(19,7,600,3,25,'Durin',1,19,5),(20,3,0,2,25,'Djinn',0,20,1);

/*Table structure for table `monster_item` */

DROP TABLE IF EXISTS `monster_item`;

CREATE TABLE `monster_item` (
  `monster_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`item_id`),
  KEY `FK_monster_item_item_id` (`item_id`),
  CONSTRAINT `FK_monster_item_id` FOREIGN KEY (`id`) REFERENCES `monster_account` (`id`),
  CONSTRAINT `FK_monster_item_item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `monster_item` */

insert  into `monster_item`(`monster_id`,`id`,`item_id`) values (11,16,1),(11,16,3),(3,18,7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
