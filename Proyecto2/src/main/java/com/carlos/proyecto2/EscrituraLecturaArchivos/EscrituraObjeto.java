package com.carlos.proyecto2.EscrituraLecturaArchivos;

import java.io.*;

import com.carlos.proyecto2.Excepciones.ExtencionNotFoundException;
import com.carlos.proyecto2.Excepciones.ObjectNotSerializableExeption;
import com.carlos.proyecto2.Jugador.ListaJugadores;
import com.carlos.proyecto2.Partida.Partida;
import com.carlos.proyecto2.Tablero.*;

public class EscrituraObjeto {
    
    private String src;

    public EscrituraObjeto(String src){
        this.src=src;
    }
    /**
     * Serealizacion de objetos 
     * @param objetoSerealizar  obejto de entrada
     * @param nombreDelArchivo  nombre del guardado
     * @param subCarpeta    nombre de subcarpeta de guardado
     * @throws ObjectNotSerializableExeption    objeto incorrecto
     * @throws FileNotFoundException    direccion incorrecta
     */
    public void WriteSerealizacion(Object objetoSerealizar,String nombreDelArchivo,String subCarpeta) throws ObjectNotSerializableExeption,FileNotFoundException{
        subCarpeta="/"+subCarpeta+"/";
        /**
         * Detectamos el tipo de instancia a la que pertenece el objeto de entrada de
         * lo contrario se lanza un tipo de Exepcion de tipo ObjectNotSerealizableException
         * 
         */
        if(objetoSerealizar instanceof Tablero || objetoSerealizar instanceof Partida || objetoSerealizar instanceof ListaJugadores){
            //preparamos la variable de salida del archivo
            ObjectOutputStream tmp=null;
            /**
             * En las condicionales siguinetes lo que buscamos es el tipo de instancia a la que pertenece
             * el objeto, dependiendo de la misma es el tipo de archivo el cual se va escribir
             */

            if(objetoSerealizar instanceof Tablero){
                /**
                 * Se inicializa una variable del objeto a procesar para tener mayor control de lo que se esta realizando
                 */
                Tablero tablero = (Tablero)objetoSerealizar;
                try {
                    tmp=new ObjectOutputStream(new FileOutputStream(src+subCarpeta+nombreDelArchivo+".board"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    tmp.writeObject(tablero);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally{
                    try {
                        tmp.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }   
            }
            if(objetoSerealizar instanceof Partida){
                Partida partida = (Partida)objetoSerealizar;
                try {
                    tmp=new ObjectOutputStream(new FileOutputStream(src+subCarpeta+nombreDelArchivo+".game"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    tmp.writeObject(partida);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally{
                    try {
                        tmp.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(objetoSerealizar instanceof ListaJugadores){
                /**
                 * Se inicializa una variable del objeto a procesar para tener mayor control de lo que se esta realizando
                 */
                ListaJugadores ranking = (ListaJugadores)objetoSerealizar;
                try {
                    tmp=new ObjectOutputStream(new FileOutputStream(src+subCarpeta+nombreDelArchivo+".rnk"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    tmp.writeObject(ranking);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally{
                    try {
                        tmp.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }   
            }
        }
        else{
            throw new ObjectNotSerializableExeption();
        }
    }
    /**
     * Ceracion de subcarpetas de guardado
     * @param nombrePartida nombre de la partida 
     * @return  directorio existente
     */
    public String subCarpetaJuego(String nombrePartida){
        File subCarpeta = new File(src+"/"+nombrePartida+"/");
        int subNumeroCarpeta=0;
        if(subCarpeta.exists()){
            while(subCarpeta.exists()){
                subNumeroCarpeta++;
                subCarpeta= new File(src+"/"+nombrePartida+subNumeroCarpeta+"/");
            }
            subCarpeta.mkdirs();
            return String.valueOf(subNumeroCarpeta);
        }
        else{
            subCarpeta.mkdirs();
            return "";
        }
    }
    /**
     * Borrado de directorio
     */
    public void borrarDirectorio(String nombrePartida){
        File subDirectorio = new File(src+"/"+nombrePartida+"/");
        if(subDirectorio.exists()){
            File[] ficheros = subDirectorio.listFiles();
            for (int i = 0; i < ficheros.length; i++) {
                
            }
        }
    }
    /**
     * Retorno del directorio
     * @return src
     */
    public String getSrc() {
        return src;
    }
    /**
     * Asignacion del sirectorio de funcionamiento
     * @param src src
     */
    public void setSrc(String src) {
        this.src = src;
    }
}