package Proyecto1.Guerreros;
public class Guerreros {

    private String planetaAsociado;
    private double factorDeMuerte;
    private int espacioOcupadoEnNave;
    private double factorDeMuertePlaneta;
    private int cantidadDeLuchas;
    private boolean estadoDeJugador;

    /**
     * Constructor general de guerreros
     * @param planetaAsociado   Planeta Asociado
     * @param factorDeMuerte    Factor de muerte del planeta asociado
     * @param espacioOcupadoEnNave  Espacio que ocupa en una nave
     */

    public Guerreros(String planetaAsociado, double factorDeMuerte, int espacioOcupadoEnNave,double factorDeMuertePlaneta,int cantidadDeLuchas,boolean estadoDeJugador){
        this.planetaAsociado=planetaAsociado;
        this.factorDeMuerte=factorDeMuerte;
        this.espacioOcupadoEnNave=espacioOcupadoEnNave;
        this.factorDeMuertePlaneta=factorDeMuertePlaneta;
        this.cantidadDeLuchas=cantidadDeLuchas;
        this.estadoDeJugador=estadoDeJugador;
    }
    
    /** 
     * Retorna el estado del guerrero
     * @return boolean
     */
    public boolean getEstadoDeGuerrero(){
        return estadoDeJugador;
    }
    
    /** 
     * Setea el estado del guerrero
     * @param estado
     */
    private void setEstadoDeGuerrero(boolean estado){
        this.estadoDeJugador=estado;
    }
    
    /** 
     * Retorna los espacios que puede tener un guerrero en la nave
     * @return int
     */
    public int getEspaciosAOcupar(){
        return espacioOcupadoEnNave;
    }

    
    /** 
     * Retorna la veces que ah peleado un guerrero
     * @return int
     */
    public int getCantidadDeLuchas(){
        return this.cantidadDeLuchas;
    }
    /**
     * Seta la cantidad de lucha que puede hacer un guerrero
     */
    private void setCantidadDeLuchas(){
        this.cantidadDeLuchas=2;
    }
    /**
     * Modifica la cantidad de luchas que hace un guerrero
     */
    private void modificarCantidadDeLuchas(){
        this.cantidadDeLuchas++;
    }

    
    /** 
     * Retorna el factor de muerte del planeta de origen
     * @return double
     */
    public double getFactorDeMuertePlaneta()
    {
        return this.factorDeMuertePlaneta;
    }

    
    /** 
     * Retorna el factor de muetre del guerreo en si
     * @return double
     */
    public double getFactorDeMuerte()
    {
        return this.factorDeMuerte;
    }

    /** 
     * Retorna el tipo de guerrero que es
     * @return String
     */
    public String tipoDeGuerrero(){
        return "";
    }

    
    /** 
     * Ejecuta la lucha entre gurereros 
     * @param adversario    Variable de tipo Guerreros
     */
    public void luchar(Guerreros adversario){

        if((this.getFactorDeMuerte()*this.getFactorDeMuertePlaneta())>(adversario.getFactorDeMuertePlaneta()*adversario.getFactorDeMuerte())){
            this.modificarCantidadDeLuchas();
            adversario.setCantidadDeLuchas();
            adversario.setEstadoDeGuerrero(false);
            //Gana el guerrero que pelea
        }
        else
        {
            //Gana el adversario del giererro que ejecuta la accion
            this.setCantidadDeLuchas();
            this.setEstadoDeGuerrero(false);
            adversario.modificarCantidadDeLuchas();
        }
        //si la cantidad de luchas es de 2 los guerreros quedan inactivos
        if(this.getCantidadDeLuchas()==2){
            this.setEstadoDeGuerrero(false);
        }
        if(adversario.getCantidadDeLuchas()==2)
        {
            adversario.setEstadoDeGuerrero(false);
        }
    }
}