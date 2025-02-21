package com.carlos.proyecto2.Casillas;
public class CasillaPropiedad extends Casillas {

    /**
     *
     */
    private static final long serialVersionUID = 2446376549814389152L;
    
    private String jugadorDuenio = "";
    private float precioCompra;
    private float precioHipoteca;
    //true -> hipotecada; false -> no hipotecada
    public boolean estadoHipoteca = false;

    /**
     * CONSTRUCTOR CASILLA PROPIEDAD
     * @param nombreCasilla nombre de la propiedad
     * @param precioCompra  precio de la propiedad
     * @param precioHipoteca    costo de la hipoteca de la propiedad
     */
    public CasillaPropiedad(String nombreCasilla, float precioCompra, float precioHipoteca){
        super(nombreCasilla, "propiedad");
        this.precioCompra = precioCompra;
        this.precioHipoteca = precioHipoteca;
    }

    /**
     * METODOS DE ASIGNACION DE DATOS
     * 
     */

     /**
      * Asignacion de propietario de la propiedad
      * @param jugadorDuenio nombre del propietario
      */
     public void setJugadorDuenio(String jugadorDuenio) {
         this.jugadorDuenio = jugadorDuenio;
     }
     /**
      * Retorno del nombre del propietario de la propiedad
      * @return nombre del propietario
      */
     public String getJugadorDuenio() {
         return jugadorDuenio;
     }
     /**
      * Asignacion del precio de la propiedad
      * @param precioCompra Precio de la propiedad
      */
     public void setPrecioCompra(float precioCompra) {
         this.precioCompra = precioCompra;
     }
     /**
      * Retorno del precio de la propiedad
      * @return precio de la porpiedad
      */
     public float getPrecioCompra() {
         return precioCompra;
     }
     /**
      * Asignacion del costo de hipoteca
      * @param precioHipoteca precio de hipoteca
      */
     public void setPrecioHipoteca(float precioHipoteca) {
         this.precioHipoteca = precioHipoteca;
     }
     /**
      * Retorno del costo asignado a hipoteca
      * @return precio de hipoteca
      */
     public float getPrecioHipoteca() {
         return precioHipoteca;
     }
     /**
      * Asignacion del estado de hipoetca de la propiedad true/hipotecada, false/no hipoetcada
      * @param estadoHipoteca estado de hipoteca
      */
     public void setEstadoHipoteca(boolean estadoHipoteca) {
         this.estadoHipoteca = estadoHipoteca;
     }
     /**
      * Asignacion del estado de hipoetca de la propiedad true/hipotecada, false/no hipoetcada
      * @return estado de hipoteca
      */
     public boolean getEstadoHipoteca(){
        return this.estadoHipoteca;
     }
}