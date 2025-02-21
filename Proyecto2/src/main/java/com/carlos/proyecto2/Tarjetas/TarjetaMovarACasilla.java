package com.carlos.proyecto2.Tarjetas;

public class TarjetaMovarACasilla extends Tarjetas{

    /**
     *
     */
    private static final long serialVersionUID = 4465321927273382180L;
    
    private String nombreCasillaMover;
    public TarjetaMovarACasilla(String grupoTomaTarjeta, String descripcionTarjeta, String nombreCasillaMover){
        super(grupoTomaTarjeta, descripcionTarjeta);
        this.nombreCasillaMover=nombreCasillaMover;
    }
    /**
     * ASIGNAR NOMBRE A CASILLA A MOVER
     * @param casillaAMover NOMBRE DE CASILLA
     */
    public void setCasillaAMover(String casillaAMover) {
        this.nombreCasillaMover = casillaAMover;
    }
    /**
     * RETORNAR NOMBRE DE CASILLA A MOVER
     * @return NOMBRE DE CASILLA
     */
    public String getCasillaAMover() {
        return nombreCasillaMover;
    }
}