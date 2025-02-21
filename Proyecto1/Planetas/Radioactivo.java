package Proyecto1.Planetas;
public class Radioactivo extends Planetas {
    /**
     * Constructor para el planeta con atributos aleatorio
     * @param nombreDePlaneta
     */
    public Radioactivo(String nombreDePlaneta){
        super(nombreDePlaneta,"Fision Guy", 5, 3, 9, 90 , 180);
    }
    /**
     * Constructor para el planeta con parametros
     * @param nombreDePlaneta
     * @param fondosDelPaneta
     * @param cantidadDeConstructores
     * @param cantidadDeGuerreros
     * @param cantidadDeNaves
     */
    public Radioactivo(String nombreDePlaneta,int fondosDelPaneta,int cantidadDeConstructores,int cantidadDeGuerreros,int cantidadDeNaves){
        super(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves, "Fision Guy", 5, 3, 9, 90 , 180);
    }
    
    /** 
     * Retorna el tipo de Planeta
     * @return String
     */
    @Override
    public String getTipoDePlaneta()
    {
        return "Radioactivo";
    }
}