package com.example.examen.Model;

public class SimuladorRacing extends EquipoGaming {
    private boolean tipoVolante;
    private int cantidadPedales;
    private String tipo = "SimuladorRacing";

    public SimuladorRacing(String uid, String marca, String modelo, int anioAdquisicion, int horasUso, int id, boolean tipoVolante, int cantidadPedales) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, id);
        this.tipoVolante = tipoVolante;
        this.cantidadPedales = cantidadPedales;
    }

    public boolean isTipoVolante() {return tipoVolante;}
    public int getCantidadPedales() {return cantidadPedales;}

}
