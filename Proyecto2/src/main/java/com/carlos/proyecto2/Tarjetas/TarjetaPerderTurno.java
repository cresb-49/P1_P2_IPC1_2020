package com.carlos.proyecto2.Tarjetas;

public class TarjetaPerderTurno extends Tarjetas{

    /**
     *
     */
    private static final long serialVersionUID = 7706327977788416578L;
    
    private int turnosAPerder;

    public TarjetaPerderTurno(String grupoTomaTarjeta, String descripcionTarjeta, int turnosAPerder){
        super(grupoTomaTarjeta, descripcionTarjeta);
        this.turnosAPerder=turnosAPerder;
    }
    /**
     * ASIGNAR CANTIDAD DE TURNOS A PERDER
     * @param turnosAPerder TURNOS A PERDER
     */
    public void setTurnosAPerder(int turnosAPerder) {
        this.turnosAPerder = turnosAPerder;
    }
    /**
     * RETORNAR CANTIDAD DE TURNOS A PERDER
     * @return TURNOS A PERDER
     */
    public int getTurnosAPerder() {
        return turnosAPerder;
    }
}