package com.mycompany.proyectoferiaclick;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    
    
    
        
    //Atributos
    private String Nombre ;//nombre del producto
    private String Tipo;//Si es verduda, fruta, fruto seco, etc
    private int ID;//Codigo de barra
    private int Stock;//disponibilidad 
    private int Precio;//Valor del producto
    private ArrayList<Producto> LProductos = new ArrayList <Producto>();
    
    
    public ArrayList<Producto> getLProductos() {
        return LProductos;
    }

    public void setLProducto(ArrayList<Producto> LProductos) {
        this.LProductos = LProductos;
    }
    
    
    public Producto(){
       
    }
    
    //Constructores 
    
    
    
    public Producto(String Nombre, String Tipo, int id, int stock, int precio){
        this.Nombre=Nombre;
        this.Tipo=Tipo;
        this.ID=id;
        this.Stock=stock;
        this.Precio=precio;
    }
    //Accesores
    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public int getID() {
        return ID;
    }

    public int getStock() {
        return Stock;
    }

    public int getPrecio() {
        return Precio;
    }
    
    //Mutadores
    public void setNombre(String Nombre1) {
        Nombre = Nombre1;
    }

    public void setTipo(String Tipo1) {
        Tipo = Tipo1;
    }

    public void setID(int ID) {
        this.ID=ID;
    }

    public void setStock(int StockProducto) {
        Stock=StockProducto;
    }

    public void setPrecio(int PrecioProducto) {
        this.Precio = PrecioProducto;
    }
    
       
    //Comportamientos 
    public void AgregarProducto() {
        String Nombre ;
        String Tipo;
        int ID;
        int Stock;
        int Precio;
        
        Scanner Entrada = new Scanner(System.in);
        
        System.out.println("Registro de producto ");
        
        System.out.println("Ingrese nombre del producto ");
        Nombre=Entrada.next();
        System.out.println("Ingrese tipo del producto");
        Tipo=Entrada.next();
        System.out.println("Ingrese Codigo del producto");
        ID=Entrada.nextInt();
        System.out.println("Ingrese Cantidad del producto");
        Stock=Entrada.nextInt();
        System.out.println("Ingrese El precio del producto");
        Precio=Entrada.nextInt();
        
        Producto producto = new Producto(Nombre,Tipo,ID,Stock,Precio);
        
        LProductos.add(producto);
        
    }
    public void EscribirProducto(){
        
        for(int i=0;i<LProductos.size();i++){
            System.out.println(LProductos.get(i).Nombre);
            System.out.println(LProductos.get(i).Tipo);
            System.out.println(LProductos.get(i).ID);
            System.out.println(LProductos.get(i).Stock);
            System.out.println(LProductos.get(i).Precio);
        }
        
        
    }
    public void ActualizarStock(int codigo){
        int opcion, posicion = -1;
        Scanner entrada = new Scanner (System.in);
        
        for(int i=0;i<LProductos.size();i++){
            if(LProductos.get(i).getID()==codigo)
                posicion=i;
           
        }
        
        System.out.println("Elemento encontrado en: "+posicion);
        System.out.println("Que va a querer modificar del producto");
        System.out.println("1. Nombre.  2. Tipo.  3.Stock disponible.  4. Precio");
        System.out.println();
        
        // no se necesita cambiar la id de un producto ya que es unico
        opcion = entrada.nextInt();
        
        switch(opcion){
            case 1:
                String NuevoNombre;
                
                System.out.println("Ingrese un nuevo nombre");
                NuevoNombre = entrada.next();
                
                LProductos.get(posicion).setNombre(NuevoNombre);
            break;
            
            case 2:
                String NuevoTipo;
                
                System.out.println("Ingrese un nuevo tipo");
                NuevoTipo = entrada.next();
                
                LProductos.get(posicion).setTipo(NuevoTipo);
            break;
            
            case 3:
                int NuevoStock;
                
                System.out.println("Ingrese un nuevo stock");
                NuevoStock = entrada.nextInt();
                
                LProductos.get(posicion).setStock(NuevoStock);
            break;
            
            case 4:
                int NuevoPrecio;
                
                System.out.println("Ingrese un nuevo precio");
                NuevoPrecio = entrada.nextInt();
                
                LProductos.get(posicion).setStock(NuevoPrecio);
            break;
        }
        
    }
    public void BorrarProducto(int codigo){
        for(int i=0;i<LProductos.size();i++){
            if(LProductos.get(i).getID()==codigo)
                LProductos.remove(i);
        }
    }
    
}
