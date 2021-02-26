drop table if exists `order_details`;
drop table if exists `orders`;
drop table if exists `items`;
drop table if exists `customers`;

create table IF NOT EXISTS `items`
(
   `IID` int not null auto_increment,
   `name` varchar (50),
   `price` float,
   primary key (IID)
);