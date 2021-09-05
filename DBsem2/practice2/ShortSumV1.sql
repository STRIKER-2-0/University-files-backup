SELECT view1.DEP, view1.nameDep, view1.sum, view2.sum 
FROM view1 LEFT JOIN view2 ON view1.dep = view2.dep
UNION
SELECT view2.DEP, view2.nameDep, view1.sum, view2.sum
FROM view2 LEFT JOIN view1 ON view1.dep = view2.dep

