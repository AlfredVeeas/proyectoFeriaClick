/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author evert
 */
public class Cliente extends Persona {
    private int dinero;

    public Cliente(int dinero, String Nombre, String Rut, String Direccion) {
        super(Nombre, Rut, Direccion);
        this.dinero = dinero;
    }

    @Override
    public int getDinero() {
        return dinero;
    }

    @Override
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    @Override
    public String identificarse(){
        return getNombre() + getRut();
    }

    @Override
    public void ComprarProducto() {
        super.ComprarProducto(); 
    }

    @Override
    public void AgregarFondos() {
        super.AgregarFondos(); 
    }
    
    
}
