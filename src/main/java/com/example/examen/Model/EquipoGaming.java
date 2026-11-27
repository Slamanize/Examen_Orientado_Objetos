package com.example.examen.Model;

import java.rmi.server.UID;

public abstract class EquipoGaming {
    private String uid;
    private String marca;
    private String modelo;
    private int anioAdquisicion;
    private int horasUso;
    private String tipo;


    public EquipoGaming(String uid, String marca, String modelo, int anioAdquisicion, int horasUso, String tipo) {
        this.uid = uid;
        this.marca = marca;
        this.modelo = modelo;
        this.anioAdquisicion = anioAdquisicion;
        this.horasUso = horasUso;
        this.tipo = tipo;
    }

    public String getUid() {return uid;}
    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public int getAnioAdquisicion() {return anioAdquisicion;}
    public int getHorasUso() {return horasUso;}
    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
