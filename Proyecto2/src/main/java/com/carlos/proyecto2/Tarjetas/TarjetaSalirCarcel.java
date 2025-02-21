package com.carlos.proyecto2.Tarjetas;

public class TarjetaSalirCarcel extends Tarjetas{
    
    /**
     *
     */
    private static final long serialVersionUID = -2551647141743269353L;
    
    private boolean estadoCarcel;
    public TarjetaSalirCarcel(String grupoTomaTarjeta, String descripcionTarjeta){
        super(grupoTomaTarjeta, descripcionTarjeta);
        this.estadoCarcel=false;
    }
    /**
     * RETORNAR ESTADO DE LA CARCEL
     * @return Estado de salir de la clase
     */
    public boolean getEstadoCarcel(){
        return this.estadoCarcel;
    }

}