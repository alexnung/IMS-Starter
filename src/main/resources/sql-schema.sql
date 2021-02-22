drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims`;
CREATE TABLE IF NOT EXISTS `ims`.`customers`
(
   `custID` INT (11) NOT NULL AUTO_INCREMENT,
   `first_name` VARCHAR (40) DEFAULT NULL,
   `surname` VARCHAR (40) DEFAULT NULL,
   PRIMARY KEY (`custID`)
);
create table IF NOT EXISTS `ims`.`items`
(
   `IID` int not null auto_increment,
   `name` varchar (50),
   `price` float,
   primary key (IID)
);
create table IF NOT EXISTS `ims`.`orders`
(
   `Order_ID` INT NOT NULL AUTO_INCREMENT,
   `customer_ID` INT,
   `Item_ID` INT,
   `quantity` INT NOT NULL,
   PRIMARY KEY (Order_ID),
   FOREIGN KEY (customer_ID) REFERENCES Customers (custID),
   FOREIGN KEY (Item_ID) REFERENCES Items (IID)
);