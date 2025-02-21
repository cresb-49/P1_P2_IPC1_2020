package com.carlos.proyecto2.Casillas;
public class CasillaPropiedadEstacion extends CasillaPropiedad{
    
    /**
     *
     */
    private static final long serialVersionUID = 6223665246899648007L;
    
    private float costoUsoEstacion;
    /**
     * Cosntructor de propiedad estacion
     * @param nombreCasilla nombre de la estacion
     * @param precioCompra  precio de compra de la estacion
     * @param precioHipoteca    precio de hipoteca de la estacion
     * @param costoUsoEstacion  costo de uso de la estacion
     */
    public CasillaPropiedadEstacion(String nombreCasilla,float precioCompra,float precioHipoteca,float costoUsoEstacion){
        super(nombreCasilla, precioCompra, precioHipoteca);
        this.costoUsoEstacion =costoUsoEstacion;
    }

    /**
     * Asignacion del costo de uso de estacion
     * @param costoUsoEstacion costo uso estacion
     */
    public void setCostoUsoEstacion(float costoUsoEstacion) {
        this.costoUsoEstacion = costoUsoEstacion;
    }
    /**
     * Retorno del costo de uso de estacion
     * @return costo uso estacion
     */
    public float getCostoUsoEstacion() {
        return costoUsoEstacion;
    }
}