package mx.uv.sysgen.Logica.plantillas;

//package mx.uv.sysgen.Logica.martin;


import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import mx.uv.sysgen.BD.BD;
import mx.uv.sysgen.BD.FConsultas1;
import mx.uv.sysgen.Logica.Configuración;





public class AdmnPlantillas extends javax.swing.JFrame {
 public BD bd=new BD();
 public LinkedList<String> tablas= new LinkedList<String>();
 public LinkedList<String> campos= new LinkedList<String>(); 
 private Configuración conf=new Configuración();

    public AdmnPlantillas() {
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        conf=conf.abrirArchivo();
        bd.configuraBD(conf.getUsuario(),conf.getContraseña(),conf.getEsquema(), conf.getManejador());
        initComponents();
         
       try{
        tablas=bd.getTablas();
        }
        catch(Exception e){}
    
       
    if(tablas.size()>0){
    this.modificar.setEnabled(true);
    this.eliminar.setEnabled(true);
    CargarCampos(this.IDCatalogo,tablas); 
    String elSelec=(String) IDCatalogo.getSelectedItem();
    
       try{
       campos=bd.getCampos(elSelec);
        }
        catch(Exception e){}
    
    }else{
    this.modificar.setEnabled(false);
    this.eliminar.setEnabled(false);}
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        IDCatalogo = new javax.swing.JComboBox();
        prop = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador de Plantilla");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jButton5.setText("Regresar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        IDCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCatalogoActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Catalogo:");

        jLabel2.setText("Propiedades Catalogo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(prop, 0, 164, Short.MAX_VALUE)
                    .addComponent(IDCatalogo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agregar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IDCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificar)
                        .addGap(13, 13, 13)
                        .addComponent(eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(106, 106, 106))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
         Plantilla inte = new Plantilla("","agregar");
         this.setVisible(false);
         inte.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarActionPerformed

    private void IDCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDCatalogoActionPerformed
        prop.removeAllItems();
        String elSelec=(String) IDCatalogo.getSelectedItem();
        try{
        campos=bd.getCampos(elSelec);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "Tablas no encontradas", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        CargarCampos(this.prop,campos);
        // TODO add your handling code here:
        
    }//GEN-LAST:event_IDCatalogoActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
         Plantilla inte = new Plantilla((String) this.IDCatalogo.getSelectedItem(),"modificar");
         this.setVisible(false);
         inte.setVisible(true); 
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
//        Plantilla inte = new Plantilla((String) this.IDCatalogo.getSelectedItem(),"");
        
  if(JOptionPane.showConfirmDialog(null,"Eliminara la Plantilla "+this.IDCatalogo.getSelectedItem(), "Advertencia", JOptionPane.WARNING_MESSAGE)==0){
     //aceptar
     bd.eliminarTabla((String) this.IDCatalogo.getSelectedItem());
     prop.removeAllItems();
     IDCatalogo.removeAllItems();     
     bd.desconectar();
     conf=conf.abrirArchivo();
     bd.configuraBD(conf.getUsuario(),conf.getContraseña(),conf.getEsquema(), conf.getManejador());
        try{
        tablas=bd.getTablas();
        }
        catch(Exception e){
        //JOptionPane.showMessageDialog(null, "Tablas no encontradas", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    CargarCampos(this.IDCatalogo,tablas); 
    String elSelec=(String) IDCatalogo.getSelectedItem();
    
       try{
       campos=bd.getCampos(elSelec);
        }
        catch(Exception e){
        //JOptionPane.showMessageDialog(null, "Tablas no encontradas", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
      
  }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FConsultas1 ventanaCons= new FConsultas1();
        ventanaCons.setVisible(true);    
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdmnPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmnPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmnPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmnPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdmnPlantillas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox IDCatalogo;
    private javax.swing.JButton agregar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton modificar;
    private javax.swing.JComboBox prop;
    // End of variables declaration//GEN-END:variables

    private void CargarCampos(JComboBox a, LinkedList b) {
        String idtabla="";
        for (int i=0; i<b.size(); i++){
               try{
        idtabla=(String) b.get(i);
        }
        catch(Exception e){
        //JOptionPane.showMessageDialog(null, "Tablas no encontradas", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
           
           
        a.addItem(idtabla);
        }
    }

     
     
 
}
