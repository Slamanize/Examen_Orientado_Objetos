package com.example.examen.Model;

public class Consola extends EquipoGaming {
    private int generacion;
    private int almacenamiento;

    public Consola(String marca, String modelo, int anioAdquisicion, int horasUso, int generacion, int almacenamiento) {
        super(marca, modelo, anioAdquisicion, horasUso);
        this.generacion = generacion;
        this.almacenamiento = almacenamiento;
    }

    public int getGeneracion() {return generacion;}
    public int getAlmacenamiento() {return almacenamiento;}
}
