package com.example.examen.Model;

public class PCGamer extends EquipoGaming{
    private int memoriaRam;
    private boolean tieneGPU;
    private String tipo = "PcGamer";

    public PCGamer(String marca, String modelo, int anioAdquisicion, int horasUso, String uid, int memoriaRam, boolean tieneGPU, String tipo) {
        super(marca, modelo, anioAdquisicion, horasUso, uid);
        this.memoriaRam = memoriaRam;
        this.tieneGPU = tieneGPU;
        this.tipo = tipo;
    }

    public int getMemoriaRam() {return memoriaRam;}
    public boolean isTieneGPU() {return tieneGPU;}
}
