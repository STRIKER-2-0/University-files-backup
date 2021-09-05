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
					<p class="indent">Select the firm name you want to add contract:
					<select name="firm">
						<?php
							include "../scripts/connect_mysqli.php";
							include "../scripts/firmnames.php";
							while($row = $res->fetch_assoc()){
								echo '<option value="'.$row["id_firm"].'">'.$row["name"].'</option>';
							}
						?>
					</select>
					</p>
					<p class="indent">New contract number: <input type="text" name="number"></p>
					<p class="indent">New contract name: <input type="text" name="name"></p>
					<p class="indent">New contract sum: <input type="text" name="sum"></p>
					<p class="indent">New contract date start: <input type="date" name="date_start"></p>
					<p class="indent">New contract date finish: <input type="date" name="date_finish"></p>
					<p class="indent">New contract prepayment: <input type="text" name="avans"></p>
					<p class="indent"><input type="submit" class="submit" name="submit" value="Add"></p>
				</form>
				<?php
					if($_GET['submit']){
						$id_firm = $_GET['firm'];
						$number = $_GET['number'];
						$name = $_GET['name'];
						$sum = $_GET['sum'];
						$date_start = $_GET['date_start'];
						$date_finish = $_GET['date_finish'];
						$avans = $_GET['avans'];
						if($number == '' || $name == '' || $sum == '' || $date_start == '' || $date_finish == '' || $avans == ''){
							echo '<p class="indent">Not all fields are filled.</p>';
							exit;
						}
						if(strcmp((string)$date_start, (string)$date_finish) == 1){
							echo '<p class="indent">Date start bigger than date finish</p>';
							exit;
						}
						if(strcmp($avans, $sum) == 1){
							echo '<p class="indent">Prepayment bigger than sum</p>';
							exit;
						}
						else {							
							include "../scripts/connect_pdo.php";
							include "../scripts/addcontract.php";
						}						
					}
				?>
			</div>
		</div>
	</body>
</html>	
