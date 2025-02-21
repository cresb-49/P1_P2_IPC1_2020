package Proyecto1.Tienda;


import Proyecto1.Planetas.*;
import Proyecto1.Naves.*;
import Proyecto1.Constructores.*;
import java.util.Scanner;


public class Tienda {
    /**
     * Cosntructro Vacio
     * Clase que solo maneja datos
     */
    public Tienda(){

    }
    
    /** 
     * Accion de vender segun un planeta
     * @param PlanetaAProcesar
     * @param Jugador
     */
    public void Vender(Planetas PlanetaAProcesar, String Jugador){
        Scanner teclado = new Scanner(System.in);
        if(PlanetaAProcesar.getPropietario().equals(Jugador)){
            boolean repeticion=true;
            //ciclo que procesa la informacion ingresado y verifica si es la correcta
            do {
                limpiarPantalla();
                System.out.println("Que es lo que desea vender: ");
                System.out.println("\n1. Vender Constructor");
                System.out.println("2. Vender Nave\n3. Salir a la tienda");
                System.out.print("\nIngrese el numero de opcion a procesar: ");
                switch (teclado.nextLine()) {
                    case "1":
                    {
                        limpiarPantalla();
                        System.out.println("CONTRUCTORES DISPONIBLES\n");
                        repeticion=false;
                        Constructores[]constructoresTemporales=PlanetaAProcesar.getConstructores();
                        //imprimirmos los cosntructores que hay en un planeta
                        for (int i = 0; i < constructoresTemporales.length; i++) {
                            System.out.println(constructoresTemporales[i].tipoDeConstructor()+", ");
                        }
                        boolean repeticion2=true;
                        String seleccion;
                        //ciclo que verifica que lo que queremos vender existe
                        do {
                            System.out.print("\nIngrese la clase de constructor que desea vender: ");
                            seleccion=teclado.nextLine();
                            //comporbamos el texto que se ingreso
                            for (int i = 0; i < constructoresTemporales.length; i++) {
                                if(constructoresTemporales[i].tipoDeConstructor().toLowerCase().equals(seleccion.toLowerCase()))
                                {
                                    //ser realiza la compra y se substrae el costo a los fondos del planeta
                                    repeticion2=false;
                                    PlanetaAProcesar.setFondosDelPlaneta(PlanetaAProcesar.getFondosDelPlaneta()+constructoresTemporales[i].getPrecioDeVenta());
                                    constructoresTemporales[i]=null;
                                    Constructores[] temporal=new Constructores[constructoresTemporales.length-1];
                                    int x=0;
                                    for (int j = 0; j < constructoresTemporales.length; j++) {
                                        if(constructoresTemporales[j]!=null){
                                            temporal[x]=constructoresTemporales[j];
                                            x++;
                                        }
                                    }
                                    //generamos en constructor y lo seteamos en el planeta
                                    PlanetaAProcesar.setCantidadDeConstructores(temporal,x);
                                    break;
                                }
                            }
                            if(repeticion2==true){
                                System.out.println("constructor no encontrado!!!");
                            }
                        } while (repeticion2);
                        System.out.println("Proceso Realizado con exito!!!");
                        pausa();
                    }
                        break;
                    case "2":
                    {
                        limpiarPantalla();
                        System.out.println("NAVES DISPONIBLES\n");
                        repeticion=false;
                        Naves[]navesTemporales=PlanetaAProcesar.getNaves();
                        for (int i = 0; i < navesTemporales.length; i++) {
                            System.out.println(navesTemporales[i].tipoDeNave()+", ");
                        }
                        boolean repeticion2=true;
                        String seleccion;
                        //ciclo que verifica que lo que queremso vender existe
                        do {
                            System.out.print("\nIngrese la clase de nave que desea vender: ");
                            seleccion=teclado.nextLine();
                            //comporbamos el texto que se ingreso
                            for (int i = 0; i < navesTemporales.length; i++) {
                                if(navesTemporales[i].tipoDeNave().toLowerCase().equals(seleccion.toLowerCase()))
                                {
                                    //ser realiza la compra y se substrae el costo a los fondos del planeta
                                    repeticion2=false;
                                    PlanetaAProcesar.setFondosDelPlaneta(PlanetaAProcesar.getFondosDelPlaneta()+navesTemporales[i].costoDeProduccion());
                                    navesTemporales[i]=null;
                                    Naves[] temporal=new Naves[navesTemporales.length-1];
                                    int x=0;
                                    for (int j = 0; j < navesTemporales.length; j++) {
                                        if(navesTemporales[j]!=null){
                                            temporal[x]=navesTemporales[j];
                                            x++;
                                        }
                                    }
                                    //generamos la nave y la seteamos en el planeta
                                    PlanetaAProcesar.setCantidadDeNaves(temporal,x);
                                    break;
                                }
                            }
                            if(repeticion2==true){
                                System.out.println("Nave no encontrado!!!");
                            }
                        } while (repeticion2);
                        System.out.println("Proceso Realizado con exito!!!");
                        pausa();
                    }
                        break;
                    case "3":
                        repeticion=false;
                        break;
                    default:
                        System.out.println("ERROR DE OPCION!!!!");
                        break;
                }
            } while (repeticion);
        }   
        else{
            System.out.println("No tiene potestad sobre el planeta!!!!");
        }
    }
    
