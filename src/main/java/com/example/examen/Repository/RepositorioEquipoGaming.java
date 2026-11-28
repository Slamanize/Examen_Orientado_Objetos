package com.example.examen.Repository;

import com.example.examen.Conexion.ConexionBD;
import com.example.examen.Model.Consola;
import com.example.examen.Model.EquipoGaming;
import com.example.examen.Model.PCGamer;
import com.example.examen.Model.SimuladorRacing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEquipoGaming {

    public boolean insertar(EquipoGaming equipoGaming, String rutCliente) throws SQLException {
        String sql = "INSERT INTO EquipoGaming (uid, marca, modelo, anioAdquisicion, horasUso, ram, gpu, tipoVolante, cantVolantes, generacion, almacenamiento, rut) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, equipoGaming.getUid());
            ps.setString(2, equipoGaming.getMarca());
            ps.setString(3, equipoGaming.getModelo());
            ps.setInt(4, equipoGaming.getAnioAdquisicion());
            ps.setInt(5, equipoGaming.getHorasUso());

            if (equipoGaming instanceof PCGamer pc) {
                ps.setInt(6, pc.getMemoriaRam());
                ps.setBoolean(7, pc.isTieneGPU());
                ps.setNull(8, Types.BOOLEAN);
                ps.setNull(9, Types.INTEGER);
                ps.setNull(10, Types.INTEGER);
                ps.setNull(11, Types.INTEGER);
            } else if (equipoGaming instanceof Consola c) {
                ps.setNull(6, Types.INTEGER);
                ps.setNull(7, Types.BOOLEAN);
                ps.setNull(8, Types.BOOLEAN);
                ps.setNull(9, Types.INTEGER);
                ps.setInt(10, c.getGeneracion());
                ps.setInt(11, c.getAlmacenamiento());
            } else if (equipoGaming instanceof SimuladorRacing s) {
                ps.setNull(6, Types.INTEGER);
                ps.setNull(7, Types.BOOLEAN);
                ps.setBoolean(8, s.isTipoVolante());
                ps.setInt(9, s.getCantidadPedales());
                ps.setNull(10, Types.INTEGER);
                ps.setNull(11, Types.INTEGER);
            }

            ps.setString(12, rutCliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizar(EquipoGaming equipoGaming) throws SQLException {
        String sql = "UPDATE EquipoGaming SET marca = ?, modelo = ?, anioAdquisicion = ?, horasUso = ?, ram = ?, gpu = ?, tipoVolante = ?, cantVolantes = ?, generacion = ?, almacenamiento = ? WHERE uid = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, equipoGaming.getMarca());
            ps.setString(2, equipoGaming.getModelo());
            ps.setInt(3, equipoGaming.getAnioAdquisicion());
            ps.setInt(4, equipoGaming.getHorasUso());

            if (equipoGaming instanceof PCGamer pc) {
                ps.setInt(5, pc.getMemoriaRam());
                ps.setBoolean(6, pc.isTieneGPU());
                ps.setNull(7, Types.BOOLEAN);
                ps.setNull(8, Types.INTEGER);
                ps.setNull(9, Types.INTEGER);
                ps.setNull(10, Types.INTEGER);
            } else if (equipoGaming instanceof Consola c) {
                ps.setNull(5, Types.INTEGER);
                ps.setNull(6, Types.BOOLEAN);
                ps.setNull(7, Types.BOOLEAN);
                ps.setNull(8, Types.INTEGER);
                ps.setInt(9, c.getGeneracion());
                ps.setInt(10, c.getAlmacenamiento());
            } else if (equipoGaming instanceof SimuladorRacing s) {
                ps.setNull(5, Types.INTEGER);
                ps.setNull(6, Types.BOOLEAN);
                ps.setBoolean(7, s.isTipoVolante());
                ps.setInt(8, s.getCantidadPedales());
                ps.setNull(9, Types.INTEGER);
                ps.setNull(10, Types.INTEGER);
            }

            ps.setInt(11, equipoGaming.getUid());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(EquipoGaming equipoGaming) throws SQLException {
        String sql = "DELETE FROM EquipoGaming WHERE uid = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, equipoGaming.getUid());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<EquipoGaming> cargar()throws SQLException {
        List<EquipoGaming> equipoGamings = new ArrayList<>();
        String sql = "SELECT * FROM equipogaming";
         try(Connection conn = ConexionBD.getConnection();
             Statement ment = conn.createStatement();
             ResultSet res = ment.executeQuery(sql)){

             while (res.next()) {
                 int id = res.getInt("uid");
                 String marca = res.getString("marca");
                 String modelo = res.getString("modelo");
                 int anioAdquisicion = res.getInt("anioAdquisicion");
                 int horasUso = res.getInt("horasUso");
                 String tipo = res.getString("tipo");
                 if(tipo.equals("PCGamer")){
                     int ram = res.getInt("ram");
                     boolean tieneGPU = res.getBoolean("gpu");
                     PCGamer pc = new PCGamer(marca,modelo,anioAdquisicion,horasUso,tipo,ram,tieneGPU);
                     pc.setUid(id);
                     equipoGamings.add(pc);
                 }else if(tipo.equals("Consola")){
                     int gen = res.getInt("generacion");
                     int almacenamiento = res.getInt("almacenamiento");
                     Consola nin = new Consola(marca,modelo,anioAdquisicion,horasUso,tipo,gen,almacenamiento);
                     nin.setUid(id);
                     equipoGamings.add(nin);
                 }else if(tipo.equals("SimuladorRacing")){
                     int cantidadPedales = res.getInt("cantPedales");
                     boolean tipoVolante = res.getBoolean("tipoVolante");
                 }
             }
             return equipoGamings;
         }
    }
}