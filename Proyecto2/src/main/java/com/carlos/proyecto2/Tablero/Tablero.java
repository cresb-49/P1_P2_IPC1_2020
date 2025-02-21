package com.carlos.proyecto2.Tablero;

import java.io.Serializable;

import com.carlos.proyecto2.Casillas.*;
import com.carlos.proyecto2.Tarjetas.*;
import com.carlos.proyecto2.Jugador.*;
import com.carlos.proyecto2.Tarjetas.*;

public class Tablero implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 2299170447910694553L;
    
    /**
     * CARACTERISTICAS GENERALES DEL TABLERO
     */
    private String nombreDelJuego;
    private int cantidadDeJugadores=0;
    private float cantidadInicialDeDineroJugadores=0;
    private float cantidadDeDineroVuelta=0;
    private int limiteDeCasas=0;
    private int limiteDeHoteles=0;
    private float porcentajeInteresHipoteca=0;
    private int perderTurnosCarcel=0;
    private int cantidadDeDatos=0;

    /**
     * CONTENEDORES DENTRO DEL TABLERO 
     * 
     * Se inicializan cuando se crea el objeto debido a que son dinamicas
     */
    private ListaCasilla casillasDelTablero = new ListaCasilla();
    private ListaTarjeta tarjetasCupon = new ListaTarjeta();
    private ListaTarjeta tarjetasBolsa = new ListaTarjeta();
    
    


    /**
     * CONTRUCTOR PARA EL TABLERO
     * @param nombreDelJuego nombre del tablero
     * @param cantidadDeJugadores   cantidad de jugadores 
     * @param cantidadInicialDeDineroJugadores  cantidad e dinero inicial
     * @param cantidadDeDineroVuelta    cantidad de dinero al pasar por inicio
     * @param limiteDeCasas limite de casas
     * @param limiteDeHoteles   limite de hoteles
     * @param porcentajeInteresHipoteca porcentaje de hipoteca de la partida
     */
    public Tablero(String nombreDelJuego, int cantidadDeJugadores,float cantidadInicialDeDineroJugadores, float cantidadDeDineroVuelta,
    int limiteDeCasas,int limiteDeHoteles, float porcentajeInteresHipoteca,int cantidadDeDados){
        this.nombreDelJuego = nombreDelJuego;
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.cantidadInicialDeDineroJugadores = cantidadInicialDeDineroJugadores;
        this.cantidadDeDineroVuelta = cantidadDeDineroVuelta;
        this.limiteDeCasas = limiteDeCasas;
        this.limiteDeHoteles = limiteDeHoteles;
        this.porcentajeInteresHipoteca = porcentajeInteresHipoteca;
        this.cantidadDeDatos=cantidadDeDados;
    }

    /**
     * Asignacion del nombre del juego
     * @param nombreDelJuego nombre del juego
     */
    public void setNombreDelJuego(String nombreDelJuego) {
        this.nombreDelJuego = nombreDelJuego;
    }
    /**
     * Retorno del nombre del juegp
     * @return nombre del juego
     */
    public String getNombreDelJuego() {
        return nombreDelJuego;
    }
    /**
     * Asignacion de la catidad e jugadores
     * @param cantidadDeJugadores cantidad de jugadores
     */
    public void setCantidadDeJugadores(int cantidadDeJugadores) {
        this.cantidadDeJugadores = cantidadDeJugadores;
    }
    /**
     * retorno de cantida de jugadores
     * @return cantidad de jugadores
     */
    public int getCantidadDeJugadores() {
        return cantidadDeJugadores;
    }
    /**
     * Asignacion de la cantidad dinero inicial
     * @param cantidadInicialDeDineroJugadores cantidad de dinero inicial 
     */
    public void setCantidadInicialDeDineroJugadores(float cantidadInicialDeDineroJugadores) {
        this.cantidadInicialDeDineroJugadores = cantidadInicialDeDineroJugadores;
    }
    /**
     * Retorno de la cantidad de dinero incial
     * @return cantidad de dinero inicial
     */
    public float getCantidadInicialDeDineroJugadores() {
        return cantidadInicialDeDineroJugadores;
    }
    /**
     * Asignacion de dinero por vuelta
     * @param cantidadDeDineroVuelta dinero al pasar por inicio
     */
    public void setCantidadDeDineroVuelta(float cantidadDeDineroVuelta) {
        this.cantidadDeDineroVuelta = cantidadDeDineroVuelta;
    }
    /**
     * Retorno del dinero por vuelta
     * @return dinero al pasa por inicio
     */
    public float getCantidadDeDineroVuelta() {
        return cantidadDeDineroVuelta;
    }
    /**
     * Asignacion de limite de casas
     * @param limiteDeCasas limite de casas
     */
    public void setLimiteDeCasas(int limiteDeCasas) {
        this.limiteDeCasas = limiteDeCasas;
    }
    /**
     * Retonro del limite de casas
     * @return limite de casas
     */
    public int getLimiteDeCasas() {
        return limiteDeCasas;
    }
    /**
     * Asignacion de limite de hoteles
     * @param limiteDeHoteles limite de hoteles
     */
    public void setLimiteDeHoteles(int limiteDeHoteles) {
        this.limiteDeHoteles = limiteDeHoteles;
    }
    /**
     * Retorno del limite de hoteles
     * @return limite de hoteles
     */
    public int getLimiteDeHoteles() {
        return limiteDeHoteles;
    }
    /**
     * ASIGNAR PORCENTAJE DE HIPOTECA
     * @param porcentajeInteresHipoteca porcentaje de hipoteca
     */
    public void setPorcentajeInteresHipoteca(float porcentajeInteresHipoteca) {
        this.porcentajeInteresHipoteca = porcentajeInteresHipoteca;
    }
    /**
     * RETORNAR PORCENTAJE DE HIPOTECA
     * @return porcentaje de hipoteca
     */
    public float getPorcentajeInteresHipoteca() {
        return porcentajeInteresHipoteca;
    }
    /**
     * GENERACION DEL TABLERO PRESTABLECIDO
     */
    public void generarTablero(){
        this.casillasDelTablero = tableroPrestablecido();
    }
    /**
     * RETORNAR CASILLAS DEL TABLERO
     * @return casillas del tablero 
     */
    public ListaCasilla getCasillasDelTablero() {
        return casillasDelTablero;
    }
    /**
     * RETORNAR TARJETAS BOLSA DEL TABLERO
     * @return tarejtas bolsa de la partida
     */
    public ListaTarjeta getTarjetasBolsa() {
        return tarjetasBolsa;
    }
    /**
     * ASIGNAR TARJETAS BOLSA DEL TABLERO
     * @param tarjetasBolsa tarejtas bolsa de la partida
     */
    public void setTarjetasBolsa(ListaTarjeta tarjetasBolsa) {
        this.tarjetasBolsa = tarjetasBolsa;
    }
    /**
     * RETORNAR TARJETAS CUPON DEL TABLERO
     * @return tarjetas cupon de la partida
     */
    public ListaTarjeta getTarjetasCupon() {
        return tarjetasCupon;
    }
    /**
     * ASIGNAR TARJETAS CUPON DEL TABLERO
     * @param tarjetasCupon tarejtas cupon de la partida
     */
    public void setTarjetasCupon(ListaTarjeta tarjetasCupon) {
        this.tarjetasCupon = tarjetasCupon;
    }
    /**
     * RETONAR CANTIDAD DE DADOS DE LA PARTIDA
     * @return cantidad de dados de la partida
     */
    public int getCantidadDeDatos() {
        return cantidadDeDatos;
    }
    /**
     * ASIGNAR CANTIDAD DE DADOS A LA PARTIDA
     * @param cantidadDeDatos cantidad de dados de la partida
     */
    public void setCantidadDeDatos(int cantidadDeDatos) {
        this.cantidadDeDatos = cantidadDeDatos;
    }
    /**
     * Carga del tablero prestablecido 
     * @return tablero de jeugo
     */
    private ListaCasilla tableroPrestablecido(){
        ListaCasilla casillas = new ListaCasilla();
        casillas.agregar(new CasillaInicio(this.cantidadDeDineroVuelta));
        casillas.agregar(new CasillaPropiedadLugar("Peten", 50, 35, 56 , 5, 55, 70, 55, "Rojo"));
        casillas.agregar(new CasillaTomaTarjeta("Bolsa 1", "Bolsa"));
        casillas.agregar(new CasillaPropiedadLugar("El Progreso", 70, 25, 38, 4, 55, 76, 55, "Rojo"));
        casillas.agregar(new CasillaTrampaPagarMulta("SAT", 200));
        casillas.agregar(new CasillaPropiedadEstacion("Aviateca", 210, 110, 25));
        casillas.agregar(new CasillaPropiedadLugar("Huehuetenango", 130, 60, 81, 7, 45, 90, 45, "Amarillo"));
        casillas.agregar(new CasillaTomaTarjeta("Cupon 1", "Cupon"));
        casillas.agregar(new CasillaPropiedadLugar("Quetzalteanngo", 100, 55, 79, 6, 45, 158, 45, "Amarillo"));
        casillas.agregar(new CasillaPropiedadLugar("Alta Verapaz", 90, 65, 83, 8, 45, 90, 45, "Amarillo"));
        casillas.agregar(new CasillaCarcel(this.perderTurnosCarcel));
        casillas.agregar(new CasillaPropiedadLugar("Quiche", 150, 70, 123, 10, 110, 246, 110, "Cafe"));
        casillas.agregar(new CasillaPropiedadServicioBasico("Inde", 175, 110, 75));
        casillas.agregar(new CasillaPropiedadLugar("Izabal", 140, 80, 132, 12, 110, 265, 110, "Cafe"));
        casillas.agregar(new CasillaPropiedadLugar("Chimaltenango", 150, 75, 128, 11, 110, 256, 110, "Cafe"));
        casillas.agregar(new CasillaPropiedadEstacion("Fegua", 190, 110, 25));
        casillas.agregar(new CasillaPropiedadLugar("Retalhuleu", 200, 100, 166, 16, 105, 333, 105, "Naranja"));
        casillas.agregar(new CasillaTomaTarjeta("Bolsa 2", "Bolsa"));
        casillas.agregar(new CasillaPropiedadLugar("Solola", 170, 90, 147, 14, 105, 290, 105, "Naranja"));
        casillas.agregar(new CasillaPropiedadLugar("Escuintla", 190, 95, 157, 15, 105, 314, 105, "Naranja"));
        casillas.agregar(new CasillaNeutral("Descanso Gratis"));
        casillas.agregar(new CasillaPropiedadLugar("San Marcos", 230, 100, 180, 24, 150, 360, 150, "Verde Claro"));
        casillas.agregar(new CasillaTomaTarjeta("Cupon 2", "Cupon"));
        casillas.agregar(new CasillaPropiedadLugar("Chiquimula", 200, 90, 171, 20, 150, 342, 150, "Verde Claro"));
        casillas.agregar(new CasillaPropiedadLugar("Baja Verapaz", 250, 95, 175, 22, 150, 351, 150, "Verde Claro"));
        casillas.agregar(new CasillaPropiedadEstacion("Flomerca", 210, 110, 25));
        casillas.agregar(new CasillaPropiedadLugar("Zacapa", 270, 140, 198, 26, 140, 395, 140, "Azul"));
        casillas.agregar(new CasillaPropiedadLugar("Totonicapan", 280, 125, 190, 20, 140, 380, 140, "Azul"));
        casillas.agregar(new CasillaPropiedadServicioBasico("Empagua", 175, 110, 75));
        casillas.agregar(new CasillaPropiedadLugar("Guatemala", 250, 135, 194, 20, 140, 388, 140, "Azul"));
        casillas.agregar(new CasillaTrampaCambiarCasilla("Vaya a la carcel"));
        casillas.agregar(new CasillaPropiedadLugar("Santa Rosa", 310, 135, 229, 30, 190, 458, 190, "Rosa"));
        casillas.agregar(new CasillaPropiedadLugar("Sacatepequez", 310, 160, 243, 35, 190, 486, 190, "Rosa"));
        casillas.agregar(new CasillaTomaTarjeta("Bolsa 3", "Bolsa"));
        casillas.agregar(new CasillaPropiedadLugar("Suchitepequez", 300, 140, 215, 25, 190, 430, 190, "Rosa"));
        casillas.agregar(new CasillaPropiedadEstacion("Microbus", 190, 110, 25));
        casillas.agregar(new CasillaTomaTarjeta("Cupon 3", "Cupon"));
        casillas.agregar(new CasillaPropiedadLugar("Jalapa", 360, 180, 252, 40, 200, 504, 200, "Verde"));
        casillas.agregar(new CasillaTrampaPagarMulta("Impuestos", 80));
        casillas.agregar(new CasillaPropiedadLugar("Jutiapa", 390, 200, 330, 50, 200, 600, 200, "Verde"));

        return casillas;
    }
}