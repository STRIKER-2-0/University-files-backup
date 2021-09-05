SELECT sum_input.id_p, sum_input.product,
	number_in - IFNULL(number_out, 0) AS present,
	sum_input.cost - IFNULL(sum_output.cost, 0) AS sum_present
FROM sum_input LEFT JOIN sum_output ON sum_input.id_p = sum_output.id_p