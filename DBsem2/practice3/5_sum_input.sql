SELECT id_i, otd, SUM(_in) AS _in, SUM(_in)*cost AS cost
FROM input 
GROUP BY id_i


