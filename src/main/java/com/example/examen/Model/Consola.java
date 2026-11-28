package com.example.examen.Model;

public class Consola extends EquipoGaming {
    private int generacion;
    private int almacenamiento;

    public Consola(String marca, String modelo, int anioAdquisicion, int horasUso, String tipo, int generacion, int almacenamiento) {
        super( marca, modelo, anioAdquisicion, horasUso, tipo);
        this.generacion = generacion;
        this.almacenamiento = almacenamiento;
        setTipo("Consola");
    }

    public int getGeneracion() {return generacion;}
    public int getAlmacenamiento() {return almacenamiento;}

    @Override
    public String getTipo() {
        return super.getTipo();
    }
}
