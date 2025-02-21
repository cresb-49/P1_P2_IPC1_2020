package Proyecto1.Planetas;
public class Fuego extends Planetas {
    /**
     * Constructor del planeta de forma aleatoria aleatorio
     * @param nombreDePlaneta
     */
    public Fuego(String nombreDePlaneta){
        super(nombreDePlaneta, "Magma", 15, 10, 20, 70 , 140);
    }
    /**
     * Constructor del planeta de forma que contenga atributos espesificados
     * @param nombreDePlaneta   Nombre del planeta
     * @param fondosDelPaneta   Fondos monetarios del planeta
     * @param cantidadDeConstructores   Cantidad de constructores del planeta
     * @param cantidadDeGuerreros   Cantidad de guerreros del planeta
     * @param cantidadDeNaves   Catnidad de naves del planeta
     */
    public Fuego(String nombreDePlaneta,int fondosDelPaneta,int cantidadDeConstructores,int cantidadDeGuerreros,int cantidadDeNaves){
        super(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves, "Magma", 15, 10, 20, 70 , 140);
    }
    
    /** 
     * Retorna el tipo de planeta
     * @return String
     */
    @Override
    public String getTipoDePlaneta()
    {
        return "Fuego";
    }
}