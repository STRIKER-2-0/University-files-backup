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
				<p class="indent">Complete firms table: </p>
				<table>
					<?php
						include "../scripts/connect_mysqli.php";
						$letters = '';
						include "../scripts/printfirms.php";
					?>
				</table>
			</div>
		</div>
	</body>
</html>	
