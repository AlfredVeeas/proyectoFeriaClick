/*
    Alfredo Esteban Veas Albornoz 20.983.109-0
    Nicolás Alejandro Zamorano León. 20.959.812-4
    Pablo Andrés Sánchez Mayorga.  20.999.959-5

*/

package app;

import java.text.ParseException;
import java.util.Scanner;

/**
 * 
 * @author evert
 */

public class Principal  {
    
    public static Producto productosFeriante= new Producto() ;
    public static Feria ferias = new Feria() ;
    public static Vendedor vendedor = new Vendedor() ;
    public static Persona personita;
    public static Interfaz interfaz=new Interfaz();
       
    public static void main(String [] args) throws ParseException{
        
        interfaz.CrearMenu();
        interfaz.Configuracion();
        
        
    }
    
}
