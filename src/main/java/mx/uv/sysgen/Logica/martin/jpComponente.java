package mx.uv.sysgen.Logica.martin;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GON
 */
public class jpComponente extends javax.swing.JPanel implements  ActionListener{
public String nombre;
private int index; 
public String tipodevar="varchar";
private boolean flag=false;
public boolean bloqueado=false;
public boolean espacio;

    /**
     * Creates new form jpComponente
     */
    public jpComponente(int indx) {
        initComponents();
        tipoVar.addActionListener(this);
        //this.jLabel3.setVisible(false);
        this.index=indx;
        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        this.setSize(230, 30);
        this.setVisible(true);
        this.cerrar.setName(nombre);
        this.nombre="Comp"+index;
        this.cerrar.setName(nombre);
        
            
        //("key_"+index)
        //this.jButton1.setActionCommand("key_"+index); 
    }


    
public void SNumeros(JTextField a){
a.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e){
    char c=e.getKeyChar();
    if (Character.isLetter(c)){
        getToolkit().beep();
        e.consume();
    }
}
});
}
public void SOtroCh (JTextField a){
a.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e){
    char c=e.getKeyChar();
        if (!Character.isUnicodeIdentifierPart(c)){
        getToolkit().beep();
        espacio=true;
        e.consume();

    }
}
});
}


public void SEspacio(JTextField a){
a.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e){
    char c=e.getKeyChar();
    if (Character.isSpaceChar(c)){
        getToolkit().beep();
        e.consume();
    }
}
});
}

public String getNombre(){
return this.nombre;} 

public void setChbxoff(){
this.jCheckBox1.setEnabled(false);
}
public void setChbxon(){
this.jCheckBox1.setEnabled(true);
}
public int getIndex(){
return this.index;} 

public boolean getFlag(){
return this.flag;}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idAtributo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        tipoVar = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        foraneo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tamanio = new javax.swing.JTextField();

        idAtributo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idAtributoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idAtributoKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre (ID):");

        jCheckBox1.setText("Llave");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        tipoVar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cadena", "Entero", "Decimal", "Fecha", "Hora" }));

        jLabel2.setText("Tipo del campo:");

        cerrar.setFont(new java.awt.Font("Aharoni", 1, 12)); // NOI18N
        cerrar.setForeground(java.awt.Color.gray);
        cerrar.setText("X");
        cerrar.setToolTipText("Cerrar");
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarMouseExited(evt);
            }
        });

        foraneo.setForeground(new java.awt.Color(153, 153, 153));
        foraneo.setText("               ");

        jLabel3.setText("Longitud:");

        tamanio.setText("20");
        tamanio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tamanioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoVar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(6, 6, 6)
                .addComponent(cerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foraneo)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(idAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jCheckBox1)
                .addComponent(cerrar)
                .addComponent(tipoVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(foraneo)
                .addComponent(jLabel3)
                .addComponent(tamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered
        this.cerrar.setForeground(Color.white);
        this.cerrar.setBackground(Color.DARK_GRAY);
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMouseEntered

    private void cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseExited
       this.cerrar.setForeground(Color.GRAY);
      
    }//GEN-LAST:event_cerrarMouseExited

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
    
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void idAtributoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idAtributoKeyReleased
   // TODO add your handling code here:
    }//GEN-LAST:event_idAtributoKeyReleased

    private void idAtributoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idAtributoKeyPressed
    SOtroCh(this.idAtributo);
    SEspacio(this.idAtributo);        // TODO add your handling code here:
    }//GEN-LAST:event_idAtributoKeyPressed

    private void tamanioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tamanioKeyPressed
     SOtroCh(this.tamanio);
     SNumeros(this.tamanio);
     SEspacio(this.tamanio);
     // TODO add your handling code here:
    }//GEN-LAST:event_tamanioKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel cerrar;
    public javax.swing.JLabel foraneo;
    public javax.swing.JTextField idAtributo;
    public javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField tamanio;
    public javax.swing.JComboBox tipoVar;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String tipvar = (String)cb.getSelectedItem();
        if(tipvar.equalsIgnoreCase("Fecha")||tipvar.equalsIgnoreCase("Hora")){
            this.tamanio.setText("");
            this.tamanio.setEnabled(false);}
        else{this.tamanio.setEnabled(true);
             this.tamanio.setText("20");}
        switch(this.tipoVar.getSelectedIndex()){
            case 0: this.tipodevar="VARCHAR";break;
            case 1: this.tipodevar="INTEGER";break;
            case 2: this.tipodevar="DECIMAL";break;
            case 3: this.tipodevar="DATE";break;
            case 4: this.tipodevar="TIME";break;
        }
        
        
        //updateLabel(petName);
    }
}
