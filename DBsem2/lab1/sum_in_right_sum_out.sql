SELECT sum_output.id_p, sum_output.product,
	IFNULL(number_in, 0) - number_out AS present, 
	IFNULL(sum_input.cost, 0) - sum_output.cost AS sum_present
FROM sum_input RIGHT JOIN sum_output ON sum_input.id_p = sum_output.id_p