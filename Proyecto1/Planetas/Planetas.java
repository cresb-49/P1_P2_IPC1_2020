package Proyecto1.Planetas;
import java.util.*;
import Proyecto1.Guerreros.*;
import Proyecto1.Guerreros.*;
import Proyecto1.Naves.*;
import Proyecto1.Constructores.*;

public class Planetas{

    private String nombreDePlaneta;
    private String propietario="Neutral";
    private String gerreroProducido;
    private int probabilidadDeAparecer;
    private int limiteInferiorDeProduccionGerreros, limiteSuperiorDeProduccionGerreros;
    private int cantidadDeDineroProducidoInferior, cantidadDeDineroProducidoSuperior;
    private int fondosDelPlaneta;
    private double porcentajeDeMuerte;
    protected int numeroDeGuerreros=0;
    protected int numeroDeConstructores=0;
    protected int numeroDeNaves=0;
    private Guerreros[] guerrerosDisponibles;
    private Naves[] navesDisponibles;
    private Constructores[] constructoresDisponibles;


    /**
     * //Costructor para planetas aleatorios
     * @param nombreDePlaneta
     * @param gerreroProducido
     * @param probabilidadDeAparecer
     * @param limiteInferiorDeProduccionGerreros
     * @param limiteSuperiorDeProduccionGerreros
     * @param cantidadDeDineroProducidoInferior
     * @param cantidadDeDineroProducidoSuperior
     */
    public Planetas(String nombreDePlaneta, String gerreroProducido, int probabilidadDeAparecer, int limiteInferiorDeProduccionGerreros, int limiteSuperiorDeProduccionGerreros, int cantidadDeDineroProducidoInferior, int cantidadDeDineroProducidoSuperior){
        this.nombreDePlaneta=nombreDePlaneta;
        this.gerreroProducido=gerreroProducido;
        this.probabilidadDeAparecer=probabilidadDeAparecer;
        this.limiteInferiorDeProduccionGerreros=limiteInferiorDeProduccionGerreros;
        this.limiteSuperiorDeProduccionGerreros=limiteSuperiorDeProduccionGerreros;
        this.cantidadDeDineroProducidoInferior=cantidadDeDineroProducidoInferior;
        this.cantidadDeDineroProducidoSuperior=cantidadDeDineroProducidoSuperior;

        this.porcentajeDeMuerte=AsignacionDeCantidadesAleatorias(9999,1000,10000);
        this.fondosDelPlaneta=(int)AsignacionDeCantidadesAleatorias(500, 100, 1);
        this.generacionNaves((int)AsignacionDeCantidadesAleatorias(3, 1, 1),"Naboo N-1");
        this.generarGerreros(0,"Aleatorio");
        this.generarConstructores(1,"Obrero");
    }
    /**
     * //constructor para planetas con atributos
     * @param nombreDePlaneta
     * @param fondosDelPaneta
     * @param cantidadDeConstructores
     * @param cantidadDeGuerreros
     * @param cantidadDeNaves
     * @param gerreroProducido
     * @param probabilidadDeAparecer
     * @param limiteInferiorDeProduccionGerreros
     * @param limiteSuperiorDeProduccionGerreros
     * @param cantidadDeDineroProducidoInferior
     * @param cantidadDeDineroProducidoSuperior
     */
    public Planetas(String nombreDePlaneta,int fondosDelPaneta,int cantidadDeConstructores,int cantidadDeGuerreros,int cantidadDeNaves, String gerreroProducido, int probabilidadDeAparecer, int limiteInferiorDeProduccionGerreros, int limiteSuperiorDeProduccionGerreros, int cantidadDeDineroProducidoInferior, int cantidadDeDineroProducidoSuperior){
        this.nombreDePlaneta=nombreDePlaneta;
        this.porcentajeDeMuerte=AsignacionDeCantidadesAleatorias(9999,1000,10000);
        this.fondosDelPlaneta=fondosDelPaneta;
        this.generarConstructores(cantidadDeConstructores,"Obrero");
        this.generacionNaves(cantidadDeNaves,"Naboo N-1");
        this.generarGerreros(cantidadDeGuerreros,"Selectivo");

        this.gerreroProducido=gerreroProducido;
        this.probabilidadDeAparecer=probabilidadDeAparecer;
        this.limiteInferiorDeProduccionGerreros=limiteInferiorDeProduccionGerreros;
        this.limiteSuperiorDeProduccionGerreros=limiteSuperiorDeProduccionGerreros;
        this.cantidadDeDineroProducidoInferior=cantidadDeDineroProducidoInferior;
        this.cantidadDeDineroProducidoSuperior=cantidadDeDineroProducidoSuperior;
    }
    
