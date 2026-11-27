package com.example.examen.Model;

public class Consola extends EquipoGaming {
    private int generacion;
    private int almacenamiento;
    private String tipo = "Consola";

    public Consola(String marca, String modelo, int anioAdquisicion, int horasUso, String uid, int generacion, int almacenamiento, String tipo) {
        super(marca, modelo, anioAdquisicion, horasUso, uid);
        this.generacion = generacion;
        this.almacenamiento = almacenamiento;
        this.tipo = tipo;
    }

    public int getGeneracion() {return generacion;}
    public int getAlmacenamiento() {return almacenamiento;}

}
