drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `custID` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`custID`)
);

<<<<<<< HEAD
create table  IF NOT EXISTS `ims`.`items` (
	`IID` int not null auto_increment,
	`name` varchar(50),
	`price` float,
	`primar`y key (IID));
=======
CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`IID` int not null auto_increment,
	`name` varchar(50),
	`price` float,
	primary key (IID)
	);
>>>>>>> 5f738e4496e26b2625434ee938942fd8eabdf36b
