package com.carlos.proyecto2.Jugador;

import java.io.Serializable;

import com.carlos.proyecto2.Interfaces.ImplementacionLista;



public class ListaJugadores implements ImplementacionLista,Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -7577655155992769227L;
    
    private Jugador raiz = null;
    private int tamano = 0;
    //True significa que esta mezclada
    private boolean listaMezclada=false;

    public ListaJugadores(){
        this.raiz=null;
        this.tamano =0;
    }
       
    /**
     * IMPLEMENTACION LISTA
     */

    @Override
    public void agregar(Object nuevo) {
        if(nuevo instanceof Jugador){
            Jugador jugadorNuevo = (Jugador)nuevo;
            if(this.raiz==null)
            {
                this.raiz = jugadorNuevo;
                raiz.setJugadorSiguiente(this.raiz);
                raiz.setJugadorAnterior(this.raiz);
                this.tamano++;
            }
            else{
                Jugador temporal = this.raiz;
                while(temporal.getJugadorSiguiente()!=this.raiz){
                    temporal = temporal.getJugadorSiguiente();
                }
                temporal.setJugadorSiguiente(jugadorNuevo);
                jugadorNuevo.setJugadorAnterior(temporal);
                jugadorNuevo.setJugadorSiguiente(this.raiz);
                this.raiz.setJugadorAnterior(jugadorNuevo);
                this.tamano++;
            }
            this.listaMezclada=false;
        }
    }

    @Override
    public void eliminar(String nombre) {
        Jugador temporal = raiz;
        while (!temporal.getNombreJugador().equals(nombre)) {
            temporal = temporal.getJugadorSiguiente();
        }
        if(temporal==raiz&&temporal.getJugadorSiguiente()==raiz){
            this.raiz=null;
        }else if(temporal==raiz){
            Jugador anterior=temporal.getJugadorAnterior();
            Jugador posterior=temporal.getJugadorSiguiente();
            posterior.setJugadorAnterior(anterior);
            anterior.setJugadorSiguiente(posterior);
            this.raiz=posterior;
        }else{
            Jugador anterior=temporal.getJugadorAnterior();
            Jugador posterior=temporal.getJugadorSiguiente();
            posterior.setJugadorAnterior(anterior);
            anterior.setJugadorSiguiente(posterior);
        }
    }

    @Override
    public void ordenar(boolean acendente) {
        int ingresados = this.jugadoresIngresados();
        Jugador jugador1 = this.raiz;
        Jugador jugador2;
        boolean orden;
        for (int i = 0; i < ingresados; i++) {
            jugador2 =jugador1.getJugadorSiguiente();
            while (jugador2!=this.raiz) {                
                orden = (acendente)?(jugador1.getFondos()<jugador2.getFondos()):(jugador1.getFondos()>jugador2.getFondos());
                if(orden)
                {
                    Jugador temporal1=jugador1;
                    Jugador temporal2=jugador2;
                    this.switchDatos(jugador1, jugador2);
                    jugador1=temporal2;
                    jugador2=temporal1;
                }
                jugador2 = jugador2.getJugadorSiguiente();
            }
            jugador1 = jugador1.getJugadorSiguiente();
        }

    }
    /**
     * Intercambio de lugar de los objetos
     */
    @Override
    public void switchDatos(Object ob1, Object ob2) {
        Jugador jugadorCambio1 = (Jugador)ob1;
        Jugador jugadorCambio2 = (Jugador)ob2;
        if(jugadorCambio1.getJugadorAnterior()==jugadorCambio2||jugadorCambio1.getJugadorSiguiente()==jugadorCambio2){
            Jugador temporal;
            if(!(jugadorCambio1.getJugadorSiguiente()==jugadorCambio2)){
                temporal= jugadorCambio1;
                jugadorCambio1=jugadorCambio2;
                jugadorCambio2=temporal;
            }
            jugadorCambio1.getJugadorAnterior().setJugadorSiguiente(jugadorCambio2);
            jugadorCambio1.setJugadorSiguiente(jugadorCambio2.getJugadorSiguiente());
            jugadorCambio1.getJugadorSiguiente().setJugadorAnterior(jugadorCambio1);
            jugadorCambio2.setJugadorSiguiente(jugadorCambio1);
            temporal = jugadorCambio1.getJugadorAnterior();
            jugadorCambio2.setJugadorAnterior(temporal);
            jugadorCambio1.setJugadorAnterior(jugadorCambio2);
            if(jugadorCambio1==raiz)
            {
                this.raiz=jugadorCambio2;
            }else if(jugadorCambio2==raiz)
            {
                this.raiz=jugadorCambio1;
            }
        }else{
            //temporales pertenecientes a casilla 1
            Jugador temporal1 = jugadorCambio1.getJugadorAnterior();
            Jugador temporal2 = jugadorCambio1.getJugadorSiguiente();
            //temporales pertenecientes a jugadorCambio2
            Jugador temporal3 = jugadorCambio2.getJugadorAnterior();
            Jugador temporal4 = jugadorCambio2.getJugadorSiguiente();

            //Cruzamos los siguienetes y anteriores en las casillas
            jugadorCambio1.setJugadorAnterior(temporal3);
            jugadorCambio1.setJugadorSiguiente(temporal4);

            jugadorCambio2.setJugadorAnterior(temporal1);
            jugadorCambio2.setJugadorSiguiente(temporal2);
            //Referenciamos de nuevo los apuntadores de los objetos ateriores y siguientes
            jugadorCambio1.getJugadorAnterior().setJugadorSiguiente(jugadorCambio1);
            jugadorCambio1.getJugadorSiguiente().setJugadorAnterior(jugadorCambio1);

            jugadorCambio2.getJugadorAnterior().setJugadorSiguiente(jugadorCambio2);
            jugadorCambio2.getJugadorSiguiente().setJugadorAnterior(jugadorCambio2);

            if(jugadorCambio1==raiz)
            {
                this.raiz=jugadorCambio2;
            }else if(jugadorCambio2==raiz)
            {
                this.raiz=jugadorCambio1;
            }
            
        }
    }

    @Override
    public void listarElementos() {
        Jugador temporal = raiz;
        while (temporal.getJugadorSiguiente()!=raiz) {
            System.out.println(temporal.getNombreJugador());
            temporal = temporal.getJugadorSiguiente();
        }
        if(temporal.getJugadorSiguiente()==raiz){
            System.out.println(temporal.getNombreJugador());
        }
    }
    /**
     * Metodo Buscar Jugador devuelve booleano
     * @param nombre nombre jugador
     * @return jugador segun busqeda
     */
    public boolean buscarJugador(String nombre){
        boolean respuesta=false;
        if(raiz!=null){
            Jugador temporal = raiz;
            while (temporal.getJugadorSiguiente()!=raiz) {
                if(temporal.getNombreJugador().equals(nombre))
                {
                    respuesta=true;
                    break;
                }
                temporal = temporal.getJugadorSiguiente();
            }
            if(temporal.getJugadorSiguiente()==raiz){
                if(temporal.getNombreJugador().equals(nombre))
                {
                    respuesta=true;
                }
            }
        }
        return respuesta;
    }
    public Jugador retornarJugador(String nombreJugador){
        Jugador temporal = this.raiz;
        while(!temporal.getNombreJugador().equals(nombreJugador))
        {
            temporal=temporal.getJugadorSiguiente();
        }
        return  temporal;
    }
    /**
     * @return the raiz
     */
    public Jugador getRaiz() {
        return raiz;
    }
    /**
     * @param raiz the raiz to set
     */
    /**
     * cantidad de jugadores en la lista
     */
    public int jugadoresIngresados(){
        int resultado=1;
        Jugador tmp = raiz;
        if(tmp==null){
            return 0;
        }
        else{
            tmp=tmp.getJugadorSiguiente();
            while(tmp!=this.raiz){
                resultado++;
                tmp=tmp.getJugadorSiguiente();
            }
            return resultado;
            
        }
    }
    /**
     * Devuelve si la lista esta mezcla por booleano
     * @return esatdo de mezcla
     */
    public boolean getListaMezclada(){
        return this.listaMezclada;
    }
    /**
     * Metodo para establecer un orden aleatorio en lo jugadores despues de ser introducidos
     * @param jugadores 
     */
    public void mezclarJugadores(){
        int seleccion1=0;
        int seleccion2=0;
        Jugador temporalCambio1=this.raiz;
        Jugador temporalCambio2=this.raiz;
        for (int i = 0; i < this.jugadoresIngresados(); i++) {
            while (seleccion1==seleccion2) {
                seleccion1=(int)Math.floor(Math.random()*(6-0+1)+0);
                seleccion2=(int)Math.floor(Math.random()*(6-0+1)+0);
            } 
            for (int j = 0; j < seleccion1; j++) {
                temporalCambio1=temporalCambio1.getJugadorSiguiente();
            }
            for (int j = 0; j < seleccion2; j++) {
                temporalCambio2=temporalCambio2.getJugadorSiguiente();
            }
            if(!(temporalCambio1==temporalCambio2))
            {
                this.switchDatos(temporalCambio1, temporalCambio2);
            }
            else
            {
                seleccion1=0;
                seleccion2=0;
            }
        }
        this.listaMezclada=true;
        System.out.println("Se mezclo la lista");
    }

}