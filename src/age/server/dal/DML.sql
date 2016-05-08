INSERT INTO `age`.`area` (`areaId`, `name`) VALUES ('0', 'Denmark');
INSERT INTO `age`.`area` (`areaId`, `name`) VALUES ('1', 'Copenhagen');
INSERT INTO `age`.`area` (`areaId`, `name`) VALUES ('2', 'Aarhus');

INSERT INTO `age`.`building` (`buildingId`, `name`, `adress`, `zip`, `areaId`) VALUES ('0', 'Faraoens Palads', 'Julius Caesars vej 7', '1234', '0');
INSERT INTO `age`.`building` (`buildingId`, `name`, `adress`, `zip`, `areaId`) VALUES ('1', 'Taj Mahal', 'Østerbøvelse 12', '7888', '2');
INSERT INTO `age`.`building` (`buildingId`, `name`, `adress`, `zip`, `areaId`) VALUES ('2', 'Rundetårn', 'Rundetårnsvej 1', '1580', '1');

INSERT INTO `age`.`room` (`roomId`, `name`, `buildingId`, `isActive`) VALUES ('0', 'Det blå værelse', '0', '1');
INSERT INTO `age`.`room` (`roomId`, `name`, `buildingId`, `isActive`) VALUES ('1', 'Lokummet', '1', '1');
INSERT INTO `age`.`room` (`roomId`, `name`, `buildingId`, `isActive`) VALUES ('2', 'Gildesalen', '2', '1');
INSERT INTO `age`.`room` (`roomId`, `name`, `buildingId`, `isActive`) VALUES ('3', 'Herreværelset', '0', '1');
INSERT INTO `age`.`room` (`roomId`, `name`, `buildingId`, `isActive`) VALUES ('4', 'Sportshallen', '1', '1');
INSERT INTO `age`.`room` (`roomId`, `name`, `buildingId`, `isActive`) VALUES ('5', 'Spisestuen', '2', '1');
INSERT INTO `age`.`room` (`roomId`, `name`, `buildingId`, `isActive`) VALUES ('6', 'Skuret', '0', '1');
