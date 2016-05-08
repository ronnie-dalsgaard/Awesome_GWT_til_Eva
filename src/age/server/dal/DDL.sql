USE age;

DROP TABLE IF EXISTS `room`;
DROP TABLE IF EXISTS `building`;
DROP TABLE IF EXISTS `area`;

CREATE TABLE `age`.`area` (
  `areaId` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`areaId`));

CREATE TABLE `age`.`building` (
  `buildingId` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `adress` VARCHAR(45) NULL,
  `zip` VARCHAR(45) NULL,
  `areaId` INT NULL,
  PRIMARY KEY (`buildingId`),
  FOREIGN KEY (`areaId`)
    REFERENCES `area` (`areaId`)
);


CREATE TABLE `age`.`room` (
  `roomId` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `buildingId` INT NOT NULL,
  `isActive` INT NULL DEFAULT 0,
  PRIMARY KEY (`roomId`),
  FOREIGN KEY (`buildingId`)
    REFERENCES `building` (`buildingId`)  
);
