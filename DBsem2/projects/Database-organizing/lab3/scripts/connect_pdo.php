<?php
	$service = 'mysql:host=localhost; dbname=firmadogovor;';
	$user = 'root';
	$password = '';
	$options = array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION);
	
	try {
		$db = new PDO($service, $user, $password, $options);
	} catch (PDOException $e){
		echo "Error during connecting to database";
	}
?>