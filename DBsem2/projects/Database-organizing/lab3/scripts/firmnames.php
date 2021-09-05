<?php
	$res = $mysqli->query(
			"SELECT id_firm, name
			FROM firma;"
		);
	if (!$res){
		echo "Error: ".$mysqli->error;
	}
?>