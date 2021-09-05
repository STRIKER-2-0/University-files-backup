SELECT output.id_p, CONCAT(name_p, '(', size, ',', material, ',', manufacture, ',', cost, ')') AS product,
	SUM(output.number) AS number_out, SUM(product.cost*output.number) AS cost
FROM output INNER JOIN product ON output.id_p = product.id_p
GROUP BY output.id_p;