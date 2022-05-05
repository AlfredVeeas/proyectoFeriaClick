
package com.mycompany.proyectoferiaclick;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor {
        
    //atributos
    private int Puesto;
    private String NombreV;
    private String RUT;
    private String NombreL;
    private String HoraAtencion;
    private ArrayList<Vendedor> LVendedor=new ArrayList<Vendedor>();    
    private ArrayList<Producto> LProductos=new ArrayList<Producto>();
	
    //Costructores
    
    public Vendedor (){
        
    }
    
    public Vendedor(String NombreV,String Rut, String NombreL,String HoraAtencion,int Puesto,ArrayList<Producto>  productos){
        this.NombreV=NombreV;
        this.NombreL=NombreL;
        this.RUT=Rut;
        this.HoraAtencion=HoraAtencion;
        this.Puesto=Puesto;
        this.LProductos=productos;
    }

    public int getPuesto() {
        return Puesto;
    }

    public void setPuesto(int Puesto) {
        this.Puesto = Puesto;
    }

    public String getNombreV() {
        return NombreV;
    }

    public void setNombreV(String NombreV) {
        this.NombreV = NombreV;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getNombreL() {
        return NombreL;
    }

    public void setNombreL(String NombreL) {
        this.NombreL = NombreL;
    }

    public String getHoraAtencion() {
        return HoraAtencion;
    }

    public void setHoraAtencion(String HoraAtencion) {
        this.HoraAtencion = HoraAtencion;
    }

    public ArrayList<Vendedor> getLVendedor() {
        return LVendedor;
    }

    public void setLVendedor(ArrayList<Vendedor> LVendedor) {
        this.LVendedor = LVendedor;
    }

    public ArrayList<Producto> getLProductos() {
        return LProductos;
    }

    public void setLProductos(ArrayList<Producto> LProductos) {
        this.LProductos = LProductos;
    }
    
    
    //Comportamientos
    public void CrearVendedor(){ //registro de un nuevo vendedor
        int Puesto;
        String NombreV;
        String RUT;
        String NombreL;
        String HoraAtencion;
        int productosVender;
       
        Scanner Entrada = new Scanner(System.in);
        
        System.out.println("Ingreso de vendedor ");
        
        System.out.println("Ingrese su numero de puesto ");
        Puesto=Entrada.nextInt();
        System.out.println("Ingrese su nombre");
        NombreV=Entrada.next();
        System.out.println("Ingrese su rut");
        RUT=Entrada.next();
        System.out.println("Ingrese el nombre de su local");
        NombreL=Entrada.next();
        System.out.println("Indique su horario de atencion");
        HoraAtencion=Entrada.next();
        //Ingreso de productos del vendedor
        
        System.out.println("¿Cuantos productos vas a ingresar "+NombreV+"?");
        productosVender=Entrada.nextInt();
        
        Producto productos=new Producto();
        
        for (int i = 0 ; i <= productosVender ; i++){
            productos.AgregarProducto();
        }
        
        Vendedor feriante = new Vendedor(NombreV,RUT,NombreL,HoraAtencion,Puesto,productos.getLProductos());

 
        
        LVendedor.add(feriante);
        
        
        
        
        
    }
    public void ConsultarVendedor(){ 
        
        for(int i=0;i<LVendedor.size();i++){
             
             System.out.println("<<< ***************Puesto No "+LVendedor.get(i).getPuesto()+ " ***********************>>>");
             System.out.println("<<< ************ Productos disponibles *********************** >>>");
             System.out.println("<<< Nombre----------------Stock----------------Precio >>>>");
             for(int j=0;j<LVendedor.get(i).LProductos.size();j++){
                 System.out.println("<<< "+LVendedor.get(i).LProductos.get(j).getNombre()+"----------------"+LVendedor.get(i).LProductos.get(j).getStock()+"----------------$"+LVendedor.get(i).LProductos.get(j).getPrecio()+" >>>>");
             }
             
             System.out.println("");
       }
    }
    public void ActualizarVendedor(String rut){
        int opcion, posicion = -1;
        Scanner entrada = new Scanner (System.in);
        
        for(int i=0;i<LVendedor.size();i++){
            if(LVendedor.get(i).getRUT()==rut)
                posicion=i;
           
        }
        
        System.out.println("Elemento encontrado en: "+posicion);
        System.out.println("Que va a querer modificar del vendedor");
        System.out.println("1. Nombre.  2. NumPuesto.  3.Hora de atencion. ");
        System.out.println();
        
        // no se necesita cambiar la id de un producto ya que es unico
        opcion = entrada.nextInt();
        
        switch(opcion){
            case 1:
                String NuevoNombre;
                
                System.out.println("Ingrese un nuevo nombre");
                NuevoNombre = entrada.next();
                
                LVendedor.get(posicion).setNombreV(NuevoNombre);
            break;
            
            case 2:
                int NuevoNum;
                
                System.out.println("Ingrese un nuevo tipo");
                NuevoNum = entrada.nextInt();
                
                LVendedor.get(posicion).setPuesto(NuevoNum);
            break;
            
            case 3:
                String NuevoHorario;
                
                System.out.println("Ingrese un nuevo stock");
                NuevoHorario = entrada.next();
                
                LVendedor.get(posicion).setHoraAtencion(NuevoHorario);
            break;
            
           
        }
        
    }
    public void EliminarVendedor(String rut){
        for(int i = 0 ; i<LVendedor.size() ; i++){
            if(LVendedor.get(i).getRUT()==rut){
                LVendedor.remove(i);
            }
        }
    }
}
