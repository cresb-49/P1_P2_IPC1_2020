package com.carlos.proyecto2.Casillas;

import java.io.Serializable;

/**
 * Casillas
 */
public class Casillas implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = -8203611192235027596L;
    /**
     * CARACTERISTICAS DE UNA CASILLA
     */
    private String nombreCasilla;
    private String tipoDeCasilla;

     /**
     * CARACTERISTICAS LISTA
     */
    private Casillas casillaSiguiente = null;
    private Casillas casillaAnterior = null;

    /**
     * CONSTRUCTOR CASILLA
     * @param nombreCasilla
     * @param tipoDeCasilla
     */
    public Casillas(String nombreCasilla, String tipoDeCasilla){
        this.nombreCasilla = nombreCasilla;
        this.tipoDeCasilla = tipoDeCasilla;
    }
    
    /**
     * asignacion del nombre de la casilla
     * @param nombreCasilla nombre de la casilla
     */
    public void setNombreCasilla(String nombreCasilla) {
        this.nombreCasilla = nombreCasilla;
    }
    /**
     * Retorno del nombre de la casilla
     * @return nombre de la casilla
     */
    public String getNombreCasilla() {
        return nombreCasilla;
    }
    /**
     * Asignacion del tipo de casilla
     * @param tipoDeCasilla the tipoDeCasilla to set
     */
    public void setTipoDeCasilla(String tipoDeCasilla) {
        this.tipoDeCasilla = tipoDeCasilla;
    }
    /**
     * Retorno del tipo de casilla
     * @return tipo de casilla
     */
    public String getTipoDeCasilla() {
        return tipoDeCasilla;
    }
    
    /**
     * Asinacion de la anterior casilla en lista
     * @param casillaAnterior casilla anterior
     */
    public void setCasillaAnterior(Casillas casillaAnterior) {
        this.casillaAnterior = casillaAnterior;
    }
    /**
     * Retorno de la casilla anterior en lista
     * @return casilla anterior 
     */
    public Casillas getCasillaAnterior() {
        return casillaAnterior;
    }
    /**
     * Asigancion de la casilla siguinte en lista
     * @param casillaSiguiente casilla siguiente
     */
    public void setCasillaSiguiente(Casillas casillaSiguiente) {
        this.casillaSiguiente = casillaSiguiente;
    }
    /**
     * Retorno de la casilla siguinte en lista
     * @return casilla siguiente
     */
    public Casillas getCasillaSiguiente() {
        return casillaSiguiente;
    }


}