package Proyecto1.Tablero;


import java.util.*;
import Proyecto1.Planetas.*;
public class Tablero {

    private Planetas[] planetasDelTablero;
    private int cantidadDePlanetas=0;
    private static String[] NombresPrestablecidos={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private static int nombresUsados=0;
    private Planetas[][] TableroDeJuego;
    private int dimencionFilas=0;
    private int dimencionColumnas=0;
    private String nombreDeJugador1;
    private String nombreDeJugador2;
    
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    public static final String ANSI_RESET = "\u001B[0m";

    public Tablero(){
        //**---Constructor Vacio */
    }

    
    /** 
     * Enviamos el tamaño de las filas del tablero
     * @return int
     */
    public int getDimencionFilas(){
        return this.dimencionFilas;
    }

    
    /** 
     * Enviamos el tamaño de la columnas del tablero
     * @return int
     */
    public int getDimencionColumnas(){
        return this.dimencionColumnas;
    }
    
    
    /** 
     * Enviamos el array que contiene los planetas
     * @return Planetas[]
     */
    public Planetas[] getPlanetasDelTablero(){
        return this.planetasDelTablero;
    }

    
    /** 
     * Enviamos La matriz donde se encuntran los planetas
     * @return Planetas[][]
     */
    public Planetas[][] getTableroDeJuego(){
        return this.TableroDeJuego;
    }

    
    /** 
     * Generamos Plantas y les damos atributos
     * @param nombreJugador1    Nombre de jugador 1
     * @param nombreJugador2    Nombre de jugador 2
     */
    public void GenerarTableroInicial(String nombreJugador1, String nombreJugador2){
        Scanner teclado =new Scanner(System.in);
        this.nombreDeJugador1=nombreJugador1;
        this.nombreDeJugador2=nombreJugador2;

        int cantidadDePlanteasNeutrales=0;
        int columnas=0;
        int filas=0;

        boolean condition=true;
        boolean repeticionCicloPrincipal=true;
        //ciclo donde se piden los atributos y verificamos que la intruccion de informacion sea correcta
        do {
            System.out.println("MENU DE OPCION DE MAPA");
            System.out.println("Ingrese el numero de filas y columunas del mapa");
            System.out.print("Ingrese Filas: ");
            //comprueba e ingresa la cantidad de filas
            do {
                try {
                    filas=Integer.parseInt(teclado.nextLine());
                    condition=false;
                } catch (Exception e) {
                    //TODO: handle exception
                    condition=true;
                }    
            } while (condition);
            System.out.print("Ingrese Columnas: ");
            condition=true;
            //comprueba e ingresa la cantida de columnas
            do {
                try {
                    columnas=Integer.parseInt(teclado.nextLine());
                    condition=false;
                } catch (Exception e) {
                    //TODO: handle exception
                    condition=true;
                }    
            } while (condition);
            this.dimencionFilas=filas;
            this.dimencionColumnas=columnas;
            System.out.print("Ingrese la camtidad de Planetas Neutrales: ");
            condition=true;
            //comprueba e ingresa la cantidad de planetas neutrales
            do {
                try {
                    cantidadDePlanteasNeutrales=Integer.parseInt(teclado.nextLine());
                    condition=false;
                } catch (Exception e) {
                    //TODO: handle exception
                    condition=true;
                }    
            } while (condition);
            //hace que la comprobacion del tablero establecido puede almacenar los planetas que se setearon
            if(filas*columnas<(this.cantidadDePlanetas+cantidadDePlanteasNeutrales))
            {
                System.out.println("Dimencion Incorecta del Tablero");
                pausa("Precione ENTER para volver a introducir los valores");
                limpiarPantalla();
                repeticionCicloPrincipal=true;
            }
            else{
                repeticionCicloPrincipal=false;
            }
        } while (repeticionCicloPrincipal);
        //Creamos un array para guardar los planetas qeu genramos y luego introcurno en la especificaciondes del tablero
        Planetas[] planetasTemporales = new Planetas[cantidadDePlanteasNeutrales+2];
        boolean condicion=true;
        int opcion=0;

        for (int i = 0; i < cantidadDePlanteasNeutrales+2; i++) {
            opcion=0;
            condicion=true;
            // ciclo donde establecemso los parametro de los planteas del tablero y compobamos si la informacion es ocrrecta
            do{
                limpiarPantalla();
                if(i<cantidadDePlanteasNeutrales){
                    System.out.println("CONFUGURACION DEL PLANETA\n");
                }
                else
                {
                    System.out.println("CONFUGURACION DEL PLANETA DE JUGADOR "+(i-cantidadDePlanteasNeutrales+1)+"\n");
                }
                System.out.println("1. Planeta Aleatorio");
                System.out.println("2. Planeta con Parametros\n");
                System.out.print("Ingrese el numero de opcion: ");
                opcion=Integer.parseInt(teclado.nextLine());
                if(opcion>=1&&opcion<=2){
                    condicion=false;
                }
            }while(condicion);
        // cambiamos el tipo de constuctor dependiendo del tipo de la seleccion en el menu anterior
            if(opcion==1){
                if(i<cantidadDePlanteasNeutrales){
                    planetasTemporales[i]= GenerarPlanetaAleatorio();
                }
                else{
                    //Aqui se generan los planetas de los jugadores
                    if(i==cantidadDePlanteasNeutrales){
                        planetasTemporales[i]= GenerarPlanetaAleatorio();
                        planetasTemporales[i].setPropieratio(nombreJugador1);
                    }
                    else{
                        planetasTemporales[i]= GenerarPlanetaAleatorio();
                        planetasTemporales[i].setPropieratio(nombreJugador2);
                    }
                }
            }
            else{
                //Sector de asigancion de las caracteristicas de los planetas
                String nombreDePlaneta;
                int fondosDelPaneta;
                int cantidadDeConstructores;
                int cantidadDeGuerreros;
                int cantidadDeNaves;
                System.out.print("Ingrese un nombre para el planeta: ");
                nombreDePlaneta=teclado.nextLine();
                System.out.print("Ingrese los fondos monetarios para el planeta: ");
                fondosDelPaneta=Integer.parseInt(teclado.nextLine());
                System.out.print("Ingrese la cantidad de constructores para el planeta: ");
                cantidadDeConstructores=Integer.parseInt(teclado.nextLine());
                System.out.print("Ingrese la cantidad de guerreros para el planeta: ");
                cantidadDeGuerreros=Integer.parseInt(teclado.nextLine());
                System.out.print("Ingrese la cantidad de naves para el planeta: ");
                cantidadDeNaves=Integer.parseInt(teclado.nextLine());
                //Constructor para planeta con parametros establecidos por el usuario anteriormente
                planetasTemporales[i]=GenerarPlanetaConParametros(i, nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves);
                if(i==cantidadDePlanteasNeutrales){
                    planetasTemporales[i].setPropieratio(nombreJugador1);
                }
                if(i==cantidadDePlanteasNeutrales+1){
                    planetasTemporales[i].setPropieratio(nombreJugador2);
                }
            }
        }
        planetasDelTablero=planetasTemporales;
        //Asignacion de las pociciones de los planetas en el tablero
        int [][] posicionesAleatoriasTablero=posicionesAleatoriasDelTablero(filas, columnas);
        
        Planetas[][]temporal=new Planetas[filas][columnas];
        //Se guardan los planetas en un matriz temporal y luego se aignan a la variable de carcteristias del tablero
        for (int j = 0; j < (planetasDelTablero.length); j++) {
            int temporalFila=posicionesAleatoriasTablero[0][j];
            int temporalColumna=posicionesAleatoriasTablero[1][j];
            temporal[temporalFila][temporalColumna]=planetasDelTablero[j];
        }
        this.TableroDeJuego=temporal;
    }

    
    /** 
     * Establecemos Las pociciones aleatorias de los planetas y las guaramos en una matriz
     * @param filas Tamaño en filas del tablero para generar los numeros aleatorios 
     * @param columnas  Tamaño en columnas del tablero para generar los numeros aleatorios 
     * @return int[][]
     */
    private static int[][] posicionesAleatoriasDelTablero(int filas,int columnas){
        int[][]posicionesAleatoriasDelTablero= new int [2][filas*columnas];
        int fi=AsignacionDeCantidadesAleatorias(filas-1, 0);
        int colum=AsignacionDeCantidadesAleatorias(columnas-1, 0);
        int i=0;
        posicionesAleatoriasDelTablero[0][0]=fi;
        posicionesAleatoriasDelTablero[1][0]=colum;
        //Generamos numeros aleatorios sin repetir y los guardamos en una matirz de dos filas para tener las parejas
        for (i = 1; i < (filas*columnas); i++) {
            fi=AsignacionDeCantidadesAleatorias(filas-1, 0);
            colum=AsignacionDeCantidadesAleatorias(columnas-1, 0);
            posicionesAleatoriasDelTablero[0][i]=fi;
            posicionesAleatoriasDelTablero[1][i]=colum;
            for (int j = 0; j < i; j++) {
                if(posicionesAleatoriasDelTablero[0][i]==posicionesAleatoriasDelTablero[0][j]&&posicionesAleatoriasDelTablero[1][i]==posicionesAleatoriasDelTablero[1][j]){
                    i--;
                }        
            }
        }
        return posicionesAleatoriasDelTablero;
    }
    /**
     * Con esta funcion modificamos las caracteristicas del tabelro que se introdujo
     */
    public void modificarTablero(){
        Scanner teclado = new Scanner(System.in);
        int cantidadDePlanteasNeutrales=0;
        int columnas=0;
        int filas=0;
        
        boolean condition=true;
        boolean repeticionCicloPrincipal=true;
        //ciclo donde se piden los atributos y verificamos que la intruccion de informacion sea correcta
        do {
            System.out.println("MENU DE OPCION DE MAPA");
            System.out.println("Ingrese el numero de filas y columunas del mapa");
            System.out.print("Ingrese Filas: ");
            //comprobamos e ingresamos el numero de filas
            do {
                try {
                    filas=Integer.parseInt(teclado.nextLine());
                    condition=false;
                } catch (Exception e) {
                    //TODO: handle exception
                    condition=true;
                }    
            } while (condition);
            System.out.print("Ingrese Columnas: ");
            condition=true;
            //comprobamos e ingresamos el numero de columnas
            do {
                try {
                    columnas=Integer.parseInt(teclado.nextLine());
                    condition=false;
                } catch (Exception e) {
                    //TODO: handle exception
                    condition=true;
                }    
            } while (condition);
            this.dimencionFilas=filas;
            this.dimencionColumnas=columnas;
            System.out.print("Ingrese la camtidad de Planetas Neutrales: ");
            condition=true;
            //compreobamos e ngresamos el numero de planetas neutrales del tablero
            do {
                try {
                    cantidadDePlanteasNeutrales=Integer.parseInt(teclado.nextLine());
                    condition=false;
                } catch (Exception e) {
                    //TODO: handle exception
                    condition=true;
                }    
            } while (condition);
            //comprobamos si las cantidades ingresadas pueden almacenar la cantidad de planetas que tendra el tablero
            if(filas*columnas<(this.cantidadDePlanetas+cantidadDePlanteasNeutrales))
            {
                System.out.println("Dimencion Incorecta del Tablero");
                pausa("Precione ENTER para volver a introducir los valores");
                limpiarPantalla();
                repeticionCicloPrincipal=true;
            }
            else{
                repeticionCicloPrincipal=false;
            }
        } while (repeticionCicloPrincipal);
        //Creamos un vector en el se alamcenen los plantas que ya se habian creado, y guardamos los nuevos
        Planetas[] temporalPlanetas=new Planetas[this.cantidadDePlanetas+cantidadDePlanteasNeutrales];
        for (int i = 0; i < this.cantidadDePlanetas; i++) {
            temporalPlanetas[i]=planetasDelTablero[i];
        }
        int cantidadInicialDePlanetas=this.cantidadDePlanetas;
        boolean condicion=true;
        int opcion=0;
        for (int i = cantidadInicialDePlanetas; i < (cantidadDePlanteasNeutrales+cantidadInicialDePlanetas); i++) {
            // ciclo donde establecemso los parametro de los planteas del tablero y compobamos si la informacion es ocrrecta
            do{
                limpiarPantalla();
                
                System.out.println("CONFUGURACION DEL PLANETA\n");
               
                System.out.println("1. Planeta Aleatorio");
                System.out.println("2. Planeta con Parametros\n");
                System.out.print("Ingrese el numero de opcion: ");
                opcion=Integer.parseInt(teclado.nextLine());
                if(opcion>=1&&opcion<=2){
                    condicion=false;
                }
            }while(condicion);
            if(opcion==1){
                temporalPlanetas[i]=GenerarPlanetaAleatorio();
            }else{
                //ingreso de los parmetros del planeta
                String nombreDePlaneta;
                int fondosDelPaneta;
                int cantidadDeConstructores;
                int cantidadDeGuerreros;
                int cantidadDeNaves;
                System.out.print("Ingrese un nombre para el planeta: ");
                nombreDePlaneta=teclado.nextLine();
                System.out.print("Ingrese los fondos monetarios para el planeta: ");
                fondosDelPaneta=Integer.parseInt(teclado.nextLine());
                System.out.print("Ingrese la cantidad de constructores para el planeta: ");
                cantidadDeConstructores=Integer.parseInt(teclado.nextLine());
                System.out.print("Ingrese la cantidad de guerreros para el planeta: ");
                cantidadDeGuerreros=Integer.parseInt(teclado.nextLine());
                System.out.print("Ingrese la cantidad de naves para el planeta: ");
                cantidadDeNaves=Integer.parseInt(teclado.nextLine());
                //asignacion al y creacion del planeta con parametros
                temporalPlanetas[i]=GenerarPlanetaConParametros(i, nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves);
            }
        }
        planetasDelTablero=temporalPlanetas;
        int [][] posicionesAleatoriasTablero=posicionesAleatoriasDelTablero(filas, columnas);
        //asignamos los lugares en el tablero para los planetas
        Planetas[][]temporal=new Planetas[filas][columnas];
        for (int j = 0; j < (planetasDelTablero.length); j++) {
            int temporalFila=posicionesAleatoriasTablero[0][j];
            int temporalColumna=posicionesAleatoriasTablero[1][j];
            temporal[temporalFila][temporalColumna]=planetasDelTablero[j];
        }
        TableroDeJuego=temporal;
    }

    
    /** 
     * Aqui Creamos un plantea dependiento del factor de aparcion de los planetas
     * @return Planetas
     */
    private Planetas GenerarPlanetaAleatorio(){
        //La genreacion depende la ca ntidad aleatoria que de como resultado
        int probabilidad=AsignacionDeCantidadesAleatorias(100,0);
        String nombrePlaneta;
        Planetas temporal=new Tierra("X");

        nombrePlaneta=NombresPrestablecidos[nombresUsados];
       
        if(probabilidad>=1&&probabilidad<=45){
            temporal=new Tierra(nombrePlaneta);
        }
        if(probabilidad>=46&&probabilidad<=70){
            temporal=new Agua(nombrePlaneta);
        }
        if(probabilidad>=71&&probabilidad<=85){
            temporal=new Fuego(nombrePlaneta);
        }
        if(probabilidad>=86&&probabilidad<=95){
            temporal=new Organico(nombrePlaneta);
        }
        if(probabilidad>=96&&probabilidad<=100){
            temporal=new Radioactivo(nombrePlaneta);
        }
     
        nombresUsados++;
        this.cantidadDePlanetas++;
       
        return temporal;
        
    }
    
    /** 
     * Generamos planeta pero varian los parametros de los planetas
     * @param i
     * @param nombreDePlaneta
     * @param fondosDelPaneta
     * @param cantidadDeConstructores
     * @param cantidadDeGuerreros
     * @param cantidadDeNaves
     * @return Planetas
     */
    private Planetas GenerarPlanetaConParametros(int i,String nombreDePlaneta,int fondosDelPaneta,int cantidadDeConstructores,int cantidadDeGuerreros,int cantidadDeNaves){
        int probabilidad=AsignacionDeCantidadesAleatorias(100,0);
        Planetas temporal=new Tierra("X");
        if(probabilidad>=1&&probabilidad<=45){
            temporal=new Tierra(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves);
        }
        if(probabilidad>=46&&probabilidad<=70){
            temporal=new Agua(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves);
        }
        if(probabilidad>=71&&probabilidad<=85){
            temporal=new Fuego(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves);
        }
        if(probabilidad>=86&&probabilidad<=95){
            temporal=new Organico(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves);
        }
        if(probabilidad>=96&&probabilidad<=100){
            temporal=new Radioactivo(nombreDePlaneta, fondosDelPaneta, cantidadDeConstructores, cantidadDeGuerreros, cantidadDeNaves);
        }
        this.cantidadDePlanetas++;
        return temporal;
        
    }

    
    /** 
     * Funcion que administra todas la funciones numericas referidas a lo aleatorio
     * @param max
     * @param min
     * @return int
     */
    private static int AsignacionDeCantidadesAleatorias(int max,int min){
        int resultado=0;
        int intervalo =(int)Math.floor(Math.random()*(max-min+1)+min);
        resultado=intervalo;
        return resultado;
    }

    
    /** 
     * Verificamos el tamaño del nombre, funcion utlizada en imprecion del mapa
     * @return int
     */
    private int tamañoDeNombres(){
        int tamañoDeNombres=0;
        for (int i = 0; i < this.planetasDelTablero.length; i++) {
            if((this.planetasDelTablero[i].getPropietario()).length()>tamañoDeNombres){
                tamañoDeNombres=planetasDelTablero[i].getPropietario().length();
            }
        }
        return tamañoDeNombres+8;
    }

    
    /** 
     * Imprecion del ḿapa segun las caracteristcas del tablero
     * @param jugador
     * @param turno
     */
    public void imprimirMapa(String jugador,int turno){
        System.out.println("Control actual: "+jugador+"\nTurno actual: "+turno+"\n");
        System.out.println("Mapa del los dominios\n");

        int tamañoDeEscritura=tamañoDeNombres();
        for (int i2 = 0; i2 < 2; i2++) {
            if(i2==0){
                System.out.print("|-");
            }else{
                System.out.print("|/");
            }
            for (int j = 0; j < this.dimencionColumnas; j++) {
                System.out.print("|");
                if(i2==0){
                    for (int j2 = 0; j2 <tamañoDeEscritura; j2++) {
                        System.out.print("-");
                    }
                }
                else{
                    for (int j2 = 0; j2 <tamañoDeEscritura; j2++) {
                        if(j2==(int)tamañoDeEscritura/2){
                            char temporal=(char)(65+j);
                            System.out.print(temporal);
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println("|");
        }
      
        for (int i2 = 0; i2 < this.dimencionFilas; i2++) {
            
            for (int i = 0; i < 3; i++) {
                if(i==0){
                    System.out.print("|-");
                }
                if(i==1){
                    System.out.print("|"+(i2+1));
                }
                if(i==2){
                    System.out.print("| ");
                }
                for (int j = 0; j < this.dimencionColumnas; j++) {
                    System.out.print("|");
                    if(i==0)
                    {
                        for (int j2 = 0; j2 <tamañoDeEscritura; j2++) {
                            System.out.print("-");
                        }
                    }
                    if(i==1){
    
                        if(TableroDeJuego[i2][j]==null)
                        {
                            for (int j2 = 0; j2 < tamañoDeEscritura; j2++) {
                                System.out.print(" ");
                            }
                        }
                        else{
                            if(TableroDeJuego[i2][j].getPropietario().equals(nombreDeJugador1))
                            {
                                System.out.print(ANSI_CYAN_BACKGROUND+ANSI_WHITE);
                            }
                            if(TableroDeJuego[i2][j].getPropietario().equals(nombreDeJugador2))
                            {
                                System.out.print(ANSI_PURPLE_BACKGROUND+ANSI_WHITE);
                            }
                            if(TableroDeJuego[i2][j].getPropietario().equals("Neutral"))
                            {
                                System.out.print(ANSI_RED_BACKGROUND+ANSI_WHITE);
                            }
                            System.out.print("Nombre: "+TableroDeJuego[i2][j].getNombreDePlaneta());
                            for (int j2 = 0; j2 < (tamañoDeEscritura-(8+TableroDeJuego[i2][j].getNombreDePlaneta().length())); j2++) {
                                System.out.print(" ");
                            }
                            System.out.print(ANSI_RESET);
                        }
                    }
                    if(i==2){
    
                        if(TableroDeJuego[i2][j]==null)
                        {
                            for (int j2 = 0; j2 < tamañoDeEscritura; j2++) {
                                System.out.print(" ");
                            }
                        }
                        else{
                            if(TableroDeJuego[i2][j].getPropietario().equals(nombreDeJugador1))
                            {
                                System.out.print(ANSI_CYAN_BACKGROUND+ANSI_WHITE);
                            }
                            if(TableroDeJuego[i2][j].getPropietario().equals(nombreDeJugador2))
                            {
                                System.out.print(ANSI_PURPLE_BACKGROUND+ANSI_WHITE);
                            }
                            if(TableroDeJuego[i2][j].getPropietario().equals("Neutral"))
                            {
                                System.out.print(ANSI_RED_BACKGROUND+ANSI_WHITE);
                            }
                            System.out.print("Dueño: "+TableroDeJuego[i2][j].getPropietario());
                            for (int j2 = 0; j2 < (tamañoDeEscritura-(7+TableroDeJuego[i2][j].getPropietario().length())); j2++) {
                                System.out.print(" ");
                            }
                            System.out.print(ANSI_RESET);
                        }
                    }
                }
                System.out.println("|");
            }
        }
        System.out.print("|-");
        for (int j = 0; j < this.dimencionColumnas; j++) {
            System.out.print("|");
            for (int j2 = 0; j2 <tamañoDeEscritura; j2++) {
                System.out.print("-");
            }
        }
        System.out.println("|");
        System.out.println("Para ingresar en la tienda escriba: TIENDA   Para entar el menu de mapa escriba: MAPA");
        System.out.println("Para consultar el estado de su flote escriba: CONSULTA");
        System.out.println("Cuando termine todos su movimientos escriba: FIN");
        System.out.println("Visualizar codigos escriba: AYUDA");
        System.out.println("Para salir del juego escriba: SALIR");
        System.out.print("Codigo: ");
    }
    /**
     * Funcion limpiar pantalla por medio de comandos 
     */
    private static void limpiarPantalla(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    /**
     * Crear pausa en el juego y con la posiblidad de mostrar un mensaje
     * @param mensaje
     */
    private static void pausa(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.println(mensaje);
        teclado.nextLine();
    }
}