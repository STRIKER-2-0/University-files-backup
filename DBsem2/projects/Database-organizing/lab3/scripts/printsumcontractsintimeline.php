<?php
	try {
		$query = "SELECT ROUND(SUM(sumd), 2) AS sum FROM dogovor
				WHERE id_firm = '$id_firm' AND
				datastart >= '$date_start' AND datafinish <= '$date_finish'";
		$stmt = $db->query($query);
	} catch (PDOException $e){
		echo "Error during finding this firm's contracts";
	}
	if($row = $stmt->fetch()){
		echo '<p class="indent">Sum of all contracts: '.$row['sum'].'</p>';
	}
	else {
		echo '<p class="indent">We didn\'t find anything in this timeline.</p>';
	}
?>