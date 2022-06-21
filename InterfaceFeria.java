/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author evert
 */
public class InterfaceFeria extends Frame implements WindowListener, ActionListener, KeyListener {
        
    private Label lblID, lblNombre,lblDireccion,lblMensaje;
    private Button btnAceptar, btnLimpiar,btnReporte;
    private TextField txtID,txtNombre,txtDireccion;
    boolean presion=false;
    
    private Feria feria=new Feria();
  
  
    
    public InterfaceFeria(String titulo){
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
         
         lblNombre=new Label("Nombre de feria");  
	 lblNombre.setBounds(250,100,150,30);
	 lblNombre.setFont(labelFont);  
	 lblNombre.setForeground(Color.WHITE);
         
         
         txtNombre=new TextField();
	 txtNombre.setBounds(400,100,400,30);
	 txtNombre.setFont(textFont);
         

         lblID=new Label("ID Feria");  
	 lblID.setBounds(250,150,150,30);
	 lblID.setFont(labelFont);  
	 lblID.setForeground(Color.WHITE);
         
         txtID=new TextField();
	 txtID.setBounds(400,150,400,30);
	 txtID.setFont(textFont);
         
         
         lblDireccion=new Label("Direccion de la feria");  
	 lblDireccion.setBounds(250,200,150,30);
	 lblDireccion.setFont(labelFont);  
	 lblDireccion.setForeground(Color.WHITE);
         
         txtDireccion=new TextField();
	 txtDireccion.setBounds(400,200,400,30);
	 txtDireccion.setFont(textFont);
                  
         
         btnAceptar=new Button("Crear");
         btnAceptar.setBounds(400,350,100,50);
	 btnAceptar.setFont(textFont);

         btnLimpiar=new Button("Limpiar");
         btnLimpiar.setBounds(500,350,100,50);
	 btnLimpiar.setFont(textFont);
         
         
         btnAceptar.addActionListener(this);
         btnLimpiar.addActionListener(this);

         
         
         add(lblMensaje);
	 add(lblNombre);
         add(txtNombre);
         add(lblID);
         add(txtID);
         add(lblDireccion);
         add(txtDireccion);
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
         
         lblMensaje=new Label("Nombre de feria");
         lblMensaje.setForeground(Color.WHITE);
         this.add(lblMensaje);
         
         lblMensaje=new Label("Id de la feria");
         lblMensaje.setForeground(Color.WHITE);
         this.add(lblMensaje);
         
         lblMensaje=new Label("Direccion de la feria");
         lblMensaje.setForeground(Color.WHITE);
         this.add(lblMensaje);
         
                  
         for(int i=0;i<feria.getLFeria().size();i++){
           
           lblMensaje=new Label(feria.getLFeria().get(i).getNombreFeria());
           lblMensaje.setForeground(Color.WHITE);
           this.add(lblMensaje);
           
           lblMensaje=new Label(feria.getLFeria().get(i).getIDFeria());
           lblMensaje.setForeground(Color.WHITE);
           this.add(lblMensaje);
           
           
           lblMensaje=new Label(feria.getLFeria().get(i).getDireccionFeria());
           lblMensaje.setForeground(Color.WHITE);
           this.add(lblMensaje);
                 
           

         }
         
        
    }
    

    //EVENTOS

  
    public void actionPerformed(ActionEvent e) {
         Date fechaNacimiento;
         String Region;
         
         //button 
         Object obj = e.getSource();
         
         
         if(obj==btnReporte){
             System.out.println("reporte");
             Reporte();
         }
         
         
         if(obj==btnAceptar){
              System.out.println("crear");
              
              
              if(!txtNombre.getText().toString().isEmpty() && !txtID.getText().toString().isEmpty() && !txtDireccion.getText().toString().isEmpty()){
                  feria.setNombreFeria(txtNombre.getText().toString());
                  feria.setIDFeria((txtID.getText().toString()));
                  feria.setDireccionFeria(txtDireccion.getText().toString());
                  feria.getLFeria().add(feria);
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
