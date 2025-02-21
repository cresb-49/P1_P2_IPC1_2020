package Proyecto1.Naves;
public class Naboo extends Naves {
    /**
     * Constructor par al anave Naboo N-1
     */
    public Naboo(){
        super(25, 1, 40, "Obrero");
    }
    /** 
     * Retorna el tipo de nave
     * @return String
     */
    @Override
    public String tipoDeNave(){
        return "Naboo N-1";
    }
}