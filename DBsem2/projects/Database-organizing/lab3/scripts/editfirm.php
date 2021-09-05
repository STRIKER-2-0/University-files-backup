<?php
	if($name != ''){
		if(!$mysqli->query(
				"UPDATE firma
				SET name = '$name'
				WHERE id_firm = '$old_id';"
			)){			
			echo "Error: ".$mysqli->error;
		}
	}
	if($shef != ''){
		if(!$mysqli->query(
				"UPDATE firma
				SET shef = '$shef'
				WHERE id_firm = '$old_id';"
			)){			
			echo "Error: ".$mysqli->error;
		}
	}
	if($address != ''){
		if(!$mysqli->query(
				"UPDATE firma
				SET address = '$address'
				WHERE id_firm = '$old_id';"
			)){			
			echo "Error: ".$mysqli->error;
		}	
	}
	echo '<p class="indent">Data edited successfully</p>';
?>