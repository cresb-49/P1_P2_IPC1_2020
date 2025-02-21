package com.carlos.proyecto2.Casillas;
public class CasillaInicio extends Casillas {
    /**
     *
     */
    private static final long serialVersionUID = 1955745492647350608L;
    private float cantidadCobrar;

    /**
     * CONSTRUCTOR CASILLA INICIO
     * @param cantidadCobrar Cantidad de dinero
     */
    public CasillaInicio(float cantidadCobrar){
        super("Inicio", "inicio");
        this.cantidadCobrar=cantidadCobrar;
    }
    /**
     * Asignacion de dinero a la casilla
     * @param cantidadCobrar Cantidad de dinero
     */
    public void setCantidadCobrar(float cantidadCobrar) {
        this.cantidadCobrar = cantidadCobrar;
    }
    /**
     * Retorno de la cantidad de dinero asignado a la casilla
     * @return Cantidad de dinero asignado
     */
    public float getCantidadCobrar() {
        return cantidadCobrar;
    }

}