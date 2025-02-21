package com.carlos.proyecto2.Tarjetas;

import java.io.Serializable;

import com.carlos.proyecto2.Interfaces.ImplementacionLista;

public class ListaTarjeta implements ImplementacionLista,Serializable{

    private Tarjetas raiz = null;
    /**
     *
     */
    private static final long serialVersionUID = 607425467326761141L;

    @Override
    public void agregar(Object nuevo) {

        Tarjetas nuevaTarjeta = (Tarjetas)nuevo;

        if(this.raiz==null){
            this.raiz = nuevaTarjeta;
        }
        else{
            Tarjetas temporal = this.raiz;
            while (temporal.getSiguientTarjeta()!=null){
                temporal = temporal.getSiguientTarjeta();
            }
            temporal.setSiguientTarjeta(nuevaTarjeta);
        }
    }

    /**
     * @return Retorno del valor de la raiz
     */
    public Tarjetas getRaiz() {
        return raiz;
    }

    public void reordenarTarjetas(){
        Tarjetas temporal = this.raiz;
        raiz = temporal.getSiguientTarjeta();
        temporal.setSiguientTarjeta(null);
        this.agregar(temporal);
    }
    /**
     * Metodo que elimina por medio de compracion de objetos 
     * @param retirar
     */
    public void eliminarDeVaraja(Tarjetas retirar){
        if(retirar==this.raiz){
            raiz=raiz.getSiguientTarjeta();
            retirar.setSiguientTarjeta(null);
        }
        else
        {
            Tarjetas temporal = this.raiz;
            while (!(retirar == temporal.getSiguientTarjeta())) {
                temporal = temporal.getSiguientTarjeta();
            }
            temporal.setSiguientTarjeta(retirar.getSiguientTarjeta());    
        }
    }
    /**
     * Devuelve la cantida de tarjetas que hay
     * @return
     */
    public int contarBaraja(){
        int tamaño=0;
        if(raiz!=null){
            Tarjetas temporal = this.raiz;
            while (temporal.getSiguientTarjeta()!=null) {
            tamaño++;
            temporal = temporal.getSiguientTarjeta();
            }
            
        }
        return tamaño;
    }
    /**
     * 
     */
    public void vaciarLista(){
        this.raiz=null;
    }
    /**
     * Metodo que elimina por medio de nombre
     */
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
        // TODO Auto-generated method stub

    }

    @Override
    public void listarElementos() {
        Tarjetas temporal = this.raiz;
        while (temporal!=null) {
            System.out.println(temporal.getGrupoTomaTarjeta());
            temporal = temporal.getSiguientTarjeta();
        }
    }

}