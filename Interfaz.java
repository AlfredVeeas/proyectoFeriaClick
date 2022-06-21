/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author evert
 */
public class Interfaz extends Frame{
    private MenuBar menu;
    
    public Interfaz (){
        this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
            });
    }
    
    public void Configuracion(){
             
                this.setTitle("FeriaClick");
                this.setSize(1000, 600);// w,h
                this.setLocation(100,100);
                
                
                
                Font titleFont = new Font("arial", Font.BOLD, 25);
                Font labelFont =new  Font("arial", Font.PLAIN, 18);
                Font textFont =new  Font("arial", Font.PLAIN, 15);
         
                
                FlowLayout miFlowLayout = new FlowLayout(FlowLayout.CENTER);
               
                Label lblMessage= new Label("Bienvenidos a mi FeriaClick");
                
               
                this.setLayout( miFlowLayout );
                this.add(lblMessage);
                
                this.setVisible(true);
                
                
                
                
         }
    
    public void CrearMenu(){
             menu= new MenuBar();
             
             
             Menu menuA = new Menu( "Vendedor" );
             Menu menuB = new Menu( "Ferias" );
             
             MenuItem submenuC=new MenuItem("Crear");
             menuA.add(submenuC);
             MenuItem submenuR=new MenuItem("Consultar");
             menuA.add(submenuR);
             MenuItem submenuU=new MenuItem("Modificar");
             menuA.add(submenuU);
             MenuItem submenuD=new MenuItem("Eliminar");
             menuA.add(submenuD);
          
             MenuItem submenuCF=new MenuItem("Crear");
             menuB.add(submenuCF);
             MenuItem submenuRF=new MenuItem("Consultar");
             menuB.add(submenuRF);
             MenuItem submenuUF=new MenuItem("Modificar");
             menuB.add(submenuUF);
             MenuItem submenuDF=new MenuItem("Eliminar");
             menuB.add(submenuDF);
             
             
             
             //actionlistener
             
             submenuC.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                         Vendedor vendedor=new Vendedor();
                         vendedor.CrearVendedor();
                         
                    }
                    
             });
             
             
             submenuR.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent a) {
                       
                                                
                    }
                    
             });
             
             submenuU.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent i) {
                       
                        
                         
                    }
                    
             });
             
             submenuD.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent o) {
                       
                        
                         
                    }
                    
             });
                
             submenuCF.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent ingresarFeria){
                     Feria feria = new Feria();
                     feria.IngresarFeria();
                 }
             });
             menu.add(menuA);
             menu.add(menuB);
             setMenuBar(menu); 
             
         }
}
