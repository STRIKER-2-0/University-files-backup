TRUNCATE TABLE cursstud;
INSERT INTO cursstud(idCurs, idStud, Gr, Ball)
VALUES ((SELECT idCur FROM curs WHERE NazvCur = 'Спортивный клуб'), (SELECT idStud FROM stud WHERE Fam = 'Андреева'), 'КС-31', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Спортивный клуб'), (SELECT idStud FROM stud WHERE Fam = 'Ткач'), 'КС-32', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Спортивный клуб'), (SELECT idStud FROM stud WHERE Fam = 'Гавришова'), 'КС-31', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Сайт для интернет-магазина хозтоваров'), (SELECT idStud FROM stud WHERE Fam = 'Иващенко'), 'КС-32', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Сайт для интернет-магазина хозтоваров'), (SELECT idStud FROM stud WHERE Fam = 'Белоус'), 'КС-32', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Регистрация ДТП'), (SELECT idStud FROM stud WHERE Fam = 'Ширинов'), 'КС-31', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Регистрация ДТП'), (SELECT idStud FROM stud WHERE Fam = 'Исиченко'), 'КС-32', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Регистрация ДТП'), (SELECT idStud FROM stud WHERE Fam = 'Тапузов'), 'КС-32', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idStud FROM stud WHERE Fam = 'Ефремов'), 'КС-31', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idStud FROM stud WHERE Fam = 'Сорокин'), 'КС-31', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idStud FROM stud WHERE Fam = 'Яшин'), 'КУ-31', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idStud FROM stud WHERE Fam = 'Фёдоров'), 'КС-32', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Биномиальное распределение Куматасавы'), (SELECT idStud FROM stud WHERE Fam = 'Фёдоров'), 'КС-32', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Биномиальное распределение Куматасавы'), (SELECT idStud FROM stud WHERE Fam = 'Ефремов'), 'КС-31', 100),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Логарифмическое распределение'), (SELECT idStud FROM stud WHERE Fam = 'Ширинов'), 'КС-31', 100);
