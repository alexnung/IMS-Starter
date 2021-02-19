drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `custID` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`custID`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`IID` int not null auto_increment,
	`name` varchar(50),
	`price` float,
	primary key (IID)
	);
