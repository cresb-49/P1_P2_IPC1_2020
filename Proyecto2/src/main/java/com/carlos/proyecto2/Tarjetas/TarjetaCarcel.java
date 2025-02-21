package com.carlos.proyecto2.Tarjetas;

public class TarjetaCarcel extends Tarjetas{
    
    /**
     *
     */
    private static final long serialVersionUID = -3030269587302850923L;
    
    private boolean estadoCarcel;

    public TarjetaCarcel(String grupoTomaTarjeta, String descripcionTarjeta){
        super(grupoTomaTarjeta, descripcionTarjeta);
        this.estadoCarcel=true;
    }

    /**
     * ESTADO DE CARCEL DEL JUGADOR
     * @return Estado De Carcel para el jugador
     */
    public boolean getEstadoCarcel(){
        return this.estadoCarcel;
    }

}