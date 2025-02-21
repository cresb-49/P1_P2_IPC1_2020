package Proyecto1.Guerreros;

public class FisionGuy extends Guerreros {
    /**
     * Constructor del Guerrero con sus estados iniciales
     */
    public FisionGuy(double factorDeMuertePlaneta){
        super("Radioactivo", 1.95, 4,factorDeMuertePlaneta,0,true);
    }
   
    /** 
     * Retorna el tipo de guerrero
     * @return String
     */
    @Override
    public String tipoDeGuerrero(){
        return "Fision Guy";
    }
}