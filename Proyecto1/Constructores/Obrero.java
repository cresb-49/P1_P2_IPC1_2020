package Proyecto1.Constructores;
public class Obrero extends Constructores {
    /**
     * Constructor para el constructor Obrero
     */
    public Obrero(){
        super(3, 50, 40, "Naboo N-1");
    }
    /** 
     * Retorna el tipo de cnstructor
     * @return String
     */
    @Override
    public String tipoDeConstructor(){
        return "Obrero";
    }
    
    /** 
     * Retorna el costo del trabajo del constructor
     * @return int
     */
    @Override
    public int costoDeTrabajo()
    {
        return 40;
    }
}