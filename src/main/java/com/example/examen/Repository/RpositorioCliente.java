package com.example.examen.Repository;

import com.example.examen.Conexion.ConexionBD;
import com.example.examen.Model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RpositorioCliente {

    public boolean insertar(Cliente clientes) throws SQLException {
        String sql = "INSERT INTO clientes (rut, nombre, telefono, apellido) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, clientes.getRut());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getApellido());
            ps.setInt(4, clientes.getTelefono());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean actualizar(Cliente clientes) throws SQLException {
        String sql = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ? WHERE rut = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, clientes.getRut());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getApellido());
            ps.setInt(4, clientes.getTelefono());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(Cliente clientes) throws SQLException {
        String sql = "DELETE FROM clientes WHERE rut = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, clientes.getRut());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


