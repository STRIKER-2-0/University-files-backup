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
				<p><a href="../contracts/contracts.html">Contracts</a></p>
			</div>
			<div class="center">			
				<a href="firms.html" class="button">&#171;Back</a>
				<p class="indent">Enter the new firm data:</p>
				<form action="" method="GET">
					<p class="indent">Firm name: <input type="text" name="name"></p>
					<p class="indent">Firm lider: <input type="text" name="shef"></p>
					<p class="indent">Firm address: <input type="text" name="address"></p>
					<p class="indent"><input type="submit" class="submit" name="submit" value="Add"></p>
				</form>
				<?php
					if($_GET['submit']){
						$name = $_GET['name'];
						$shef = $_GET['shef'];
						$address = $_GET['address'];
						if($name != '' || $shef != '' || $address != ''){
							include "../scripts/connect_mysqli.php";
							include "../scripts/addfirm.php";
						}
						else {
							echo '<p class="indent">Not all fields are filled.</p>';
						}
					}
				?>
			</div>
		</div>
	</body>
</html>	