    /** 
     * Regresa el tipo de plantea que se genera
     * @return String
     */
    public String getTipoDePlaneta()
    {
        return " ";
    }
    
    /** 
     * Regresa los fondos monetarios del planeta
     * @return int
     */
    public int getFondosDelPlaneta() {
        return fondosDelPlaneta;
    }
    
    
    /** 
     * Setea los constructores del planeta
     * @param Constructores[]temporalConstructores
     * @param numeroDeConstructores
     */
    public void setCantidadDeConstructores(Constructores[]temporalConstructores,int numeroDeConstructores)
    {
        this.constructoresDisponibles=temporalConstructores;
        this.numeroDeConstructores=numeroDeConstructores;
    }
    
    /** 
     * setea las naves del planeta
     * @param Naves[]temporalNaves
     * @param numeroDeNaves
     */
    public void setCantidadDeNaves(Naves[]temporalNaves,int numeroDeNaves)
    {
        this.navesDisponibles=temporalNaves;
        this.numeroDeNaves=numeroDeNaves;
    }
    
    /** 
     * Setea los fondos del planeta
     * @param fondosDelPlaneta
     */
    public void setFondosDelPlaneta(int fondosDelPlaneta){
        this.fondosDelPlaneta=fondosDelPlaneta;
    }
    
    
    /** 
     * Funcion que admintra todas las cantidades aleatorias de los planetas
     * @param max
     * @param min
     * @param asignarTantoPorCiento
     * @return double
     */
    private static double AsignacionDeCantidadesAleatorias(int max,int min,int asignarTantoPorCiento){
        double resultado=0;
        double intervalo = Math.floor(Math.random()*(max-min+1)+min);
        resultado=intervalo/asignarTantoPorCiento;
        return resultado;
    }
    /**
     * Funcion que geneta las cantidades numericas de un planeta dependiendo del tipo de planeta
     */
    public void produccionDeDineroFinalizacionDeTurno(){

        int fondos = this.fondosDelPlaneta;
        int fondosProducidos=0;
        if(this instanceof Tierra){
            fondosProducidos=(int)AsignacionDeCantidadesAleatorias(this.cantidadDeDineroProducidoSuperior, this.cantidadDeDineroProducidoInferior,1);
        }
        if(this instanceof Agua){
            fondosProducidos=(int)AsignacionDeCantidadesAleatorias(this.cantidadDeDineroProducidoSuperior, this.cantidadDeDineroProducidoInferior, 1);
        }
        if(this instanceof Fuego){
            fondosProducidos=(int)AsignacionDeCantidadesAleatorias(this.cantidadDeDineroProducidoSuperior, this.cantidadDeDineroProducidoInferior, 1);
        }
        if(this instanceof Organico){
            fondosProducidos=(int)AsignacionDeCantidadesAleatorias(this.cantidadDeDineroProducidoSuperior, this.cantidadDeDineroProducidoInferior, 1);
        }
        if(this instanceof Radioactivo){
            fondosProducidos=(int)AsignacionDeCantidadesAleatorias(this.cantidadDeDineroProducidoSuperior, this.cantidadDeDineroProducidoInferior, 1);
        }
        this.fondosDelPlaneta=fondos+fondosProducidos;
    }
    
    /** 
     * generacion de un solo guerrero 
     * @param tipoDeGuerreroAGenerar
     * @return Guerreros
     */
    public Guerreros generarGerreroTemporal(String tipoDeGuerreroAGenerar){
        Guerreros temporal=null;
        tipoDeGuerreroAGenerar=tipoDeGuerreroAGenerar.toLowerCase();
        if(tipoDeGuerreroAGenerar.equals("mole")){
            temporal=new Mole(0);
        }
        if(tipoDeGuerreroAGenerar.equals("nemo")){
            temporal=new Nemo(0);
        }
        if(tipoDeGuerreroAGenerar.equals("magma")){
            temporal=new Magma(0);
        }
        if(tipoDeGuerreroAGenerar.equals("groot")){
            temporal=new Groot(0);
        }
        if(tipoDeGuerreroAGenerar.equals("fision guy")){
            temporal=new FisionGuy(0);
        }
        return temporal;

    }
    
