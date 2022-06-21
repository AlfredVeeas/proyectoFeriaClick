
package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor implements Compra{
        
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
    
    public Vendedor(ArrayList<Producto>  productos){
        this.LProductos=productos;
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
        String NombreV="";
        String RUT="";
        String NombreL="";
        String HoraAtencion="";
        int productosVender;
        
        InterfaceVendedor vendedorGui= new InterfaceVendedor("CrearVendedor");
        vendedorGui.ConstuirFormulario();
        
        
    }
    
    //Metodo que consulta por el rut de vendedor para poder ingresar nuevos productos
    public void IngresarVendedor(String RUT){
        int productosVender;
        
        Scanner Entrada = new Scanner(System.in);
        
        if(!(ValidarRut(RUT))){
            System.out.println("Rut no encontrado");
        }else{
            System.out.println("Bienvenido "+LVendedor.get(EncontrarVendedor(RUT)).getNombreV());
            
            System.out.println("¿Cuantos productos vas a ingresar "+LVendedor.get(EncontrarVendedor(RUT)).getNombreV()+"?");
            productosVender=Entrada.nextInt();
        
            Producto productos=new Producto();
        
            for (int i = 0 ; i < productosVender ; i++){
                productos.AgregarProducto();
            }
            
            LVendedor.get(EncontrarVendedor(RUT)).LProductos.add(productos);
        }
    }
    
    
    public void ConsultarVendedor(){ 
        
        System.out.println(LVendedor.size());
        
        for(int i=0;i<LVendedor.size();i++){
             
             System.out.println("<<< ***************Puesto: "+LVendedor.get(i).getNombreL() +" ***********************>>>");
             System.out.println("<<< ***************Horario de atencion: "+LVendedor.get(i).getHoraAtencion() +" ***********************>>>");
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
            if(LVendedor.get(i).getRUT().equals(rut))
                posicion=i;
           
        }
        
        System.out.println("Elemento encontrado en: "+(posicion + 1));
        System.out.println("Que va a querer modificar del vendedor");
        System.out.println("1. Nombre.  2. NumPuesto.  3.Hora de atencion. ");
        System.out.println();
        
        // no se necesita cambiar la id de un producto ya que es unico
        opcion = entrada.nextInt();
        
        switch(opcion){
            case 1:
                String NuevoNombre="";
                
                System.out.println("Ingrese un nuevo nombre");
                NuevoNombre = entrada.nextLine();
                
                LVendedor.get(posicion).setNombreV(NuevoNombre);
            break;
            
            case 2:
                int NuevoNum;
                
                System.out.println("Ingrese un nuevo numero de puesto");
                NuevoNum = entrada.nextInt();
                
                LVendedor.get(posicion).setPuesto(NuevoNum);
            break;
            
            case 3:
                String NuevoHorario="";
                
                System.out.println("Ingrese un nuevo horario");
                NuevoHorario = entrada.nextLine();
                
                LVendedor.get(posicion).setHoraAtencion(NuevoHorario);
            break;
            
           
        }
        
    }
    public void EliminarVendedor(String rut){
        for(int i = 0 ; i<LVendedor.size() ; i++){
            if(LVendedor.get(i).getRUT().equals(rut)){
                LVendedor.remove(i);
            }
        }
    }
    
    //metodo que valida por rut de vendedor si esta en sistema
    public boolean ValidarRut(String rut){
        for(int i = 0 ; i<LVendedor.size() ; i++){
            if(LVendedor.get(i).getRUT().equals(rut)){
                return true;
            }
        }
        return false;
    }
    
    //busca un vendedor por rut y retorna la posicion que se encuentra en el sistema
    public int EncontrarVendedor(String rut){
        for(int i = 0 ; i<LVendedor.size() ; i++){
            if(LVendedor.get(i).getRUT().equals(rut)){
                return i;
            }
        }
        return -1;
    }
    
    //valida que un puesto no se encuentre repetido 
    public boolean ValidarNumeroPuesto(int N){
        for(int i = 0 ; i<LVendedor.size() ; i++){
            if(LVendedor.get(i).getPuesto()==N){
                return true;
            }
        }
        return false;
    }
 
    public boolean ValidarProducto(String Producto){
        for(int i = 0 ; i<LVendedor.size() ; i++){
            for(int j = 0 ; i<LVendedor.get(i).LProductos.size() ; i++){
                if(LVendedor.get(i).LProductos.get(j).getNombre().equals(Producto))
                   return true; 
            }
                           
        }
        return false;
    }
    
    public int [] BuscarVendedor(String Producto){
        int [] posiciones = new int [2];
        
        for(int i = 0 ; i<LVendedor.size() ; i++){
            for(int j = 0 ; i<LVendedor.get(i).LProductos.size() ; i++){
                if(LVendedor.get(i).LProductos.get(j).getNombre().equals(Producto))
                   posiciones[0]=i;
                   posiciones[1]=j;
            }
                           
        }
        return posiciones ;
    }
    
    //busca el primer vendedor que tiene cierto producto dentro del sistema 
    //de vendedor, y descuenta del stock
    public void SacarStock(String Producto,int Cant){
       int [] posVendedor=BuscarVendedor(Producto);
       
       LVendedor.get(posVendedor[0]).LProductos.get(posVendedor[1]).setStock(LProductos.get(posVendedor[1]).getStock()-Cant);
       
    }
    
    @Override 
    public void ComprarProducto(){
        String ProductoComprar="";
        int CantCompra;
        Scanner Entrada = new Scanner(System.in);
        
        System.out.println("¿Que productos deseas comprar?" +getNombreV());
        ProductoComprar = Entrada.nextLine();
        
        if(ValidarProducto(ProductoComprar)){
            System.out.println("¿Cuantos productos deseas comprar?" +getNombreV());
            CantCompra=Entrada.nextInt();
            SacarStock(ProductoComprar,CantCompra);
        } else
            System.out.println("Producto no encontrado");
    }

    @Override
    public void AgregarFondos() {
        
    }
}

