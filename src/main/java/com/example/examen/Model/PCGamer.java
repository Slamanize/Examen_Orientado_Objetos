package com.example.examen.Model;

public class PCGamer extends EquipoGaming{
    private int memoriaRam;
    private boolean tieneGPU;
    private String tipo = "PcGamer";

    public PCGamer(String uid, String marca, int modelo, int anioAdquisicion, String horasUso, int id, boolean tieneGPU, String memoriaRam) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, id);
        this.tieneGPU = tieneGPU;
        this.memoriaRam = memoriaRam;
    }

    public int getMemoriaRam() {return memoriaRam;}
    public boolean isTieneGPU() {return tieneGPU;}
}