    /** 
     * Generamos guerreros, para un planeta depndiendo de su factor de generacion
     * @param guerrerosAGenerar
     * @param tipoDeGeneracion
     */
    public void generarGerreros(int guerrerosAGenerar,String tipoDeGeneracion){
        //si es de forma aleatria se generan los guerreos de foma en lo establecen los planetas
        if(tipoDeGeneracion.equals("Aleatorio")){
            guerrerosAGenerar=(int)AsignacionDeCantidadesAleatorias(this.limiteSuperiorDeProduccionGerreros,this.limiteInferiorDeProduccionGerreros, 1);
        }
        int cantidadInicalDeGuerreros=this.numeroDeGuerreros;
        Guerreros[] temporal= new Guerreros[guerrerosAGenerar+cantidadInicalDeGuerreros];
        //detectamos si anteriormente habia guerreros en el planta y los guardamos y generamos los nuevos
        if(cantidadInicalDeGuerreros>0){
            for (int i = 0; i < guerrerosDisponibles.length; i++) {
                temporal[i]=guerrerosDisponibles[i];
            }
        }
        if(this instanceof Tierra){
            for (int i = cantidadInicalDeGuerreros; i < (guerrerosAGenerar+cantidadInicalDeGuerreros); i++) {
                temporal[i]=new Mole(this.porcentajeDeMuerte);
                this.numeroDeGuerreros++;
            }
        }
        if(this instanceof Agua){
           
            for (int i = cantidadInicalDeGuerreros; i < (guerrerosAGenerar+cantidadInicalDeGuerreros); i++) {
                temporal[i]=new Nemo(this.porcentajeDeMuerte);
                this.numeroDeGuerreros++;
            }
        }
        if(this instanceof Fuego){
            
            for (int i = cantidadInicalDeGuerreros; i < (guerrerosAGenerar+cantidadInicalDeGuerreros); i++) {
                temporal[i]=new Magma(this.porcentajeDeMuerte);
                this.numeroDeGuerreros++;
            }
        }
        if(this instanceof Organico){
            
            for (int i = cantidadInicalDeGuerreros; i < (guerrerosAGenerar+cantidadInicalDeGuerreros); i++) {
                temporal[i]=new Groot(this.porcentajeDeMuerte);
                this.numeroDeGuerreros++;
            }
        }
        if(this instanceof Radioactivo){
            
            for (int i = cantidadInicalDeGuerreros; i < (guerrerosAGenerar+cantidadInicalDeGuerreros); i++) {
                temporal[i]=new FisionGuy(this.porcentajeDeMuerte);
                this.numeroDeGuerreros++;
            }
        }
        this.guerrerosDisponibles=temporal;
    }

    
    /** 
     * Generacion de una sola nave 
     * @param tipoDeNave
     * @return Naves
     */
    public Naves generacionNavesTemporal(String tipoDeNave){
        
        Naves temporal=null;
        tipoDeNave=tipoDeNave.toLowerCase();

        if(tipoDeNave.equals("naboo n-1")){
            temporal= new Naboo();
            
        }

        if(tipoDeNave.equals("x-wing")){
            temporal= new XWing();
            
        }

        if(tipoDeNave.equals("millenial falcon")){
            temporal= new MillenialFalcon();
            
        }

        if(tipoDeNave.equals("star destroyer")){
            temporal= new StarDestroyer();
            
        }
        return temporal;
    }

    
    /** 
     * Gueneracion de naves dependiendo la forma en que se genera el planeta
     * @param cantidadDeNaves
     * @param tipoDeNave
     */
    public void generacionNaves(int cantidadDeNaves, String tipoDeNave){
        int cantidadInicalDeNaves=this.numeroDeNaves;
        Naves [] temporal= new Naves[cantidadDeNaves+cantidadInicalDeNaves];
        //Guardamos las naves ateriores y genramos la nuevas
        if(cantidadInicalDeNaves>0){
            for (int i = 0; i < this.navesDisponibles.length; i++) {
                temporal[i]=this.navesDisponibles[i];
            }
        }

        if(tipoDeNave.equals("Naboo N-1")){
            for (int i = cantidadInicalDeNaves; i < (cantidadDeNaves+cantidadInicalDeNaves); i++) {
                temporal[i]= new Naboo();
                this.numeroDeNaves++;
            }
        }

        if(tipoDeNave.equals("X-Wing")){
            for (int i = cantidadInicalDeNaves; i < (cantidadDeNaves+cantidadInicalDeNaves); i++) {
                temporal[i]= new XWing();
                this.numeroDeNaves++;         
            }
        }

        if(tipoDeNave.equals("Millenial Falcon")){
            for (int i = cantidadInicalDeNaves; i < (cantidadDeNaves+cantidadInicalDeNaves); i++) {
                temporal[i]= new MillenialFalcon();
                this.numeroDeNaves++;     
            }
        }

        if(tipoDeNave.equals("Star Destroyer")){
            for (int i = cantidadInicalDeNaves; i < (cantidadDeNaves+cantidadInicalDeNaves); i++) {
                temporal[i]= new StarDestroyer();
                this.numeroDeNaves++;        
            }
        }
        this.navesDisponibles=temporal;
    }

    
    /** 
     * Generacion de contructor dependiendo de los paramtros de creacion del planeta 
     * @param cantidadDeConstructores
     * @param tipoDeConstructor
     */
    public void generarConstructores(int cantidadDeConstructores, String tipoDeConstructor){
        int cantidadInicalDeConstructores=this.numeroDeConstructores;
        Constructores[] temporal= new Constructores[cantidadInicalDeConstructores+cantidadDeConstructores];    
        //Guardmos los cosntrucoteres anteriores y genramos lo nuevos
        if(cantidadInicalDeConstructores>0){
            for (int i = 0; i < constructoresDisponibles.length; i++) {
                temporal[i]=constructoresDisponibles[i];
            }
        }

        if(tipoDeConstructor.equals("Obrero")){
            for (int i = cantidadInicalDeConstructores; i < (cantidadDeConstructores+cantidadInicalDeConstructores); i++) {
                temporal[i]= new Obrero();
                this.numeroDeConstructores++;        
            }
        }
        if(tipoDeConstructor.equals("Maestro De Obras")){
            for (int i = cantidadInicalDeConstructores; i < (cantidadDeConstructores+cantidadInicalDeConstructores); i++) {
                temporal[i]= new MaestroDeObra();
                this.numeroDeConstructores++;        
            }
        }
        if(tipoDeConstructor.equals("Arquitecto")){
            for (int i = cantidadInicalDeConstructores; i < (cantidadDeConstructores+cantidadInicalDeConstructores); i++) {
                temporal[i]= new Arquitecto();
                this.numeroDeConstructores++;        
            }
        }
        if(tipoDeConstructor.equals("Ingeniero")){
            for (int i = cantidadInicalDeConstructores; i < (cantidadDeConstructores+cantidadInicalDeConstructores); i++) {
                temporal[i]= new Ingeniero();
                this.numeroDeConstructores++;        
            }
        }
        constructoresDisponibles=temporal;
    }

    
    /** 
     * Regreso del nombre del propietario
     * @return String
     */
    public String getPropietario(){
        return this.propietario;
    }
    
