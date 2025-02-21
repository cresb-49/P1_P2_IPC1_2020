package Proyecto1.Naves;
public class MillenialFalcon extends Naves {
    /**
     * Constructor de la nave Millenial Falcon
     */
    public MillenialFalcon(){
        super(58, 1.5, 70, "Arquitecto");
    }
    /** 
     * Retorna el tipo de nave
     * @return String
     */
    @Override
    public String tipoDeNave(){
        return "Millenial Falcon";
    }
}