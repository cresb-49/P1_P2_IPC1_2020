package Proyecto1.Guerreros;
public class Groot extends Guerreros {
     /**
     * Constructor del Guerrero con sus estados iniciales
     */
    public Groot(double factorDeMuertePlaneta){
        super("Organico", 1.85, 3,factorDeMuertePlaneta,0,true);
    }
    /** 
     * Retorna el tipo de guerrero
     * @return String
     */
    @Override
    public String tipoDeGuerrero(){
        return "Groot";
    }
}