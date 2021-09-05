INSERT INTO input(otd, inv, named, _in, cost, dat)
SELECT Dep, InvNom, NameDev, main.Add, Cost, NOW()
FROM main;