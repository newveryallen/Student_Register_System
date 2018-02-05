CREATE TABLE `student` (
	`sid` INT(11) NOT NULL AUTO_INCREMENT,
	`sfname` VARCHAR(100) NOT NULL,
	`slname` VARCHAR(100) NOT NULL,
	`sage` INT(11) NOT NULL,
	`ssex` VARCHAR(100) NOT NULL,
	`sno` INT(100) NOT NULL,
	`email` VARCHAR(100) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`sid`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
