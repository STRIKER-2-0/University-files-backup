SELECT input.id_p, CONCAT(name_p, '(', size, ',', material, ',', manufacture, ',', cost, ')') AS product,
	SUM(input.number) AS number_in, SUM(product.cost*input.number) AS cost
FROM input INNER JOIN product ON input.id_p = product.id_p
GROUP BY input.id_p;