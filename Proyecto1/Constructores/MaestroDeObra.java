package Proyecto1.Constructores;
public class MaestroDeObra extends Constructores {
    /**
     * Constructor para el constructor maestro de obras
     */
    public MaestroDeObra(){
        super(2, 100, 70, "X-Wing");
    }
    
    /** 
     * Retorna el tipo de constructor
     * @return String
     */
    @Override
    public String tipoDeConstructor(){
        return "Maestro De Obra";
    }
    
    /** 
     * Retorna el costo de poner a trabajar el constructor
     * @return int
     */
    @Override
    public int costoDeTrabajo()
    {
        return 50;
    }
}