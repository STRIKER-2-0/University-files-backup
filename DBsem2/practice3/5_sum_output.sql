SELECT output.id_i, output.otd, SUM(_out) AS _out, SUM(_out)*input.cost AS cost
FROM output INNER JOIN input ON output.id_i = input.id_i
GROUP BY id_i, otd