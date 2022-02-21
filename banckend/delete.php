<?php 
require_once("connect.php");

$id = $_GET['id'];
$ps = $db->query("DELETE FROM matieres WHERE id = $id");

if($ps->rowCount()>0){
    echo "Suppression effectué avec succès";
}else{
    echo "Problème de suppression!";
}


