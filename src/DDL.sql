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


DELIMITER //
DROP FUNCTION IF EXISTS createRoom //
CREATE FUNCTION createRoom(`vName` VARCHAR(25), `vBuildingId` INT, `vIsActive` INT) RETURNS INT
BEGIN
  DECLARE `nextRoomId` INT DEFAULT 0;
  SELECT MAX(`roomId`)+1 INTO `nextRoomId` FROM `room`;
  INSERT INTO `room` (`roomId`, `name`, `buildingId`, `isActive`) 
    VALUES (`nextRoomId`, `vName`, `vBuildingId`, `vIsActive`);
  RETURN `nextRoomId`;
END; //
DELIMITER ;
