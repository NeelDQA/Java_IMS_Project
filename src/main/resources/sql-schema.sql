drop schema `ims`;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims`;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id` INT NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(40) DEFAULT NULL,
	`item_type` VARCHAR(40) DEFAULT NULL,
	`item_price` DOUBLE DEFAULT NULL,
	PRIMARY KEY(`item_id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`cust_id` INT NOT NULL ,
    `order_id` INT NOT NULL AUTO_INCREMENT,
	`order_status` VARCHAR(40) DEFAULT NULL,
	`order_price` DOUBLE DEFAULT NULL,
	PRIMARY KEY(`order_id`),
    foreign key(`cust_id`) references `customers`(`id`)
    );
CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
	`itemID` INT NOT NULL ,
    `orderID` INT NOT NULL ,
    `order_items_id` INT NOT NULL AUTO_INCREMENT,
	`order_quantity` int DEFAULT NULL,
	`unit_price` DOUBLE DEFAULT NULL,
	PRIMARY KEY(`order_items_id`),
    foreign key(`itemID`) references `items`(`item_id`),
    foreign key(`orderID`) references `orders`(`order_id`) on delete cascade
    
    );
    
SET FOREIGN_KEY_CHECKS = 0;




	