    /** 
     * seteo del propietario del planeta
     * @param nuevoPropietario
     */
    public void setPropieratio(String nuevoPropietario){
        this.propietario=nuevoPropietario;
    }
    
    /** 
     * regreso del nombre del planeta
     * @return String
     */
    public String getNombreDePlaneta(){
        return nombreDePlaneta;
    }
    /**
     * Funcion que imprime la caracteristicas del planeta
     */
    public void mostrarCarcteristicasDelPlaneta(){
        System.out.println("- Nombre del Planeta: "+this.nombreDePlaneta);
        System.out.println("- Tipo de Planeta: "+this.getTipoDePlaneta());
        System.out.println("- Porcentaje de muerte: "+this.porcentajeDeMuerte);
        System.out.print("- Estado del planeta: ");
        if(this.getPropietario()=="Neutral")
        {
            System.out.println(this.getPropietario());
        }
        else{
            System.out.println("Consquistado");
        }
        System.out.println("- Fondos Monetarios del planeta: "+this.fondosDelPlaneta);
        
        System.out.println("- Numero de Constructores: "+this.numeroDeConstructores);
        System.out.print("    ");
        for (int i = 0; i < constructoresDisponibles.length; i++) {
            System.out.print(constructoresDisponibles[i].tipoDeConstructor()+", ");            
        }
        System.out.println("");
        System.out.println("- Numero de Naves: "+this.numeroDeNaves);
        System.out.print("    ");
        for (int i = 0; i < this.navesDisponibles.length; i++) {
            if(this.navesDisponibles[i]==null){
                System.out.print("null, ");                
            }
            else
            {
                
                System.out.print(this.navesDisponibles[i].tipoDeNave()+", ");            
            }
        }
        System.out.println("");
        System.out.println("- Numero de Guerreros: "+this.numeroDeGuerreros);
        System.out.print("    ");
        for (int i = 0; i < guerrerosDisponibles.length; i++) {
            System.out.print(guerrerosDisponibles[i].tipoDeGuerrero()+", ");            
        }
        System.out.println("");
    }
    
