package com.carlos.proyecto2.Tarjetas;

public class TarjetaMulta extends Tarjetas{

    /**
     *
     */
    private static final long serialVersionUID = 3243817765476145148L;
    
    private float dineroAExtraer;

    public TarjetaMulta(String grupoTomaTarjeta, String descripcionTarjeta, float dineroAExtraer){
        super(grupoTomaTarjeta, descripcionTarjeta);
        this.dineroAExtraer=dineroAExtraer;
    }
    /**
     * ASIGNAR CANTIDAD DE DINERO A PAGAR
     * @param dineroAExtraer DINERO A PAGAR
     */
    public void setDineroAExtraer(float dineroAExtraer) {
        this.dineroAExtraer = dineroAExtraer;
    }
    /**
     * RETORNAR CANTIDAD DE DINERO A PAGAR
     * @return DINERO A PAGAR
     */
    public float getDineroAExtraer() {
        return dineroAExtraer;
    }
}