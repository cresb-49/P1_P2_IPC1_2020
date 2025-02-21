package com.carlos.proyecto2.Casillas;
public class CasillaPropiedadLugar extends CasillaPropiedad {

    /**
     *
     */
    private static final long serialVersionUID = -8539154990243231210L;
    
    private int cantidadHoteles;
    private int cantidadCasas;
    private float costoEstancia;
    private float costoEstanciaAumentadoCadaCasa;
    private float precioCasa;
    private float costoEstanciaAumentadoCadaHotel;
    private float precioHotel;
    private String grupoPropiedad;
    /**
     * Constructor de propiedad lugar
     * @param nombreCasilla nombre del lugar
     * @param precioCompra  precio de venta del lugar
     * @param precioHipoteca    precio de hipoteca del lugar
     * @param costoEstanciaAumentadoCadaCasa    precio aumentado por cada casa
     * @param costoEstancia precio de estancia en casilla
     * @param precioCasa    precio de cada casa
     * @param costoEstanciaAumentadoCadaHotel   precio aumentado cada hotel
     * @param precioHotel   precio de cada hotel
     * @param grupoPropiedad    color de la propiedad
     */
    public CasillaPropiedadLugar(String nombreCasilla,float precioCompra, float precioHipoteca, float costoEstanciaAumentadoCadaCasa,
    float costoEstancia,float precioCasa,float costoEstanciaAumentadoCadaHotel,float precioHotel,String grupoPropiedad){

        super(nombreCasilla, precioCompra, precioHipoteca);
        this.cantidadHoteles=0;
        this.cantidadCasas=0;
        this.costoEstancia=costoEstancia;
        this.precioCasa=precioCasa;
        this.precioHotel=precioHotel;
        this.costoEstanciaAumentadoCadaCasa= costoEstanciaAumentadoCadaCasa;
        this.costoEstanciaAumentadoCadaHotel=costoEstanciaAumentadoCadaHotel;
        this.grupoPropiedad=grupoPropiedad;
    }
    /**
     * METODOS DE ASIGNACION DE LOS ATRIBUTOS
     */
    /**
     * Asignacion de la cantidad de hoteles de la propiedad
     * @param cantidadHoteles cantidad de hoteles
     */
    public void setCantidadHoteles(int cantidadHoteles){
        this.cantidadHoteles=cantidadHoteles;
    }
    /**
     * Retorno de la cantida de hoteles de la propiedad
     * @return cantidad de hoteles
     */
    public int getCantidadHoteles(){
        return this.cantidadHoteles;
    }
    /**
     * Asignacion de la cantidad de casas de la propiedad
     * @param cantidadCasas cantidad de casas
     */
    public void setCantidadCasas(int cantidadCasas){
        this.cantidadCasas = cantidadCasas;
    }
    /**
     * Retorno de la cantidad de casas de la propiedad
     * @return cantidad de casas
     */
    public int getCantidadCasas(){
        return this.cantidadCasas;
    }

    /**
     * Retorno del costo de estacia en la propiedad 
     * @return costo de estancia
     */
    public float getCostoEstancia() {
        return costoEstancia;
    }
    /**
     * Asignacion del costo de estancia de la propiedad
     * @param costoEstancia costo de estancia
     */
    public void setCostoEstancia(float costoEstancia) {
        this.costoEstancia = costoEstancia;
    }
    /**
     * Retorno del costo aumentado por cada casa
     * @return costo aumentado por cada casa 
     */
    public float getCostoEstanciaAumentadoCadaCasa() {
        return costoEstanciaAumentadoCadaCasa;
    }
    /**
     * Asignacion del costo aumentado por cada casa
     * @param costoEstanciaAumentadoCadaCasa costo aumentado pro cada casa
     */
    public void setCostoEstanciaAumentadoCadaCasa(float costoEstanciaAumentadoCadaCasa) {
        this.costoEstanciaAumentadoCadaCasa = costoEstanciaAumentadoCadaCasa;
    }
    /**
     * Retorno del precio de las casas de la propiedad
     * @return precio de una casa
     */
    public float getPrecioCasa() {
        return precioCasa;
    }
    /**
     * Asignacion del precio de las casas de la propiedad
     * @param precioCasa precio de casas de la propiedad
     */
    public void setPrecioCasa(float precioCasa) {
        this.precioCasa = precioCasa;
    }
    /**
     * Retorno del costo aumentado por cada hotel
     * @return costo aumentado por casa hotel
     */
    public float getCostoEstanciaAumentadoCadaHotel() {
        return costoEstanciaAumentadoCadaHotel;
    }
    /**
     * Asignacion del costo aumentado por cada hotel
     * @param costoEstanciaAumentadoCadaHotel costo aumentado pro cada hotel
     */
    public void setCostoEstanciaAumentadoCadaHotel(float costoEstanciaAumentadoCadaHotel) {
        this.costoEstanciaAumentadoCadaHotel = costoEstanciaAumentadoCadaHotel;
    }
    /**
     * Retorno del precio de los hoteles de la propiedad
     * @return precio de hoteles de la poriedad
     */
    public float getPrecioHotel() {
        return precioHotel;
    }
    /**
     * Asignacion de precio de hotel de la propiedad
     * @param precioHotel precio de hotel
     */
    public void setPrecioHotel(float precioHotel) {
        this.precioHotel = precioHotel;
    }
    /**
     * Retorno del color asignado a la propiedad
     * @return color de la propiedad
     */
    public String getGrupoPropiedad() {
        return grupoPropiedad;
    }
    /**
     * Asignacion del color de la propiedad
     * @param grupoPropiedad color de la propiedad
     */
    public void setGrupoPropiedad(String grupoPropiedad) {
        this.grupoPropiedad = grupoPropiedad;
    }
    /**
     * Agregar una casa a la propiedad
     */
    public void agregarCasa()
    {
        this.cantidadCasas++;
    }
    /**
     * Eliminar todas las casas de la propiedad
     */
    public void eliminarCasas()
    {
        this.cantidadCasas=0;
    }
    /**
     * eliminar una casa de la propiedad
     */
    public void eliminarCasa()
    {
        this.cantidadCasas--;
    }
    /**
     * Agregar un hotel a la propiedad
     */
    public void agregarHoteles()
    {
        this.cantidadHoteles++;
    }
    /**
     * Eliminar todos los hoteles de la propiedad
     */
    public void eliminarHoteles()
    {
        this.cantidadHoteles=0;
    }
    /**
     * Eliminar un hotel de la propiedad
     */
    public void eliminarHotel()
    {
        this.cantidadHoteles--;
    }
}