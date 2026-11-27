package com.example.examen.Repository;

import com.example.examen.Conexion.ConexionBD;
import com.example.examen.Model.EquipoGaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Repositorio {


    public boolean insertar(EquipoGaming equipoGaming) throws SQLException {
        String sql = "INSERT INTO EquipoGaming (marca, modelo, anioAdquisicion, horasUso) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, equipoGaming.getMarca());
            ps.setString(2, equipoGaming.getModelo());
            ps.setInt(3, equipoGaming.getAnioAdquisicion());
            ps.setInt(4, equipoGaming.getHorasUso());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean actualizar(EquipoGaming equipoGaming) throws SQLException {
        String sql = "UPDATE equipoGaming SET marca= ?, modelo = ?, anioAdquisicion = ?, horaUso = ? WHERE uid = ? ";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, equipoGaming.getMarca());
            ps.setString(2, equipoGaming.getModelo());
            ps.setInt(3, equipoGaming.getAnioAdquisicion());
            ps.setInt(4, equipoGaming.getHorasUso());
            ps.setString(5, equipoGaming.getUid());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
