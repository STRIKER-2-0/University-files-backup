TRUNCATE  TABLE output;

INSERT INTO output(id_p, output.number, output.Data)
VALUES	((SELECT id_p FROM product WHERE product.id_p = 2  AND product.name_p = "комплект" 	AND product.size = "Двуспальный стандарт" AND product.material = "сатин" AND product.manufacture  = "Турция"  AND cost = 600), 2,  NOW() + INTERVAL 2 DAY),
	((SELECT id_p FROM product WHERE product.id_p = 2  AND product.name_p = "комплект" 	AND product.size = "Двуспальный стандарт" AND product.material = "сатин" AND product.manufacture  = "Турция"  AND cost = 600), 2,  NOW() + INTERVAL 10 DAY),
	((SELECT id_p FROM product WHERE product.id_p = 5  AND product.name_p = "комплект" 	AND product.size = "Односпальный стандарт"AND product.material = "сатин" AND product.manufacture  = "Китай"   AND cost = 400), 3,  NOW() + INTERVAL 15 DAY),
	((SELECT id_p FROM product WHERE product.id_p = 4  AND product.name_p = "комплект" 	AND product.size = "Европейский" 	  AND product.material = "бязь"  AND product.manufacture  = "Китай"   AND cost = 800), 2,  NOW() + INTERVAL 27 DAY),
	((SELECT id_p FROM product WHERE product.id_p = 3  AND product.name_p = "комплект" 	AND product.size = "Полуторный стандарт"  AND product.material = "ситец" AND product.manufacture  = "Россия"  AND cost = 500), 1,  NOW() + INTERVAL 28 DAY),
	((SELECT id_p FROM product WHERE product.id_p = 6  AND product.name_p = "пододеяльник"  AND product.size = "150*220" 		  AND product.material = "шелк"  AND product.manufacture  = "Турция"  AND cost = 300), 5,  NOW() + INTERVAL 36 DAY),	
	((SELECT id_p FROM product WHERE product.id_p = 7  AND product.name_p = "пододеяльник"  AND product.size = "210*220" 		  AND product.material = "сатин" AND product.manufacture  = "Украина" AND cost = 200), 10, NOW() + INTERVAL 41 DAY),
	((SELECT id_p FROM product WHERE product.id_p = 8  AND product.name_p = "простыня" 	AND product.size = "100*220" 		  AND product.material = "сатин" AND product.manufacture  = "Украина" AND cost = 100), 10, NOW() + INTERVAL 41 DAY);
