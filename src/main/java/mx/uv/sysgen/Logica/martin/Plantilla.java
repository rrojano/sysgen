package mx.uv.sysgen.Logica.martin;
import mx.uv.sysgen.BD.*;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import mx.uv.sysgen.Logica.Configuración;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GON
 */
public class Plantilla extends javax.swing.JFrame {

public JScrollPane scroll = new JScrollPane();
public PanelClass panel = new PanelClass();   
public int index=0;
public BD bd = new BD();
public String texto;
public LinkedList<String> tablas= new LinkedList<String>();
public boolean espacio;



    public Plantilla(String ap) {
        Configuración conf=new Configuración();
        conf=conf.abrirArchivo();
        bd.configuraBD(conf.getUsuario(),conf.getContraseña(),conf.getEsquema(), conf.getManejador());
        initComponents();
        if(ap!=""){iniciar(ap);}
        
        try{
        tablas=bd.getTablas();}
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "Tablas no encontradas", "Advertencia",JOptionPane.WARNING_MESSAGE);}
  
        ocupado.setVisible(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        scroll.setSize(640, 177);
        scroll.setLocation(50, 50);
        
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setViewportView(panel.getPanel());
        this.getContentPane().add(scroll); 
        this.pack();
        scroll.setVisible(true);    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Agregar = new javax.swing.JButton();
        idCatalogo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        Importar = new javax.swing.JButton();
        ocupado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Plantilla");

        Agregar.setText("+");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        idCatalogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idCatalogoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idCatalogoKeyReleased(evt);
            }
        });

        jLabel1.setText("ID Catalogo");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Aceptar.setText("Aceptar");
        Aceptar.setMaximumSize(new java.awt.Dimension(77, 23));
        Aceptar.setMinimumSize(new java.awt.Dimension(77, 23));
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Importar.setText("Importar");
        Importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportarActionPerformed(evt);
            }
        });

        ocupado.setForeground(new java.awt.Color(255, 0, 0));
        ocupado.setText("Ocupado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addComponent(idCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ocupado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Importar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ocupado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Agregar)
                        .addComponent(Importar))
                    .addComponent(jButton1))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        index++;
        panel.addelement();
        scroll.validate();

        scroll.setVisible(true);
        
        this.pack();
    }//GEN-LAST:event_AgregarActionPerformed

    private void ImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportarActionPerformed
        index++;
        Importar imp = new Importar();
        
        panel.addelement(imp.getId(),imp.getTipo());
        scroll.validate();

        scroll.setVisible(true);
        
        this.pack();  
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         AdmnPlantillas inte = new AdmnPlantillas();
         inte.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idCatalogoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idCatalogoKeyReleased
        if(espacio == false){
        this.texto=idCatalogo.getText();
        for(int i=0; i<tablas.size();i++){
            if(texto.equalsIgnoreCase(tablas.get(i).trim())){
            ocupado.setForeground(Color.red);ocupado.setText("Ocupado");}
            else{ocupado.setForeground(Color.green);ocupado.setText("Libre");}}
        ocupado.setVisible(true);
        espacio=false;
        }
         // TODO add your handling code here:
    }//GEN-LAST:event_idCatalogoKeyReleased

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
    LinkedList<CampoSQL> tabla= new LinkedList<CampoSQL>();
    if(this.ocupado.getText().equalsIgnoreCase("Ocupado") || this.idCatalogo.getText().equalsIgnoreCase(""))
    {JOptionPane.showMessageDialog(null, "Revise el nombre del catálogo", "Advertencia",JOptionPane.WARNING_MESSAGE);}
    else {JOptionPane.showMessageDialog(null, "El catálogo se agregó correctamente.", "Advertencia",JOptionPane.WARNING_MESSAGE);
    for (int i=0; i<panel.arreglo.size(); i++){
        jpComponente jpc = (jpComponente) panel.arreglo.get(i); 
    tabla.add(setCampSQL(jpc));    
    }
    bd.crearTabla(idCatalogo.getText(), tabla);
         AdmnPlantillas inte = new AdmnPlantillas();
         inte.setVisible(true);
         this.dispose();
    }
    
    }//GEN-LAST:event_AceptarActionPerformed

    private void idCatalogoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idCatalogoKeyPressed
    SEspacio(idCatalogo);            // TODO add your handling code here:
    }//GEN-LAST:event_idCatalogoKeyPressed


public CampoSQL setCampSQL(jpComponente jpc){
    String tipo;
    boolean nonulo=false;;
    if(jpc.tipodevar.equalsIgnoreCase("DATE")||jpc.tipodevar.equalsIgnoreCase("TIME")){
    tipo=jpc.tipodevar;}
    else{ 
    tipo=jpc.tipodevar+"("+jpc.tamanio.getText()+")";
    if(jpc.tamanio.getText().equalsIgnoreCase("") ||jpc.tamanio.getText().equalsIgnoreCase("0")){
    nonulo=true;
    }
    else{nonulo=false;}
    }
    boolean llavePrim;
    if(jpc.jCheckBox1.isSelected()== true){llavePrim=true;}
    else {llavePrim=false;}
    System.out.println(tipo);
    CampoSQL campo = new CampoSQL(jpc.idAtributo.getText(),tipo,llavePrim,nonulo);
    return campo;
}

public void SEspacio(JTextField a){
a.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e){
    boolean noValido=false;
    char c=e.getKeyChar();
    if (!Character.isUnicodeIdentifierPart(c)){
        getToolkit().beep();
        espacio=true;
        e.consume();

    }    
    if (Character.isSpaceChar(c)){
        getToolkit().beep();
        espacio=true;
        e.consume();

   }
    
}
});
}
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
            java.util.logging.Logger.getLogger(Plantilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plantilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plantilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plantilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Plantilla("").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Importar;
    private javax.swing.JTextField idCatalogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel ocupado;
    // End of variables declaration//GEN-END:variables

    private void iniciar(String tabla) {
    LinkedList<String> campos= new LinkedList<String>(); 
    LinkedList<String> tipo= new LinkedList<String>();
    LinkedList<String> tamanio = new LinkedList<String>();
    
    this.idCatalogo.setText(tabla);
    try{
       tipo=bd.getCampos(tabla,1);
       campos=bd.getCampos(tabla,3);
       tamanio=bd.getCampos(tabla,2);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "Tablas no encontradas", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        boolean key=false;
    for (int i=0; i<campos.size(); i++){

        String idelemento=campos.get(i);
        if(bd.esLlavePrimaria(tabla, campos.get(i))==true){
        key=true;
        }else{
        key=false;
        }
        
        
        panel.addelement(campos.get(i),tipo.get(i),tamanio.get(i), key);
        scroll.validate();

        scroll.setVisible(true);
        
        this.pack(); 
    }
    }
    
}
