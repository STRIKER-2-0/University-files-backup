CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    PROCEDURE `devices`.`6_form_present`()
    /*LANGUAGE SQL
    | [NOT] DETERMINISTIC
    | { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
    | SQL SECURITY { DEFINER | INVOKER }
    | COMMENT 'string'*/
	BEGIN
		INSERT INTO present(otd, main_pres, main_sum_pres, data_last_modified)
		SELECT otd, present, present_cost, NOW()
		FROM `5_final_sum`	
	END