    /** 
     * Regreso de los constructores del planeta 
     * @return Constructores[]
     */
    public Constructores[] getConstructores()
    {
        return constructoresDisponibles;
    }

    
    /** 
     * Regreso de los guerreros del planeta
     * @return Guerreros[]
     */
    public Guerreros[] getGuerreros()
    {
        return this.guerrerosDisponibles;
    }
    
    /** 
     * seteo de los guerreros del planeta
     * @param nuevoGuerreros
     * @param cantidaGuerrerosNuevos
     */
    public void setGuerreros(Guerreros[] nuevoGuerreros,int cantidaGuerrerosNuevos)
    {
        this.guerrerosDisponibles=nuevoGuerreros;
        this.numeroDeGuerreros=cantidaGuerrerosNuevos;
    }

    
    /** 
     * Verifiacro de exitencia de construtores
     * @param constructor
     * @return boolean
     */
    public boolean verificadorDeConstructor(String constructor){
        boolean respuesta=false;
        for (int i = 0; i < constructoresDisponibles.length; i++) {
            if(constructoresDisponibles[i].tipoDeConstructor().toLowerCase().equals(constructor.toLowerCase())){
                respuesta=true;
                break;
            }
        }
        return respuesta;
    }

    
    /** 
     * verificador de naves del planeta
     * @param nave
     * @return boolean
     */
    public boolean verificadorDeNave(String nave){
        boolean respuesta=false;
        for (int i = 0; i < navesDisponibles.length; i++) {
            if(navesDisponibles[i]!=null)
            {
                if(navesDisponibles[i].tipoDeNave().toLowerCase().equals(nave.toLowerCase())){
                    respuesta=true;
                    break;
                }
            }
        }
        return respuesta;
    }

    
    /** 
     * Verificador de guerreros del planeta
     * @param guerrero
     * @return boolean
     */
    public boolean verificadorDeGuerrero(String guerrero){
        boolean respuesta=false;
        for (int i = 0; i < guerrerosDisponibles.length; i++) {
            if(guerrerosDisponibles[i].tipoDeGuerrero().toLowerCase().equals(guerrero.toLowerCase())){
                respuesta=true;
                break;
            }
        }
        return respuesta;
    }
    
    /** 
     * Regresar la cnatidad de guerreros de una clase del planeta
     * @param guerrero
     * @return int
     */
    public int cantidadDeGuerrerosUnaClase(String guerrero){
        int respuesta=0;
        for (int i = 0; i < guerrerosDisponibles.length; i++) {
            if(guerrerosDisponibles[i].tipoDeGuerrero().toLowerCase().equals(guerrero.toLowerCase())){
                respuesta++;
                break;
            }
        }
        return respuesta;
    }
    

