package com.example.examen.Model;

public class PCGamer extends EquipoGaming{
    private int memoriaRam;
    private boolean tieneGPU;
    private String tipo = "PcGamer";

    public PCGamer(String uid, String marca, String modelo, int anioAdquisicion, int horasUso, int id, boolean tieneGPU, int memoriaRam) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, id);
        this.tieneGPU = tieneGPU;
        this.memoriaRam = memoriaRam;
    }

    public int getMemoriaRam() {return memoriaRam;}
    public boolean isTieneGPU() {return tieneGPU;}
}
