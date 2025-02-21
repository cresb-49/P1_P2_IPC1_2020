package Proyecto1;

import java.util.Scanner;
import Proyecto1.Usuarios.*;
public class Principal {
    
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Usuarios acciones = new Usuarios();
        limpiarPantalla();
        String nombreDeJugador1;
        String nombreDeJugador2;

        System.out.println("BIENVENIDO AL JUEGO \nIngrese el nombre se los jugadores:\n");
        System.out.print("Ingrese nombre del Jugador 1:");
        nombreDeJugador1=teclado.nextLine();
        
        System.out.print("Ingrese nombre del Jugador 2:");
        nombreDeJugador2=teclado.nextLine();
        limpiarPantalla();
        
        System.out.println("MAPA VACIO!!!!");
        pausa("PRECIONE ENTER PARA IR A LA CONFIGURACION DE MAPAS!!!");
        limpiarPantalla();
        acciones.inicioDePartida(nombreDeJugador1, nombreDeJugador2);
        
        limpiarPantalla();
               
        int jugadores = 1;
        int turnos=1;
        String turnoJugador;
        String cambioDeJugador;
        boolean repeticionCiclo=true;
        do{
            limpiarPantalla();
            if(jugadores==1){
                turnoJugador=nombreDeJugador1;
            }
            else
            {
                turnoJugador=nombreDeJugador2;
            }
            acciones.ActualizarMapa(turnoJugador,turnos);
            acciones.accionesEnSegundoPlano(turnos);
            /**
             * la variable acciones puede regresar variables de tipo string, que son identificadas
             * para detectar cuando un jugador termina sus acciones y el jugador 2 hace las suyas,
             * cuando terminan ambos se realizan las acciones despues de los turnos.
             */
            cambioDeJugador=acciones.procesamientoDeTexto(teclado.nextLine(),turnoJugador,turnos);
            /**
             * La condicional comprueba si es la palabra correcta para hacer un turno durante el juego
             */
            if(cambioDeJugador.equals("FIN")){
                jugadores++;
                if(jugadores==3){
                    jugadores=1;
                    acciones.accionesPostTurnos(turnos);
                    turnos++;
                }
            }
            /**
             * Con esta accion salimos completamente del juego desde el menu principal
             */
            if(cambioDeJugador.equals("SALIR")){
                repeticionCiclo=false;
            }
            /**
             * Aqui se resetean los contadores para cuando se hace cambio de mapa
             */
            if(cambioDeJugador.equals("CAMBIO")){
                turnos=1;
                jugadores=1;
            }
        }while(repeticionCiclo);
    }
    /**
     * Comandos para limpiar la pantalla de la consola
     */
    public static void limpiarPantalla(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    /**
     * Funcion con la cual podemos establecer una pausa y lanzar al mismo tiempo un mensaje
     * @param mensaje
     */
    private static void pausa(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.println(mensaje);
        teclado.nextLine();
    }
}