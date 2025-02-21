package Proyecto1.Planetas;
public class Organico extends Planetas {
    /**
     * Costructor de planeta con atributos aleatorio
     * @param nombreDePlaneta
     */
    public Organico(String nombreDePlaneta){
        super(nombreDePlaneta, "Groot", 10, 5, 15, 80 , 160);
    }
    /**
     * Constructor de planeta con atributos asignados
     * @param nombreDePlaneta   Nombre del planeta
     * @param fondosDelPaneta   Fondos monetarios del planeta
     * @param cantidadDeConstructores   Cantidad de constructores del planeta
     * @param cantidadDeGuerreros   Cantidad de guerreros del plantea
     * @param cantidadDeNaves   Cantidad de naves del planeta
     */
    public Organico(String nombreDePlaneta,int fondosDelPaneta,int cantidadDeConstructores,int cantidadDeGuerreros,int cantidadDeNaves){
        super(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves, "Groot", 10, 5, 15, 80 , 160);
    }
    
    /** 
     * Retorna el tipo de planeta
     * @return String
     */
    @Override
    public String getTipoDePlaneta()
    {
        return "Organico";
    }
}