<?php 
require_once('connect.php');

if(isset($_POST)){

    extract($_POST);

    $ps = $db->prepare('INSERT INTO matieres VALUES(null,?,?,"kotlin.jpg",0)');
    $ps->execute(array($nom,$departement));

    if($ps->rowCount()>0){
        echo "insertion effectué avec succès";
    }else{
        echo "Problème d'insertion";
    }


}