package com.example.examen.Model;

public class Cliente {
    private String rut; //Sera String por que solo se mostrara
    private String nombre;
    private int telefono;

    public Cliente(String rut, String nombre, int telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getRut() {return rut;}

    public String getNombre() {return nombre;}

    public int getTelefono() {return telefono;}
}
