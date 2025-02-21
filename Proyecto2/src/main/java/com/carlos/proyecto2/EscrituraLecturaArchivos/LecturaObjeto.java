package com.carlos.proyecto2.EscrituraLecturaArchivos;

import java.io.*;
import com.carlos.proyecto2.Excepciones.*;
import com.carlos.proyecto2.Jugador.ListaJugadores;
import com.carlos.proyecto2.Partida.Partida;
import com.carlos.proyecto2.Tablero.Tablero;

public class LecturaObjeto {
    public LecturaObjeto(){
        
    }
    /**
     * Lectura de objetos
     * @param archivoCargado archivo seleccionado
     * @return  archivo convertia a objeto
     * @throws ExtencionNotFoundException   la extencion no es correcta
     * @throws IOException  
     * @throws ClassNotFoundException calse de obejeto incorrecta
     */
    public Object readSerialization(File archivoCargado) throws ExtencionNotFoundException,IOException,ClassNotFoundException{
        /**
         * Se establece un filtro para el tipo de archivo que deseamos procesar en este caso 
         * .board y .game
         */
        String src = archivoCargado.getAbsolutePath();
        //System.out.println(src);
        //ObjectInputStream tm = new ObjectInputStream();   
        ObjectInputStream tm = new ObjectInputStream(new FileInputStream(src));
        Object tmp = null;
        if(archivoCargado.getName().toLowerCase().endsWith(".game")||archivoCargado.getName().toLowerCase().endsWith(".board")){
            if(archivoCargado.getName().toLowerCase().endsWith(".board")){
                tmp = (Tablero)tm.readObject();
            }
            if(archivoCargado.getName().toLowerCase().endsWith(".game")){
                tmp = (Partida)tm.readObject();
            }
            return tmp;
        }
        else{
            throw new ExtencionNotFoundException();
        }
    }
    /**
     * Lectura de archivos 2
     * @param src   directorio de lectura
     * @param subCarpeta    subcarpeta de almacenamiento
     * @param nombreDeArchivo nombre del archivo
     * @param terminacion   terminacion del archivo
     * @return  convercion de archivo a aobjeto 
     * @throws ExtencionNotFoundException   extencion incorrecta
     * @throws IOException
     * @throws ClassNotFoundException   clase no almacenada en el programa
     */
    public Object readSerialization(String src,String subCarpeta,String nombreDeArchivo,String terminacion) throws ExtencionNotFoundException,IOException,ClassNotFoundException{
        /**
         * Se establece un filtro para el tipo de archivo que deseamos procesar en este caso 
         * .board y .game
         */
        //System.out.println(src);
        //ObjectInputStream tm = new ObjectInputStream();   
        ObjectInputStream tm = new ObjectInputStream(new FileInputStream(src+subCarpeta+"/"+nombreDeArchivo+terminacion));
        Object tmp = null;
        if(terminacion.equals(".game")||terminacion.equals(".board")||terminacion.equals(".rnk")){
            if(terminacion.equals(".board")){
                tmp = (Tablero)tm.readObject();
            }
            if(terminacion.equals(".game")){
                tmp = (Partida)tm.readObject();
            }
            if(terminacion.equals(".rnk")){
                tmp = (ListaJugadores)tm.readObject();
            }
            return tmp;
        }
        else{
            throw new ExtencionNotFoundException();
        }
    }
}