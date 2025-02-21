package Proyecto1.Constructores;

import Proyecto1.Planetas.*;

public class Constructores {
    private int tiempoDeConstruccion;
    private int precioTienda;
    private int precioDeVenta;
    private String construirNave;
    /**
     * Constructor de los constructores
     * @param tiempoDeConstruccion  Tiempo que tarda en construir 
     * @param precioTienda  Precio para adquirir en al tienda del juego
     * @param precioDeVenta Precio de venta del constructor en la tienda del juego
     * @param construirNave El tipo de nave que construye el constructor
     */
    public Constructores(int tiempoDeConstruccion, int precioTienda, int precioDeVenta,String construirNave){
        this.tiempoDeConstruccion=tiempoDeConstruccion;
        this.precioTienda=precioTienda;
        this.precioDeVenta=precioDeVenta;
        this.construirNave=construirNave;
    }
    
    /** 
     * Retorna el tipo de nave que construye el constructor
     * @return String
     */
    public String naveAConstruir(){
        return construirNave;
    }
    
    /** 
     * Retorna el tiempo de trabajo del constructor
     * @return int
     */
    public int getTiempoDeConstruccion(){
        return this.tiempoDeConstruccion;
    }
    
    /** 
     * Retorna el precio de venta del constructor para la tienda
     * @return int
     */
    public int getPrecioDeVenta(){
        return this.precioDeVenta;
    }
    
    /** 
     * Retorna el precio del constructor en la tienda
     * @return int
     */
    public int getPrecioDeTienda()
    {
        return this.precioTienda;
    }
    
    /** 
     * Retorna el tipo de constructor que es
     * @return String
     */
    public String tipoDeConstructor(){
        return "";
    }
    
    /** 
     * Retorna el costo de poner a trabajar al constructor
     * @return int
     */
    public int costoDeTrabajo()
    {
        return 0;
    }
    
    /** 
     * Ejecuta la accion de construir una nave
     * @param planetaDeEjecucion
     */
    public void construirNave(Planetas planetaDeEjecucion){
        planetaDeEjecucion.generacionNaves(1, this.construirNave);
        planetaDeEjecucion.setFondosDelPlaneta(planetaDeEjecucion.getFondosDelPlaneta()-this.costoDeTrabajo());
    }
}