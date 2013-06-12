/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.GUI;
import com.lowagie.text.DocumentException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mx.uv.sysgen.BD.BD;
import javax.swing.*;
import mx.uv.sysgen.Logica.GenerarReporte;
import mx.uv.sysgen.Logica.Configuración;
import mx.uv.sysgen.Logica.GenReporte;
import mx.uv.sysgen.Logica.GenReporte2;



/**
 *
 * @author clemente
 */
public class Reportes extends javax.swing.JFrame {
String tabla,tab;
String nombreColumna;
List<String> ids = new ArrayList<String>();      
    /**
     * Creates new form Reportes
     */
    public Reportes() {
        super("GENERAR REPORTES");
        setVisible(true);
        setResizable(false);
      //  setdefaultclose();
        initComponents();
        Desabilitar();
    }
    public void Desabilitar(){
     BCancelar.setEnabled(false);
     BGenerar.setEnabled(false);
     Bseleccionar.setEnabled(false);
     CBTablas.setEnabled(false);
     LAtributos.setEnabled(false);
     TFTitulo.setEnabled(false);
    }
    public void Habilitar(){
     Bseleccionar.setEnabled(true);
     BCancelar.setEnabled(true);
     CBTablas.setEnabled(true);
     LAtributos.setEnabled(true);
     TFTitulo.setEnabled(true);
    }
    
    int m;
   
    /* Método que sirve para obtener el nombre de las tablas de ma BD*/
     public void ObtenerTablas(){ 
         
        Configuración config=new Configuración();//creamos un objeto de la clase Configuracion 
        config=config.abrirArchivo();
        m=config.getManejador();
            BD conexion = new BD();
            conexion.configuraBD(config.getUsuario(), config.getContraseña(), config.getEsquema(),config.getManejador());
         try {
            LinkedList<String> ls=conexion.getTablas();
            for (int i=0;i<ls.size();i++){
                CBTablas.addItem(ls.get(i));
            }
         } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            //CBTablas.addItem("");//asignamos una cadena vacia al combobox de Tablas
         
         
    }
     
