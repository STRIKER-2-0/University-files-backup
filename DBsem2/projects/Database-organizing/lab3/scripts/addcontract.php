<?php
	try {
		$stmt = $db->prepare(
			"INSERT INTO dogovor(id_firm, numberd, named, sumd, datastart, datafinish, avans)
			VALUES (?, ?, ?, ?, ?, ?, ?);"
		);
		$stmt->execute(array($id_firm, $number, $name, $sum, $date_start, $date_finish, $avans));
		
	} catch (PDOException $e){
		echo "Error during adding this firm's contract ".$e;
	}
	echo '<p class="indent">Data inserted successfully</p>';	
?>