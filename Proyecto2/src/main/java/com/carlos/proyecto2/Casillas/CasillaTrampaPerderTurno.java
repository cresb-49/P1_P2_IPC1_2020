package com.carlos.proyecto2.Casillas;
public class CasillaTrampaPerderTurno extends CasillaTrampa{
    /**
     *
     */
    private static final long serialVersionUID = -2232083299955950644L;
    
    private int turnosPerdidos;
    /**
     * Cosntructor casilla perder turno 
     * @param nombreCasilla nombre de la casilla
     * @param turnosPerdidos    turnos a perder en la casilla
     */
    public CasillaTrampaPerderTurno(String nombreCasilla, int turnosPerdidos){
        super(nombreCasilla, "perderTurno");
        this.turnosPerdidos = turnosPerdidos;
    }
    /**
     * Asignacion de la cantidad de turno a perder
     * @param turnosPerdidos numero de turnos a perder
     */
    public void setTurnosPerdidos(int turnosPerdidos){
        this.turnosPerdidos = turnosPerdidos;
    }
    /**
     * Retorno de la cantidad de turno a perder
     * @return numero de turno a perder
     */
    public int getTurnosPerdidos(){
        return this.turnosPerdidos;
    }
}