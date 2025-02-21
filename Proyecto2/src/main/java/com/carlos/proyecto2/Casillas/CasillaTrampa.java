package com.carlos.proyecto2.Casillas;
public class CasillaTrampa extends Casillas {
    /**
     *
     */
    private static final long serialVersionUID = 6458049230616028543L;
    
    private String tipoCasillaTrampa;
    /**
     * Cosntructor casilla trampa
     * @param nombreCasilla nombre de la casilla
     * @param tipoCasillaTrampa tipo de casilla
     */
    public CasillaTrampa(String nombreCasilla,String tipoCasillaTrampa){
        super(nombreCasilla, "trampa");
        this.tipoCasillaTrampa=tipoCasillaTrampa;
    }
    /**
     * Asignacion del tipo de casilla trampa
     * @param tipoCasillaTrampa tipo de casilla trampa
     */
    public void setTipoCasillaTrampa(String tipoCasillaTrampa){
        this.tipoCasillaTrampa = tipoCasillaTrampa;
    }
    /**
     * Retorno del tipo de casilla trampa
     * @return  tipo de casilla trampa
     */
    public String getTipoCasillaTrampa(){
        return this.tipoCasillaTrampa;
    }

}