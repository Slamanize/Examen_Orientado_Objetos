package com.example.examen.Model;

public class Consola extends EquipoGaming {
    private int generacion;
    private int almacenamiento;
    private String tipo = "Consola";

    public Consola(String uid, String marca, int modelo, int anioAdquisicion, String horasUso, int id, int generacion, String almacenamiento) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, id);
        this.generacion = generacion;
        this.almacenamiento = almacenamiento;
    }

    public int getGeneracion() {return generacion;}
    public int getAlmacenamiento() {return almacenamiento;}

}
