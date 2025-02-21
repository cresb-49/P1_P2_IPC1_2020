package com.carlos.proyecto2.Casillas;
public class CasillaTomaTarjeta extends Casillas{
    /**
     *
     */
    private static final long serialVersionUID = -6811201713876894988L;
    
    private String grupoDeTarjeta;
    /**
     * Cosntructor casilla tomar tarjeta
     * @param nombreCasilla nombre del casilla 
     * @param grupoDeTrajeta    tipo de tarjeta que contiene
     */
    public CasillaTomaTarjeta(String nombreCasilla,String grupoDeTrajeta){
        super(nombreCasilla, "tomaTarjeta");
        this.grupoDeTarjeta=grupoDeTrajeta;
    }
    /**
     * Asignar tipo de tarjeta que contiene la casilla
     * @param grupoDeTarjeta tipo de tarjeta contenedora
     */
    public void setGrupoDeTarjeta(String grupoDeTarjeta) {
        this.grupoDeTarjeta = grupoDeTarjeta;
    }
    /**
     * Retorno del tipo de tarejta que contiene
     * @return tipo de atrjeta contenedora
     */
    public String getGrupoDeTarjeta() {
        return grupoDeTarjeta;
    }
}