    /**
     * Carga nave y regresa un objeto de tipo nave
     * @param tipoDeGuerero
     * @param CantidadDeGuerrerosACargar
     * @param tipoDeNave
     * @return
     */
    public Naves selecccionaryCargar(String tipoDeGuerrero,int CantidadDeGuerrerosACargar,String tipoDeNave,double distanciaEntrePlanetas){
        //Seleccionamos un nave del tipo que escribimos anteriormente
        Naves Navetemporal=null;
        for (int i = 0; i < this.navesDisponibles.length; i++) {
            if(navesDisponibles[i]!=null){
                if(navesDisponibles[i].tipoDeNave().toLowerCase().equals(tipoDeNave.toLowerCase()))
                {
                    Navetemporal=navesDisponibles[i];
                    navesDisponibles[i]=null;
                    break;
                }
            }
        }  
        //Substremos los guerreroa a cargar en el planeta 
        Guerreros[] guerrerosACargar=new Guerreros[CantidadDeGuerrerosACargar];
        int j=0;
        for (int j2 = 0; j2 < this.guerrerosDisponibles.length; j2++) {
            
            if(this.guerrerosDisponibles[j2].tipoDeGuerrero().toLowerCase().equals(tipoDeGuerrero.toLowerCase()))
            {
                
                guerrerosACargar[j]=this.guerrerosDisponibles[j2];
                this.guerrerosDisponibles[j2]=null;
                j++;
                if(j==CantidadDeGuerrerosACargar)
                {
                    break;
                }
            }
        }
        //cargamos la nave con los guerreros
        Navetemporal.cargarNave(guerrerosACargar);
        j=0;
        for (int i = 0; i < this.guerrerosDisponibles.length; i++) {
            if(this.guerrerosDisponibles[i]!=null)
            {
                j++;
            }
        }
        //ordenamos lo guerreros restantes dl planeta y los establecemos como los disponibles del mismo
        Guerreros[] guerrerosRestantes=new Guerreros[j];
        this.numeroDeGuerreros=j;
        j=0;
        for (int i = 0; i < this.guerrerosDisponibles.length; i++) {
            if(this.guerrerosDisponibles[i]!=null)
            {
                guerrerosRestantes[j]=this.guerrerosDisponibles[i];
                j++;
            }
        }
        this.guerrerosDisponibles=guerrerosRestantes;
        return Navetemporal;
    }
    
