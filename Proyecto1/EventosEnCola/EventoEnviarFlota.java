package Proyecto1.EventosEnCola;

import Proyecto1.Planetas.*;
import Proyecto1.Naves.*;

public class EventoEnviarFlota extends EventosEnCola {
    private final Planetas origen;
    private final Planetas destino;
    private final Naves nave;
    private final double distancia;
    private final String jugador;
    /**
     * 
     * @param origen Planeta de Salida
     * @param destino Planeta de Destino
     * @param nave Nave que lleva los Guerreros
     * @param distancia La distancia que hay entre los planetas
     * @param turno El turno donde se a realizado el procedimiento
     */
    public EventoEnviarFlota(Planetas origen, Planetas destino, Naves nave, double distancia,int turnoDeCreacion,String jugador) {
        this.origen = origen;
        this.destino = destino;
        this.nave = nave;
        this.distancia = distancia;
        final double velocidad = this.nave.velocidadDeTrasporte();
        this.turnoDeEjecucion=(turnoDeCreacion+((int)(distancia/velocidad)));
        this.jugador=jugador;
        this.estadoDeEjecucion=true;
    }
    /**
     * Ejecuta la lucha entre ejercito enviado al planeta y el 
     */
    @Override
    public void ejecutar()
    {
        limpiarPantalla();
        this.destino.enfrentaiento(nave,this.jugador);
        this.nave.cargarNave(null);
        //se piden las neves del planeta de destino para regresar al estado de memoria donde estaba ubicado antes
        Naves[] temporal = origen.getNaves();
        for (int i = 0; i < temporal.length; i++) {
            if(temporal[i]==null)
            {
                temporal[i]=this.nave;
                break;
            }
        }
        this.estadoDeEjecucion=false;
    }
    
    /** 
     * Retorna el nombre del jugador que hara la accion
     * @return String
     */
    @Override
    public String getJugador(){
        return this.jugador;
    }
    
    /** 
     * Retorna el turno en el que se va a arealizar la ejecucion
     * @return int
     */
    @Override
    public int getTurnoDeEjecucion()
    {
        return this.turnoDeEjecucion;
    }
    
    /** 
     * Retorna el planeta de donde salieron los guerreros
     * @return String
     */
    @Override
    public String getPlanetaDeOrigen(){
        return origen.getNombreDePlaneta();
    }
    
    /** 
     * Retrona el planeta donde se va a realizar la accion 
     * @return String
     */
    @Override
    public String getPlanetaDestino(){
        return destino.getNombreDePlaneta();
    }
    
    /** 
     * Retorna la cantidad de guerreros que tiene dentro la nave
     * @return int
     */
    @Override
    public int getCantidadDeGuerrerosEnviados(){
        return nave.contarPasajeros();
    }
}