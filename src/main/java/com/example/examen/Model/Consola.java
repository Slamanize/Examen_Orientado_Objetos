package com.example.examen.Model;

public class Consola extends EquipoGaming {
    private int generacion;
    private int almacenamiento;
    private String tipo = "Consola";

    public Consola(String uid, String marca, String modelo, int anioAdquisicion, int horasUso, int id, int generacion, int almacenamiento) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, id);
        this.generacion = generacion;
        this.almacenamiento = almacenamiento;
    }

    public int getGeneracion() {return generacion;}
    public int getAlmacenamiento() {return almacenamiento;}

}
