package com.example.examen.Model;

import java.util.ArrayList;

public class Cliente {
    private String rut; //Sera String por que solo se mostrara
    private String nombre;
    private String apellido;
    private int telefono;
    private ArrayList<Integer> Equipos = new ArrayList<>();

    public Cliente(String rut, String apellido, String nombre, int telefono, ArrayList<Integer> equipos) {
        this.rut = rut;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        Equipos = equipos;
    }

    public String getRut() {return rut;}
    public String getNombre() {return nombre;}
    public int getTelefono() {return telefono;}
    public String getApellido() {return apellido;}

    public ArrayList<Integer> getEquipos() {
        return Equipos;
    }

    public void setEquipos(ArrayList<Integer> equipos) {
        Equipos = equipos;
    }
}
