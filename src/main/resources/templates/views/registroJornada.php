<?php

    // CONEXION A LA BBDD

    // DECLARACION DE VARIABLES PARA CONEXIÓN 

    $usuario = "root";
    $contrasena = "";
    $servidor = "localhost";
    $database = "recar";

    // CONEXIÓN A LA BASE DE DATOS

    $conexion = mysqli_connect($servidor, $usuario, $contrasena) or die ("Hay un problema con la conexión");

    mysqli_select_db($conexion, $database) or die ("Hay un problema al acceder a la base de datos");

    // DECLARACION DE VARIABLES

    $dni = $_POST["dni"];
    $dni = strtoupper($dni);
    $fechaRegistro = $_POST["fecha"];
    $horaEntrada = $_POST["hora_entrada"];
    $horaSalida = $_POST["hora_salida"];

    // CONSULTA EL REGISTRO ACTUAL DE OPERARIOS

    $consultaOperario = "SELECT * FROM operarios";
    $registrosOperarios = mysqli_query($conexion, $consultaOperario);

    while ($operario = mysqli_fetch_array($registrosOperarios)) {       

        // COMPRUEBA SI EXISTE EL OPERARIO
        if($operario['dni'] == $dni){

            $nombre = $operario['nombre'];

            $registrarJornada = "INSERT INTO registrojornada (nombre, dni, fecha, entrada, salida) VALUES ('$nombre', '$dni', '$fechaRegistro', '$horaEntrada', '$horaSalida')";
            mysqli_query($conexion, $registrarJornada);

        }
    }

?>