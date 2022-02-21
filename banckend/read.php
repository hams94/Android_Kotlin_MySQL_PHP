<?php 
require_once("connect.php");

$ps = $db->query("SELECT * FROM matieres");
$response = array();
while($data = $ps->fetch(PDO::FETCH_ASSOC)){
    $response[]=$data;
}

echo "coucou";