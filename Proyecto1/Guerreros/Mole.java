package Proyecto1.Guerreros;
public class Mole extends Guerreros {
    /**
     * Constructor del Guerrero Mole
     * @param factorDeMuertePlaneta Factor de muerte de su planeta de origen
     */
    public Mole(double factorDeMuertePlaneta){
        super("Tierra", 1.5, 1,factorDeMuertePlaneta,0,true);
    }
    /** 
     * Retorna el tipo de Guerrero
     * @return String
     */
    @Override
    public String tipoDeGuerrero(){
        return "Mole";
    }
}