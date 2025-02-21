package Proyecto1.EventosEnCola;

import Proyecto1.Planetas.*;
import Proyecto1.Naves.*;
public class EventoExportarGuerreros extends EventosEnCola {
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
    public EventoExportarGuerreros(Planetas origen, Planetas destino, Naves nave, double distancia,int turnoDeCreacion,String jugador) {
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
     * ejecuta la incorporacion de los guerreros al planeta aliado
     */
    @Override
    public void ejecutar()
    {
        limpiarPantalla();
        this.destino.recibirGuerreros(nave);
        this.nave.cargarNave(null);
        //solicitamos las naves del planeta de origen y luego buscamos una casiilla de tipo null para guardar la nave que salio
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
     * Regresamos el jugador que creo el evento
     * @return String
     */
    @Override
    public String getJugador(){
        return this.jugador;
    }
    
    /** 
     * Retorna el turno en el cual se va a ejecutar la accion
     * @return int
     */
    @Override
    public int getTurnoDeEjecucion()
    {
        return this.turnoDeEjecucion;
    }
    
    /** 
     * Retorna el nombre de planeta donde salen los guerreros
     * @return String
     */
    @Override
    public String getPlanetaDeOrigen(){
        return origen.getNombreDePlaneta();
    }
    
    /** 
     * Retorna el nombre de planeta donde se va a ejecutar la accion
     * @return String
     */
    @Override
    public String getPlanetaDestino(){
        return destino.getNombreDePlaneta();
    }
    
    /** 
     * Retorna la cantidad de pasajeros que tiene la nave
     * @return int
     */
    @Override
    public int getCantidadDeGuerrerosEnviados(){
        return nave.contarPasajeros();
    }
}