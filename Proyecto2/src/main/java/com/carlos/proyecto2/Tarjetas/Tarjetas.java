package com.carlos.proyecto2.Tarjetas;

import java.io.Serializable;

public class Tarjetas implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -5313792601765579615L;
    
    private String grupoTomaTarjeta;
    private String descripcionTarjeta;
    private Tarjetas siguientTarjeta=null;

    public Tarjetas(String grupoTomaTarjeta, String descripcionTarjeta){

        this.grupoTomaTarjeta=grupoTomaTarjeta;
        this.descripcionTarjeta=descripcionTarjeta;
    }

    /**
     * ASIGNAR GRUPO DE TOMAR TARJETA CUPON/BOLSA
     * @param grupoTomaTarjeta GRUPO DE TOMAR TARJETA
     */
    public void setGrupoTomaTarjeta(String grupoTomaTarjeta) {
        this.grupoTomaTarjeta = grupoTomaTarjeta;
    }
    /**
     * RETORNAR GRUPO DE TOMAR TARJETA CUPON/BOLSA
     * @return GRUPO DE TOMAR TARJETA
     */
    public String getGrupoTomaTarjeta() {
        return grupoTomaTarjeta;
    }

    /**
     * ASIGNAR DESCRIPCION DE LA TARJETA
     * @param descripcionTarjeta DESCRIPCION DE TARJETA
     */
    public void setDescripcionTarjeta(String descripcionTarjeta) {
        this.descripcionTarjeta = descripcionTarjeta;
    }
    /**
     * RETORNAR DESCRIPCION DE LA TARJETA
     * @return DESCRIPCION DE TARJETA
     */
    public String getDescripcionTarjeta() {
        return descripcionTarjeta;
    }

    /**
     * RETORNAR SIGUINETE TARJETA
     * @return SIGUIENTE TARJETA
     */
    public Tarjetas getSiguientTarjeta() {
        return siguientTarjeta;
    }

    /**
     * ASIGNAR SIGUINETE TARJETA
     * @param siguientTarjeta SIGUIENTE TARJETA
     */
    public void setSiguientTarjeta(Tarjetas siguientTarjeta) {
        this.siguientTarjeta = siguientTarjeta;
    }
}