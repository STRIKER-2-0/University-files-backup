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
				<p class="indent">Print some first letters of firm name: </p>
				<form action="" method="GET">
					<input type="text" name="letters">
					<input type="submit" class="submit" name="submit" value="Find">
				</form>
				<table>
					<?php
						if($_GET['submit']){
							if($_GET['letters'] != ''){
								include "../scripts/connect_mysqli.php";
								$letters = $_GET['letters'];
								include "../scripts/printfirms.php";
							}
							else {
								echo '<p class="indent">You didn\'t print anything.</p>';
							}
						}
					?>
				</table>
			</div>
		</div>
	</body>
</html>	
