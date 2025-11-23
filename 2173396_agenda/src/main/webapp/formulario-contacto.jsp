<%@ page import="dev.jeremyrossell.agenda.model.Contacto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Contacto</title>
</head>
<body>
<div align="center">
    <%
        Contacto contacto = (Contacto) request.getAttribute("contacto");
    %>
    <h1>
        <%= (contacto != null) ? "Editar Contacto" : "Nuevo Contacto" %>
    </h1>

    <form action="<%= (contacto != null) ? "actualizar" : "insertar" %>" method="post">

        <% if(contacto != null) { %>
        <input type="hidden" name="id" value="<%= contacto.getId() %>" />
        <% } %>

        <table border="1" cellpadding="5">
            <tr>
                <th>Nombre:</th>
                <td><input type="text" name="nombre" size="45" value="<%= (contacto != null) ? contacto.getNombre() : "" %>" required/></td>
            </tr>
            <tr>
                <th>Apellido Paterno:</th>
                <td><input type="text" name="apellidoPaterno" size="45" value="<%= (contacto != null) ? contacto.getApellidoPaterno() : "" %>" required/></td>
            </tr>
            <tr>
                <th>Apellido Materno:</th>
                <td><input type="text" name="apellidoMaterno" size="45" value="<%= (contacto != null) ? contacto.getApellidoMaterno() : "" %>" required/></td>
            </tr>
            <tr>
                <th>Sexo:</th>
                <td>
                    <select name="sexo">
                        <option value="M" <%= (contacto != null && "M".equals(contacto.getSexo())) ? "selected" : "" %>>Masculino</option>
                        <option value="F" <%= (contacto != null && "F".equals(contacto.getSexo())) ? "selected" : "" %>>Femenino</option>
                        <option value="O" <%= (contacto != null && "O".equals(contacto.getSexo())) ? "selected" : "" %>>Otro</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Teléfono:</th>
                <td><input type="text" name="telefono" size="15" value="<%= (contacto != null) ? contacto.getTelefono() : "" %>" required/></td>
            </tr>
            <tr>
                <th>Dirección:</th>
                <td><input type="text" name="direccion" size="45" value="<%= (contacto != null) ? contacto.getDireccion() : "" %>" required/></td>
            </tr>
            <tr>
                <th>Tipo Contacto:</th>
                <td>
                    <select name="tipoContacto">
                        <option value="CASA" <%= (contacto != null && "CASA".equals(contacto.getTipoContacto())) ? "selected" : "" %>>Casa</option>
                        <option value="TRABAJO" <%= (contacto != null && "TRABAJO".equals(contacto.getTipoContacto())) ? "selected" : "" %>>Trabajo</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Guardar" />
                </td>
            </tr>
        </table>
    </form>
    <h3><a href="list">Volver a la Lista</a></h3>
</div>
</body>
</html>