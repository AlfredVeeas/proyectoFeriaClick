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
    
       
    public static void main(String [] args) throws ParseException{
        int opcion;
        Scanner Entrada = new Scanner(System.in);
        
        do{
            System.out.println("BIENVENIDO A FERIA CLICK");
            System.out.println();

            System.out.println("DIGITE UNA OPCION DE MENU: ");
            System.out.println();

            System.out.println("0.  Salir");
            System.out.println("1.  Agregar productos ");
            System.out.println("2.  Mostrar productos ");
            System.out.println("3.  Modificar productos ");
            System.out.println("4.  Eliminar productos ");
            System.out.println("5.  Registrar feriante");
            System.out.println("6.  Mostrar feriantes");
            System.out.println("7.  Modificar feriante");
            System.out.println("8.  Eliminar feriante");
            System.out.println("9.  Registrar feria");
            System.out.println("10. Mostrar ferias");
            System.out.println("11. Modificar ferias");
            System.out.println("12. Eliminar feria");
            System.out.println("13. Ingresar como feriante");

            opcion = Entrada.nextInt();

                       
            switch (opcion){
                case 1: 
                    productosFeriante.AgregarProducto();
                break;

                case 2:
                    
                    productosFeriante.EscribirProducto();
                break;
                    
                case 3: 
                    int codigoAux;
                    Scanner aux = new Scanner(System.in);
                    System.out.println("Ingrese codigo de producto a eliminar");
                    codigoAux= aux.nextInt();
                    
                    productosFeriante.ActualizarStock(codigoAux);
                break;
                    
                case 4:
                    int codigoAux2;
                    Scanner aux2 = new Scanner(System.in);
                    
                    System.out.println("Ingrese codigo de producto a eliminar");
                    codigoAux2 =  aux2.nextInt();
                    
                    productosFeriante.BorrarProducto(codigoAux2);
                break;
                    
                case 5: 
                    vendedor.CrearVendedor();
                    
                    
                break;
                    
                case 6: 
                                
                    
                    vendedor.ConsultarVendedor();
                break;
                    
                case 7: 
                    String rut;
                    Scanner auxV = new Scanner(System.in);
                    
                    System.out.println("Ingrese rut de vendedor");
                    rut = auxV.next();
                    vendedor.ActualizarVendedor(rut);;

                break;
                    
                case 8:
                    String rutAux;
                    Scanner auxVendedor = new Scanner(System.in);
                    
                    System.out.println("Ingrese rut de vendedor");
                    rutAux = auxVendedor.next();
                    vendedor.EliminarVendedor(rutAux);
                break;
                    
                case 9: 
                    ferias.IngresarFeria();
                break;
                    
                case 10: 
                    ferias.MostrarFerias();
                break;
                    
                case 11:
                    String NombreFeria;
                    Scanner auxFeria = new Scanner(System.in);
                    
                    System.out.println("Ingrese nombre de feria a modificar");
                    NombreFeria= auxFeria.next();
                    
                    ferias.ModificarFeria(NombreFeria);
                break;
                    
                case 12: 
                    String NombreFeria1="";
                    Scanner auxFeria1 = new Scanner(System.in);
                    
                    System.out.println("Ingrese nombre de feria a eliminar");
                    NombreFeria1= auxFeria1.nextLine();
                    
                    ferias.EliminarFeria(NombreFeria1);
                break;
                
                case 13:
                    String rut1;
                    Scanner entrada = new Scanner(System.in);
                    
                    System.out.println("Ingrese rut de vendedor");
                    rut1= entrada.next();                
                    vendedor.IngresarVendedor(rut1);
                break;
                
                case 14:
                    String Nombre="";
                    String Rut="";
                    String Direccion="";
                    int dinero;
                    
                    Scanner readCliente = new Scanner(System.in);
                    
                    System.out.println("Ingrese su nombre");
                    Nombre=readCliente.nextLine();
                    
                    System.out.println("Ingrese su rut");
                    rut=readCliente.nextLine();
                    
                    System.out.println("Ingrese su direccion");
                    Direccion=readCliente.nextLine();
                    
                    System.out.println("Ingrese cuanto dinero tienes para gastar");
                    dinero=readCliente.nextInt();
                    
                    personita = new Cliente(dinero,Nombre,rut,Direccion);
                break;
            }
        }while(opcion != 0);  
        
    }
}
