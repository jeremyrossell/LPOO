<%@ page import="java.util.List" %>
<%@ page import="dev.jeremyrossell.agenda.model.Contacto" %> <%-- Import actualizado --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agenda de Contactos</title>
</head>
<body>
<div align="center">
    <h1>Gestión de Contactos</h1>
    <h2><a href="nuevo">Agregar Nuevo Contacto</a></h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>A. Paterno</th>
            <th>A. Materno</th>
            <th>Sexo</th>
            <th>Teléfono</th>
            <th>Dirección</th>
            <th>Tipo</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Contacto> lista = (List<Contacto>) request.getAttribute("listaContactos");
            if (lista != null) {
                for (Contacto c : lista) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNombre() %></td>
            <td><%= c.getApellidoPaterno() %></td>
            <td><%= c.getApellidoMaterno() %></td>
            <td><%= c.getSexo() %></td>
            <td><%= c.getTelefono() %></td>
            <td><%= c.getDireccion() %></td>
            <td><%= c.getTipoContacto() %></td>
            <td>
                <a href="editar?id=<%= c.getId() %>">Editar</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="eliminar?id=<%= c.getId() %>">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>