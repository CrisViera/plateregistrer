<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../estilos/estilos.css">
    <title>Operario</title>
</head>
<body>

<div class="login">

    <!-- LOGO DE LA EMPRESA -->

    <div class="img_logo" id="img_logo">

        <img src="../img/logo.png" alt="logo" class="logo" id="logo">

    </div>

    <!-- ELECCION DE JORNADA O PRODUCCION -->

    <div class="usuario" id="usuario">

        <div class="boton_jornadaproduccion">

            <div>

                <input type="checkbox" class="boton_usuario" id="jornada">
                
                <label for="jornada"><p>Registro de jornada</p></label>

            </div>

            <div>

                <input type="checkbox" class="boton_usuario" id="produccion">

                <label for="produccion">Registro de producción</label>

            </div>

        </div>

    </div>

    <?php include "modeloproduccion.php"; ?>

    <!-- FORMULARIO DE REGISTRO DE JORNADA -->

    <div class="registro_jornada" id="reg_jornada">

        <form class="login" id="form_jornada" method="post">

            <label for="dni" class="datos_label">DNI del operario</label>

                <input type="text" name="dni" id="" class="dni">

            <label for="fecha" class="datos_label">Fecha</label>

                <input type="date" class="jor_fecha">

            <label for="hora" class="datos_label">Hora de entrada</label>

                <input type="time" min="07:00" class="jor_horaentrada">

            <label for="hora" class="datos_label">Hora de salida</label>

                <input type="time" min="07:00" class="jor_horasalida">

            <input type="submit" value="Registrar jornada" class="registrarJornada">

        </form>
    </div>
    
    <!-- FORMULARIO DE INICIO DE SESION PARA REGISTRO DE PRODUCCION -->

    <div class="formulario_inicio" id="login_produccion">

        <form class="login" id="form_login" method="post" th:action="@{/inicioSesion}">

            <label for="dni" class="datos_label">DNI del operario</label>

                <input type="text" name="dni" id="" class="dni">

            <input type="submit" value="Ingresar a producción" class="registrarProduccion">
            <p class="error" th:if="${error}" th:text="${error}"></p>
        </form>

    </div>

    <div class="atras" id="atras">
        <p>Volver</p>
    </div>

</div>

<script src="../js/efectosInicio.js"></script>

</body>
</html>