/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author evert
 */
public class Repartidor extends Persona{
    private String MatriculaVehiculo;
    private int dinero;

    
    public Repartidor(String MatriculaVehiculo, String Nombre, String Rut, String Direccion) {
        super(Nombre, Rut, Direccion);
        this.MatriculaVehiculo = MatriculaVehiculo;
    }

    public String getMatriculaVehiculo() {
        return MatriculaVehiculo;
    }

    public void setMatriculaVehiculo(String MatriculaVehiculo) {
        this.MatriculaVehiculo = MatriculaVehiculo;
    }

    public Repartidor(String MatriculaVehiculo, int dinero, String Nombre, String Rut, String Direccion) {
        super(Nombre, Rut, Direccion);
        this.MatriculaVehiculo = MatriculaVehiculo;
        this.dinero = dinero;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    
    
    
    @Override
    public String identificarse() {
        return getNombre() + getDireccion() + getMatriculaVehiculo();
    }
    
    public void Repartir(String Direccion){
        System.out.println("Repartiendo a :"+Direccion);
    }

    @Override
    public void ComprarProducto() {
        super.ComprarProducto(); 
    }

    @Override
    public void AgregarFondos() {
        super.AgregarFondos(); 
    }
    
    
    
    /*
    @Override
    public void ComprarProducto() {
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
    public void AgregarFondos() {
        int nuevosFondos;
        Scanner Entrada = new Scanner(System.in);
        System.out.println("¿Cuanto dinero quieres agregar? "+getNombre());
        nuevosFondos = Entrada.nextInt();
        
        setDinero(dinero+nuevosFondos);
    }
    */
}
