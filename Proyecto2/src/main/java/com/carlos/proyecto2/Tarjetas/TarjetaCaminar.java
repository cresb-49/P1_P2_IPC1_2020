package com.carlos.proyecto2.Tarjetas;

public class TarjetaCaminar extends Tarjetas{
    
    /**
     *
     */
    private static final long serialVersionUID = -3698336240400934050L;
    
    private String sentidoMovimiento;
    private String tipoCasilla;
    
    public TarjetaCaminar(String grupoTomaTarjeta,String descripcionTarjeta, String sentidoMovimiento,String tipoCasilla){
        super(grupoTomaTarjeta, descripcionTarjeta);
        this.sentidoMovimiento=sentidoMovimiento;
        this.tipoCasilla=tipoCasilla;
    }
    /**
     * ASIGNAR SETNIDO DE MOVIMIENTO
     * @param sentidoMovimiento SENTIDO DE MOVIMIENTO
     */
    public void setSentidoMovimiento(String sentidoMovimiento) {
        this.sentidoMovimiento = sentidoMovimiento;
    }
    /**
     * RETORNAR SENTIDO DE MOVIMIENTO
     * @return SENTIDO DE MOVIMIENTO
     */
    public String getSentidoMovimiento() {
        return sentidoMovimiento;
    }
    /**
     * RETORNAR TIPO DE CASILLA
     * @return TIPO DE CASILLA 
     */
    public String getTipoCasilla() {
        return tipoCasilla;
    }
    /**
     * ASIGNAR TIPO DE CASILLA
     * @param tipoCasilla TIPO DE CASILLA
     */
    public void setTipoCasilla(String tipoCasilla) {
        this.tipoCasilla = tipoCasilla;
    }
    @Override
    public String getDescripcionTarjeta() {
        // TODO Auto-generated method stub
        return super.getDescripcionTarjeta();
    }
}