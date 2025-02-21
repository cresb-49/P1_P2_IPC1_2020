package Proyecto1.Guerreros;
public class Nemo extends Guerreros {
    /**
     * Constructor para el guerrero Nemo
     * @param factorDeMuertePlaneta Factor de muerte del planeta de origen
     */
    public Nemo(double factorDeMuertePlaneta){
        super("Agua", 1.6, 1,factorDeMuertePlaneta,0,true);
    }
    
    /** 
     * Retorna el tipo de guerrero
     * @return String
     */
    @Override
    public String tipoDeGuerrero(){
        return "Nemo";
    }
}