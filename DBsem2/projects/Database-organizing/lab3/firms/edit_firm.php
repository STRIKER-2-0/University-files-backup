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
				<p><a href="firms.html">Firms</a></p>
				<p><a href="../contracts/contracts.php">Contracts</a></p>
			</div>
			<div class="center">			
				<a href="firms.html" class="button">&#171;Back</a>				
				<form action="" method="GET">
					<p class="indent">Select the firm name which data you want to edit:
					<select name="oldname">
						<?php
							include "../scripts/connect_mysqli.php";
							include "../scripts/firmnames.php";
							while($row = $res->fetch_assoc()){
								echo '<option value="'.$row["id_firm"].'">'.$row["name"].'</option>';
							}
						?>
					</select>
					</p>
					<p class="indent">New firm name: <input type="text" name="name"></p>
					<p class="indent">New firm lider: <input type="text" name="shef"></p>
					<p class="indent">New firm address: <input type="text" name="address"></p>
					<p class="indent"><input type="submit" class="submit" name="submit" value="Edit"></p>
				</form>
				<?php
					if($_GET['submit']){
						$old_id = $_GET['oldname'];
						$name = $_GET['name'];
						$shef = $_GET['shef'];
						$address = $_GET['address'];
						if($name == '' && $shef == '' && $address == ''){						
							echo '<p class="indent">All fields are blank.</p>';
							exit;
						}
						else {
							include "../scripts/connect_mysqli.php";
							include "../scripts/editfirm.php";
						}
					}
				?>
			</div>
		</div>
	</body>
</html>	