    /** 
     * Funcion qeu recibe nave aliada
     * @param naveArrivada
     */
    public void recibirGuerreros(Naves naveArrivada){
        System.out.println("lOS GUERREROS LLEGARON A PLANETA ALIADO\n");
        Guerreros[] guerrerosAliados=naveArrivada.descargarGuerreros();
        Guerreros[] guerrerosLocales=this.guerrerosDisponibles;
        int nuevaCantidadDeGuerreros=guerrerosAliados.length+this.numeroDeGuerreros;
        //creamos un arreglo del tamaño de los guerreos del plante y los guerreros que llegan
        Guerreros[] nuevosGuerrerosDelPlaneta=new Guerreros[nuevaCantidadDeGuerreros];
        int lugares=0;
        //Guardso los guerreros en los espacios del nuevo arreglo
        for (int i = 0; i < guerrerosAliados.length; i++) {
            nuevosGuerrerosDelPlaneta[lugares]=guerrerosAliados[i];
            lugares++;
        }
        for (int i = 0; i < guerrerosLocales.length; i++) {
            nuevosGuerrerosDelPlaneta[lugares]=guerrerosLocales[i];
            lugares++;
        }
        //ingresamos los nuevos guerreros al arreglo del planeta
        this.setGuerreros(nuevosGuerrerosDelPlaneta, nuevaCantidadDeGuerreros);
        System.out.println("LOS GUERREROS SE HAN UNIDO A LAS FILAS DEL PLANETA\n");

    }

    
    /** 
     * Funcion si se realiza una pelea dentro del planeta
     * @param naveArrivada
     * @param jugador
     */
    public void enfrentaiento(Naves naveArrivada,String jugador){
        Guerreros[] guerrerosEnemigos=naveArrivada.descargarGuerreros();
        Guerreros[] guerrerosLocales=this.guerrerosDisponibles;
        this.guerrerosDisponibles=null;
        
        System.out.println("COMENZO LA PELEA!!!!!");
        System.out.println("Enemigos "+cantidadDeSoldados(guerrerosEnemigos));
        System.out.println("Locales  "+cantidadDeSoldados(guerrerosLocales));
        int enemigos=0;
        int locales=0;
        //Enfentameindo de los guerreros hasta que no haya guerreros vivos, funcion complemetada con las acciones de los guerreros en el archivo Guerreros.java
        do {
            boolean enemigo=guerrerosEnemigos[enemigos].getEstadoDeGuerrero();
            boolean local=guerrerosLocales[locales].getEstadoDeGuerrero();

            if(enemigo==true&&local==true){
                guerrerosEnemigos[enemigos].luchar(guerrerosLocales[locales]);
            }
            else
            {
                if(enemigo==false){
                    enemigos++;
                }
                if(local==false){
     
                    locales++;
                }
                if(enemigos==guerrerosEnemigos.length){
                    enemigos=0;
                }
                if(locales==guerrerosLocales.length)
                {
                    locales=0;
                }
            }

        } while (estadoDeEjercito(guerrerosEnemigos)==true&&estadoDeEjercito(guerrerosLocales)==true);
   

        System.out.println("Termino la Pelea!!!!!\n");
        System.out.println("Enemigos Sobrevivientes: "+cantidadDeSoldados(guerrerosEnemigos));
        System.out.println("Locales Sobrevivientes: "+cantidadDeSoldados(guerrerosLocales)+"\n");
        //Comparacion de la cantidad de guerreros vivos del planeta
        if(cantidadDeSoldados(guerrerosEnemigos)>cantidadDeSoldados(guerrerosLocales)){
            System.out.println("Gano el ejercito del jugador: "+jugador);
            this.setPropieratio(jugador);
            Guerreros[] tempGuerreros=recuperarGuerreros(guerrerosEnemigos);
            int cantidadDeGuerreros=tempGuerreros.length;
            this.setGuerreros(tempGuerreros,cantidadDeGuerreros);
        }
        else
        {
            if(this.getPropietario().equals("Neutral")){
                System.out.println("El planeta todavia es neutral");
            }
            else{
                System.out.println("Gano el ejercito del jugador: "+this.getPropietario());
            }
            Guerreros[] tempGuerreros=recuperarGuerreros(guerrerosLocales);
            int cantidadDeGuerreros=tempGuerreros.length;
            this.setGuerreros(tempGuerreros,cantidadDeGuerreros);
        }
   }

   
   /** 
    * Regresamos el estado en conjutno de todo el ejercito
    * @param ejercitoGuerreros
    * @return boolean
    */
   private static boolean estadoDeEjercito(Guerreros [] ejercitoGuerreros){
        boolean resultado=false;
        for (int i = 0; i < ejercitoGuerreros.length; i++) {
            if(ejercitoGuerreros[i].getCantidadDeLuchas()>=0&&ejercitoGuerreros[i].getCantidadDeLuchas()<2)
            {
                resultado=true;
            }
        }
        return resultado;
   }

   
   /** 
    * Regresamos la cantida de soldados activos
    * @param soldados
    * @return int
    */
   private static int cantidadDeSoldados(Guerreros[] soldados){

       int cantidad=0;
       for (int i = 0; i < soldados.length; i++) {
            if(soldados[i].getEstadoDeGuerrero()){
                cantidad++;
            }
       }
       return  cantidad;
   }
   
   
   /** 
    * Funcion que clasifica por medio de la caracteristicas de los guerreros quienes estan vivos a muertos
    * @param ejercito
    * @return Guerreros[]
    */
   private static Guerreros[] recuperarGuerreros(Guerreros[] ejercito){
        Guerreros[]temporal=null;
        int disponibles=0;
        //contamos los guerreros vivos 
        for (int i = 0; i < ejercito.length; i++) {
            if(ejercito[i].getEstadoDeGuerrero()){
                disponibles++;
            }
        }
        // generamos array par los soldados vivos
        Guerreros[]temporal2=new Guerreros[disponibles];
        disponibles=0;
        for (int i = 0; i < ejercito.length; i++) {
            if(ejercito[i].getEstadoDeGuerrero()){
                temporal2[disponibles]=ejercito[i];
                disponibles++;
            }
        }
        temporal=temporal2;
        return temporal;
   }

   
   /** 
    * Retronamos las naves del planeta 
    * @return Naves[]
    */
   public Naves[] getNaves(){
       return navesDisponibles;
   }
   
   /** 
    * seteamos las naves que hay en el planeta
    * @param navesDisponibles
    */
   public void setNaves(Naves[] navesDisponibles)
   {
       this.navesDisponibles=navesDisponibles;
   }
}