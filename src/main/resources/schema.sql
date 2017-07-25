-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema testing
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema testing
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `testing` DEFAULT CHARACTER SET utf8 ;
USE `testing` ;

-- -----------------------------------------------------
-- Table `testing`.`test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`test` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`topic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NULL,
  `topicId` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_topic1_idx` (`topicId` ASC),
  CONSTRAINT `fk_question_topic1`
    FOREIGN KEY (`topicId`)
    REFERENCES `testing`.`topic` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NULL,
  `questionId` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_answer_question1_idx` (`questionId` ASC),
  CONSTRAINT `fk_answer_question1`
    FOREIGN KEY (`questionId`)
    REFERENCES `testing`.`question` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`userrole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`userrole` (
  `userId` INT NOT NULL,
  `roleId` INT NOT NULL,
  PRIMARY KEY (`userId`, `roleId`),
  INDEX `fk_userrole_role1_idx` (`roleId` ASC),
  CONSTRAINT `fk_userrole_user`
    FOREIGN KEY (`userId`)
    REFERENCES `testing`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_userrole_role1`
    FOREIGN KEY (`roleId`)
    REFERENCES `testing`.`role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`testquestion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`testquestion` (
  `testId` INT NOT NULL,
  `questionId` INT NOT NULL,
  PRIMARY KEY (`testId`, `questionId`),
  INDEX `fk_testquestion_question1_idx` (`questionId` ASC),
  CONSTRAINT `fk_testquestion_test1`
    FOREIGN KEY (`testId`)
    REFERENCES `testing`.`test` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_testquestion_question1`
    FOREIGN KEY (`questionId`)
    REFERENCES `testing`.`question` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SET AUTOCOMMIT=1;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;