     /* Método que sirve para obtener los Campos de las tabals de la BD*/
     public void CargarCampos(){
         DefaultListModel model = new DefaultListModel();
         Configuración config=new Configuración();//creamos un objeto de la clase Configuracion 
        config=config.abrirArchivo();
        m=config.getManejador();
            BD conexion = new BD();
            conexion.configuraBD(config.getUsuario(), config.getContraseña(), config.getEsquema(),config.getManejador());
            
            tab=(String) CBTablas.getSelectedItem();
            if (CBTablas.getSelectedItem()!=""){
         try {
            LinkedList<String> ls=conexion.getCampos(tab);
            for (int i=0;i<ls.size();i++){
                model.addElement(ls.get(i));
            }
         } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
         }
            }
         LAtributos.setModel(model);
                      
         
         
     }
     public void SeleccionarCampos(){
         ids.clear();//Elimino los campos  que se encuentran en la en el array list
         ids=LAtributos.getSelectedValuesList();//guardo los elementos seleccionados en una array list
          //Campos();
     }
     /*metodod para que muestra los elementos de mi array list*/
     private void Campos(){
            DefaultListModel model = new DefaultListModel(); 
     for( int i=0; i < ids.size(); i++ ) {
              model.addElement(ids.get(i));
        
                      System.out.println("Campos"+" "+ids.get(i)); 
                                           
   }
  }
     /*obtengo el nombre del reporte*/
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PReporte = new javax.swing.JPanel();
        JBMaestro = new javax.swing.JButton();
        LMaestro = new javax.swing.JLabel();
        PDatos = new javax.swing.JPanel();
        PAtributos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LAtributos = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        CBTablas = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        BGenerar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        TFTitulo = new javax.swing.JTextField();
        LBTitulo = new javax.swing.JLabel();
        Bseleccionar = new javax.swing.JButton();

        jButton2.setText("jButton2");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PReporte.setBorder(javax.swing.BorderFactory.createTitledBorder("TIPO DE REPORTE"));

        JBMaestro.setIcon(new javax.swing.ImageIcon("C:\\Users\\clemente\\Desktop\\sysgen\\src\\main\\java\\mx\\uv\\sysgen\\Assets\\maestro.png")); // NOI18N
        JBMaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMaestroActionPerformed(evt);
            }
        });

        LMaestro.setText("MAESTRO");

        javax.swing.GroupLayout PReporteLayout = new javax.swing.GroupLayout(PReporte);
        PReporte.setLayout(PReporteLayout);
        PReporteLayout.setHorizontalGroup(
            PReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PReporteLayout.createSequentialGroup()
                .addGroup(PReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PReporteLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(JBMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PReporteLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(LMaestro)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        PReporteLayout.setVerticalGroup(
            PReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PReporteLayout.createSequentialGroup()
                .addComponent(JBMaestro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LMaestro))
        );

        PDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS"));

        PAtributos.setBorder(javax.swing.BorderFactory.createTitledBorder("ATRIBUTOS"));

        jScrollPane1.setViewportView(LAtributos);

        javax.swing.GroupLayout PAtributosLayout = new javax.swing.GroupLayout(PAtributos);
        PAtributos.setLayout(PAtributosLayout);
        PAtributosLayout.setHorizontalGroup(
            PAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAtributosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        PAtributosLayout.setVerticalGroup(
            PAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("TABLAS"));

        CBTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTablasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CBTablas, 0, 143, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CBTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BGenerar.setIcon(new javax.swing.ImageIcon("C:\\Users\\clemente\\Desktop\\sysgen\\src\\main\\java\\mx\\uv\\sysgen\\Assets\\reporte.png")); // NOI18N
        BGenerar.setText("Generar Rep");
        BGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGenerarActionPerformed(evt);
            }
        });

        BCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\clemente\\Desktop\\sysgen\\src\\main\\java\\mx\\uv\\sysgen\\Assets\\cancelar.png")); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        LBTitulo.setText("TITULO DEL REPORTE");

        Bseleccionar.setIcon(new javax.swing.ImageIcon("C:\\Users\\clemente\\Desktop\\sysgen\\src\\main\\java\\mx\\uv\\sysgen\\Assets\\seleccionar.png")); // NOI18N
        Bseleccionar.setText("Seleccionado");
        Bseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BseleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LBTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Bseleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BGenerar)
                        .addGap(18, 18, 18)
                        .addComponent(BCancelar))
                    .addComponent(TFTitulo))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCancelar)
                    .addComponent(BGenerar)
                    .addComponent(Bseleccionar))
                .addContainerGap())
        );

        javax.swing.GroupLayout PDatosLayout = new javax.swing.GroupLayout(PDatos);
        PDatos.setLayout(PDatosLayout);
        PDatosLayout.setHorizontalGroup(
            PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PDatosLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PDatosLayout.setVerticalGroup(
            PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDatosLayout.createSequentialGroup()
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PAtributos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBMaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMaestroActionPerformed
        // TODO add your handling code here:
        Habilitar();
       ObtenerTablas();/*Método que obtiene las tablas de una BD y las carga en un combobox*/
    }//GEN-LAST:event_JBMaestroActionPerformed

    private void CBTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTablasActionPerformed
        // TODO add your handling code here:
        CargarCampos(); 
    }//GEN-LAST:event_CBTablasActionPerformed

    private void BGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGenerarActionPerformed
        // TODO add your handling code here:
       String tituloR=TFTitulo.getText();
       tabla=tab;
     // GenerarReporte GenerarR =new GenerarReporte();
       //        GenerarR.EjecutarReporte(ids,tituloR);
       GenReporte2  Reporte = new GenReporte2();        
            Reporte.GenerarReporte(tituloR,ids,tabla);       
    }//GEN-LAST:event_BGenerarActionPerformed

    private void BseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BseleccionarActionPerformed
        BGenerar.setEnabled(true); 
        ids.clear();
        SeleccionarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_BseleccionarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        // TODO add your handling code here:
        TFTitulo.setText("");
        Desabilitar();
    }//GEN-LAST:event_BCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BGenerar;
    private javax.swing.JButton Bseleccionar;
    private javax.swing.JComboBox CBTablas;
    private javax.swing.JButton JBMaestro;
    private javax.swing.JList LAtributos;
    private javax.swing.JLabel LBTitulo;
    private javax.swing.JLabel LMaestro;
    private javax.swing.JPanel PAtributos;
    private javax.swing.JPanel PDatos;
    private javax.swing.JPanel PReporte;
    private javax.swing.JTextField TFTitulo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
