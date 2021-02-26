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
create table IF NOT EXISTS `items`
(
   `IID` int not null auto_increment,
   `name` varchar (50),
   `price` float,
   primary key (IID)
);
create table IF NOT EXISTS `orders`
(
   `Order_ID` INT NOT NULL AUTO_INCREMENT,
   `customer_ID` INT,
   `Item_ID` INT,
   `quantity` INT NOT NULL,
   PRIMARY KEY (Order_ID),
   FOREIGN KEY (customer_ID) REFERENCES Customers (custID),
   FOREIGN KEY (Item_ID) REFERENCES Items (IID)
);
CREATE TABLE IF NOT EXISTS `order_details`
(
   `FID` INT (10) NOT NULL AUTO_INCREMENT,
   `order_id` INT (10) NOT NULL,
   `item_id` INT (10) NOT NULL,
   `quantity` INT (10) NOT NULL,
   PRIMARY KEY (`FID`),
   FOREIGN KEY (`order_id`) REFERENCES orders (`Order_ID`),
   FOREIGN KEY (`item_id`) REFERENCES items (`IID`)
);