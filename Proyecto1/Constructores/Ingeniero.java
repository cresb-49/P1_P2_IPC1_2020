package Proyecto1.Constructores;
public class Ingeniero extends Constructores {
    /**
     * Constructor del constructor ingeniero
     */
    public Ingeniero(){
        super(1, 300, 200, "Star Destroyer");
    }
    /** 
     * Retorna el tipo de constructor
     * @return String
     */
    @Override
    public String tipoDeConstructor(){
        return "Ingeniero";
    }
    
    /** 
     * Retorna el consto de colocar a trabajar al constructor
     * @return int
     */
    @Override
    public int costoDeTrabajo()
    {
        return 100;
    }
}