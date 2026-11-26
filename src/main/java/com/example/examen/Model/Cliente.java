package com.example.examen.Model;

public class Cliente {
    private int rut;
    private String dv;
    private String nombre;
    private String apellido;
    private int telefono;

    public Cliente(int rut, String dv, String nombre, String apellido, int telefono) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getRut() {return rut;}

    public String getDv() {return dv;}

    public String getApellido() {return apellido;}

    public String getNombre() {return nombre;}

    public int getTelefono() {return telefono;}
}
