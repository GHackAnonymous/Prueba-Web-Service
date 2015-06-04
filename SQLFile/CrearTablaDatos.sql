-- ------------------
--    Creo la tabla -
-- ------------------
CREATE TABLE `webserviceprueba1`.`tabla_datos` (
    `id_datos` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NOT NULL,
    `apellido` VARCHAR(100),
    `password` VARCHAR(50) NOT NULL,
    `email` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id_datos`));

-- ----------------------------
--    Inserto datos de prueba -
-- ----------------------------

INSERT INTO `webserviceprueba1`.`tabla_datos`(`nombre`,`apellido`,`password`,`email`)
VALUES('User1','Subname1','passwd1','user1@email.com');

INSERT INTO `webserviceprueba1`.`tabla_datos`(`nombre`,`apellido`,`password`,`email`)
VALUES('User2','Subname2','passwd2','user2@email.com');

INSERT INTO `webserviceprueba1`.`tabla_datos`(`nombre`,`apellido`,`password`,`email`)
VALUES('User3','Subname3','passwd3','user3@email.com');

INSERT INTO `webserviceprueba1`.`tabla_datos`(`nombre`,`apellido`,`password`,`email`)
VALUES('User4','Subname4','passwd4','user4@email.com');

INSERT INTO `webserviceprueba1`.`tabla_datos`(`nombre`,`apellido`,`password`,`email`)
VALUES('User5','Subname5','passwd5','user5@email.com');