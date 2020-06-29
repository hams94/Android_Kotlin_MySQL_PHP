<?php 
require_once('connect.php');

if(isset($_POST)){

    extract($_POST);

    $ps = $db->prepare('UPDATE  matieres SET nom=?, departement = ? WHERE id = ?');
    $ps->execute(array($nom,$departement,$id));

    if($ps->rowCount()>0){
        echo "Modification effectuée avec succès";
    }else{
        echo "Problème de modification";
    }


}