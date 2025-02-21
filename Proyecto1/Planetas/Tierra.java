package Proyecto1.Planetas;
public class Tierra extends Planetas {
    /**
     * Constructor del planeta con atributos aleatorios
     * @param nombreDePlaneta
     */
    public Tierra(String nombreDePlaneta) {
        super(nombreDePlaneta, "Mole", 45, 15, 25, 50 , 100);
    }
    /**
     * Constructor del planeta on atributos estabelcidos
     * @param nombreDePlaneta   Nombre del planeta
     * @param fondosDelPaneta   Fondos monetarios del planeta
     * @param cantidadDeConstructores   Cantidad de contructores del planeta
     * @param cantidadDeGuerreros   Cantidad de guerreros del planeta
     * @param cantidadDeNaves   Cantidad de naves del planeta
     */
    public Tierra(String nombreDePlaneta,int fondosDelPaneta,int cantidadDeConstructores,int cantidadDeGuerreros,int cantidadDeNaves){
        super(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves, "Mole", 45, 15, 25, 50, 100);
    }
    
    /** 
     * Retorna el tiepo de planeta
     * @return String
     */
    @Override
    public String getTipoDePlaneta()
    {
        return "Tierra";
    }
}