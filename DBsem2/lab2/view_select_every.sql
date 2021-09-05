DROP VIEW IF EXISTS select_every;
CREATE VIEW `cursach`.`select_every` 
    AS
(
	SELECT 
		curs.idCur,
		NazvCur,
		Referat,
		God, 
		NazvPr, 
		CONCAT(sotrud.Fam, ' ', SUBSTRING(sotrud.Im, 1, 1), '.', SUBSTRING(sotrud.Ot, 1, 1), '.') Sotrud,
		NazvTol,
		CONCAT(stud.Fam, ' ', SUBSTRING(stud.Im, 1, 1), '.', SUBSTRING(stud.Ot, 1, 1), '. (', cursstud.Gr, ')') Stud
	FROM (
	      (curs INNER JOIN (
				(curssotrpr INNER JOIN sotrud ON curssotrpr.idSotr = sotrud.idSotr) 	#сотрудники
				INNER JOIN predm ON curssotrpr.idPred = predm.idPr			#предметы
			) ON curs.idCur = curssotrpr.idCur
		) 
		INNER JOIN (
			curstolls INNER JOIN tool ON curstolls.idTol = tool.idTol		#инструменты
		) ON curs.idCur = curstolls.idCur
	)
	INNER JOIN (
		cursstud INNER JOIN stud ON cursstud.idStud = stud.idStud		#студенты
	) ON curs.idCur = cursstud.idCurs
);
