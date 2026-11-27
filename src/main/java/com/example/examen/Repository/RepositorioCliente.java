package com.example.examen.Repository;

import com.example.examen.Conexion.ConexionBD;
import com.example.examen.Model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositorioCliente {

    public boolean insertar(Cliente clientes) throws SQLException {
        String sql = "INSERT INTO clientes (rut, nombre, apellido, telefono) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, clientes.getRut());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getApellido());
            ps.setInt(4, clientes.getTelefono());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(Cliente clientes) throws SQLException {
        String sql = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ? WHERE rut = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, clientes.getNombre());
            ps.setString(2, clientes.getApellido());
            ps.setInt(3, clientes.getTelefono());
            ps.setString(4, clientes.getRut());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(Cliente clientes) throws SQLException {
        String sql = "DELETE FROM clientes WHERE rut = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, clientes.getRut());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}