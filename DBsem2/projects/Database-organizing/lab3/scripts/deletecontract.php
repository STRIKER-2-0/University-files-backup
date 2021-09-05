<?php
	try {			
		$stmt = $db->exec(
			"DELETE FROM dogovor
			WHERE id_d = '$id_d';"
		);		
	} catch (PDOException $e){
		echo "Error during deleting this firm's contract".$e;
	}
	echo '<p class="indent">Contract deleted successfully</p>';	
?>