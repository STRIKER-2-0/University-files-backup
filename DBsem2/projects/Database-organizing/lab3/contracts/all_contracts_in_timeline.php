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
					<p class="indent">Select the firm name you want to see contracts:
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
					<p class="indent">Timeline start: <input type="date" name="date_start"></p>
					<p class="indent">Timeline finish: <input type="date" name="date_finish"></p>					
					<input type="submit" class="submit" name="submit" value="View">
					</p>
				</form>
				<table>
				<?php
					if($_GET['submit']){
						$id_firm = $_GET['firm'];
						$date_start = $_GET['date_start'];
						$date_finish = $_GET['date_finish'];
						if($id_firm == ''){
							echo '<p class="indent">You didn\'t choose the firm.</p>';
							exit;
						}
						if(strcmp((string)$date_start, (string)$date_finish) == 1){
							echo '<p class="indent">Date start bigger than date finish</p>';
							exit;
						}						
						include "../scripts/connect_pdo.php";
						include "../scripts/printcontractsintimeline.php";				
					}
				?>
				</table>
			</div>
		</div>
	</body>
</html>	
