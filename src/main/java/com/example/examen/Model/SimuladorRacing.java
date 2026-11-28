package com.example.examen.Model;

public class SimuladorRacing extends EquipoGaming {
    private boolean tipoVolante;
    private int cantidadPedales;

    public SimuladorRacing( String marca, String modelo, int anioAdquisicion, int horasUso, String tipo, boolean tipoVolante, int cantidadPedales) {
        super( marca, modelo, anioAdquisicion, horasUso, tipo);
        this.tipoVolante = tipoVolante;
        this.cantidadPedales = cantidadPedales;
        setTipo("SimuladorRacing");
    }

    public boolean isTipoVolante() {return tipoVolante;}
    public int getCantidadPedales() {return cantidadPedales;}

    @Override
    public String getTipo() {
        return super.getTipo();
    }
}
