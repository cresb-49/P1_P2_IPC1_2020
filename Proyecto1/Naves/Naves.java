package Proyecto1.Naves;

import Proyecto1.Guerreros.*;
public class Naves {
    private int espacioDeNave;
    private double velocidadDeTrasporte;
    private int costoDeProduccion;
    private String constructorAFin;
    private Guerreros[] guerrerosAbordo;
    /**
     * Constructor para la naves en general
     * @param espacioDeNave Espacios que posee la nave
     * @param velocidadDeTrasporte  La velocidad con la cual viaja el trasnporte
     * @param costoDeProduccion Costo de la nave
     * @param constructorAFin   El constructor que lo construye la nave
     */
    public Naves(int espacioDeNave, double velocidadDeTrasporte, int costoDeProduccion, String constructorAFin){
        this.espacioDeNave=espacioDeNave;
        this.velocidadDeTrasporte=velocidadDeTrasporte;
        this.costoDeProduccion=costoDeProduccion;
        this.constructorAFin=constructorAFin;
    }
    
    /** 
     * Retorna la velocidad de la nave
     * @return double
     */
    public double velocidadDeTrasporte()
    {
        return this.velocidadDeTrasporte;
    }
    
    /** 
     * Retorna los espacios de la nave
     * @return int
     */
    public int getEspaciosDeNave(){
        return this.espacioDeNave;
    }
    /** 
     * Retorna el tipo de nave
     * @return String
     */
    public String tipoDeNave(){
        return "";
    }
    
    /** 
     * Retorna el cosnto de porduccion de la nave
     * @return int
     */
    public int costoDeProduccion()
    {
        return this.costoDeProduccion;
    }
    /**
     * Debemos agregar in array de guerreros
     * @param pasajeros Pasajeros de la nave
     */
    public void cargarNave(Guerreros[] pasajeros){
        guerrerosAbordo=pasajeros;
    }
    /**
     * Retornamos un array de tipo guerreros
     * @return
     */
    public Guerreros[] descargarGuerreros(){
        return guerrerosAbordo;
    }
    
    /** 
     * Se cuenta la cantidad de pasajeros que lleva la nave
     * @return int
     */
    public int contarPasajeros(){
        return guerrerosAbordo.length;
    }
}