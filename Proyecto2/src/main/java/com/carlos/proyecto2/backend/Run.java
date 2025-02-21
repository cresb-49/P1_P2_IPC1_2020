package com.carlos.proyecto2.backend;
import com.carlos.proyecto2.EscrituraLecturaArchivos.*;
import com.carlos.proyecto2.gui.MainFrame;
/**
 * Hello world!
 *
 */
public class Run {
    public static void main(String[] args) {
        String directorioDeGuardado = raizDirectorios();
        CrearRanking();
        MainFrame ventanaPrincial = new MainFrame("MONOPOLIO",directorioDeGuardado);
    }
    /**
     * Generacion del directorio de guardo principal del programa
     * @return src donde se guardaran las partidas
     */
    public static String raizDirectorios(){
        AccesoDirectorios principal = new AccesoDirectorios();
        principal.AsignarDirectorioRaiz();
        principal.CrearCarpetaGuardado();
        return principal.getSaveSrc();
    }
    /**
     * Creacion del archivo y carpeta ranking del juego
     */
    public static void CrearRanking()
    {
        AccesoDirectorios crearRanking = new AccesoDirectorios();
        crearRanking.CrearCarpetaRankingYArchivo();
    }

}
