DELIMITER $$

USE `cursach`$$

DROP PROCEDURE IF EXISTS `summary`$$

CREATE PROCEDURE `summary`()
BEGIN
		DECLARE continue_flag BOOL DEFAULT TRUE;
		
		DECLARE id INT;
		DECLARE cur_name VARCHAR(255);
		DECLARE annotation VARCHAR(2048);
		DECLARE cur_year YEAR;
		DECLARE discipline VARCHAR(128);
		DECLARE teacher VARCHAR(128);
		DECLARE tool VARCHAR(128);
		DECLARE student VARCHAR(256);
		
		DECLARE prev_id INT DEFAULT 0;
		DECLARE prev_name VARCHAR(255);
		DECLARE prev_annotation VARCHAR(2048);
		DECLARE prev_year YEAR;
		DECLARE prev_discipline VARCHAR(128);
		DECLARE prev_teacher VARCHAR(128) DEFAULT '\0';
		DECLARE prev_tool VARCHAR(128) DEFAULT '\0';
		DECLARE prev_student VARCHAR(256);
		
		DECLARE temp_student VARCHAR(256) DEFAULT '';
		DECLARE temp_tool VARCHAR(128) DEFAULT '';
		DECLARE temp_teacher VARCHAR(128) DEFAULT '';
		
		DECLARE res_student VARCHAR(256) DEFAULT '';
		DECLARE res_tool VARCHAR(128) DEFAULT '';
		
		DECLARE tool_flag BOOL DEFAULT TRUE;
				
		DECLARE cur CURSOR FOR SELECT *
					FROM select_every
					ORDER BY idCur, NazvCur, Referat, God, NazvPr, Sotrud, NazvTol, Stud;			
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET continue_flag = FALSE;				
		OPEN cur;		
		FETCH cur INTO id, cur_name, annotation, cur_year, discipline, teacher, tool, student;
		SET prev_id = id;
		SET prev_name = cur_name;
		SET prev_annotation = annotation;
		SET prev_year = cur_year;
		SET prev_discipline = discipline;
		SET prev_teacher = teacher;
		SET prev_tool = tool;
		SET prev_student = student;
		SET temp_tool = CONCAT(temp_tool, ' ', tool);
		WHILE continue_flag DO			
			IF tool <> prev_tool THEN 
				BEGIN
				SET temp_tool = CONCAT(temp_tool, ' ', prev_tool);
				SET res_student = temp_student;
				SET temp_student = '';
				SET tool_flag = FALSE;
				END;
			END IF;
			IF teacher <> prev_teacher THEN 
				BEGIN
				SET temp_teacher = CONCAT(temp_teacher, ' ', prev_teacher);
				IF tool_flag THEN 
					SET temp_tool = CONCAT(temp_tool, ' ', prev_tool);
				END IF;
				SET res_tool = temp_tool;
				SET temp_tool = '';
				SET temp_student = '';
				END;
			END IF;
			IF id <> prev_id THEN 
				BEGIN
				INSERT INTO report(`Название`, `Аннотация`, `Год`, `Дисциплина`, `Преподаватель`, `Инструменты`, `Студенты`)
				SELECT prev_name, prev_annotation, prev_year, prev_discipline, temp_teacher, res_tool, res_student;
				SET temp_teacher = '';
				SET temp_tool = '';
				SET temp_student = '';
				END;
			END IF;
			SET temp_student = CONCAT(temp_student, ' ', student);
			SET prev_id = id;
			SET prev_name = cur_name;
			SET prev_annotation = annotation;
			SET prev_year = cur_year;
			SET prev_discipline = discipline;
			SET prev_teacher = teacher;
			SET prev_tool = tool;
			SET prev_student = student;
			SET tool_flag = TRUE;
			FETCH cur INTO id, cur_name, annotation, cur_year, discipline, teacher, tool, student;
		END WHILE;
		SET temp_teacher = CONCAT(temp_teacher, ' ', prev_teacher);
		INSERT INTO report(`Название`, `Аннотация`, `Год`, `Дисциплина`, `Преподаватель`, `Инструменты`, `Студенты`)
		SELECT prev_name, prev_annotation, prev_year, prev_discipline, temp_teacher, res_tool, res_student;
		CLOSE cur;
	END$$

DELIMITER ;