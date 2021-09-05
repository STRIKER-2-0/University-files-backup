<?php
	$stmt = $mysqli->prepare(
			"INSERT INTO firma(name, shef, address)
			VALUES (?, ?, ?);"
		);
	if (!$stmt){
		echo "Preparing error: ".$mysqli->error;
		exit;
	}
	if (!$stmt->bind_param("sss", $name, $shef, $address)){
		echo "Binding error: ".$stmt->error;
		exit;
	}
	if (!$stmt->execute()){
		echo "Executing error: ".$stmt->error;
		exit;
	}
	else {
		echo '<p class="indent">Data inserted successfully</p>';
	}
?>