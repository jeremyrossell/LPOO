package dev.jeremyrossell.practica11;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EnviaDatos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // configurar tipo de respuesta
        resp.setContentType("text/html;charset=UTF-8");

        // obtener los datos del formulario
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");

        // imprimir respuesta en el navegador
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Datos Recibidos</title></head>");
            out.println("<body>");
            out.println("<h1>¡Datos recibidos con éxito!</h1>");
            out.println("<p><strong>Nombre:</strong> " + nombre + "</p>");
            out.println("<p><strong>Apellido:</strong> " + apellido + "</p>");
            out.println("<p><strong>Email:</strong> " + email + "</p>");
            out.println("<p><strong>Teléfono:</strong> " + telefono + "</p>");
            out.println("<a href='index.jsp'>Volver</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}