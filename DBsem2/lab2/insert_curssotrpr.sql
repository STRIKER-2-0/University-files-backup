TRUNCATE TABLE curssotrpr;
INSERT INTO curssotrpr(idCur, idPred, idSotr)
VALUES ((SELECT idCur FROM curs WHERE NazvCur = 'Спортивный клуб'), (SELECT idPr FROM predm WHERE NazvPr = 'Организация баз данных и знаний'), (SELECT idSotr FROM sotrud WHERE Fam = 'Лазурик' AND Im = 'Валентина')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Спортивный клуб'), (SELECT idPr FROM predm WHERE NazvPr = 'Организация баз данных и знаний'), (SELECT idSotr FROM sotrud WHERE Fam = 'Мартинкус')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Сайт для интернет-магазина хозтоваров'), (SELECT idPr FROM predm WHERE NazvPr = 'Организация баз данных и знаний'), (SELECT idSotr FROM sotrud WHERE Fam = 'Лазурик' AND Im = 'Валентина')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Сайт для интернет-магазина хозтоваров'), (SELECT idPr FROM predm WHERE NazvPr = 'Организация баз данных и знаний'), (SELECT idSotr FROM sotrud WHERE Fam = 'Мартинкус')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Регистрация ДТП'), (SELECT idPr FROM predm WHERE NazvPr = 'Организация баз данных и знаний'), (SELECT idSotr FROM sotrud WHERE Fam = 'Мартинкус')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Регистрация ДТП'), (SELECT idPr FROM predm WHERE NazvPr = 'Организация баз данных и знаний'), (SELECT idSotr FROM sotrud WHERE Fam = 'Лазурик' AND Im = 'Валентина')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idPr FROM predm WHERE NazvPr = 'Организация баз данных и знаний'), (SELECT idSotr FROM sotrud WHERE Fam = 'Мартинкус')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Японская анимация'), (SELECT idPr FROM predm WHERE NazvPr = 'Организация баз данных и знаний'), (SELECT idSotr FROM sotrud WHERE Fam = 'Лазурик' AND Im = 'Валентина')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Биномиальное распределение Куматасавы'), (SELECT idPr FROM predm WHERE NazvPr = 'Моделирование стохастических процессов'), (SELECT idSotr FROM sotrud WHERE Fam = 'Рудичев')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Биномиальное распределение Куматасавы'), (SELECT idPr FROM predm WHERE NazvPr = 'Моделирование стохастических процессов'), (SELECT idSotr FROM sotrud WHERE Fam = 'Лазурик' AND Im = 'Валентин')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Логарифмическое распределение'), (SELECT idPr FROM predm WHERE NazvPr = 'Моделирование стохастических процессов'), (SELECT idSotr FROM sotrud WHERE Fam = 'Рудичев')),
       ((SELECT idCur FROM curs WHERE NazvCur = 'Логарифмическое распределение'), (SELECT idPr FROM predm WHERE NazvPr = 'Моделирование стохастических процессов'), (SELECT idSotr FROM sotrud WHERE Fam = 'Лазурик' AND Im = 'Валентин'));
