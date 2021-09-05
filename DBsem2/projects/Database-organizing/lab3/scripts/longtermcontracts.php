<?php
	try {
		$query = "SELECT name, numberd, named, sumd, datastart, datafinish, avans 
				FROM dogovor INNER JOIN firma ON dogovor.id_firm = firma.id_firm
				WHERE (datafinish - datastart) > 365";
		$stmt = $db->query($query);
	} catch (PDOException $e){
		echo "Error during finding contracts";
	}
	if($row = $stmt->fetch()){
		echo '<p class="indent">All long-term contracts: ';
		echo "<tr><th>Firm</th><th>Number</th><th>Name</th><th>Sum</th><th>Date Start</th><th>Date Finish</th><th>Prepayment</th></tr>";
		echo "<tr><td>".$row["name"]."</td><td>".$row["numberd"]."</td><td>".$row["named"]."</td><td>".$row["sumd"]."</td><td>".$row["datastart"]."</td><td>".$row["datafinish"]."</td><td>".$row["avans"]."</td></tr>";
	}
	else {
		echo '<p class="indent">We didn\'t find anything.</p>';
		exit;
	}
	while($row = $stmt->fetch()){
		echo "<tr><td>".$row["name"]."</td><td>".$row["numberd"]."</td><td>".$row["named"]."</td><td>".$row["sumd"]."</td><td>".$row["datastart"]."</td><td>".$row["datafinish"]."</td><td>".$row["avans"]."</td></tr>";
	}
?>