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
				<form action="" method="GET">
					<p class="indent">Select the firm name you want to delete:
					<select name="firm">
						<?php
							include "../scripts/connect_mysqli.php";
							include "../scripts/firmnames.php";
							while($row = $res->fetch_assoc()){
								echo '<option value="'.$row["id_firm"].'">'.$row["name"].'</option>';
							}
						?>
					</select>
					<p class="indent"><input type="submit" class="submit" name="submit" value="Delete"></p>
				</form>
				<?php
					if($_GET['submit']){
						$id_firm = $_GET['firm'];
						include "../scripts/connect_mysqli.php";
						include "../scripts/deletefirm.php";						
					}
				?>
			</div>
		</div>
	</body>
</html>	
