package dev.jeremyrossell.agenda.controller;

import dev.jeremyrossell.agenda.dao.ContactoDAO;
import dev.jeremyrossell.agenda.model.Contacto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ContactoServlet extends HttpServlet {
    private ContactoDAO contactoDAO;

    public void init() {
        contactoDAO = new ContactoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action == null) action = "/";

        switch (action) {
            case "/insertar":
                insertarContacto(request, response);
                break;
            case "/actualizar":
                actualizarContacto(request, response);
                break;
            default:
                listarContactos(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action == null) action = "/";

        try {
            switch (action) {
                case "/nuevo":
                    mostrarFormularioNuevo(request, response);
                    break;
                case "/editar":
                    mostrarFormularioEditar(request, response);
                    break;
                case "/eliminar":
                    eliminarContacto(request, response);
                    break;
                default:
                    listarContactos(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listarContactos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contacto> listaContactos = contactoDAO.seleccionarTodos();
        request.setAttribute("listaContactos", listaContactos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("lista-contactos.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("formulario-contacto.jsp");
        dispatcher.forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contacto contactoExistente = contactoDAO.seleccionarPorId(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("formulario-contacto.jsp");
        request.setAttribute("contacto", contactoExistente);
        dispatcher.forward(request, response);
    }

    private void insertarContacto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String sexo = request.getParameter("sexo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String tipoContacto = request.getParameter("tipoContacto");

        Contacto nuevoContacto = new Contacto(nombre, apellidoPaterno, apellidoMaterno, sexo, telefono, direccion, tipoContacto);
        contactoDAO.insertarContacto(nuevoContacto);
        response.sendRedirect("list");
    }

    private void actualizarContacto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String sexo = request.getParameter("sexo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String tipoContacto = request.getParameter("tipoContacto");

        Contacto contacto = new Contacto(id, nombre, apellidoPaterno, apellidoMaterno, sexo, telefono, direccion, tipoContacto);
        contactoDAO.actualizarContacto(contacto);
        response.sendRedirect("list");
    }

    private void eliminarContacto(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        contactoDAO.eliminarContacto(id);
        response.sendRedirect("list");
    }
}