package com.example.examen.Model;

public class Consola extends EquipoGaming {
    private int generacion;
    private int almacenamiento;

    public Consola(String uid, String marca, String modelo, int anioAdquisicion, int horasUso, String tipo, int generacion, int almacenamiento) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, tipo);
        this.generacion = generacion;
        this.almacenamiento = almacenamiento;
        setTipo("Consola");
    }

    public int getGeneracion() {return generacion;}
    public int getAlmacenamiento() {return almacenamiento;}

}
