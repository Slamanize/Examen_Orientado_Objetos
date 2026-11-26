package com.example.examen.Model;

public class PCGamer extends EquipoGaming{
    private int memoriaRam;
    private boolean tieneGPU;
    private String tipo = "PcGamer";

    public PCGamer(String marca, String modelo, int anioAdquisicion, int horasUso, int memoriaRam, boolean tieneGPU) {
        super(marca, modelo, anioAdquisicion, horasUso);
        this.memoriaRam = memoriaRam;
        this.tieneGPU = tieneGPU;
    }

    public int getMemoriaRam() {return memoriaRam;}
    public boolean isTieneGPU() {return tieneGPU;}
}
