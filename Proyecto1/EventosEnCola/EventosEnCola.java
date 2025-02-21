package Proyecto1.EventosEnCola;

public class EventosEnCola {
    protected int turnoDeEjecucion;
    protected String jugador;
    protected boolean estadoDeEjecucion;
    /**
     * Constructor vacio
     */
    public EventosEnCola(){
    }
    
    /** 
     * Retorna e turno de ejecucion del evento 
     * @return int
     */
    public int getTurnoDeEjecucion()
    {
        return 0;
    }
    //Ejecuta la accion del evento
    public void ejecutar()
    {
        
    }
    
    /** 
     * Retorna el estado en el cual esta la ejecucion
     * @return boolean
     */
    public boolean getEstadoDeEjecucion()
    {
        return estadoDeEjecucion;
    }
    
    /** 
     * Retorna el jugador que creo la accion
     * @return String
     */
    public String getJugador(){
        return "";
    }
    
    /** 
     * Retorna el planeta de donde se ejecuto una instruccion
     * @return String
     */
    public String getPlanetaDeOrigen(){
        return "";
    }
    
    /** 
     * Retorna el planeta donde se va a realizar la accion
     * @return String
     */
    public String getPlanetaDestino(){
        return "";
    }
    
    /** 
     * Retorna la cantidad de guerreros que estan en la nave
     * @return int
     */
    public int getCantidadDeGuerrerosEnviados(){
        return 0;
    }
    protected void limpiarPantalla(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}