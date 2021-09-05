SELECT * FROM in_left_out
UNION
SELECT * FROM in_right_out
ORDER BY id_p;