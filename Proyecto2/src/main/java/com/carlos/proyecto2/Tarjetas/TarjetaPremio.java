package com.carlos.proyecto2.Tarjetas;

public class TarjetaPremio extends Tarjetas {

    /**
     *
     */
    private static final long serialVersionUID = -3614788091170593997L;
    
    private float dineroRecibir;
    public TarjetaPremio(String grupoTomaTarjeta, String descripcionTarjeta, float dineroRecibir){
        super(grupoTomaTarjeta, descripcionTarjeta);
        this.dineroRecibir=dineroRecibir;
    }
    /**
     * ASIGNAR DINERO A RECIBIR
     * @param dineroRecibir DINERO A RECIBIR
     */
    public void setDineroRecibir(float dineroRecibir) {
        this.dineroRecibir = dineroRecibir;
    }
    /**
     * RETORNAR CANTIDAD DE DINERO A RECIBIR
     * @return DINERO A RECIBIR
     */
    public float getDineroRecibir() {
        return dineroRecibir;
    }
}