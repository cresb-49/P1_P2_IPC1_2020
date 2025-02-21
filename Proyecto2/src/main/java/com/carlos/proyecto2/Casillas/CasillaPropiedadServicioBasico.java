package com.carlos.proyecto2.Casillas;
public class CasillaPropiedadServicioBasico extends CasillaPropiedad {
    /**
     *
     */
    private static final long serialVersionUID = -7946618389903115181L;
    
    private float costoServicio;
    /**
     * Constructo de la porpiedad servicio basico
     * @param nombreCasilla nombre del servicio
     * @param precioCompra  precio de compra de la empresa de servico
     * @param precioHipoteca precio de hipoteca de la empresa de servicio
     * @param costoServicio costo del servicio 
     */
    public CasillaPropiedadServicioBasico(String nombreCasilla,float precioCompra,float precioHipoteca,float costoServicio){
        super(nombreCasilla, precioCompra, precioHipoteca);
        this.costoServicio=costoServicio;
    }
    /**
     * Asignacion del costo del servicio
     * @param costoServicio costo del servicio
     */
    public void setCostoServicio(float costoServicio) {
        this.costoServicio = costoServicio;
    }
    /**
     * Retorno del costo del servicio
     * @return costo del servicio
     */
    public float getCostoServicio() {
        return costoServicio;
    }
}