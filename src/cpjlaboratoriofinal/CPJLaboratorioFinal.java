
package cpjlaboratoriofinal;

import factories.Factory;
import factories.UtilitarioConexion;
import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CPJLaboratorioFinal {
    private static Scanner scan = new Scanner (System.in);
    private static int opcion = -1;    
    private static CatalogoPeliculas catalogo = null;
    
    public static void CPJLaboratorioFinal() {
        try {
            catalogo = Factory.obtenerCatalogoPeliculas();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main2(String[] args) throws Exception {        
    }
    
    public static void main (String [] args) throws Exception{
        CPJLaboratorioFinal();
        //Mientras que la opcion elegida sea 0, preguntamos
        while (opcion != 0){
            try{
                System.out.println("Elige una opción: \n"
                                  + "1.- Iniciar catalogo peliculas\n"
                                  + "2.-Agregar pelicula\n"
                                  + "3.-Listar peliculas\n"
                                  + "4.-Buscar pelicula\n"
                                  + "0.-Salir\n");
                opcion = Integer.parseInt(scan.nextLine());
                //ahora sale un switch para la diferentes opciones mencionada anteriormente
                
                switch(opcion){
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        catalogo.inciarArchivo();
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        System.out.println("Introduce el nombre de la pelicula que queres agregar: \n");
                        String nombre = scan.nextLine();
                        catalogo.agregarPelicula(nombre);
                        break;
                    case 3:
                        //3. listar catalogo completo
                        catalogo.listarPeliculas();
                        break;
                    case 4:
                        //4. Buscar pelicula
                        System.out.println("Introduce la pelicula que deseas buscar: \n");
                        String buscar = scan.nextLine();
                        catalogo.buscarPelicula(buscar);
                        break;
                    case 0: 
                        System.out.println("Hasta pronto!!!");
                        break;
                    default:    
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");
            }catch(Exception e){
                System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                e.printStackTrace();
            }
        }
    
    }
}