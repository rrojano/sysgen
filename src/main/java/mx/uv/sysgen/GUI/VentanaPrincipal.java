/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author clemente
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    JDesktopPane escritorio; 
    public VentanaPrincipal() {
        super("SYSGEN 1.0.1");
        this.setVisible(true);
        crearMenu();
        initComponents();
    }
    public void crearMenu(){
       // JasperReport reporteMaestro = null;
         JMenuBar barra;
       //= new JMenuBar();
 /* ---- DECLARAMOS LOS MENUS  ----*/        
        JMenu menu_archivo, menu_catalogos,menu_plantillas,menu_reportes;//,menu_consultas;
 /* ---- DECLARAMOS LAS OPCIONES DE LOS MENUS  ----*/       
        JMenuItem op_salir,op_imprimir;
        JMenuItem op_actualizarCatalogos;
        JMenuItem op_generarPlantillas;
        JMenuItem op_generarReportes;
       // JMenuItem op_catclientes,op_catventas,op_catproductos,op_catpagos;
        
  /* ************ Creo mi Barra de menus ******************************************* */      
        barra= new JMenuBar();
/* ------------ CREAMOS LOS MENUS------------------------------------------- */        
        menu_archivo = new JMenu("Archivo");     
        menu_catalogos = new JMenu("Catalogos");
        menu_plantillas = new JMenu("Plantilla");
        menu_reportes  = new JMenu("Reportes");
        //menu_consultas=new JMenu("Consultas");
 /********* Cambiamos de color la barra de menus ************/       
 // barra.setBackground (Color.lightGray);
        
 /* ------------------ CREAMOS LAS OPCIONES DEL MENU ARCHIVO------------------------- */        
       
       
        op_salir = new JMenuItem("Salir",new ImageIcon("C:\\Users\\clemente\\Desktop\\Universidad\\iconos\\salir.png"));
        op_salir.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.event.InputEvent.CTRL_MASK));
        op_salir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {            
         if (JOptionPane.showConfirmDialog(null, "¿Está seguro de querer salir?", "Advertencia",
             JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)        
                System.exit(0);
            }
        });
            
        
        
        op_imprimir = new JMenuItem("Imprimir",new ImageIcon("C:\\Users\\clemente\\Desktop\\Universidad\\iconos\\impresora.png"));
        op_imprimir.setAccelerator(KeyStroke.getKeyStroke('P',java.awt.event.InputEvent.CTRL_MASK));
        op_imprimir.addActionListener(new ActionListener(){           
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"La impresora no esta canectada");
    
                      
            }
        });
        
 /* ------------------ CREAMOS LAS OPCIONES DEL MENU ACERVO------------------------- */            
       op_actualizarCatalogos = new JMenuItem("Actualizar Catalogos",new ImageIcon("C:\\Users\\clemente\\Desktop\\Universidad\\iconos\\acervo.png"));
        op_actualizarCatalogos.setAccelerator(KeyStroke.getKeyStroke('C',java.awt.event.InputEvent.ALT_MASK));
        op_actualizarCatalogos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {               
             
                                       
            }
        });
        
/* ------------------ CREAMOS LAS OPCIONES DEL MENU INFRAESTRUCTURA------------------------- */        
      
           op_generarPlantillas = new JMenuItem("Generar Plantilla",new ImageIcon("C:\\Users\\clemente\\Desktop\\Universidad\\iconos\\infraestructura.png"));
        op_generarPlantillas.setAccelerator(KeyStroke.getKeyStroke('P',java.awt.event.InputEvent.ALT_MASK));
         op_generarPlantillas.addActionListener(new ActionListener(){           
            public void actionPerformed(ActionEvent e) {
              
            }
        });
         
         
   /* ------------------ CREAMOS LAS OPCIONES DEL MENU SERVICIO ------------------------- */          
      op_generarReportes= new JMenuItem("Generar Reporte",new ImageIcon("C:\\Users\\clemente\\Desktop\\Universidad\\iconos\\servicios.png"));
        op_generarReportes.setAccelerator(KeyStroke.getKeyStroke('R',java.awt.event.InputEvent.ALT_MASK));
         op_generarReportes.addActionListener(new ActionListener(){           
            public void actionPerformed(ActionEvent e) {
                Reportes reporte=new Reportes();
               
            }
        });   
         
         
 /* ----------------------------- AGREGAMOS LAS OPCIONES A LOS MENUS -------------------*/
       menu_archivo.add(op_salir); 
       menu_archivo.add(op_imprimir);       
       menu_catalogos.add( op_actualizarCatalogos);
       menu_plantillas.add(op_generarPlantillas);
       menu_reportes.add(op_generarReportes);
       
       
 /* ----------------------------- AGREGAMOS LOS MENUS A LA BARRA DE MENUS -------------------*/
       
        barra.add(menu_archivo);
        barra.add( menu_catalogos);
        barra.add(menu_plantillas);
        barra.add( menu_reportes);
        //barra.add(menu_consultas);
        
       setJMenuBar(barra);
   }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
