package Proyecto1.Naves;
public class XWing extends Naves {
    /**
     * Constructor para la nave X Wing
     */
    public XWing(){
        super(42, 1.25, 50, "Maestro De Obra");
    }
    /** 
     * Retorna el tipo de Nave
     * @return String
     */
    @Override
    public String tipoDeNave(){
        return "X-Wing";
    }
}