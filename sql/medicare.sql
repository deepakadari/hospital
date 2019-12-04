-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema medicare_schema
-- ----------------------------------------------------

-- -----------------------------------------------------
-- Schema medicare_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medicare_schema` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema medicare
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema medicare
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medicare` DEFAULT CHARACTER SET utf8 ;
USE `medicare_schema` ;

-- -----------------------------------------------------
-- Table `medicare_schema`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare_schema`.`admin` (
  `admin_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `age` INT(2) NOT NULL,
  `gender` VARCHAR(7) NULL DEFAULT NULL,
  `dob` DATE NOT NULL,
  `contact_number` DECIMAL(10,0) NOT NULL,
  `alt_contact_number` DECIMAL(10,0) NULL DEFAULT NULL,
  `email_id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE INDEX `contact_number_UNIQUE` (`contact_number` ASC),
  UNIQUE INDEX `alt_contact_number_UNIQUE` (`alt_contact_number` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare_schema`.`medicare_services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare_schema`.`medicare_services` (
  `medicare_service_id` INT(11) NOT NULL AUTO_INCREMENT,
  `medicare_service` VARCHAR(50) NOT NULL,
  `service_description` VARCHAR(200) NOT NULL,
  `amount` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`medicare_service_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare_schema`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare_schema`.`patient` (
  `patient_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `age` INT(2) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `dob` DATE NULL DEFAULT NULL,
  `contact_number` DECIMAL(10,0) NOT NULL,
  `alt_contact_number` DECIMAL(10,0) NULL DEFAULT NULL,
  `email_id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `address_line_1` VARCHAR(100) NOT NULL,
  `address_line_2` VARCHAR(100) NULL DEFAULT NULL,
  `city` VARCHAR(50) NOT NULL,
  `state` VARCHAR(50) NOT NULL,
  `zip_code` DECIMAL(10,0) NOT NULL,
  `flag` TINYINT(1) NOT NULL,
  `statusflag` INT(11) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE INDEX `contact_number_UNIQUE` (`contact_number` ASC),
  UNIQUE INDEX `email_id_UNIQUE` (`email_id` ASC),
  UNIQUE INDEX `alt_contact_number_UNIQUE` (`alt_contact_number` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare_schema`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare_schema`.`booking` (
  `booking_id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NOT NULL,
  `medicare_service_id` INT(11) NOT NULL,
  PRIMARY KEY (`booking_id`),
  INDEX `patient_id_idx` (`patient_id` ASC),
  INDEX `medicare_service_id_idx` (`medicare_service_id` ASC),
  CONSTRAINT `medicare_service_id`
    FOREIGN KEY (`medicare_service_id`)
    REFERENCES `medicare_schema`.`medicare_services` (`medicare_service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `patient_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `medicare_schema`.`patient` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare_schema`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare_schema`.`doctor` (
  `doctor_id` INT(11) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `age` INT(2) NOT NULL,
  `gender` VARCHAR(7) NULL DEFAULT NULL,
  `dob` DATE NULL DEFAULT NULL,
  `flag` TINYINT(1) NOT NULL,
  `contact_number` DECIMAL(10,0) NOT NULL,
  `alt_contact_number` DECIMAL(10,0) NULL DEFAULT NULL,
  `email_id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `address_line_1` VARCHAR(100) NOT NULL,
  `address_line_2` VARCHAR(100) NULL DEFAULT NULL,
  `city` VARCHAR(50) NOT NULL,
  `state` VARCHAR(50) NOT NULL,
  `zip_code` DECIMAL(10,0) NOT NULL,
  `degree` VARCHAR(50) NOT NULL,
  `specialty` VARCHAR(50) NOT NULL,
  `work_hours` TIME(3) NOT NULL,
  `hospital_name` VARCHAR(100) NOT NULL,
  `medicare_service_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`doctor_id`),
  UNIQUE INDEX `contact_number_UNIQUE` (`contact_number` ASC),
  UNIQUE INDEX `alt_contact_number_UNIQUE` (`alt_contact_number` ASC),
  INDEX `medicare_service_id_fk_idx` (`medicare_service_id_fk` ASC),
  CONSTRAINT `medicare_service_id_fk`
    FOREIGN KEY (`medicare_service_id_fk`)
    REFERENCES `medicare_schema`.`medicare_services` (`medicare_service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare_schema`.`medical_test_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare_schema`.`medical_test_history` (
  `report_id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NOT NULL,
  `doctor_id` INT(11) NOT NULL,
  `admin_id` INT(11) NOT NULL,
  `medical_service_id` INT(11) NOT NULL,
  `service_date` DATE NOT NULL,
  `result_date` DATE NOT NULL,
  `actual_value` DOUBLE NOT NULL,
  `normal_range` VARCHAR(45) NOT NULL,
  `doctor` VARCHAR(500) NOT NULL,
  `other_info` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`report_id`),
  INDEX `customer_id_idx` (`patient_id` ASC),
  INDEX `doctor_id_idx` (`doctor_id` ASC),
  INDEX `medical_service_id_idx` (`medical_service_id` ASC),
  INDEX `admin_id_idx` (`admin_id` ASC),
  CONSTRAINT `admin_id_fk`
    FOREIGN KEY (`admin_id`)
    REFERENCES `medicare_schema`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `doctor_id_fk`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `medicare_schema`.`doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `medical_service_id_fk`
    FOREIGN KEY (`medical_service_id`)
    REFERENCES `medicare_schema`.`medicare_services` (`medicare_service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `patient_id_fk`
    FOREIGN KEY (`patient_id`)
    REFERENCES `medicare_schema`.`patient` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `medicare` ;

-- -----------------------------------------------------
-- Table `medicare`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`admin` (
  `admin_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `age` INT(2) NOT NULL,
  `gender` VARCHAR(7) NULL DEFAULT NULL,
  `d_o_b` DATE NOT NULL,
  `contact_number` DECIMAL(10,0) NOT NULL,
  `alt_contact_number` DECIMAL(10,0) NULL DEFAULT NULL,
  `email_id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE INDEX `Contact_Number_UNIQUE` (`contact_number` ASC),
  UNIQUE INDEX `Alt_Contact_Number_UNIQUE` (`alt_contact_number` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`medicare_services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`medicare_services` (
  `medicare_service_id` INT(11) NOT NULL AUTO_INCREMENT,
  `medicare_service` VARCHAR(50) NOT NULL,
  `service_description` VARCHAR(200) NOT NULL,
  `amount` DECIMAL(10,0) NOT NULL,
  `img_link` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`medicare_service_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`patient` (
  `patient_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `age` INT(2) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `d_o_b` DATE NULL DEFAULT NULL,
  `contact_number` DECIMAL(10,0) NOT NULL,
  `alt_contact_number` DECIMAL(10,0) NULL DEFAULT NULL,
  `mail_id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `address_line_1` VARCHAR(100) NOT NULL,
  `address_line_2` VARCHAR(100) NULL DEFAULT NULL,
  `city` VARCHAR(50) NOT NULL,
  `state` VARCHAR(50) NOT NULL,
  `zip_code` DECIMAL(10,0) NOT NULL,
  `flag` TINYINT(1) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE INDEX `Contact_Number_UNIQUE` (`contact_number` ASC),
  UNIQUE INDEX `Email_ID_UNIQUE` (`mail_id` ASC),
  UNIQUE INDEX `Alt_Contact_Number_UNIQUE` (`alt_contact_number` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`booking` (
  `booking_id` INT(11) NOT NULL,
  `booking_patient_id` INT(11) NOT NULL,
  `booking_medicare_service_id` INT(11) NOT NULL,
  PRIMARY KEY (`booking_id`),
  INDEX `Patient_ID_idx` (`booking_patient_id` ASC),
  INDEX `Medicare_Service_ID_idx` (`booking_medicare_service_id` ASC),
  CONSTRAINT `booking_medicare_service_id_fk`
    FOREIGN KEY (`booking_medicare_service_id`)
    REFERENCES `medicare`.`medicare_services` (`medicare_service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `booking_patient_id_fk`
    FOREIGN KEY (`booking_patient_id`)
    REFERENCES `medicare`.`patient` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`doctor` (
  `doctor_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `age` INT(2) NOT NULL,
  `gender` VARCHAR(7) NULL DEFAULT NULL,
  `d_o_b` DATE NULL DEFAULT NULL,
  `contact_number` DECIMAL(10,0) NOT NULL,
  `alt_contact_number` DECIMAL(10,0) NULL DEFAULT NULL,
  `Email_ID` VARCHAR(50) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `address_line_1` VARCHAR(100) NOT NULL,
  `address_line_2` VARCHAR(100) NULL DEFAULT NULL,
  `city` VARCHAR(50) NOT NULL,
  `state` VARCHAR(50) NOT NULL,
  `zip_code` DECIMAL(10,0) NOT NULL,
  `degree` VARCHAR(50) NOT NULL,
  `specialty` VARCHAR(50) NOT NULL,
  `work_hours` VARCHAR(10) NOT NULL,
  `hospital_name` VARCHAR(100) NOT NULL,
  `flag` TINYINT(1) NOT NULL,
  `medicare_services_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`doctor_id`),
  UNIQUE INDEX `Contact_Number_UNIQUE` (`contact_number` ASC),
  UNIQUE INDEX `Alt_Contact_Number_UNIQUE` (`alt_contact_number` ASC),
  INDEX `medicare_services_id_fk_idx` (`medicare_services_id_fk` ASC),
  CONSTRAINT `medicare_services_id_fk`
    FOREIGN KEY (`medicare_services_id_fk`)
    REFERENCES `medicare`.`medicare_services` (`medicare_service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medicare`.`medical_test_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`medical_test_history` (
  `report_id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id_fk` INT(11) NOT NULL,
  `doctor_id_fk` INT(11) NOT NULL,
  `service_date` DATE NULL DEFAULT NULL,
  `result_date` DATE NULL DEFAULT NULL,
  `actual_value` DOUBLE NULL DEFAULT NULL,
  `normal_range` VARCHAR(45) NULL DEFAULT NULL,
  `doctor_comments` VARCHAR(500) NULL DEFAULT NULL,
  `other_info` VARCHAR(500) NULL DEFAULT NULL,
  `admin_id_fk` INT(11) NULL DEFAULT NULL,
  `booking_status` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  INDEX `Doctor_ID_idx` (`doctor_id_fk` ASC),
  INDEX `Admin_ID_idx` (`admin_id_fk` ASC),
  INDEX `patient_id_fk_idx` (`patient_id_fk` ASC),
  CONSTRAINT `admin_id_fk`
    FOREIGN KEY (`admin_id_fk`)
    REFERENCES `medicare`.`admin` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `doctor_id_fk`
    FOREIGN KEY (`doctor_id_fk`)
    REFERENCES `medicare`.`doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `patient_id_fk`
    FOREIGN KEY (`patient_id_fk`)
    REFERENCES `medicare`.`patient` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
