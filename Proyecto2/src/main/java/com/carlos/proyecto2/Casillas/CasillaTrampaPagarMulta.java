package com.carlos.proyecto2.Casillas;
public class CasillaTrampaPagarMulta extends CasillaTrampa{
    /**
     *
     */
    private static final long serialVersionUID = -2318742679020750936L;
    
    private float multaPagar;
    /**
     * Cosntructo casilla pagar multa
     * @param nombreCasilla nombre de la casilla
     * @param multaPagar    multa asiganda a la casilla
     */
    public CasillaTrampaPagarMulta(String nombreCasilla, float multaPagar){
        super(nombreCasilla, "pagarMulta");
        this.multaPagar = multaPagar;
    }
    /**
     * asignacion de la multa
     * @param multaPagar monto de la multa
     */
    public void setMultaPagar(float multaPagar){
        this.multaPagar = multaPagar;
    }
    /**
     * Retorno del valor de la multa
     * @return monto de la multa
     */
    public float getMultaPagar(){
        return this.multaPagar;
    }

}