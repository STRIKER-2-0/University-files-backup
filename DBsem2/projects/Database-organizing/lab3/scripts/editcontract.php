<?php
	try {
		if($number != ''){				
			$stmt = $db->exec(
				"UPDATE dogovor
				SET numberd='$number'
				WHERE id_d='$id_d';"
			);
		}
		if($name != ''){		
			$stmt = $db->exec(
				"UPDATE dogovor
				SET named='$name'
				WHERE id_d='$id_d';"
			);
		}
		if($sum != ''){		
			$stmt = $db->exec(
				"UPDATE dogovor
				SET sumd='$sum'
				WHERE id_d='$id_d';"
			);
		}
		if($date_start != ''){		
			$stmt = $db->exec(
				"UPDATE dogovor
				SET datastart='$date_start'
				WHERE id_d='$id_d';"
			);
		}
		if($date_finish != ''){		
			$stmt = $db->exec(
				"UPDATE dogovor
				SET datafinish='$date_finish'
				WHERE id_d='$id_d';"
			);
		}
		if($avans != ''){		
			$stmt = $db->exec(
				"UPDATE dogovor
				SET avans='$avans'
				WHERE id_d='$id_d';"
			);
		}		
	} catch (PDOException $e){
		echo "Error during editing this firm's contract: uncorrect value";
	}
	echo '<p class="indent">Data edited successfully</p>';	
?>