drop table if exists `order_details`;
drop table if exists `orders`;
drop table if exists `items`;
drop table if exists `customers`;

CREATE TABLE IF NOT EXISTS `customers`
(
   `custID` INT (11) NOT NULL AUTO_INCREMENT,
   `first_name` VARCHAR (40) DEFAULT NULL,
   `surname` VARCHAR (40) DEFAULT NULL,
   PRIMARY KEY (`custID`)
);
