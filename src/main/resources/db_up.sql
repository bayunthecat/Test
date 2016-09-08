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
CREATE SCHEMA IF NOT EXISTS `testing` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `testing` ;

-- -----------------------------------------------------
-- Table `testing`.`Test`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`Test` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`Question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`Question` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `content` VARCHAR(45) NULL COMMENT '',
  `testId` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`, `testId`)  COMMENT '',
  INDEX `fk_Question_Test_idx` (`testId` ASC)  COMMENT '',
  CONSTRAINT `fk_Question_Test`
    FOREIGN KEY (`testId`)
    REFERENCES `testing`.`Test` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`Answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`Answer` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `content` VARCHAR(45) NULL COMMENT '',
  `isCorrect` TINYINT(1) NULL COMMENT '',
  `questionId` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_Answer_Question1_idx` (`questionId` ASC)  COMMENT '',
  CONSTRAINT `fk_Answer_Question1`
    FOREIGN KEY (`questionId`)
    REFERENCES `testing`.`Question` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`hibernate_sequences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testing`.`hibernate_sequences` (
  `idhibernate_sequence` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idhibernate_sequence`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
