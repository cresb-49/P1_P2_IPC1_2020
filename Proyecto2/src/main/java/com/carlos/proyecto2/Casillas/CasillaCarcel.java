package com.carlos.proyecto2.Casillas;


public class CasillaCarcel extends Casillas{

    private static final long serialVersionUID = 582047624470027846L;

    private int turnosAPerder;
    /**
     * Constructor de la casilla carcel
     * @param turnosAPerder Ingreso de los turnos que se pierden en la casilla
     */
    public CasillaCarcel(int turnosAPerder){
        super("Carcel", "carcel");
        this.turnosAPerder=turnosAPerder;
    }
    /**
     * Asignacion de la cantidad de turnos a perder
     * @param turnosAPerder numero de turnos a perder
     */
    public void setTurnosAPerder(int turnosAPerder) {
        this.turnosAPerder = turnosAPerder;
    }
    /**
     * Retorno de los turnos a perder
     * @return retorno del numero de turnos a perder
     */
    public int getTurnosAPerder() {
        return turnosAPerder;
    }
}