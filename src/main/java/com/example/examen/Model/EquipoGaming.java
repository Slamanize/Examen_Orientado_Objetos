package com.example.examen.Model;

public abstract class EquipoGaming {
    private String marca;
    private String modelo;
    private int anioAdquisicion;
    private int horasUso;

    public EquipoGaming(String marca, String modelo, int anioAdquisicion, int horasUso) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioAdquisicion = anioAdquisicion;
        this.horasUso = horasUso;
    }

    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public int getAnioAdquisicion() {return anioAdquisicion;}
    public int getHorasUso() {return horasUso;}
}
