<?php
	$host = 'localhost';
	$database = 'firmadogovor';
	$user = 'root';
	$password = '';
	$port = 3306;
	
	$mysqli = new mysqli($host, $user, $password, $database, $port);
	if ($mysqli->connect_errno){
		echo $mysqli->connect_error;
		exit;
	}
?>