package dev.jeremyrossell.agenda.dao;

import dev.jeremyrossell.agenda.model.Contacto;
import dev.jeremyrossell.agenda.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    private static final String INSERT_SQL = "INSERT INTO contactos (nombre, apellidoPaterno, apellidoMaterno, sexo, telefono, direccion, tipoContacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM contactos";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM contactos WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM contactos WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE contactos SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, sexo = ?, telefono = ?, direccion = ?, tipoContacto = ? WHERE id = ?";

    // 1. insertar
    public void insertarContacto(Contacto contacto) {
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getApellidoPaterno());
            ps.setString(3, contacto.getApellidoMaterno());
            ps.setString(4, contacto.getSexo());
            ps.setString(5, contacto.getTelefono());
            ps.setString(6, contacto.getDireccion());
            ps.setString(7, contacto.getTipoContacto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. seleccionar todos
    public List<Contacto> seleccionarTodos() {
        List<Contacto> contactos = new ArrayList<>();
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                contactos.add(new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("sexo"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("tipoContacto")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }

    // 3. seleccionar por ID (para editar)
    public Contacto seleccionarPorId(int id) {
        Contacto contacto = null;
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contacto = new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getString("sexo"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("tipoContacto")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacto;
    }

    // 4. actualizar
    public boolean actualizarContacto(Contacto contacto) {
        boolean rowUpdated = false;
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getApellidoPaterno());
            ps.setString(3, contacto.getApellidoMaterno());
            ps.setString(4, contacto.getSexo());
            ps.setString(5, contacto.getTelefono());
            ps.setString(6, contacto.getDireccion());
            ps.setString(7, contacto.getTipoContacto());
            ps.setInt(8, contacto.getId());
            rowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // 5. eliminar
    public boolean eliminarContacto(int id) {
        boolean rowDeleted = false;
        try (Connection connection = ConexionDB.getConexion();
             PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}