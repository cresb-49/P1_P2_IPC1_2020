package Proyecto1.Planetas;
public class Agua extends Planetas {
    /**
     * Constructor Aleatorio
     * @param nombreDePlaneta
     */
    public Agua(String nombreDePlaneta){
        super(nombreDePlaneta, "Nemo", 25, 12, 23, 60 , 120);
    }
    /**
     * Constructor con Atributos
     * @param nombreDePlaneta   Nombre del planeta a generar
     * @param fondosDelPaneta   Fondos monetarios del planeta
     * @param cantidadDeConstructores   Cantidad de constructores del planeta
     * @param cantidadDeGuerreros   Cantidad de guerreros del planeta
     * @param cantidadDeNaves   Cantidad de naves del planeta
     */
    public Agua(String nombreDePlaneta,int fondosDelPaneta,int cantidadDeConstructores,int cantidadDeGuerreros,int cantidadDeNaves){
        super(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves, "Nemo", 25, 12, 23, 60 , 120);
    }
    
    /** 
     * Retorno del tipo del planeta
     * @return String
     */
    @Override
    public String getTipoDePlaneta()
    {
        return "Agua";
    }
}