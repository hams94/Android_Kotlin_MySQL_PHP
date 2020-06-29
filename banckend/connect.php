<?php 
try{
    $db = new PDO('mysql:host=localhost;dbname=gandhi','root','');
}catch(Exception $e){
    die("Erreur de connexion à la BD ".$e->getMessage());
}