 INSERT INTO depart(Dep)
 VALUES (101),
	(102),
	(103);
 
 INSERT INTO input(otd, inv, named, _in, cost, dat)
 VALUES (101, 11111, "Стол", 10, 500, NOW() + INTERVAL 1 DAY),
	(101, 22222, "Стул", 20, 200, NOW() + INTERVAL 1 DAY),
	(101, 33333, "Кресло", 2, 1000, NOW() + INTERVAL 1 DAY),
	(102, 44444, "ТВ", 2, 7000, NOW() + INTERVAL 2 DAY),
	(103, 55555, "ваза", 3, 100, NOW() + INTERVAL 3 DAY);
	
INSERT INTO output(id_i, otd, _out, dat_o)
 VALUES ((SELECT id_i FROM input WHERE input.otd = 101 AND input.inv = 11111 AND input.named = "Стол"), 101, 1, NOW() + INTERVAL 4 DAY),
	((SELECT id_i FROM input WHERE input.otd = 101 AND input.inv = 11111 AND input.named = "Стол"), 101, 2, NOW() + INTERVAL 5 DAY),
	((SELECT id_i FROM input WHERE input.otd = 101 AND input.inv = 22222 AND input.named = "Стул"), 101, 9, NOW() + INTERVAL 5 DAY),
	((SELECT id_i FROM input WHERE input.otd = 101 AND input.inv = 22222 AND input.named = "Стул"), 101, 1, NOW() + INTERVAL 6 DAY),
	((SELECT id_i FROM input WHERE input.otd = 103 AND input.inv = 55555 AND input.named = "Ваза"), 103, 3, NOW() + INTERVAL 6 DAY);
	