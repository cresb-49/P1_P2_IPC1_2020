package Proyecto1.Naves;
public class StarDestroyer extends Naves {
    /**
     * Cosntructor de la nave Star Destroyer
     */
    public StarDestroyer(){
        super(80, 1.75, 100, "Arquitecto");
    }
    /** 
     * Retorna el tipo de nave
     * @return String
     */
    @Override
    public String tipoDeNave(){
        return "Star Destroyer";
    }
}