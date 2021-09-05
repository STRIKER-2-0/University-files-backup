TRUNCATE TABLE curstolls;
INSERT INTO curstolls(idCur, idTol, curstolls.Comment)
VALUES ((SELECT idCur FROM curs WHERE NazvCur = 'Спортивный клуб'), (SELECT idTol FROM tool WHERE nazvTol = 'C#'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Спортивный клуб'), (SELECT idTol FROM tool WHERE nazvTol = 'MySQL'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Сайт для интернет-магазина хозтоваров'), (SELECT idTol FROM tool WHERE nazvTol = 'MySQL'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Сайт для интернет-магазина хозтоваров'), (SELECT idTol FROM tool WHERE nazvTol = 'PHP'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Регистрация ДТП'), (SELECT idTol FROM tool WHERE nazvTol = 'MySQL'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Регистрация ДТП'), (SELECT idTol FROM tool WHERE nazvTol = 'PHP'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idTol FROM tool WHERE nazvTol = 'JavaScript'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idTol FROM tool WHERE nazvTol = 'Asp.net'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idTol FROM tool WHERE nazvTol = 'MongoDB'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idTol FROM tool WHERE nazvTol = 'MySQL'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Биномиальное распределение Куматасавы'), (SELECT idTol FROM tool WHERE nazvTol = 'Fortran'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Биномиальное распределение Куматасавы'), (SELECT idTol FROM tool WHERE nazvTol = 'C#'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Логарифмическое распределение'), (SELECT idTol FROM tool WHERE nazvTol = 'Fortran'), 'comment'),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Логарифмическое распределение'), (SELECT idTol FROM tool WHERE nazvTol = 'Java'), 'comment');