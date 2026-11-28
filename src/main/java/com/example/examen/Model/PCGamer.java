package com.example.examen.Model;

public class PCGamer extends EquipoGaming{
    private int memoriaRam;
    private boolean tieneGPU;
    private String tipo = "PcGamer";

    public PCGamer( String marca, String modelo, int anioAdquisicion, int horasUso, String tipo, int memoriaRam, boolean tieneGPU) {
        super(marca, modelo, anioAdquisicion, horasUso, tipo);
        this.memoriaRam = memoriaRam;
        this.tieneGPU = tieneGPU;
        setTipo("PcGamer");
    }

    public int getMemoriaRam() {return memoriaRam;}
    public boolean isTieneGPU() {return tieneGPU;}

    @Override
    public String getTipo() {
        return super.getTipo();
    }
}
