package com.carlos.proyecto2.Partida;

import com.carlos.proyecto2.Casillas.CasillaPropiedad;
import com.carlos.proyecto2.Casillas.CasillaPropiedadEstacion;
import com.carlos.proyecto2.Casillas.CasillaPropiedadLugar;
import com.carlos.proyecto2.Casillas.CasillaPropiedadServicioBasico;
import com.carlos.proyecto2.Casillas.Casillas;
import java.io.Serializable;

import com.carlos.proyecto2.Jugador.*;
import com.carlos.proyecto2.Tablero.*;

public class Partida implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = -910532607696290698L;

    private String nombreDeLaPartida;
    private Tablero tableroDeJuego;
    //ESTA VARIABLE INDICA SI LA PARTIDA YA ESTA TERMINADA O NO
    private boolean estadoDePartida=false;


     /**
     * CONTENEDORES DENTRO DE LA PARTIDA 
     * 
     * Se inicializan cuando se crea el objeto debido a que son dinamicas
     */
    private ListaJugadores jugadoresDeLaPartida = new ListaJugadores();
    /**
     * cosntructor de partida
     * @param nombreDeLaPartida nombre de la partida
     */
    public Partida(String nombreDeLaPartida) {
        this.nombreDeLaPartida = nombreDeLaPartida;
    }
    /**
     * Crecion del tablerp
     * @param cantidadDeJugadores   cantidad de jugadores
     * @param cantidadInicialDeDineroJugadores  cantidad inicial de dinero de jugadores
     * @param cantidadDeDineroVuelta    cantidad de dinero al par por inicio
     * @param limiteDeCasas limite de casas 
     * @param limiteDeHoteles   limite de hoteles
     * @param porcentajeInteresHipoteca porcentaje de hipoteca
     * @param cantidadDados cantidad de dados de la partida
     */
    public void CrearTablero(int cantidadDeJugadores,float cantidadInicialDeDineroJugadores, float cantidadDeDineroVuelta,int limiteDeCasas,int limiteDeHoteles,float porcentajeInteresHipoteca,int cantidadDados){
        String nombreDelJuego = this.nombreDeLaPartida;
        tableroDeJuego = new Tablero(nombreDelJuego, cantidadDeJugadores, cantidadInicialDeDineroJugadores, cantidadDeDineroVuelta, limiteDeCasas, limiteDeHoteles, porcentajeInteresHipoteca,cantidadDados);
    }

    /**
     * Retorno de los jugadores de la partida
     * @return juegadores de la partida
     */
    public ListaJugadores getJugadoresDeLaPartida() {
        return jugadoresDeLaPartida;
    }
    /**
     * Retorno del tablero de la parida
     * @return tablero de la partida
     */
    public Tablero getTableroDeJuego() {
        return tableroDeJuego;
    }
    /**
     * asignacion del tablero de la partida
     * @param tableroDeJuego tablero de juego
     */
    public void setTableroDeJuego(Tablero tableroDeJuego) {
        this.tableroDeJuego = tableroDeJuego;
    }
    /**
     * Asignacion del nombre la parida
     * @param nombreDeLaPartida nombre de la partida
     */
    public void setNombreDeLaPartida(String nombreDeLaPartida) {
        this.nombreDeLaPartida = nombreDeLaPartida;
    }
    /**
     * retorno del nombre la partida
     * @return nombre de la partida
     */
    public String getNombreDeLaPartida() {
        return nombreDeLaPartida;
    }
    /**
     * Retorna si la partida ya esta terminada o no 
     * @return Estado de partida "terminada / no terminada"
     */
    public boolean isEstadoDePartida() {
        return estadoDePartida;
    }
    /**
     * Establecer el estado de la partida
     * @param estadoDePartida Variable para establecer la partida
     */
    public void setEstadoDePartida(boolean estadoDePartida) {
        this.estadoDePartida = estadoDePartida;
    }
    public void reinicioPartida()
    {
        this.setEstadoDePartida(false);
        Casillas temporalCasilla = this.tableroDeJuego.getCasillasDelTablero().getRaiz();
        Jugador temporalJugador = this.jugadoresDeLaPartida.getRaiz();
        int cantidadJugadores = this.jugadoresDeLaPartida.jugadoresIngresados();
        //ciclo qei elimina segun el nombre del jugador en la partida
        for (int i = 0; i < cantidadJugadores; i++) {
            temporalJugador.setFondos(this.tableroDeJuego.getCantidadInicialDeDineroJugadores());
            temporalJugador.setEstadoBancarota(false);
            temporalJugador.setEstadoCarcel(false);
            temporalJugador.setNombreCasillaUbicacion("Inicio");
            temporalJugador.setTarjetas(null);
            temporalJugador.setTurnosPerdidos(0);
            temporalJugador.setDeuda(0);
            temporalJugador=temporalJugador.getJugadorSiguiente();
        }
        for (int i = 0; i < 40; i++) {
            if(temporalCasilla instanceof CasillaPropiedad){
                ((CasillaPropiedad) temporalCasilla).setEstadoHipoteca(false);
                ((CasillaPropiedad) temporalCasilla).setJugadorDuenio("");
                if(temporalCasilla instanceof CasillaPropiedadLugar)
                {
                    ((CasillaPropiedadLugar) temporalCasilla).setCantidadCasas(0);
                    ((CasillaPropiedadLugar) temporalCasilla).setCantidadHoteles(0);
                }
            }
            temporalCasilla = temporalCasilla.getCasillaSiguiente();
        }
    }
    /**
     * Elimina todo rastro del jugador en el juego
     * @param jugadorDelTurno 
     */
    public void eliminarRastroJugador(Jugador jugadorDelTurno)
    {
        Casillas temporal = this.tableroDeJuego.getCasillasDelTablero().getRaiz();
        String nombreJugador = jugadorDelTurno.getNombreJugador();
        for (int i = 0; i < 40; i++) {
            if(temporal instanceof CasillaPropiedad)
            {
                if(((CasillaPropiedad) temporal).getJugadorDuenio().equals(jugadorDelTurno.getNombreJugador()))
                {
                    ((CasillaPropiedad) temporal).setJugadorDuenio("");
                    ((CasillaPropiedad) temporal).setEstadoHipoteca(false);
                    if(temporal instanceof CasillaPropiedadLugar)
                    {
                        ((CasillaPropiedadLugar) temporal).setCantidadCasas(0);
                        ((CasillaPropiedadLugar) temporal).setCantidadHoteles(0);
                    }
                }
            }
        }
        jugadorDelTurno.setFondos(0);
        jugadorDelTurno.setDeuda(0);
        jugadorDelTurno.setEstadoCarcel(false);
        jugadorDelTurno.setEstadoBancarota(true);
        jugadorDelTurno.setNombreCasillaUbicacion("Inicio");
        jugadorDelTurno.setTurnosPerdidos(0);
    }
    /**
     * Precio de los bienes del jugador;
     * @return 
     */
    public float precioBienes(Jugador jugadorDelTurno){
        float bienesResultantes=0;
        Casillas temporal = this.tableroDeJuego.getCasillasDelTablero().getRaiz();
        String nombreJugador = jugadorDelTurno.getNombreJugador();
        for (int i = 0; i < 40; i++) {
            if(temporal instanceof CasillaPropiedad){
                if(!((CasillaPropiedad) temporal).getEstadoHipoteca())
                {
                    if(temporal instanceof CasillaPropiedadLugar)
                    {
                        if(((CasillaPropiedadLugar) temporal).getJugadorDuenio().equals(jugadorDelTurno.getNombreJugador()))
                        {
                            int cantidadCasas = ((CasillaPropiedadLugar) temporal).getCantidadCasas();
                            int cantidadHoteles = ((CasillaPropiedadLugar) temporal).getCantidadHoteles();
                            float precioCasas = ((CasillaPropiedadLugar) temporal).getPrecioCasa();
                            float precioHoteles = ((CasillaPropiedadLugar) temporal).getCantidadHoteles();
                            float precioPropiedad = ((CasillaPropiedadLugar) temporal).getPrecioCompra();
                            bienesResultantes= bienesResultantes+(cantidadCasas*precioCasas)+(cantidadHoteles+precioHoteles)+(precioPropiedad);
                        }
                    }
                    if(temporal instanceof CasillaPropiedadEstacion)
                    {
                        if(((CasillaPropiedadEstacion) temporal).getJugadorDuenio().equals(jugadorDelTurno.getNombreJugador()))
                        {
                            float costoPropiedad = ((CasillaPropiedadEstacion) temporal).getPrecioCompra();

                            bienesResultantes= bienesResultantes+costoPropiedad;
                        }
                    }
                    if(temporal instanceof CasillaPropiedadServicioBasico)
                    {
                        if(((CasillaPropiedadServicioBasico) temporal).getJugadorDuenio().equals(jugadorDelTurno.getNombreJugador()))
                        {
                            float costoPropiedad = ((CasillaPropiedadServicioBasico) temporal).getPrecioCompra();

                            bienesResultantes= bienesResultantes+costoPropiedad;
                        }
                    }
                }
            }
            temporal=temporal.getCasillaSiguiente();
        }
        return bienesResultantes;
    }
    
    /**
     * OPERACION DE PAGAR A LOS DEMAS JUGADORES
     * @param jugadorDelTurno jugador que paga
     * @param dineroAPagar cantidad de dinero que paga
     */
    public void pagoJugadores(Jugador jugadorDelTurno,float dineroAPagar)
    {
            ListaJugadores jugadoresAcreedores = this.jugadoresDeLaPartida;
            int jugadoresDeLaPartida = jugadoresAcreedores.jugadoresIngresados();
            dineroAPagar=dineroAPagar*jugadoresDeLaPartida;
            jugadorDelTurno.pagarMulta(dineroAPagar);
            
            Jugador jugadorAcreedor = jugadoresAcreedores.getRaiz();
            jugadorAcreedor.recibirDinero(dineroAPagar/jugadoresDeLaPartida);
            while(jugadorAcreedor.getJugadorSiguiente()!=jugadoresAcreedores.getRaiz()){
                jugadorAcreedor=jugadorAcreedor.getJugadorSiguiente();
                jugadorAcreedor.recibirDinero(dineroAPagar/jugadoresDeLaPartida);
            }
    }
    /**
     * RETORNA JUGADORES SIN BANCA ROTA
     * @return ENTERO
     */
    public int contarJugadoresSinBancaRota(){
        Jugador temporal = this.jugadoresDeLaPartida.getRaiz();
        int cantidadJugadores = this.jugadoresDeLaPartida.jugadoresIngresados();
        int resultado=0;
        for (int i = 0; i < cantidadJugadores; i++) {
            if(temporal.isEstadoBancaRota())
            {
                resultado++;
            }
            temporal = temporal.getJugadorSiguiente();
        }
        return resultado;
    }
    public int jugadorConTodasLasPropiedades(){
        int resultado = 0;
        Jugador temporalJugador = this.jugadoresDeLaPartida.getRaiz();
        int cantidadJugadores = this.jugadoresDeLaPartida.jugadoresIngresados();
        for (int i = 0; i < cantidadJugadores; i++) {
            resultado=0;
            if(!temporalJugador.isEstadoBancaRota())
            {
                Casillas temporalCasillas = this.tableroDeJuego.getCasillasDelTablero().getRaiz();
                for (int j = 0; j < 40; j++) {
                    if(temporalCasillas instanceof CasillaPropiedad)
                    {
                        if(((CasillaPropiedad) temporalCasillas).getJugadorDuenio().equals(temporalJugador.getNombreJugador()))
                        {
                            resultado++;
                        }
                        if(resultado == 28)
                        {
                            return resultado;
                            
                        }
                    }
                        
                    temporalCasillas = temporalCasillas.getCasillaSiguiente();
                }
                        
            }
            temporalJugador = temporalJugador.getJugadorSiguiente();
        }
        return resultado;
    }
}