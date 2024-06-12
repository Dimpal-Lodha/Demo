------------------------------------------------------------------
-- @Author :- Dimpal Lodha
-- @Created Date:- 6/12/2024
-- @Description :- Company schema CREATE
------------------------------------------------------------------

CREATE SCHEMA `company` ;


------------------------------------------------------------------
-- @Author :- Dimpal Lodha
-- @Created Date:- 6/12/2024
-- @Description :- Employee Table CREATE
------------------------------------------------------------------

DROP TABLE IF EXISTS `employee`; 
CREATE TABLE `employee` (
  `emp_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NULL,
  `salary` DECIMAL(6,0) NULL,
  PRIMARY KEY (`emp_id`));
  
  
  
------------------------------------------------------------------
-- @Author :- Dimpal Lodha
-- @Created Date:- 6/12/2024
-- @Description :- Branch Table CREATE
------------------------------------------------------------------
DROP TABLE IF EXISTS `branch`; 
CREATE TABLE `branch` (
  `branch_id` BIGINT(5) NOT NULL AUTO_INCREMENT,
  `branch_name` VARCHAR(45) NULL,
  PRIMARY KEY (`branch_id`));
  
  
------------------------------------------------------------------
-- @Author :- Dimpal Lodha
-- @Created Date:- 6/12/2024
-- @Description :- Add branch_id as FK in Employee Table
------------------------------------------------------------------	
ALTER TABLE `employee` 
ADD COLUMN `branch_id` BIGINT(5) NOT NULL AFTER `salary`;

ALTER TABLE `employee` 
ADD CONSTRAINT `branch_id_emp_FK`
  FOREIGN KEY (`branch_id`)
  REFERENCES `company`.`branch` (`branch_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;