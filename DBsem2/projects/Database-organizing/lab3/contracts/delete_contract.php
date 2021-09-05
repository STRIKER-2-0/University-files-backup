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
					<p class="indent">Select the firm name you want to delete contract:
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
						echo '<p class="indent">Select the contract you want to delete:';
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
						echo '</select>';
						echo '<input type="submit" class="submit" name="submit" value="Delete"></p>';
					}
					if($_GET['submit']){
						$id_d = $_GET['contract'];											
						include "../scripts/connect_pdo.php";
						include "../scripts/deletecontract.php";
							
					}
				?>
			</div>
		</div>
	</body>
</html>	
