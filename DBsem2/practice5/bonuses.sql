DELIMITER $$

USE `klientzakaz`$$

DROP PROCEDURE IF EXISTS `bonuses`$$

CREATE DEFINER=`Bezruk Yurii`@`%` PROCEDURE `bonuses`()
BEGIN
		DECLARE continue_flag INT DEFAULT TRUE;
		DECLARE visits INT DEFAULT 0;
		DECLARE klient INT;
		DECLARE dat DATETIME;
		DECLARE prev_klient INT DEFAULT -1;	
		
		DECLARE cur CURSOR FOR 
				SELECT DISTINCT id_k, dt
				FROM zakaz21
				WHERE MONTH(dt) = IF(@m - 1 = 0, 12, @m - 1) AND YEAR(dt) = IF(@m - 1 = 0, @g - 1, @g)
				ORDER BY id_k;
		DECLARE CONTINUE HANDLER FOR NOT FOUND 
			SET continue_flag = FALSE;		
		OPEN cur;
		FETCH cur INTO klient, dat;		
		WHILE continue_flag DO
			IF klient = prev_klient OR prev_klient = -1 THEN
				BEGIN
				SET visits = visits + 1;
				SET prev_klient = klient;
				END;
			ELSE 
				BEGIN
				IF visits >= 5 THEN 
					INSERT INTO bonus(code_k, bonus, mes, god)
					SELECT prev_klient, IF(visits > 7, 4, visits - 4), MONTH(dat), YEAR(dat);
				END IF;
				SET visits = 1;
				SET prev_klient = klient;
				END;
			END IF;
			FETCH cur INTO klient, dat;		
		END WHILE;
		IF visits >= 5 THEN 
			INSERT INTO bonus(code_k, bonus, mes, god)
			SELECT prev_klient, IF(visits > 7, 4, visits - 4), MONTH(dat), YEAR(dat);
		END IF;
		CLOSE cur;	
	END$$

DELIMITER ;