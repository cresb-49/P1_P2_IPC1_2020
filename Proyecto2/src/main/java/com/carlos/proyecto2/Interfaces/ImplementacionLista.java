package com.carlos.proyecto2.Interfaces;

public interface ImplementacionLista {
    /**
     * agercaion de objeto
     * @param nuevo objeto nuevo 
     */ 
    public void agregar(Object nuevo);
    /**
     * Eliminacion de objeto
     * @param nombre nombre del objeto
     */
    public void eliminar(String nombre);
    /**
     * Orndenar obejtos
     * @param acendente tipo de orden
     */
    public void ordenar(boolean acendente);
    /**
     * Cambio de lugar de objetos
     * @param ob1 obejto 1
     * @param ob2 objeto 2
     */
    public void switchDatos(Object ob1, Object ob2);
    /**
     * Mostrar orden en consola
     */
    public void listarElementos();
}