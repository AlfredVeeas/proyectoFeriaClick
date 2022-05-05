
package com.mycompany.proyectoferiaclick;

import java.util.ArrayList;
import java.util.Scanner;

public class Feria {
    
    public ArrayList<Feria> LFeria=new ArrayList<Feria>();
    
    //atributos 
    private String NombreFeria;
    private String DireccionFeria;  
    
    //constructores
    public Feria(){
        
    }
    
    public Feria(String NombreFeria, String DireccionFeria){
        this.NombreFeria=NombreFeria;
        this.DireccionFeria=DireccionFeria;
    }
    //accesores 
    
    public String getNombreFeria(){
        return NombreFeria;
    }
    public String getDireccionFeria(){
        return DireccionFeria;
    }
    
    //mutadores 
    
    public void setNombreFeria(String NombreFeria1){
        NombreFeria=NombreFeria1;
    }
    
    public void setDireccionFeria(String DireccionFeria1){
        DireccionFeria=DireccionFeria1;
    }
    
    //Comportamientos 
    public void IngresarFeria(){
        String NFeria;
        String DFeria;
        Scanner Entrada=new Scanner(System.in);
        
        System.out.println("Ingrese el nombre  de la feria (SIN ESPACIOS)");
        NFeria=Entrada.next();
        System.out.println("Ingrese el direccion de la feria");
        DFeria=Entrada.next();
        
        Feria ferias = new Feria(NFeria,DFeria);
        LFeria.add(ferias);
    }
    
    //Metodo que muestra la lista de ferias disponibles
    public void MostrarFerias(){ 
        for(int i=0;i<LFeria.size();i++){
            System.out.println(LFeria.get(i).NombreFeria);
            System.out.println(LFeria.get(i).DireccionFeria);
            
        }
    }
    
    //Metodo que muestra los objetos que hay dentro de feria (Por el momento no sera implementada)
    /**
      public void ConsultarFeria(int i){
        
        }   
     */
    
    
    //Metodo que modifica algun atributo dentro de feria
    public void ModificarFeria(String NombreFeria){
        int opcion, posicion = -1;
        Scanner entrada = new Scanner (System.in);
        
        for(int i=0;i<LFeria.size();i++){
            if(LFeria.get(i).getNombreFeria()==NombreFeria)
                posicion=i;
           
        }
        
        System.out.println("Elemento encontrado en: "+posicion);
        System.out.println("Que va a querer modificar de ferias");
        System.out.println("1. Nombre.  2. Direccion.");
        System.out.println();
        
        // no se necesita cambiar la id de un producto ya que es unico
        opcion = entrada.nextInt();
        
        switch(opcion){
            case 1:
                String NuevoNombre;
                
                System.out.println("Ingrese un nuevo nombre");
                NuevoNombre = entrada.next();
                
                LFeria.get(posicion).setNombreFeria(NuevoNombre);
            break;
            
            case 2:
                String NuevaDireccion;
                
                System.out.println("Ingrese un nuevo tipo");
                NuevaDireccion = entrada.next();
                
                LFeria.get(posicion).setDireccionFeria(NuevaDireccion);
            break;
            
            
        }
    }
    //Metodo que elimina algun objeto dentro de la coleccion de ferias
    public void EliminarFeria(String NombreFeria){
        for(int i = 0 ; i<LFeria.size() ; i++){
            if(LFeria.get(i).getNombreFeria()==NombreFeria){
                LFeria.remove(i);
            }
        }
    }
}
