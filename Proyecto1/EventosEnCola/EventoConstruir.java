package Proyecto1.EventosEnCola;
import Proyecto1.Constructores.*;
import Proyecto1.Planetas.*;
public class EventoConstruir extends EventosEnCola {
    private Planetas planetaDondeSeEjecuta;
    private Constructores Constructor;
    private int turnoDeCreacion;
    /**
     * Constructor de evento de construir una nave en el juego
     * @param planetaDondeSeEjecuta Planeta donde se ejecuta la accion de construir
     * @param Constructor   El constructor encargado de construir la nave
     * @param turnoDeCreacion   Guarda el turno de creacion del evento
     * @param jugador   Guarda el nombre del jugador qeu creo la accion
     */
    public EventoConstruir(Planetas planetaDondeSeEjecuta,Constructores Constructor,int turnoDeCreacion,String jugador){
        this.planetaDondeSeEjecuta=planetaDondeSeEjecuta;
        this.Constructor=Constructor;
        this.turnoDeCreacion=turnoDeCreacion;
        this.turnoDeEjecucion=(turnoDeCreacion+Constructor.getTiempoDeConstruccion());// este valor se calcula por medio de turno de creacion y el timepo de construccion del constructor
        this.jugador=jugador;
        this.estadoDeEjecucion=true;
    }
    /**
     * Ejecutar la funcion de construir una nave
     */
    @Override
    public void ejecutar()
    {
        this.Constructor.construirNave(this.planetaDondeSeEjecuta);
        this.estadoDeEjecucion=false;
    }
    
    /** 
     * Retorna el nombre del jugador que creo el evento
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
     * Retorna el nombre de planeta donde se va a ejecutar la accion
     * @return String
     */
    @Override
    public String getPlanetaDeOrigen(){
        return planetaDondeSeEjecuta.getNombreDePlaneta();
    }
}