    /** 
     * Vender obejetos del planeta
     * @param PlanetaAProcesar
     * @param Jugador
     */
    public void Comprar(Planetas PlanetaAProcesar, String Jugador){
        Scanner teclado = new Scanner(System.in);
        if(PlanetaAProcesar.getPropietario().equals(Jugador)){
            boolean repeticion=true;
            //ciclo que procesa la informacion ingresado y verifica si es la correcta
            do {
                limpiarPantalla();
                System.out.println("Que tipo de constructor desea comprar: ");
                System.out.println("\n1. Obrero\n2. Maestro de Obra\n3. Arquitecto\n4. Ingeniero\n5. Salir a la tienda\n");
                System.out.print("\nIngrese el numero de opcion a procesar: ");
                String opcion=teclado.nextLine();
                int dineroMinimo=0;
                //Asignamos dinera minimo para la operacion qeu del compra
                switch (opcion) {
                    case "1":
                        dineroMinimo=50;
                        break;
                    case "2":
                        dineroMinimo=100;
                        break;
                    case "3":
                        dineroMinimo=250;
                        break;
                    case "4":
                        dineroMinimo=300;
                        break;
                    default:
                        break;
                }
                if(PlanetaAProcesar.getFondosDelPlaneta()<dineroMinimo)
                {
                    System.out.println("No puede Realizar la compra del Constructor");
                    pausa();
                }
                //ralizamos la accion dpendiendo del numero ingresado
                else{
                    //Creamos el constructor y se ingresan a las filas obreras del planeta
                    switch (opcion) {
                        case "1":
                            repeticion=false;
                            PlanetaAProcesar.generarConstructores(1, "Obrero");
                            PlanetaAProcesar.setFondosDelPlaneta(PlanetaAProcesar.getFondosDelPlaneta()-dineroMinimo);
                            System.out.println("Proceso Realizado con exito!!!");
                            pausa();
                            break;
                        case "2":
                            PlanetaAProcesar.generarConstructores(1,"Maestro De Obras");
                            repeticion=false;
                            PlanetaAProcesar.setFondosDelPlaneta(PlanetaAProcesar.getFondosDelPlaneta()-dineroMinimo);
                            System.out.println("Proceso Realizado con exito!!!");
                            pausa();
                            break;
                        case "3":
                            PlanetaAProcesar.generarConstructores(1,"Arquitecto");
                            repeticion=false;
                            PlanetaAProcesar.setFondosDelPlaneta(PlanetaAProcesar.getFondosDelPlaneta()-dineroMinimo);
                            System.out.println("Proceso Realizado con exito!!!");
                            pausa();
                            break;
                        case "4":
                            PlanetaAProcesar.generarConstructores(1,"Ingeniero");
                            repeticion=false;
                            PlanetaAProcesar.setFondosDelPlaneta(PlanetaAProcesar.getFondosDelPlaneta()-dineroMinimo);
                            System.out.println("Proceso Realizado con exito!!!");
                            pausa();
                            break;
                        case "5":
                            repeticion=false;
                            break;
                        default:
                            System.out.println("Error de opcion!!!");
                            pausa();
                            break;
                    }
                    
                }
                    
            }while(repeticion);
        }
    }
    /**
     * Funcion par limpiar pantalla
     */
    private static void limpiarPantalla(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    /**
     * Pausa del proceso del juego
     */
    public static void pausa(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Precione ENTER para continuar");;
        teclado.nextLine();
    }
    
}