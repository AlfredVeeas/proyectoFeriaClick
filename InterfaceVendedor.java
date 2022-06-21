package app;


import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfaceVendedor extends Frame implements WindowListener, ActionListener, KeyListener {
    
    private Label lblNombre, lblPuesto,lblRut,lblNombreLocal,lblHoraDeAtencion,lblMensaje;
    private Button btnAceptar, btnLimpiar,btnReporte;
    private TextField txtNombre,txtPuesto,txtRut,txtNombreLocal,txtHoraDeAtencion;
    private Choice chRegion;
    boolean presion=false;
    
    private Vendedor vendedor=new Vendedor();

    

    /**
     *
     * @param titulo
     */
   
    
    
    
    public InterfaceVendedor(String titulo){
          super(titulo);
          

          this.addWindowListener(this);
          
          
         
     }

    public void ConstuirFormulario(){
         
         this.setSize(1000, 600);// w,h
         this.setLayout(null);
         this.setVisible(true);
         
	 Color formColor = new Color(53, 59, 72);
	 setBackground(formColor);
         
         
         Font titleFont = new Font("arial", Font.BOLD, 25);
	 Font labelFont =new  Font("arial", Font.PLAIN, 18);
	 Font textFont =new  Font("arial", Font.PLAIN, 15);
         
         
         
         lblMensaje=new Label("");
         lblMensaje.setForeground(Color.RED);
         lblMensaje.setBounds(400,50,400,30);
         
         lblNombre=new Label("Nombre");  
	 lblNombre.setBounds(250,100,150,30);
	 lblNombre.setFont(labelFont);  
	 lblNombre.setForeground(Color.WHITE);
         
         
         txtNombre=new TextField();
	 txtNombre.setBounds(400,100,400,30);
	 txtNombre.setFont(textFont);
         

         lblPuesto=new Label("N° puesto");  
	 lblPuesto.setBounds(250,150,150,30);
	 lblPuesto.setFont(labelFont);  
	 lblPuesto.setForeground(Color.WHITE);
         
         txtPuesto=new TextField();
	 txtPuesto.setBounds(400,150,400,30);
	 txtPuesto.setFont(textFont);
         
         
         lblRut=new Label("Rut");  
	 lblRut.setBounds(250,200,150,30);
	 lblRut.setFont(labelFont);  
	 lblRut.setForeground(Color.WHITE);
         
         txtRut=new TextField();
	 txtRut.setBounds(400,200,400,30);
	 txtRut.setFont(textFont);
         
         
         lblNombreLocal=new Label("Nombre del local");  
	 lblNombreLocal.setBounds(250,250,150,30);
	 lblNombreLocal.setFont(labelFont);  
	 lblNombreLocal.setForeground(Color.WHITE);
         
         
         txtNombreLocal=new TextField();
	 txtNombreLocal.setBounds(400,250,400,30);
	 txtNombreLocal.setFont(textFont);

         

         lblHoraDeAtencion=new Label("Hora de atencion");  
	 lblHoraDeAtencion.setBounds(250,300,150,30);
	 lblHoraDeAtencion.setFont(labelFont);  
	 lblHoraDeAtencion.setForeground(Color.WHITE);
         
         txtHoraDeAtencion=new TextField();
	 txtHoraDeAtencion.setBounds(400,250,400,30);
	 txtHoraDeAtencion.setFont(textFont);

         btnAceptar=new Button("Crear");
         btnAceptar.setBounds(400,350,100,50);
	 btnAceptar.setFont(textFont);

         btnLimpiar=new Button("Limpiar");
         btnLimpiar.setBounds(500,350,100,50);
	 btnLimpiar.setFont(textFont);
         
         
         btnAceptar.addActionListener(this);
         btnLimpiar.addActionListener(this);
         txtHoraDeAtencion.addKeyListener(this);
         
         
         add(lblMensaje);
	 add(lblNombre);
         add(txtNombre);
         add(lblPuesto);
         add(txtPuesto);
         add(lblRut);
         add(txtRut);
         add(lblNombreLocal);
         add(txtNombreLocal);
         add(btnAceptar);
         add(btnLimpiar);
  
    }
    
    
    public void Reporte(){
        
        this.removeAll();
         
	 Color formColor = new Color(53, 59, 72);
	 setBackground(formColor);
         
         
         Font titleFont = new Font("arial", Font.BOLD, 25);
	 Font labelFont =new  Font("arial", Font.PLAIN, 18);
	 Font textFont =new  Font("arial", Font.PLAIN, 15);
         
         this.setLayout(new GridLayout(2, 5));
         
         lblMensaje=new Label("Nombre");
         lblMensaje.setForeground(Color.WHITE);
         this.add(lblMensaje);
         
         lblMensaje=new Label("Puesto");
         lblMensaje.setForeground(Color.WHITE);
         this.add(lblMensaje);
         
         lblMensaje=new Label("Rut");
         lblMensaje.setForeground(Color.WHITE);
         this.add(lblMensaje);
         
         lblMensaje=new Label("Hora de antencion");
         lblMensaje.setForeground(Color.WHITE);
         this.add(lblMensaje);
         
         for(int i=0;i<vendedor.getLVendedor().size();i++){
           
           lblNombre=new Label(vendedor.getLVendedor().get(i).getNombreV());
           lblNombre.setForeground(Color.WHITE);
           this.add(lblNombre);
           
           int aux = vendedor.getLVendedor().get(i).getPuesto();
           String toString = Integer.toString(aux);
           
           lblPuesto=new Label(toString);
           lblPuesto.setForeground(Color.WHITE);
           this.add(lblPuesto);
           
           
           lblRut=new Label(vendedor.getLVendedor().get(i).getRUT());
           lblRut.setForeground(Color.WHITE);
           this.add(lblRut);
           
           
           lblHoraDeAtencion=new Label(vendedor.getLVendedor().get(i).getHoraAtencion());
           lblMensaje.setForeground(Color.WHITE);
           this.add(lblHoraDeAtencion);

         }
         
        
    }
    

    //EVENTOS

  
    public void actionPerformed(ActionEvent e) {
         
         
         //button 
         Object obj = e.getSource();
         
         
         if(obj==btnReporte){
             System.out.println("reporte");
             Reporte();
         }
         
         
         if(obj==btnAceptar){
              System.out.println("crear");
              
              
              if(!txtNombre.getText().toString().isEmpty() && !txtPuesto.getText().toString().isEmpty() && !txtRut.getText().toString().isEmpty() &&  !txtHoraDeAtencion.getText().toString().isEmpty()){
                  vendedor.setNombreV(txtNombre.getText().toString());
                  vendedor.setPuesto(Integer.parseInt(txtPuesto.getText().toString()));
                  vendedor.setRUT(txtRut.getText().toString());
                  vendedor.setHoraAtencion(txtHoraDeAtencion.getText().toString());
                  vendedor.getLVendedor().add(vendedor);
                  this.removeAll();
                  lblMensaje=new Label("Datos insertados!!!");
                  lblMensaje.setForeground(Color.RED);
                  lblMensaje.setBounds(400,50,400,30);
                  Font textFont =new  Font("arial", Font.PLAIN, 15);
                  btnReporte=new Button("Reporte");
                  lblMensaje.setForeground(Color.WHITE);
                  btnReporte.setBounds(500,50,500,30);
                  btnReporte.setFont(textFont);
                  add(lblMensaje);
                  add(btnReporte);
                  btnReporte.addActionListener(this);
                
                
              }else{
                 
                  Alerta("Los datos deben llenarse");
                  lblMensaje.setText("Los campos deben llenarse");
                  
                  
              }
             
         }
            
         if(obj==btnLimpiar){
             System.out.println("limpiar");
         }     
         
    }
    
    
     public void Alerta(String Mensaje){
             Dialog ventanaAlerta = new Dialog(this, Mensaje, true);  
                  ventanaAlerta.setLayout( new FlowLayout() );  
                  Button b = new Button ("OK"); 
                  
                  b.addActionListener ( new ActionListener(){  
                    public void actionPerformed( ActionEvent e )  
                    {  
                        ventanaAlerta.setVisible(false);  
                    }  
                });  
                ventanaAlerta.add( new Label ("Click para continuar."));  
                ventanaAlerta.add(b);
                ventanaAlerta.setSize(300,300);    
                ventanaAlerta.setVisible(true);  
                
     }
    
     public void windowClosing(WindowEvent e) {
                System.out.println("Cerrar la interface");
                dispose();
                
     }
      
      
      public void windowOpened(WindowEvent e) {}
      public void windowActivated(WindowEvent e) {}
      public void windowIconified(WindowEvent e) {}
      public void windowDeiconified(WindowEvent e) {}
      public void windowDeactivated(WindowEvent e) {}
      public void windowClosed(WindowEvent e) {}

   //eventos teclado
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e){}       
    public void keyReleased(KeyEvent e){}
    
}
