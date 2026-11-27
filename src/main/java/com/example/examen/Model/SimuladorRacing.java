package com.example.examen.Model;

public class SimuladorRacing extends EquipoGaming {
    private boolean tipoVolante;
    private int cantidadPedales;
    private String tipo = "SimuladorRacing";

    public SimuladorRacing(String uid, String marca, int modelo, int anioAdquisicion, String horasUso, boolean id, int tipoVolante, String cantidadPedales) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, id);
        this.tipoVolante = tipoVolante;
        this.cantidadPedales = cantidadPedales;
    }

    public boolean isTipoVolante() {return tipoVolante;}
    public int getCantidadPedales() {return cantidadPedales;}

}
