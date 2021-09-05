SELECT otd, SUM(_in - _out) AS present, SUM(in_cost - out_cost) AS present_cost
FROM 5_sum_in_and_out_cost 
GROUP BY otd