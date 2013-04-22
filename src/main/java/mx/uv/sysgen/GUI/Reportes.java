/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.GUI;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mx.uv.sysgen.BD.ConexionBD;

/**
 *
 * @author clemente
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        super("GENERAR REPORTES");
        setVisible(true);
        setResizable(false);
        initComponents();
    }
     public void ObtenerTablas(){ 
          //creamos un nuevo obtejo llamado conexion de ConexionSQL
            ConexionBD conexion=new ConexionBD();
            /*declaramos una variable conn de tipo Connection a la cual le asignaremos el resultado que nos
             devuelbe el metodo Conectar*/
            int i=0;
            Connection conn  = conexion.Conectar(i);      
            /*Recuperamos los metadatos de la base de datos.Los metadatos incluyen información sobre
             las tablas de la base de datos*/
     
         if(conn!=null){    
         try {
            DatabaseMetaData metadata=conn.getMetaData();
            /* Con este metodo tendremos los nombres de las tablas que tiene nuestra BD*/
            /*•catálogo de la base de datos. Al poner null, estamos preguntando por el catálogo (BD) actual                     
              •Esquema de la base de datos. Al poner null, es el actual.
              •Patrón para las tablas en las que tenemos interés. En SQL el caracter que indica "todo" es % .
               Esto nos dará todas las tablas del catálogo y esquema actual.  
              •El cuarto parámetro es un array de String, en el que pondríamos qué tipos de tablas queremos
              (normales, vistas, etc). Al poner null, nos devolverá todos los tipos de tablas.*/
                    ResultSet rs = metadata.getTables(null, null, "%", null);
                    while(rs.next()){
                    String catalogo = rs.getString(1);//obtenemos el nombre del catalogo (BD) que tenemos
                    String tabla = rs.getString(3);//obtenemos el nombre de las tablas de nuestro catalogo
                    //System.out.println("TABLA=" + catalogo + "." + tabla); 
                    CBTablas.addItem(tabla);//cargamos un ComboBox con los nombres de las Tablas                     
                 }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
           
        }      
      }
         else{
             JOptionPane.showMessageDialog(null,"No se pueden cargar los datos, verifieque la "
                                        + "conexión de la Base de Datos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
         }
    }
     
     public void CargarCampos(){
         ConexionBD conexion=new ConexionBD();
            /*declaramos una variable conn de tipo Connection a la cual le asignaremos el resultado que nos
             devuelbe el metodo Conectar*/
            int i=0;
            Connection conn  = conexion.Conectar(i);      
            /*Recuperamos los metadatos de la base de datos.Los metadatos incluyen información sobre
             las tablas de la base de datos*/
     
         if(conn!=null){    
         try {
            DatabaseMetaData metadata=conn.getMetaData();
            /* Con este metodo tendremos los nombres de las tablas que tiene nuestra BD*/
            /*•catálogo de la base de datos. Al poner null, estamos preguntando por el catálogo (BD) actual                     
              •Esquema de la base de datos. Al poner null, es el actual.
              •Patrón para las tablas en las que tenemos interés. En SQL el caracter que indica "todo" es % .
               Esto nos dará todas las tablas del catálogo y esquema actual.  
              •El cuarto parámetro es un array de String, en el que pondríamos qué tipos de tablas queremos
              (normales, vistas, etc). Al poner null, nos devolverá todos los tipos de tablas.*/
                    ResultSet rs = metadata.getColumns(null, null,"%", null);
                   while (rs.next()) {
                   // El contenido de cada columna del ResultSet se puede ver en
                   // la API de java, en el metodo getColumns() de DataBaseMetaData
                   // La 4 corresponde al TABLE_NAME
                   // y la 6 al TYPE_NAME
                    String nombreColumna = rs.getString(4);
                   // String tipoColumna = rs.getString(6);
                   //  System.out.println(" COLUMNA, nombre=" + nombreColumna+ " tipo = " + tipoColumna); 
                    CBTablas.addItem(nombreColumna);//cargamos un ComboBox con los nombres de las Tablas                     
                 }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
           
        }      
      }
         else{
             JOptionPane.showMessageDialog(null,"No se pueden cargar los datos, verifieque la "
                                        + "conexión de la Base de Datos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
         }
     }

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
        jPanel1 = new javax.swing.JPanel();
        JBMaestro = new javax.swing.JButton();
        JBMaestroDetalle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        CBTablas = new javax.swing.JComboBox();
        CBAtributos = new javax.swing.JComboBox();
        LTablas = new javax.swing.JLabel();
        LAtributos = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Reoprte"));

        JBMaestro.setIcon(new javax.swing.ImageIcon("C:\\Users\\clemente\\Desktop\\sysgen\\src\\main\\java\\mx\\uv\\sysgen\\Assets\\maestro.png")); // NOI18N
        JBMaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMaestroActionPerformed(evt);
            }
        });

        JBMaestroDetalle.setIcon(new javax.swing.ImageIcon("C:\\Users\\clemente\\Desktop\\sysgen\\src\\main\\java\\mx\\uv\\sysgen\\Assets\\maestro-detalle.png")); // NOI18N
        JBMaestroDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMaestroDetalleActionPerformed(evt);
            }
        });

        jLabel2.setText("MAESTRO- DETALLE");

        jLabel3.setText("MAESTRO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JBMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBMaestroDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBMaestro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBMaestroDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS"));

        LTablas.setText("TABLAS");

        LAtributos.setText("ATRIBUTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(LTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LAtributos)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(CBTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(CBAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LTablas)
                    .addComponent(LAtributos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBMaestroDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMaestroDetalleActionPerformed
          JOptionPane.showMessageDialog(null,"No hay nadada"); 
        // TODO add your handling code here:
    }//GEN-LAST:event_JBMaestroDetalleActionPerformed

    private void JBMaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMaestroActionPerformed
        // TODO add your handling code here:
       ObtenerTablas();
    }//GEN-LAST:event_JBMaestroActionPerformed

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
    private javax.swing.JComboBox CBAtributos;
    private javax.swing.JComboBox CBTablas;
    private javax.swing.JButton JBMaestro;
    private javax.swing.JButton JBMaestroDetalle;
    private javax.swing.JLabel LAtributos;
    private javax.swing.JLabel LTablas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
