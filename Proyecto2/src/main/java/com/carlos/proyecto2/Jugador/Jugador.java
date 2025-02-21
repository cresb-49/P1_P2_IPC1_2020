package com.carlos.proyecto2.Jugador;

import java.io.Serializable;

import com.carlos.proyecto2.Casillas.*;
import com.carlos.proyecto2.Tarjetas.ListaTarjeta;

public class Jugador implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1071715124045028696L;
    /**
     * CARACTERISTICAS DE UN JUGADOR
     */
    private String nombreJugador;
    private float fondos;
    private float deuda=0;
    private ListaTarjeta tarjetas;
    private String nombreCasillaUbicacion="Inicio";
    //true significa que el jugador esta en banca rota
    private boolean estadoBancaRota=false;
    
    private boolean estadoCarcel;
    private int turnosPerdidos=0;
    /**
     * CARACTERISTICAS LISTA
     */
    private Jugador jugadorSiguiente=null;
    private Jugador jugadorAnterior=null;
    
    /**
     * CONSTRUCTOR JUGADOR
     * @param nombreJugador nombre del jugador
     * @param fondos fondos monetario del jugador 
     */
    public Jugador(String nombreJugador, float fondos){
        this.nombreJugador = nombreJugador;
        this.fondos = fondos;
        this.tarjetas = new ListaTarjeta();
    }
    /**
     * SEGUNDO CONSTRCTOR DE JUGADOR
     * @param nombreJugador nombre del jugador
     * @param dineroDelJugador fondos monetario del jugador
     */
    public Jugador(String nombreJugador)
    {
        this.nombreJugador=nombreJugador;
    }

    /**
     * METODOS DE ASIGNACION DE DATOS
     */
    /**
     * Asignacion del nombre del jugador
     * @param nombreJugador nombre del jugador
     */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    /**
     * Retorno del nombre del jugador
     * @return nombre del jugador
     */
    public String getNombreJugador() {
        return nombreJugador;
    }
    /**
     * asignacion de la deuda del jugador
     * @param deuda deuda del jugador
     */
    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }
    /**
     * retorno de la deuda del jugador
     * @return deuda del jugador
     */
    public float getDeuda() {
        return deuda;
    }
    
    /**
     * Asignacion del fondos del juagdor
     * @param fondos fondos del jugador
     */
    public void setFondos(float fondos) {
        this.fondos = fondos;
    }
    /**
     * retorno de fondos del jugador
     * @return fondos del jugador
     */
    public float getFondos() {
        return fondos;
    }
    /**
     * Retorna booleano de estado de banca rota
     * @return estado de banacarota
     */
    public boolean isEstadoBancaRota() {
        return estadoBancaRota;
    }
    /**
     * Establecer el estado de bancarota del jugador
     * @param estado estado de bancarota
     */
    public void setEstadoBancarota(boolean estado)
    {
        this.estadoBancaRota=estado;
    }
    /**
     * Retorna si el jugador esta en la carcel
     * @return estado de carcel
     */
    public boolean isEstadoCarcel() {
        return estadoCarcel;
    }
    /**
     * Establece el estado de carcel del jugador
     * @param estadoCarcel esatdo de carcel
     */
    public void setEstadoCarcel(boolean estadoCarcel) {
        this.estadoCarcel = estadoCarcel;
    }
    /**
     * Retona los turnos en la carcel el jugador
     * @return trunos perdidos 
     */
    public int getTurnosPerdigos() {
        return turnosPerdidos;
    }
    /**
     * Establece los turnos que el jugador estara en la carcel
     * @param turnosEnCarcel turnos en la carcel
     */
    public void setTurnosPerdidos(int turnosPerdidos) {
        this.turnosPerdidos = turnosPerdidos;
    }
    /**
     * Descuenta los turnos perdidos del jugador
     */
    public void descontarTurnosPerdidos(){
        this.turnosPerdidos--;
        System.out.println("Turnos perdidos: "+this.turnosPerdidos);
        if(this.turnosPerdidos==0&&this.estadoCarcel)
        {
            this.estadoCarcel=false;
        }
    }
    /**
     * FUNCIONALIDADES LISTA DE JUGADORES
     */

    /**
     * Asignar jugador anterior 
     * @param jugadorAnterior jugador anterior
     */
    public void setJugadorAnterior(Jugador jugadorAnterior) {
        this.jugadorAnterior = jugadorAnterior;
    }
    /**
     * Retornar jugador anterior
     * @return jugador anterior 
     */
    public Jugador getJugadorAnterior() {
        return jugadorAnterior;
    }
    /**
     * Asignar jugador siguinete
     * @param jugadorSiguiente jugador siguiente
     */
    public void setJugadorSiguiente(Jugador jugadorSiguiente) {
        this.jugadorSiguiente = jugadorSiguiente;
    }
    /**
     * Retornar jugador siguiente
     * @return jugador siguiente
     */
    public Jugador getJugadorSiguiente() {
        return jugadorSiguiente;
    }
    /**
     * Asignar tarjeta
     * @return tarjetas
     */
    public ListaTarjeta getTarjetas() {
        return tarjetas;
    }
    /**
     * Asignar tarjetas
     * @param tarjetas tarjetas
     */
    public void setTarjetas(ListaTarjeta tarjetas) {
        this.tarjetas = tarjetas;
    }
    /**
     * Retornar nombre de la casilla de ubicacion
     * @return nombre de casilla ubicacion 
     */
    public String getNombreCasillaUbicacion() {
        return nombreCasillaUbicacion;
    }
    /**
     * Asignar nombre de casilla de ubicacion
     * @param nombreCasillaUbicacion nombre de casilla de ubicacion
     */
    public void setNombreCasillaUbicacion(String nombreCasillaUbicacion) {
        this.nombreCasillaUbicacion = nombreCasillaUbicacion;
    }
    /**
     * RETIRAR DINERO DEL JUGADOR
     * @param montoAPagar Descontar monto de la deuda
     */
    public void pagarMulta(float montoAPagar){
        if(this.fondos>montoAPagar){
            float dineroDisponible=this.fondos;
            this.fondos=dineroDisponible- montoAPagar;
        }
        else
        {
            float montoDeudaActual = this.fondos-montoAPagar;
            this.fondos=0;
            this.deuda=this.deuda+(-1*montoDeudaActual);
            if(deuda>=500)
            {
                this.estadoBancaRota=true;
                
            }
        }
    }
    /**
     * Metodo para recibir dinero
     * @param premio dinero a recibir
     */
    public void recibirDinero(float dineroRecibido){
        if(deuda>0)
        {
            this.deuda=this.deuda-dineroRecibido;
            if(this.deuda<0)
            {
                this.fondos=this.fondos+(-1*this.deuda);
                this.deuda=0;
            }
        }
        else
        {
         this.fondos=this.fondos+dineroRecibido;   
        }
    }
}