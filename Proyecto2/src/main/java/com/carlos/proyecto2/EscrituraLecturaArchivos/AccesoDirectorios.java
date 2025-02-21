package com.carlos.proyecto2.EscrituraLecturaArchivos;

import com.carlos.proyecto2.Excepciones.ObjectNotSerializableExeption;
import com.carlos.proyecto2.Jugador.ListaJugadores;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoDirectorios {
    private String src;
    private String saveSrc;
    public AccesoDirectorios(){

    }
    /**
     * Retorno De directorio donde trabajamos
     * @return
     */
    public void AsignarDirectorioRaiz(){
        File d = new File("");
        this.setSrc(d.getAbsolutePath());
    }
    /**
     * Genreacion de carpeta de guardado
     */
    public void CrearCarpetaGuardado(){
        File guardado = new File(src+"/Saves");
        if(!guardado.exists()){
            guardado.mkdirs();
            setSaveSrc(src+"/Saves/");
        }
        else{
            setSaveSrc(src+"/Saves/");
        }
    }
    /**
     * Creacion del archivo y carpeta ramking del juego
     */
    public void CrearCarpetaRankingYArchivo(){
        File d = new File("");
        String src =d.getAbsolutePath();
        File ranking = new File(src+"/Saves/"+"/Ranking");
        if(!ranking.exists()){
            ranking.mkdirs();
            EscrituraObjeto nuevaEscritura = new EscrituraObjeto(ranking.getAbsolutePath()+"/");
            ListaJugadores rankingDeJugadores = new ListaJugadores();
            try {
                nuevaEscritura.WriteSerealizacion(rankingDeJugadores,"Ranking", "");
            } catch (ObjectNotSerializableExeption ex) {
                Logger.getLogger(AccesoDirectorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AccesoDirectorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            File ArchivoRanking = new File(src+"/Saves/"+"/Ranking/"+"Ranking.rnk");
            if(!ArchivoRanking.exists())
            {
                System.out.println("com.carlos.proyecto2.EscrituraLecturaArchivos.AccesoDirectorios.CrearCarpetaRankingYArchivo()");
                EscrituraObjeto nuevaEscritura = new EscrituraObjeto(ranking.getAbsolutePath()+"/");
                ListaJugadores rankingDeJugadores = new ListaJugadores();
                try {
                    nuevaEscritura.WriteSerealizacion(rankingDeJugadores,"Ranking", "");
                } catch (ObjectNotSerializableExeption ex) {
                    Logger.getLogger(AccesoDirectorios.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AccesoDirectorios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /**
     * Retorno de la direccion principal
     * @return src
     */
    public String getSrc() {
        return src;
    }
    /**
     * Asignacion de la direcccion principal
     * @param src src
     */
    public void setSrc(String src) {
        this.src = src;
    }
    /**
     * Retorno del directorio de guardado
     * @return Savesrc
     */
    public String getSaveSrc() {
        return saveSrc;
    }
    /**
     * Asignacion del directorio de guardado
     * @param saveSrc Savesrc
     */
    public void setSaveSrc(String saveSrc) {
        this.saveSrc = saveSrc;
    }
}