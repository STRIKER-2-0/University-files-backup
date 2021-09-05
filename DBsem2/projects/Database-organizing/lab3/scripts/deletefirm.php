<?php
	if(!$mysqli->query(
			"DELETE FROM firma
			WHERE id_firm = '$id_firm';"
		)){			
		echo "Error: ".$mysqli->error;
	}
	else {
		echo '<p class="indent">Firm deleted successfully.</p>';
	}
	
?>