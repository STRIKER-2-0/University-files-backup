<?php
	try {
		$stmt = $db->query("SELECT * FROM dogovor WHERE id_firm = '$id_firm'");
	} catch (PDOException $e){
		echo "Error during finding this firm's contracts";
	}
	if($row = $stmt->fetch()){
		echo "<tr><th>Number</th><th>Name</th><th>Sum</th><th>Date Start</th><th>Date Finish</th><th>Prepayment</th></tr>";
		echo "<tr><td>".$row["numberd"]."</td><td>".$row["named"]."</td><td>".$row["sumd"]."</td><td>".$row["datastart"]."</td><td>".$row["datafinish"]."</td><td>".$row["avans"]."</td></tr>";
	}
	else {
		echo '<p class="indent">We didn\'t find anything.</p>';
		exit;
	}
	while($row = $stmt->fetch()){
		echo "<tr><td>".$row["numberd"]."</td><td>".$row["named"]."</td><td>".$row["sumd"]."</td><td>".$row["datastart"]."</td><td>".$row["datafinish"]."</td><td>".$row["avans"]."</td></tr>";
	}
?>