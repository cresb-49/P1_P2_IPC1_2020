package Proyecto1.Constructores;

public class Arquitecto extends Constructores {
    /**
     * Constructor del constructor arquitecto
     */
    public Arquitecto(){
        super(1, 250, 175, "Millenial Falcon");
    }
    /** 
     * Retorno del tipo de constructor
     * @return String
     */
    @Override
    public String tipoDeConstructor(){
        return "Arquitecto";
    }
    
    /** 
     * Costo de poner a trabajar al constructor
     * @return int
     */
    @Override
    public int costoDeTrabajo()
    {
        return 70;
    }
    
}