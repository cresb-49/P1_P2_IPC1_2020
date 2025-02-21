package com.carlos.proyecto2.EscrituraLecturaArchivos;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FiltroBoard extends FileFilter {

    @Override
    public boolean accept(File archivo) {
        
        return archivo.getName().toLowerCase().endsWith(".board")||archivo.isDirectory();
    }

    @Override
    public String getDescription() {
        
        return "Archivo.board";
    }
}