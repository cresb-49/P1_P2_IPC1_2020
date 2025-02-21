package com.carlos.proyecto2.Casillas;

import java.io.Serializable;

import com.carlos.proyecto2.Interfaces.*;

public class ListaCasilla implements ImplementacionLista,Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -4425989393360352685L;
    
    private Casillas raiz = null;
    private int tamano = 0;

    public ListaCasilla(){
        this.raiz=null;
        this.tamano =0;
    }
    /**
     * Retorno del primero en la lista
     * @return raiz
     */
    public Casillas getRaiz() {
        return raiz;
    }
    /**
     * Busqueda de casillas
     * @param nombreCasilla nombre de la casilla
     * @return casilla con la descripcion dada
     */
    public Casillas buscarCasilla(String nombreCasilla){
        Casillas temporal = null;
        temporal = raiz;
        while (!(temporal.getNombreCasilla().equals(nombreCasilla))) {   
            temporal = temporal.getCasillaSiguiente();
        }
        return temporal;
    }
    
    @Override
    public void agregar(Object nuevo) {
        Casillas nuevaCasilla = (Casillas)nuevo;
        if(this.raiz==null){
            this.raiz = nuevaCasilla;
            raiz.setCasillaSiguiente(this.raiz);
            raiz.setCasillaAnterior(this.raiz);
        }
        else{
            Casillas temporal = this.raiz;
            while (temporal.getCasillaSiguiente()!=this.raiz){
                temporal = temporal.getCasillaSiguiente();
            }
            temporal.setCasillaSiguiente(nuevaCasilla);
            nuevaCasilla.setCasillaAnterior(temporal);
            nuevaCasilla.setCasillaSiguiente(this.raiz);
            this.raiz.setCasillaAnterior(nuevaCasilla);

        }
        this.tamano++;
    }

    @Override
    public void eliminar(String nombre) {
        // TODO Auto-generated method stub

    }

    @Override
    public void ordenar(boolean acendente) {
        // TODO Auto-generated method stub

    }

    @Override
    public void switchDatos(Object ob1, Object ob2) {

        Casillas casilla1 = (Casillas)ob1;
        Casillas casilla2 = (Casillas)ob2;

        if(casilla1.getCasillaAnterior()==casilla2||casilla1.getCasillaSiguiente()==casilla2){
            Casillas temporal;
            if(!(casilla1.getCasillaSiguiente()==casilla2)){
                temporal= casilla1;
                casilla1=casilla2;
                casilla2=temporal;
            }
            casilla1.getCasillaAnterior().setCasillaSiguiente(casilla2);
            casilla1.setCasillaSiguiente(casilla2.getCasillaSiguiente());
            casilla1.getCasillaSiguiente().setCasillaAnterior(casilla1);
            casilla2.setCasillaSiguiente(casilla1);
            temporal = casilla1.getCasillaAnterior();
            casilla2.setCasillaAnterior(temporal);
            casilla1.setCasillaAnterior(casilla2);
            if(casilla1==raiz)
            {
                this.raiz=casilla2;
            }else if(casilla2==raiz)
            {
                this.raiz=casilla1;
            }
        }else{
            //temporales pertenecientes a casilla 1
            Casillas temporal1 = casilla1.getCasillaAnterior();
            Casillas temporal2 = casilla1.getCasillaSiguiente();
            //temporales pertenecientes a casilla2
            Casillas temporal3 = casilla2.getCasillaAnterior();
            Casillas temporal4 = casilla2.getCasillaSiguiente();

            //Cruzamos los siguienetes y anteriores en las casillas
            casilla1.setCasillaAnterior(temporal3);
            casilla1.setCasillaSiguiente(temporal4);

            casilla2.setCasillaAnterior(temporal1);
            casilla2.setCasillaSiguiente(temporal2);
            //Referenciamos de nuevo los apuntadores de los objetos ateriores y siguientes
            casilla1.getCasillaAnterior().setCasillaSiguiente(casilla1);
            casilla1.getCasillaSiguiente().setCasillaAnterior(casilla1);

            casilla2.getCasillaAnterior().setCasillaSiguiente(casilla2);
            casilla2.getCasillaSiguiente().setCasillaAnterior(casilla2);

            if(casilla1==raiz)
            {
                this.raiz=casilla2;
            }else if(casilla2==raiz)
            {
                this.raiz=casilla1;
            }
            
        }

    }

    @Override
    public void listarElementos() {
        //System.out.println("Elementos de la lista");
        Casillas temporal = raiz;
        while (temporal.getCasillaSiguiente()!=raiz) {
            System.out.println(temporal.getNombreCasilla());
            temporal = temporal.getCasillaSiguiente();
        }
        if(temporal.getCasillaSiguiente()==raiz){
            System.out.println(temporal.getNombreCasilla());
        }

    }
    /**
     * Busqueda de casillas
     * @param nombreCasilla nombre de la casilla
     * @return casilla con la descripcion dada
     */
    public Casillas retornarCasilla(String nombreCasilla){
        Casillas temporal = this.raiz;
        while(!temporal.getNombreCasilla().equals(nombreCasilla))
        {
            temporal=temporal.getCasillaSiguiente();
        }
        return  temporal;
    }
}