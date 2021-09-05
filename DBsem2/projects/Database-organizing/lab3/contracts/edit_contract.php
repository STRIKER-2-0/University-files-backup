<html>
	<head>
		<link href="../styles/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<header>
				<h1 class="title">Firm-contract Database</h1>
		</header>
		<div class="wrapper">
			<div class="left">
				<p><a href="../index.html">Main page</a></p>
				<p><a href="../firms/firms.html">Firms</a></p>
				<p><a href="contracts.html">Contracts</a></p>
			</div>
			<div class="center">			
				<a href="contracts.html" class="button">&#171;Back</a>				
				<form action="" method="GET">
					<p class="indent">Select the firm name you want to edit contract:
					<select name="firm">
						<?php
							include "../scripts/connect_mysqli.php";
							include "../scripts/firmnames.php";
							while($row = $res->fetch_assoc()){
								echo '<option value="'.$row["id_firm"].'">'.$row["name"].'</option>';
							}
						?>
					</select>
					<input type="submit" class="submit" name="accept" value="Accept firm">
					</p>
				</form>					
				<?php
					if($_GET['accept']){										
						echo '<form action="" method="GET">';
						echo '<p class="indent">Select the contract you want to edit:';
						echo '<select name="contract">';
						include "../scripts/connect_pdo.php";
						$id_firm = $_GET['firm'];
						try {
							$stmt = $db->query("SELECT id_d, numberd, named FROM dogovor WHERE id_firm = '$id_firm'");
						} catch (PDOException $e){
							echo "Error during finding this firm's contracts";
						}
						while($row = $stmt->fetch()){
							echo '<option value="'.$row["id_d"].'">'.$row['numberd'].', '.$row["named"].'</option>';
						}
						echo '</select></p>';							
						echo '<p class="indent">New contract number: <input type="text" name="number"></p>';
						echo '<p class="indent">New contract name: <input type="text" name="name"></p>';
						echo '<p class="indent">New contract sum: <input type="text" name="sum"></p>';
						echo '<p class="indent">New contract date start: <input type="date" name="date_start"></p>';
						echo '<p class="indent">New contract date finish: <input type="date" name="date_finish"></p>';
						echo '<p class="indent">New contract prepayment: <input type="text" name="avans"></p>';
						echo '<p class="indent"><input type="submit" class="submit" name="submit" value="Edit"></p>';
					}
					if($_GET['submit']){
						$id_d = $_GET['contract'];
						$number = $_GET['number'];
						$name = $_GET['name'];
						$sum = $_GET['sum'];
						$date_start = $_GET['date_start'];
						$date_finish = $_GET['date_finish'];
						$avans = $_GET['avans'];
						
						if($number == '' && $name == '' && $sum == '' && $date_start == '' && $date_finish == '' && $avans == ''){
							echo '<p class="indent">All fields are blank.</p>';
							exit;
						}
						if($date_start != '' && $date_finish != ''){
							if(strcmp((string)$date_start, (string)$date_finish) == 1){
								echo '<p class="indent">Date start bigger than date finish</p>';
								exit;
							}
						}
						if(strcmp($avans, $sum) == 1){
							echo '<p class="indent">Prepayment bigger than sum</p>';
							exit;
						}
						else {							
							include "../scripts/connect_pdo.php";
							include "../scripts/editcontract.php";
						}	
					}
				?>
			</div>
		</div>
	</body>
</html>	
