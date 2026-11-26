package com.example.examen.Model;

public class SimuladorRacing extends EquipoGaming {
    private boolean tipoVolante;
    private int cantidadPedales;

    public SimuladorRacing(String marca, String modelo, int anioAdquisicion, int horasUso, boolean tipoVolante, int cantidadPedales) {
        super(marca, modelo, anioAdquisicion, horasUso);
        this.tipoVolante = tipoVolante;
        this.cantidadPedales = cantidadPedales;
    }

    public boolean isTipoVolante() {return tipoVolante;}
    public int getCantidadPedales() {return cantidadPedales;}
}
