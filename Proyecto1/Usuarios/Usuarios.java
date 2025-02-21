package Proyecto1.Usuarios;


import java.text.DecimalFormat;
import java.util.*;
import Proyecto1.Planetas.*;
import Proyecto1.Tablero.*;
import Proyecto1.Naves.*;
import Proyecto1.EventosEnCola.*;
import Proyecto1.Tienda.*;
import Proyecto1.Guerreros.*;
import Proyecto1.Constructores.*;
import Proyecto1.EventosEnCola.*;

public class Usuarios{
    private Planetas[] planetasDelTableroUtilizado;
    private Planetas[][] tableroDeJuegoUtilizado;
    private int dimencionColumnasDeTableroUtilizado;
    private int dimencionFilasDeTableroUtilizado;

    private Tablero[] tableroDisponibles;
    private Tablero tableroUtilizado;

    private String nombreDeJugador1;
    private String nombreDeJugador2;

    private EventosEnCola[] colaJugadores;
    private int numeroDeProcesosEnCola=0;

    public Usuarios(){
        //Constructor Vacio
    }
    /**
     * Funcion con comandos para limpiar la pantalla de la consola
     */
    private static void limpiarPantalla(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    /**
     * Con esta funcion generamos el mapa incial cuando el juego esta vacio al principio
     * @param jugador1 Nombre del jugador 1
     * @param jugador2 Nombre del jugador 2
     */
    public void inicioDePartida(String jugador1, String jugador2){
        this.nombreDeJugador1=jugador1;
        this.nombreDeJugador2=jugador2;
        Tablero[] mapaInicial = new Tablero[1]; //Inicializamos un arreglo de tipo tablero para guardarlo en el arreglo que los almacena todos
        Tablero mapa= new Tablero(); //Generamos un objeto de tipo tablero
        mapa.GenerarTableroInicial(jugador1, jugador2); //Incluimos los parametros del tablero
        this.tableroUtilizado=mapa; // Seteamos el mapa de juego en la variable en uso
        mapaInicial[0]=mapa; // guardamos el mapa en el arreglo que inicializamos anteriormente
        this.tableroDisponibles=mapaInicial;// Guardamos el arreglo en donde se guardaran los demas mapas del juego
        this.dimencionColumnasDeTableroUtilizado=mapa.getDimencionColumnas(); //Adquirimos las especificaiones del mapa
        this.dimencionFilasDeTableroUtilizado=mapa.getDimencionFilas();// <== Referencia a las filas
        this.planetasDelTableroUtilizado=mapa.getPlanetasDelTablero();// <== Referencia a las columnas
        this.tableroDeJuegoUtilizado=mapa.getTableroDeJuego();// <== Referencia a la matriz donde estan guardados los planetas
    }
    /**
     * Es esta funcion estan incluido el rocesamiento y la excepciones que hay al momento de introducir el codigo dentro del juego
     * @param codigoIngresado Variable de tipo String
     * @param jugador   Varible de tipo String
     * @param turnos Variable de tipo entera
     * @return
     */
    public String  procesamientoDeTexto(String codigoIngresado, String jugador,int turnos) {
        String paso=" ";
        //En la primera condicion identificaos incialmente las palabra que no necesitan un procesamiento en si, solo que son palabra reservadas para el juego
        if(codigoIngresado.equals("SALIR")||codigoIngresado.equals("AYUDA")||codigoIngresado.equals("TIENDA")||codigoIngresado.equals("MAPA")||codigoIngresado.equals("CONSULTA")||codigoIngresado.equals("FIN")){
            Scanner teclado = new Scanner(System.in);
            //ingresamos a la ayuda de usuario 
            if(codigoIngresado.equals("AYUDA")){
                paso=" ";
                ayudaDeUsuario();
            }
            //Hacemos que terminen las acciones tiene relacion directa con el archivo Principal.java
            if(codigoIngresado.equals("FIN")){
                paso="FIN";

            }            
            //Con esta opcion salimos completamente del juego
            if(codigoIngresado.equals("SALIR")){
                paso="SALIR";
            }
            //Se accede a la funciones de opciones de mapa
            if(codigoIngresado.equals("MAPA")){
                String opcionDeMapa;
                boolean condicionDeRepeticion=true;
                //ciclo que me ayuda a saber si los parametros ingreasados son correctos
                do {
                    limpiarPantalla();
                    System.out.println("MENU DE OPCION DE MAPA");
                    System.out.println("1. Modificar mapa actual\n2. Crear un nuevo mapa\n3. Seleccionar un mapa para jugar\n4. Salir\nEscriba el numero de opcion a procesar:");
                    opcionDeMapa=teclado.nextLine();
                    if(opcionDeMapa.equals("1")||opcionDeMapa.equals("2")||opcionDeMapa.equals("3")){
                        condicionDeRepeticion=false;
                    }
                } while (condicionDeRepeticion);
                //Opcion de modificacion del mapa en el que se juega actualmente 
                if(opcionDeMapa.equals("1")){
                    tableroUtilizado.modificarTablero();
                }
                // opcion para crear un mapa nuevo
                if(opcionDeMapa.equals("2")){
                    int tamañoAnterior=tableroDisponibles.length;
                    //Creamos un arreglo temporal que almacene los mapas anteriores y podamos guardar el nuevo
                    Tablero[] tableroTemporal = new Tablero[tamañoAnterior+1];
                    //ciclo de hace una copia del archivo donde se encuntra todos los mapas y guardamos el nuevo
                    for (int i = 0; i < this.tableroDisponibles.length; i++) {
                        tableroTemporal[i]=this.tableroDisponibles[i];
                    }
                    Tablero mapaTemporal = new Tablero();
                    mapaTemporal.GenerarTableroInicial(this.nombreDeJugador1, this.nombreDeJugador2);
                    tableroTemporal[tamañoAnterior]=mapaTemporal;
                    this.tableroDisponibles=tableroTemporal;
                }
                //opcion de seleccion del mapa y el seteo de todas las caracteristicas del todo el mapa
                if(opcionDeMapa.equals("3")){
                    limpiarPantalla();
                    //Imprecion de los mapas y nos señala en que maap estamos actualmente 
                    System.out.println("MAPAS DISPONIBLES DEL JUEGO\n");
                    for (int i = 0; i < this.tableroDisponibles.length; i++) {
                        System.out.print("- Mapa "+(i+1)+" "+this.tableroDisponibles[i]);
                        if(this.tableroDisponibles[i]==tableroUtilizado){
                            System.out.println(" ====MAPA ACTUAL====");
                        }
                        else
                        {
                            System.out.println("");
                        }
                        if(i==(this.tableroDisponibles.length-1)){
                            System.out.println("- "+(i+2)+" Salir");
                        }
                    }
                    int opcionDeMapaNuevo=0;
                    boolean condicion=true;
                    //ciclo para que no tengamos errores al momento de ingresar la opcion del usuario
                    do {
                        System.out.print("Seleccione el numero de mapa o opcion: ");
                        try {
                            opcionDeMapaNuevo=Integer.parseInt(teclado.nextLine());
                            if(opcionDeMapaNuevo>0&&opcionDeMapaNuevo<=(this.tableroDisponibles.length+1)){
                                condicion=false;
                            }
                        } catch (Exception e) {
                            
                        }    
                    } while (condicion);
                    //Hace referencia a la opcion salir que estara siempre una unidad mas que ekl largo del vector
                    if(opcionDeMapaNuevo==(this.tableroDisponibles.length+1)){
                        paso=" ";
                        pausa("EL MAPA DEL JUEGO NO A SIDO CAMBIADO");
                    }
                    else{

                        for (int i = 0; i < this.tableroDisponibles.length; i++) {
                            if(this.tableroDisponibles[i]==tableroUtilizado){
                                this.tableroDisponibles[i]=tableroUtilizado;
                            }
                        }
                        // seteo de los parametros del tablero nuevo a jugar a las vaaribles de esta clase
                        tableroUtilizado=this.tableroDisponibles[opcionDeMapaNuevo-1];
                        this.dimencionColumnasDeTableroUtilizado=tableroUtilizado.getDimencionColumnas();
                        this.dimencionFilasDeTableroUtilizado=tableroUtilizado.getDimencionFilas();
                        this.planetasDelTableroUtilizado=tableroUtilizado.getPlanetasDelTablero();
                        this.tableroDeJuegoUtilizado=tableroUtilizado.getTableroDeJuego();
                        colaJugadores=null;
                        numeroDeProcesosEnCola=0;
                        //codio para reiniciar en el archi principal el contador 
                        paso="CAMBIO";
                        pausa("EL MAPA DEL JUEGO A SIDO CAMBIADO");

                    }
                    
                    
                }
            }  
            //Referencia a la opcion de mostrar el progreso de nuestra flora 
            if(codigoIngresado.equals("CONSULTA")){
                limpiarPantalla();
                System.out.println("CONSULTA DE LA FLOTA DE JUGADOR: "+ jugador+"\n");
                consultaDeFlota(this.colaJugadores,jugador);
            }
            //referencia a la tienda de nuestro juego
            if(codigoIngresado.equals("TIENDA")){
                paso=" ";
                //Inicializacion de la tienda
                String opcionTienda;
                Tienda tienda=new Tienda();
                boolean repeticion=true;
                //Menu de opciones de la tienda, tambien hace la comprobacion de introduccion de inforamacion
                do {
                    limpiarPantalla();
                    System.out.println("    TIENDA\n\n1. Comprar Constructores\n2. Vender\n3. Salir de tienda\n\nIngrese el numero opcion a procesar");
                    opcionTienda=teclado.nextLine();
                    limpiarPantalla();
                    System.out.println("Lista de planetas del usuario\n");
                    //Opcion de compra de constructores
                    if(opcionTienda.equals("1")){
                        // imprecion de los panetas que tiene en posecion el usuario
                        imprimirListaDePlanetas(planetasDelTableroUtilizado, jugador);
                        System.out.println(" ");
                        System.out.print("Ingrese el nombre del planeta: ");
                        String nombreDePlanetaSeleccionado=teclado.nextLine();
                        //comprobacion del planeta 
                        if(buscarPorNombre(planetasDelTableroUtilizado, nombreDePlanetaSeleccionado)==null){
                            pausa("Error de nombre precione ENTER para regresar a la tienda!!!!");
                        }
                        else
                        {
                            //Aqui es donde se hace la realizacion de la compra
                            tienda.Comprar(buscarPorNombre(planetasDelTableroUtilizado, nombreDePlanetaSeleccionado), jugador);
                        }
                        
                    }
                    //opcion de hacer rederencia a la de vender objetos
                    if(opcionTienda.equals("2")){
                        imprimirListaDePlanetas(planetasDelTableroUtilizado, jugador);
                        System.out.println(" ");
                        System.out.print("Ingrese el nombre del planeta: ");
                        String nombreDePlanetaSeleccionado=teclado.nextLine();
                        if(buscarPorNombre(planetasDelTableroUtilizado, nombreDePlanetaSeleccionado)==null){
                            pausa("Error de nombre precione ENTER para regresar a la tienda!!!!");
                        }
                        else
                        {
                            tienda.Vender(buscarPorNombre(planetasDelTableroUtilizado, nombreDePlanetaSeleccionado), jugador);
                        }
                    }
                    if(opcionTienda.equals("3")){
                        repeticion=false;
                    }
                    
                } while (repeticion);
                
            }
            
        }
        else
        {
            //aqui es donde se proce todo el demas texto que no cumple con las anteriores especificaciones 
            paso=" ";
            //detectamos si el texto es mayor que uno y si no exite alguna coma del ultimo en el texto, de lo contrario lo tomamos como error
            if ((codigoIngresado.lastIndexOf(",")!=codigoIngresado.length()-1)&&codigoIngresado.length()>1)
            {
                //con esta funcion contamos la cantidad de comas que hay en un texto ingresado
                int cantidadDeComas=contadorDeComas(codigoIngresado);
                // si el codigo solo posee una coma
                if(cantidadDeComas==0){
                    limpiarPantalla();
                    // ingresamos a la opcion de ver planeta
                    System.out.println("Ver planeta\n");
                    if(comprobarPlaneta(codigoIngresado, this.dimencionColumnasDeTableroUtilizado, this.dimencionFilasDeTableroUtilizado, this.tableroDeJuegoUtilizado)){
                        ordenarAlPlaneta(codigoIngresado, this.tableroDeJuegoUtilizado, jugador);
                    }
                    else{
                        pausa("Ningun planeta tiene los parametros ingresados!!!");
                    }
                }
                // con la cantida de comas igual a 1 podemos hacer dos diferentes acciones
                if(cantidadDeComas==1){
                        int posicionDeLetraAnalizar=codigoIngresado.indexOf(",");
                        int codigoACII = (int)codigoIngresado.charAt(posicionDeLetraAnalizar+2);
                        //detectamos si la segunda letra depues de la coma es un numero comparando segun el codigo acii o si es una letra que indica que es alguna otra opcion
                        if(codigoACII>=48&&codigoACII<=57)
                        {
                            //accion de medisr distancia
                            limpiarPantalla();
                            System.out.println("Medir Distancia\n");
                            if((comprobarPlaneta(extraerTexto(codigoIngresado, 0, codigoIngresado.indexOf(",")-1), this.dimencionColumnasDeTableroUtilizado, this.dimencionFilasDeTableroUtilizado, this.tableroDeJuegoUtilizado))&&(comprobarPlaneta(extraerTexto(codigoIngresado, codigoIngresado.indexOf(",")+1,codigoIngresado.length()-1 ), this.dimencionColumnasDeTableroUtilizado, this.dimencionFilasDeTableroUtilizado, this.tableroDeJuegoUtilizado)))
                            {
                                System.out.println("Cordenadas Correctas\n");
                                System.out.println("La Distancia entre: "+extraerTexto(codigoIngresado, 0, codigoIngresado.indexOf(",")-1).toUpperCase()+" y "+extraerTexto(codigoIngresado, codigoIngresado.indexOf(",")+1,codigoIngresado.length()-1 ).toUpperCase());
                                System.out.print(calularDistancia(extraerTexto(codigoIngresado, 0, codigoIngresado.indexOf(",")-1), extraerTexto(codigoIngresado, codigoIngresado.indexOf(",")+1,codigoIngresado.length()-1 )));
                                System.out.println(" ");
                            }
                            else
                            {
                                System.out.println("Cordenadas Incorrectas!!!");
                            }
                            pausa("Precione ENTER para regresar al MAPA");
                            
                        }
                        else{
                            //accion de construir
                            limpiarPantalla();
                            System.out.println("Construir Nave\n");
                            //extraemos el texto que queremso analizar que va guiado por la comas del texto, por eso se utiliza la opcion de "estraer texto"
                            String coordendaPlaneta=extraerTexto(codigoIngresado, 0, codigoIngresado.indexOf(",")-1);
                            String tipoDeConstructor=extraerTexto(codigoIngresado, codigoIngresado.indexOf(",")+1, codigoIngresado.length()-1);
                            //comprovbamos si el planeta extiste en el tablero con la funcion comporbarPlaneta
                            if(comprobarPlaneta(coordendaPlaneta.toUpperCase(), this.dimencionColumnasDeTableroUtilizado, this.dimencionFilasDeTableroUtilizado, this.tableroDeJuegoUtilizado)&&validadorDeTexto(tipoDeConstructor)){
                                //Verificamos si nostro podes ejercer una aciion sobre el planeta por medio del usuuario que reaiza la accion
                                if(verificarPropietario(coordendaPlaneta, this.tableroDeJuegoUtilizado, jugador)){
                                    //extraemos el planeta y revisamos dentro de sus contructores si existe lo que ingresamos en el codigo de ejecucuin del juego
                                    if(retonarPlaneta(coordendaPlaneta, this.tableroDeJuegoUtilizado).verificadorDeConstructor(tipoDeConstructor)){
                                        //Creamos onjeto temporales par poder extraer las caracteristicas de los mismos
                                        Constructores[]tempConstructores=retonarPlaneta(coordendaPlaneta, this.tableroDeJuegoUtilizado).getConstructores();
                                        Constructores temporalConstructores=null;
                                        for (int i = 0; i < tempConstructores.length; i++) {
                                            if(tempConstructores[i].tipoDeConstructor().toLowerCase().equals(tipoDeConstructor.toLowerCase())){
                                                temporalConstructores=tempConstructores[i];
                                                break;
                                            }
                                        }
                                        //Analizamos si el planeta tiene los fondos suficientes para poder realizar la accion ingresada
                                        if(retonarPlaneta(coordendaPlaneta, this.tableroDeJuegoUtilizado).getFondosDelPlaneta()>temporalConstructores.costoDeTrabajo()){
                                            /**
                                             * Inicializacion De un evento en Cola
                                             */
                                            EventosEnCola[] tempEventosEnColas=null;
                                            //Guardamos los demas objetos en cola si es que el arrglo tiene mas informacion adentro 
                                            if(numeroDeProcesosEnCola==0)
                                            {
                                                tempEventosEnColas=new EventosEnCola[1];
                                            }
                                            else
                                            {
                                                tempEventosEnColas=new EventosEnCola[numeroDeProcesosEnCola+1];
                                                for (int i = 0; i < this.colaJugadores.length; i++) {
                                                    tempEventosEnColas[i]=this.colaJugadores[i];
                                                }
                                            }

                                            System.out.println("Accion Agregada a Cola");
                                            EventoConstruir orden = new EventoConstruir(retonarPlaneta(coordendaPlaneta, this.tableroDeJuegoUtilizado), temporalConstructores, turnos,jugador);
                                            tempEventosEnColas[numeroDeProcesosEnCola]=orden;
                                            this.numeroDeProcesosEnCola++;

                                            /**
                                             *Agregar Instruccion a la cola de archivos 
                                             */
                                            colaJugadores=tempEventosEnColas;
                                        }
                                        else{
                                            System.out.println("No tiene los fondos suficientes");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("No existe el tipo de constructor en su planeta");
                                    }
                                }
                                else{
                                    System.out.println(jugador+" no es propietario del planeta");
                                }
                            }
                            else{
                                if(!comprobarPlaneta(coordendaPlaneta, this.dimencionColumnasDeTableroUtilizado, this.dimencionFilasDeTableroUtilizado, this.tableroDeJuegoUtilizado))
                                {
                                    System.out.println("El Planeta no existe");
                                }
                                if(!validadorDeTexto(tipoDeConstructor))
                                {
                                    System.out.println("El tipo de constructor no existe");
                                }
                            }
                            pausa("\nPrecione ENTER para regresar al mapa");
                        }
                }
                if(cantidadDeComas==2||cantidadDeComas==3||cantidadDeComas>4){
                    pausa("Error de cadigo!!! el texto no cumple con la sintaxis");
                }
                if(cantidadDeComas==4){
                    //referencia a la opcion de envio de flota
                    limpiarPantalla();
                    System.out.println("Envio De Flota\n");
                    //extraemos la ubicacion de la coma y extraemos el texto que esta dentro de la funcion
                    int coma1=codigoIngresado.indexOf(",");
                    String planetaSalida=extraerTexto(codigoIngresado, 0, coma1-1);

                    int coma2=codigoIngresado.indexOf(",", coma1+1);
                    String cantidadDeGuerreros=extraerTexto(codigoIngresado,coma1+1,coma2-1);

                    int coma3=codigoIngresado.indexOf(",", coma2+1);
                    String tipoDeGuerrero=extraerTexto(codigoIngresado, coma2+1, coma3-1);

                    int coma4=codigoIngresado.indexOf(",", coma3+1);
                    String tipoDenave=extraerTexto(codigoIngresado, coma3+1, coma4-1);

                    String PlanetaDeDestino=extraerTexto(codigoIngresado, coma4+1, codigoIngresado.length()-1);
                    //comprobamos si el planeta de salida existe
                    if(comprobarPlaneta(planetaSalida.toUpperCase(), this.dimencionColumnasDeTableroUtilizado, this.dimencionFilasDeTableroUtilizado, this.tableroDeJuegoUtilizado))
                    {
                        //verificamso si el planeta de salida es neustro de lo contrio no se realiza la accion
                        if(verificarPropietario(planetaSalida, this.tableroDeJuegoUtilizado, jugador))
                        {
                            //comprobamos si el texto de extraimos es un numero
                            if(comprobarCantidadesNumericas(cantidadDeGuerreros)){
                                //validamos el texto que se ingreso si exoste una concidencia con lo que esta incluido en el juego
                                if(validadorDeTexto(tipoDeGuerrero)){
                                    //verificamos si tenemos la calse de guerreos en el planeta 
                                    if(retonarPlaneta(planetaSalida, this.tableroDeJuegoUtilizado).verificadorDeGuerrero(tipoDeGuerrero))
                                    {
                                        Guerreros guerreroTemporal=retonarPlaneta(planetaSalida, this.tableroDeJuegoUtilizado).generarGerreroTemporal(tipoDeGuerrero);
                                        int cantidadPedida=Integer.parseInt(cantidadDeGuerreros);
                                        //comprobamso si tenemos los gurereros solicitados
                                        if(cantidadPedida>retonarPlaneta(planetaSalida, this.tableroDeJuegoUtilizado).cantidadDeGuerrerosUnaClase(tipoDeGuerrero))
                                        {
                                            // validamos el texto por alguna concidencia de lo qu existe en el juego 
                                            if(validadorDeTexto(tipoDenave))
                                            {
                                                // verificamso si tenemos la case de nave en el planeta de salida 
                                                if(retonarPlaneta(planetaSalida, this.tableroDeJuegoUtilizado).verificadorDeNave(tipoDenave)){
                                                    // comprobamos si existe el planeta de destino 
                                                    if(comprobarPlaneta(PlanetaDeDestino.toUpperCase(), this.dimencionColumnasDeTableroUtilizado, this.dimencionFilasDeTableroUtilizado, this.tableroDeJuegoUtilizado))
                                                    {
                                                        //creamos una nave temporal segun los parametros de ingreso par saber loe spacios que tenmos disponibles en la nave
                                                        Naves naveTemporal=retonarPlaneta(planetaSalida, this.tableroDeJuegoUtilizado).generacionNavesTemporal(tipoDenave);
                                                        int espaciosOcupados=guerreroTemporal.getEspaciosAOcupar();
                                                        int espaciosDisponibles=naveTemporal.getEspaciosDeNave();
                                                        int espaciosReales=(int)(espaciosDisponibles/espaciosOcupados);
                                                        //comparamos si tenemos los espacios necesarios en la nave para los gurreros que solicitamos enviar
                                                        if(cantidadPedida>espaciosReales){
                                                            System.out.println("No hay espacio suficiente para los guerreros");
                                                        }
                                                        else
                                                        {
                                                            /**
                                                             * Inicializacion De un evento en Cola
                                                             */
                                                            EventosEnCola[] tempEventosEnColas=null;
                                                            if(numeroDeProcesosEnCola==0)
                                                            {
                                                                tempEventosEnColas=new EventosEnCola[1];
                                                            }
                                                            else
                                                            {
                                                                //guarmaos eventos anteriores si hay en el arrglo que los guarda
                                                                tempEventosEnColas=new EventosEnCola[numeroDeProcesosEnCola+1];
                                                                for (int i = 0; i < this.colaJugadores.length; i++) {
                                                                    tempEventosEnColas[i]=this.colaJugadores[i];
                                                                }
                                                            }
                                                           /// comprobamos se el planeta es del mismo dueño que el del planeta de salida
                                                            if(retonarPlaneta(PlanetaDeDestino, this.tableroDeJuegoUtilizado).getPropietario().equals(jugador))
                                                            {
                                                                //La accion cabio y xcremos otro tipo de evento
                                                                System.out.println("Planeta aliado, se agregaran los soldados al ejercito de su planeta, accion en cola");
                                                                //enviamos los parametrso necesario para crear el turno de ejecucion del evento 
                                                                double distanciaEntrePlanetas=calularDistancia(planetaSalida, PlanetaDeDestino);
                                                                Planetas planetaTemporal1=retonarPlaneta(planetaSalida, this.tableroDeJuegoUtilizado);
                                                                Planetas planetaTemporal2=retonarPlaneta(PlanetaDeDestino, this.tableroDeJuegoUtilizado);
                                                                Naves naveCargadaTemporal=planetaTemporal1.selecccionaryCargar(tipoDeGuerrero, cantidadPedida, tipoDenave,distanciaEntrePlanetas);

                                                                EventoExportarGuerreros orden = new EventoExportarGuerreros(planetaTemporal1, planetaTemporal2, naveCargadaTemporal, distanciaEntrePlanetas, turnos, jugador);
                                                                tempEventosEnColas[numeroDeProcesosEnCola]=orden;
                                                                this.numeroDeProcesosEnCola++;
                                                            }
                                                            else
                                                            {   
                                                                /// si el planeta de destino no es propiedad del jugador que ejecuto la accion hacemos el mismo porcedimeitno anterior solo cambia el tipo de evento
                                                                double distanciaEntrePlanetas=calularDistancia(planetaSalida, PlanetaDeDestino);
                                                                Planetas planetaTemporal1=retonarPlaneta(planetaSalida, this.tableroDeJuegoUtilizado);
                                                                Planetas planetaTemporal2=retonarPlaneta(PlanetaDeDestino, this.tableroDeJuegoUtilizado);
                                                                Naves naveCargadaTemporal=planetaTemporal1.selecccionaryCargar(tipoDeGuerrero, cantidadPedida, tipoDenave,distanciaEntrePlanetas);

                                                                EventoEnviarFlota orden = new EventoEnviarFlota(planetaTemporal1, planetaTemporal2, naveCargadaTemporal, distanciaEntrePlanetas, turnos, jugador);
                                                                tempEventosEnColas[numeroDeProcesosEnCola]=orden;
                                                                this.numeroDeProcesosEnCola++;
                                                                System.out.println("El codigo fue indroducido satisfactoriamente, accion en cola");
                                                            }
                                                            /**
                                                             * Agregar intruccion a la cola de archivos
                                                             */
                                                            colaJugadores=tempEventosEnColas;
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("No existe el paneta de destino");
                                                    }
                                                }
                                                else{
                                                    System.out.println("No tiene el tipo de nave introducida");
                                                }
            
                                            }
                                            else
                                            {
                                                System.out.println("Usted no ingreso una nave correcta");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("No tiene la cantidad de guerreros que ingreso");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("No tiene este tipo de Guerrero");
                                    }
                                }
                                else{
                                    System.out.println("No ingreso un guerrero corecto");
                                }
                            }
                            else
                            {
                                System.out.println("No ingreso una cantidad numerica");
                            }
                        }
                        else
                        {
                            System.out.println(jugador+" no es propietatio del planeta");
                        }
                    }
                    else
                    {
                        System.out.println("El planeta de salida no existe");
                    }
                    pausa("\nPrecione ENTER para regresar al mapa");
                }
            }
            else
            {
               
                System.out.println("Error De Codigo");
            }
            
        }
        
        return paso;
    }
    /**
     * Ingresamos una cadena para saber si la podemos parcear
     * @param cadena
     * @return
     */
    private static boolean comprobarCantidadesNumericas(String cadena){
        boolean resultado=true;
        for (int i = 0; i < cadena.length();i++) {
            int acii=(int)cadena.charAt(0);
            //comprobamos si la cadena tiene letras por medio del codigo acii
            if(acii>=65&&acii<=90)
            {
                resultado=false;
            }
        }
        return resultado;
    }
    /**
     * Imprecion de codigos de ayuda para el usurio del juego 
     */
    private static void ayudaDeUsuario(){
        limpiarPantalla();
        System.out.println("Para visualizar un planeta escriba la celda donde se encuentra\nEjemplo: A1");
        System.out.println("");
        System.out.println("Para medir la distancia entre dos planetas escriba\nlas celdas donde se encuentra separados por coma\nEjemplo: A1,C3");
        System.out.println("");
        System.out.println("Para enviar a las flotas de guerreos de escribir en el siguinte orden\nPlaneta de Origen,Cantidad de Guerreros,Tipo de Guerrero,Tipo de Nave, Planeta de Destino\nEjemplo: A1,35,Mole,Naboo N-1,G4");
        System.out.println("");
        System.out.println("Para construir una nave escriba el planeta a seleccionar y lugo el tipo de constructor Ejemplo: A1,Ingeniero");
        System.out.println("");
        System.out.println("");
        pausa("Precione ENTER para regresar al MAPA");
        limpiarPantalla();

    }
    /**
     * Funcion para establer pausa e imprimir un mensaje
     */
    private static void pausa(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.println(mensaje);
        teclado.nextLine();
    }
    /**
     * Extraemos el texto de un string 
     * @param cadena Texto que se analizara 
     * @param inicio Donde inicia el texto variable de tipo entera
     * @param fin Dondo termina el texto varibale de tipo entera
     * @return
     */
    private static String extraerTexto(String cadena, int inicio, int fin){
        String temporal="";
        char []temporalLetras = new char[(fin-inicio)+1];
        int contador=0;
        //extraemos caracter publicpor caracter y los ingresmos a un arreglo
        for (int i = inicio; i <= fin; i++) {
            temporalLetras[contador]=cadena.charAt(i);
            contador++;
        }
        //convertimos el arreglo a un string
        temporal=String.valueOf(temporalLetras);
        return temporal;
    }
    /**
     * Comporvacion si el planeta existe en el tabelro de juego
     * @param cadena Ubicacion por medio de la celda donde se tiene una vista del objeto
     * @param dimencionColumnasDeTableroUtilizado   Tamaño en columnas del tablero
     * @param dimencionFilasDeTableroUtilizado Tamaño en filas del tablero
     * @param tableroDeJuegoUtilizado Matriz del tablero utilizado
     * @return
     */
    private static boolean comprobarPlaneta(String cadena, int dimencionColumnasDeTableroUtilizado, int dimencionFilasDeTableroUtilizado,Planetas[][]tableroDeJuegoUtilizado){
        boolean respuesta=false;
        cadena=cadena.toUpperCase();
        int letras=0;
        //contamos si el texot de ingreso comple con la sitaxis de la ubicacion de un planeta
        for (int i = 0; i < cadena.length();i++) {
            int acii=(int)cadena.charAt(i);
            if(acii>=65&&acii<=90)
            {
                letras++;
            }
        }
        if(letras>1)
        {
            // si no cimple la respuesta sera falsa
            respuesta=false;

        }else{
            //convertimos la letra a un numero del codigo acii y lo volvemos como un conteo natural
            int acii=(int)cadena.charAt(0);
            //comprobamos si el primer caracter del string es una letra por medio del codigo acii
            if(acii>=65&&acii<=90)
            {
                int columa=(int)cadena.charAt(0)-65;
                //parcemos el demas texto que deberia se un numero 
                int fila=Integer.parseInt(extraerTexto(cadena, 1, cadena.length()-1))-1;
                // omprobamso si la cordenada esta dentro de las dimenciones del tabelro 
                if(columa<=dimencionColumnasDeTableroUtilizado&&fila<=dimencionFilasDeTableroUtilizado)
                {
                    //comprobamos si la pocision ingresasa es un espacio en blanco o no 
                    if(tableroDeJuegoUtilizado[fila][columa]!=null)
                    {
                        respuesta=true;
                    }
                    else{
                        respuesta =false;
                    }
                }
                else{
                    respuesta=false;
                }
            }
            else{
                respuesta=false;
            }
        }
        return respuesta;
    }
    /**
     * Muestra si nosotros podemos ejercer acciones sobre el planeta
     * @param cadena    texto qeu representa la celda
     * @param Tablero   Matriz de tipo Planetas
     * @param jugador   Nombre del jugador
     */
    private static void ordenarAlPlaneta(String cadena,Planetas[][]Tablero,String jugador){
        limpiarPantalla();
        cadena=cadena.toUpperCase();
        int columna=(int)cadena.charAt(0)-65;
        int fila=Integer.parseInt(extraerTexto(cadena, 1, cadena.length()-1))-1;
        if(Tablero[fila][columna].getPropietario().equals(jugador)||Tablero[fila][columna].getPropietario().equals("Neutral")){
            limpiarPantalla();
            Tablero[fila][columna].mostrarCarcteristicasDelPlaneta();
        }
        else
        {
            System.out.println("No tiene potestad sobre el planeta!!!!");
        }
        pausa("Precione ENTER para regresar al MAPA");
        limpiarPantalla();
    }
    /**
     * Verificamos si el jugador segun el nombre es el propietario del planeta
     * @param cadena Cordenada en formato de celda
     * @param Tablero   Matriz de tipo  Planetas
     * @param jugador   Nombre del jugador
     * @return
     */
    private static boolean verificarPropietario(String cadena,Planetas[][]Tablero,String jugador){
        boolean resultado = false;
        cadena=cadena.toUpperCase();
        int columna=(int)cadena.charAt(0)-65;
        int fila=Integer.parseInt(extraerTexto(cadena, 1, cadena.length()-1))-1;
        if(Tablero[fila][columna].getPropietario().equals(jugador)){
            resultado=true;
        }
        return resultado;
    }
    /**
     * Calculamos la distancia entre palentas por medio del teorema de pitagoras
     * @param cadena    Ubicacion del planeta en formato de celda
     * @param cadena2   Ubicacion del planeta en formade de celda
     * @return
     */
    public static float calularDistancia(String cadena,String cadena2){
        DecimalFormat formato = new DecimalFormat("#.00");
        float resultado=0;
        double distancia=0;
        cadena=cadena.toUpperCase();
        cadena2=cadena2.toUpperCase();
        int x=(int)cadena.charAt(0)-65;
        int y=Integer.parseInt(extraerTexto(cadena, 1, cadena.length()-1))-1;
        int x2=(int)cadena2.charAt(0)-65;
        int y2=Integer.parseInt(extraerTexto(cadena2, 1, cadena2.length()-1))-1;
        float X=(x2-x);
        float Y=(y2-y);
        distancia=Double.parseDouble(formato.format(Math.sqrt((X*X)+(Y*Y))));
        resultado=(float)distancia;
        return resultado;
    }
    /**
     * Imprecion de Nombre de los planetas segun el nombre del jugador, que identifica si es su propirtario
     * @param planetasRecibidos Array de tipo Planetas
     * @param Jugador   Nombre del jugador
     */
    private static void imprimirListaDePlanetas(Planetas[] planetasRecibidos,String Jugador){
        for (int i = 0; i < planetasRecibidos.length; i++) {
            if(planetasRecibidos[i].getPropietario().equals(Jugador))
            {
                System.out.println("Nombre del Planeta: "+planetasRecibidos[i].getNombreDePlaneta());
            }
        }
    }
    
    /**
     * Buscamos un planeta por medio de la ubicacion de la celda
     * @param cadena    String de la celda
     * @param Tablero   Tablero del juego
     * @return
     */
    private static Planetas retonarPlaneta(String cadena,Planetas[][]Tablero){
        Planetas temporal=null;
        cadena=cadena.toUpperCase();
        int columna=(int)cadena.charAt(0)-65;
        int fila=Integer.parseInt(extraerTexto(cadena, 1, cadena.length()-1))-1;
        temporal=Tablero[fila][columna];
        return temporal;
    }

    /**
     * Busamos un Planeta por el nombre del mismo
     * @param planetasRecibidos Array de planetas del juego
     * @param NombreDePlaneta
     * @return
     */
    private static Planetas buscarPorNombre(Planetas[] planetasRecibidos, String NombreDePlaneta){
        Planetas respuestaPlanetas=null;
        for (int i = 0; i < planetasRecibidos.length; i++) {
            if(planetasRecibidos[i].getNombreDePlaneta().equals(NombreDePlaneta)){
                respuestaPlanetas=planetasRecibidos[i];
                break;
            }
        }
        return respuestaPlanetas;
    }

    /**
     * Ingresamos un string y nos verifica si existe un nombre asi en el juego
     * @param entidad
     * @return booleano
     */
    private static boolean validadorDeTexto(String entidad){
        boolean respuesta=false;

        entidad=entidad.toLowerCase();

        switch (entidad) {
            case "ingeniero":
                respuesta=true;
                break;
            case "maestro de obra":
                respuesta =true;
                break;
            case "obrero":
                respuesta =true;
                break;
            case "arquitecto":
                respuesta =true;
                break;
            case "naboo n-1":
                respuesta =true;
                break;
            case "x-wing":
                respuesta =true;
                break;
            case "millenial falcon":
                respuesta =true;
                break;
            case "star destroyer":
                respuesta =true;
                break;
            case "mole":
                respuesta =true;
                break;
            case "nemo":
                respuesta =true;
                break;
            case "magma":
                respuesta =true;
                break;
            case "groot":
                respuesta =true;
                break;
            case "fision guy":
                respuesta =true;
                break;
            default:
                respuesta=false;
                break;
        }
        return respuesta;
    }

    /**
     * Ingresamos una variable de tipo String y nos devuelve la cantidad de comas que contiene
     * @param cadena   Texto a analizar
     * @return int
     */
    private static int contadorDeComas(String cadena){
        int respuesta=0;
        int j=0;
        int k=0;
        do{
            if(cadena.indexOf(",", j)>-1){
                j=cadena.indexOf(",", j)+1;
                k++;
            }
        }while(cadena.indexOf(",", j)!=-1);
        respuesta=k;
        return respuesta;
    }
    /**
     * Impricion de los eventos en cola segun el nombre del jugador que los creo
     * @param eventosREcibidos Array de tipo EventosEnCola
     * @param jugador   Nombre del jugador
     */
    private static void consultaDeFlota(EventosEnCola[] eventosREcibidos,String jugador){
        if(eventosREcibidos==null)
        {
            System.out.println("No hay precesos es cola");
        }
        else{

            for (int i = 0; i < eventosREcibidos.length; i++) {
                if(eventosREcibidos[i] instanceof EventoEnviarFlota||eventosREcibidos[i] instanceof EventoExportarGuerreros){
                    if(eventosREcibidos[i].getEstadoDeEjecucion()){
                        if(eventosREcibidos[i] instanceof EventoEnviarFlota&&eventosREcibidos[i].getJugador().equals(jugador))  
                        {
                            System.out.println("Envio De Flota a Planeta Enemigo");
                            System.out.println("Nombre del planeta de origen; "+eventosREcibidos[i].getPlanetaDeOrigen());
                            System.out.println("Nombre del planeta de destino; "+eventosREcibidos[i].getPlanetaDestino());
                            System.out.println("Cantidad de Guerreros Enviados; "+eventosREcibidos[i].getCantidadDeGuerrerosEnviados());
                            System.out.println("La nave llegara en el turno; "+eventosREcibidos[i].getTurnoDeEjecucion());
                            System.out.println("===========================================");
                        }
                        if(eventosREcibidos[i] instanceof EventoExportarGuerreros)
                        {
                            System.out.println("Envio De Flota a Planeta Aliado");
                            System.out.println("Nombre del planeta de origen; "+eventosREcibidos[i].getPlanetaDeOrigen());
                            System.out.println("Nombre del planeta de destino; "+eventosREcibidos[i].getPlanetaDestino());
                            System.out.println("Cantidad de Guerreros Enviados; "+eventosREcibidos[i].getCantidadDeGuerrerosEnviados());
                            System.out.println("La nave llegara en el turno; "+eventosREcibidos[i].getTurnoDeEjecucion());
                            System.out.println("===========================================");
                        }
                    }
                }
            }
        }
        pausa("\nPrecione ENTER para ir al mapa del juego");
    }
    /**
     * Ejecucion de los eventos que se realizan depues de la realizacon de turnos, evento ejecutado en el archivo Principal.java
     * @param turno numero de turno
     */
    public void accionesPostTurnos(int turno){

        for (int i = 0; i < planetasDelTableroUtilizado.length; i++) {
            planetasDelTableroUtilizado[i].produccionDeDineroFinalizacionDeTurno();
            planetasDelTableroUtilizado[i].generarGerreros(0, "Aleatorio");
        }

        
        
    }
    /**
     * Ejecucion de eventos que se realizan despues de una cierta cantidad de turnos
     * @param turno numero de turno
     */
    public void accionesEnSegundoPlano(int turno){
        if(this.colaJugadores!=null){

            for (int i = 0; i < this.colaJugadores.length; i++) {
                if (this.colaJugadores[i].getEstadoDeEjecucion()&&this.colaJugadores[i].getTurnoDeEjecucion()==turno) {
                    this.colaJugadores[i].ejecutar();
                }
            }
        }
    }
    /**
     * Actualizacion de mapa, accion ligada al archivo Principal.java y Tablero.java
     * @param turnoJugador
     * @param turnos
     */
    public void ActualizarMapa(String turnoJugador,int turnos){
        this.tableroUtilizado.imprimirMapa(turnoJugador, turnos);
    }
}