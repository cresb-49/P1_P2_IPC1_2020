package com.carlos.proyecto2.Excepciones;

public class ObjectNotSerializableExeption extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 9057148148260990344L;

    public ObjectNotSerializableExeption() {
        super("El objeto no aplica a Serealizacion");
    }
}