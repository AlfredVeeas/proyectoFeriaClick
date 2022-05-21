/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author evert
 */
public abstract class Persona {
    private String Nombre;
    private String Rut;
    
    public Persona(String Nombre, String Rut) {
        this.Nombre = Nombre;
        this.Rut = Rut;
    }
                                                             
    public abstract String identificarse();
    
    public  String getNombre(){
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public  String getRut(){
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    } 
    
    
}
