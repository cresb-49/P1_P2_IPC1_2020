package com.carlos.proyecto2.Casillas;
public class CasillaTrampaCambiarCasilla extends CasillaTrampa{
    
    /**
     *
     */
    private static final long serialVersionUID = -1033302435394919800L;
    
    private String nombreCasillaDestino;
    /**
     * Cosntructor casilla trampa cambiar a otra casilla
     * @param nombreCasilla nombre de la casilla
     */
    public CasillaTrampaCambiarCasilla(String nombreCasilla){
        super(nombreCasilla, "cambiarCasilla");
    }
    /**
     * Asignacion del mombre de casilla de destino
     * @param nombreCasillaDestino nombre de casilla destino
     */
    public void setNombreCasillaDestino(String nombreCasillaDestino){
        this.nombreCasillaDestino = nombreCasillaDestino;
    }
    /**
     * Retorno del nombre de casilla de destino
     * @return nombre de casilla de destino
     */
    public String getNombreCasillaDestino(){
        return nombreCasillaDestino;
    }

}