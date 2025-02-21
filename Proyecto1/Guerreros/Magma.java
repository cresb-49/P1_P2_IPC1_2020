package Proyecto1.Guerreros;
public class Magma extends Guerreros {
    /**
     * Constructor del Guerrero Magma
     * @param factorDeMuertePlaneta Factor de muerte de su planeta de origen
     */
    public Magma(double factorDeMuertePlaneta){
        super("Fuego", 1.75, 2,factorDeMuertePlaneta,0,true);
    }
    /** 
     * Retorna el tipo de guerrero
     * @return String
     */
    @Override
    public String tipoDeGuerrero(){
        return "Magma";
    }
}