<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Registro</title>
</head>
<body>
<h1>Registro de Usuario</h1>

<form action="EnviaDatos" method="GET">

    <label for="nombre">Nombre:</label><br>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="apellido">Apellido:</label><br>
    <input type="text" id="apellido" name="apellido" required><br><br>

    <label for="email">E-mail:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="telefono">Teléfono:</label><br>
    <input type="tel" id="telefono" name="telefono"><br><br>

    <input type="submit" value="Enviar Datos">

</form>
</body>
</html>