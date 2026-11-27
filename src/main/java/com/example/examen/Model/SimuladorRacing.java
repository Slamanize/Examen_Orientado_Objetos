package com.example.examen.Model;

public class SimuladorRacing extends EquipoGaming {
    private boolean tipoVolante;
    private int cantidadPedales;
    private String tipo = "SimuladorRacing";

    public SimuladorRacing(String uid, String marca, String modelo, int anioAdquisicion, int horasUso, String tipo, boolean tipoVolante, int cantidadPedales) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, tipo);
        this.tipoVolante = tipoVolante;
        this.cantidadPedales = cantidadPedales;
    }

    public boolean isTipoVolante() {return tipoVolante;}
    public int getCantidadPedales() {return cantidadPedales;}

    public String getTipo() {
        return tipo;
    }
}
