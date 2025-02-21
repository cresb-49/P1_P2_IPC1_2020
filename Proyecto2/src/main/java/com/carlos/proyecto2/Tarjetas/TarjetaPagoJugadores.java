package com.carlos.proyecto2.Tarjetas;

public class TarjetaPagoJugadores extends Tarjetas {

    /**
     *
     */
    private static final long serialVersionUID = -7816802973917635058L;
    
    private float pagoJugadores;

    public TarjetaPagoJugadores(String grupoTomaTarjeta,String descripcionTarjeta,float pagoJugadores){
        super(grupoTomaTarjeta, descripcionTarjeta);
        this.pagoJugadores=pagoJugadores;
    }
    /**
     * ASIGNAR CANTIDAD DE DINERO A PAGAR A JUGADORES
     * @param pagoJugadores DINERO A PAGAR
     */
    public void setPagoJugadores(float pagoJugadores) {
        this.pagoJugadores = pagoJugadores;
    }
    /**
     * ASIGNAR CANTIDAD DE DINERO A PAGAR A JUGADORES
     * @return DINERO A PAGAR
     */
    public float getPagoJugadores() {
        return pagoJugadores;
    }
}