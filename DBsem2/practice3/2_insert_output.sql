INSERT INTO output(id_i, otd, _out, dat_o)
SELECT id_i, Dep, move, dat
FROM(
	SELECT input.id_i, main.Dep, main.InvNom, SUM(main.Move) AS move, NOW() AS dat
	FROM input INNER JOIN main ON (
		input.otd = main.Dep AND input.inv = main.InvNom AND 
		input.named = main.NameDev AND input._in = main.Add AND input.cost = main.Cost)
	WHERE main.Move > 0
	GROUP BY main.InvNom
) AS output;
