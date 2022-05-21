/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Scanner;

/**
 *
 * @author evert
 */
public class Cliente extends Persona implements Compra{
    private int dinero;
    private Vendedor vendedor;
    
    public Cliente(int dinero, String Nombre, String Rut) {
        super(Nombre, Rut);
        this.dinero = dinero;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    @Override
    public String identificarse(){
        return getNombre() + getRut();
    }
    
    @Override
    public void ComprarProducto(){
        String ProductoComprar="";
        Scanner Entrada = new Scanner(System.in);
        
        if(dinero > 0){
            System.out.println("¿Que producto desea comprar? "+getNombre());
            ProductoComprar=Entrada.nextLine();
            if(vendedor.ValidarProducto(ProductoComprar)){
                setDinero(dinero-100);
            }
        }
    }
    @Override 
    public void AgregarFondos(){
        int nuevosFondos;
        Scanner Entrada = new Scanner(System.in);
        System.out.println("¿Cuanto dinero quieres agregar? "+getNombre());
        nuevosFondos = Entrada.nextInt();
        
        setDinero(dinero+nuevosFondos);
        
    }
}
