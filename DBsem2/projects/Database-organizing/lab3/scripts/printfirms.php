<?php
	$answer = $mysqli->query(
			"SELECT *
			FROM firma
			WHERE name LIKE '".$letters."%';"
		);
	if (!$answer){
		echo "Error: ".$mysqli->error;
	}
	if($row = $answer->fetch_assoc()){
		echo "<tr><th>Firm name</th><th>Director</th><th>Address</th></tr>";
		echo "<tr><td>".$row["name"]."</td><td>".$row["shef"]."</td><td>".$row["address"]."</td></tr>";		
	}
	else {
		echo '<p class="indent">We didn\'t find anything.</p>';
		exit;
	}
	while($row = $answer->fetch_assoc()){
		echo "<tr><td>".$row["name"]."</td><td>".$row["shef"]."</td><td>".$row["address"]."</td></tr>";
	}
?>