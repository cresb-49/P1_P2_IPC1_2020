package com.carlos.proyecto2.Dados;

import com.carlos.proyecto2.gui.EspacioJInternalFrame;
import com.carlos.proyecto2.gui.MainFrame;

public class Dados implements Runnable{
    private int cara;
    EspacioJInternalFrame frameOrigen;
    /**
     * Constructor Vacio
     */
    int numeroDeDado;
    public Dados(int numeroDeDado){
        this.numeroDeDado = numeroDeDado;
    }
    /**
     * asignacion del frame donde se llama la accion
     * @param frameOrigen frame de origen de ejecucion
     */
    public void setFrameOrigen(EspacioJInternalFrame frameOrigen) {
        this.frameOrigen = frameOrigen;
    }
    /**
     * @return the cara
     */
    public int getCara() {
        return cara;
    }
    
    @Override
    public void run() {
        //System.out.println("El dado cayo");
        int tiempoFinalizar =(int)Math.floor(Math.random()*(1-0+1)+1);
        //System.out.println("tiempo segundo espera: "+tiempoFinalizar);
        this.esperarXsegundos(tiempoFinalizar);
        int resutadoDado =(int)Math.floor(Math.random()*(5-0+1)+1);
        //System.out.println("resultado dado "+numeroDeDado+" : " +resutadoDado);
        frameOrigen.resultadoDado(numeroDeDado, resutadoDado);
    }
    /**
     * Funcion para pausar el procemiento
     * @param segundos cantidad de segundos
     */
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}