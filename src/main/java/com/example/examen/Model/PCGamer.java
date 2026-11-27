package com.example.examen.Model;

public class PCGamer extends EquipoGaming{
    private int memoriaRam;
    private boolean tieneGPU;
    private String tipo = "PcGamer";

    public PCGamer(String uid, String marca, String modelo, int anioAdquisicion, int horasUso, String tipo, int memoriaRam, boolean tieneGPU) {
        super(uid, marca, modelo, anioAdquisicion, horasUso, tipo);
        this.memoriaRam = memoriaRam;
        this.tieneGPU = tieneGPU;
    }

    public int getMemoriaRam() {return memoriaRam;}
    public boolean isTieneGPU() {return tieneGPU;}

    public String getTipo() {
        return tipo;
    }
}
