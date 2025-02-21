package com.carlos.proyecto2.Tarjetas;

public class TarjetaPersonalizada extends Tarjetas{

    /**
     *
     */
    private static final long serialVersionUID = 2502493618392752096L;
    
    private float dineroARecibir;
    private float dineroAPagar;
    private float dineroPagarJugadores;
    private String nombreCasillaDestino;
    private int turnosPerdidos;

    public TarjetaPersonalizada(String grupoTomaTarjeta, String descripcionTarjeta,
            float dineroARecibir, float dineroAPagar, float dineroPagarJugadores, String nombreCasillaDestino,int turnosPerdidos){

        super(grupoTomaTarjeta, descripcionTarjeta);
        this.dineroARecibir=dineroARecibir;
        this.dineroAPagar=dineroAPagar;
        this.dineroPagarJugadores=dineroPagarJugadores;
        this.nombreCasillaDestino=nombreCasillaDestino;
        this.turnosPerdidos=turnosPerdidos;
    }
    /**
     * ASIGNAR DINERO A RECIBIR
     * @param dineroARecibir DINERO A RECIBIR
     */
    public void setDineroARecibir(float dineroARecibir) {
        this.dineroARecibir = dineroARecibir;
    }
    /**
     * rETORNAR DINERO A RECIBIR
     * @return DEINERO A RECIBIR
     */
    public float getDineroARecibir() {
        return dineroARecibir;
    }
    /**
     * aSIGNAR DINERO A PAGAR
     * @param dineroAPagar DINERO A PAGAR
     */
    public void setDineroAPagar(float dineroAPagar) {
        this.dineroAPagar = dineroAPagar;
    }
    /**
     * rETORNAR DINERO A PAGAR
     * @return DINERO A PAGAR
     */
    public float getDineroAPagar() {
        return dineroAPagar;
    }
    /**
     * ASIGNAR DINERO PARA PAGO A JUGADORES
     * @param dineroPagarJugadores PAGO A JUGADORES
     */
    public void setDineroPagarJugadores(float dineroPagarJugadores) {
        this.dineroPagarJugadores = dineroPagarJugadores;
    }
    /**
     * RETORNAR DINERO DE PAGO A JUGADORES
     * @return PAGO A JUGADORES
     */
    public float getDineroPagarJugadores() {
        return dineroPagarJugadores;
    }
    /**
     * ASIGNAR NOMBRE DE CASILLA DE DESTINO
     * @param casillaDestino NOMBRE CASILLA DESTINO
     */
    public void setNombreCasillaDestino(String nombreCasillaDestino) {
        this.nombreCasillaDestino = nombreCasillaDestino;
    }
    /**
     * RETORNAR NOMBRE CASILLA DESTINO
     * @return NOMBRE CASILLA DESTINO
     */
    public String getNombreCasillaDestino() {
        return this.nombreCasillaDestino;
    }
    /**
     * ASIGNAR TURNOS A PERDER
     * @param turnosPerdidos TURNOS A PERDER
     */
    public void setTurnosPerdidos(int turnosPerdidos) {
        this.turnosPerdidos = turnosPerdidos;
    }
    /**
     * RETORNAR TURNOS A PERDER
     * @return TURNOS A PERDER
     */
    public int getTurnosPerdidos() {
        return turnosPerdidos;
    }
}