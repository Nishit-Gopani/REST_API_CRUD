CREATE SCHEMA IF NOT EXISTS `newtonx_test`;
USE `newtonx_test` ;

-- -----------------------------------------------------
-- Table `newtonx_test`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newtonx_test`.`user` ;

CREATE TABLE IF NOT EXISTS `newtonx_test`.`user` (
    `user_Id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`user_Id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARACTER SET=UTF8;

INSERT INTO `newtonx_test`.`user` (`firstName`, `lastName`) VALUES ('Charles', 'Harry');
INSERT INTO `newtonx_test`.`user` (`firstName`, `lastName`) VALUES ('Mary ', 'Willams');
INSERT INTO `newtonx_test`.`user` (`firstName`, `lastName`) VALUES ('Chad ', 'Derby');
INSERT INTO `newtonx_test`.`user` (`firstName`, `lastName`) VALUES ('Sid', 'Jones');
INSERT INTO `newtonx_test`.`user` (`firstName`, `lastName`) VALUES ('John ', 'Cena');
