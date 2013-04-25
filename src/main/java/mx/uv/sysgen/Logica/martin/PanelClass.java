/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;



/**
 *
 * @author GON
 */
public class PanelClass extends JPanel implements ActionListener{

    public JPanel cont = new JPanel();
    private int index=0;
    private int y=60;
    private boolean flag=false;
    private boolean key=false;
    public ArrayList<Object> arreglo = new ArrayList<Object>();
    private Map nota = new HashMap();
    
public PanelClass (){
                 
                 cont.setVisible(true);
                 cont.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); 
                }

public JPanel getPanel (){
return cont;
}

public void setSizecont(int index){
    if (index<5){flag=false;}
    if (flag == true){
    y=y+59;
    flag=false;
    }else flag=true;y=y-1;
    cont.setPreferredSize(new Dimension(748, y));
    cont.validate();
}
public void addelement(){
    jpComponente comp = new jpComponente(index+1);
    if (this.key==true){comp.setChbxoff();}
    comp.jCheckBox1.addActionListener(this);
    arreglo.add(comp);
    cont.add(comp);
    cont.validate();
    nota.put("key_" + index, comp );
    index++;

}


    public void actionPerformed(ActionEvent e) {
        int i;
        i = 1;
        
        if (key==false){
        while (i <= index){
        jpComponente jpc = (jpComponente) arreglo.get(i-1);
        if(jpc.jCheckBox1.isSelected()== false){
        jpc.setChbxoff();}
        else{jpc.cerrar.setEnabled(false);}
        i++;}
        this.key=true;
        }
        
        else{   
        while (i <= index){
        jpComponente jpc = (jpComponente) arreglo.get(i-1);
        if(jpc.jCheckBox1.isSelected()== false){
        jpc.setChbxon();}
        i++;}
        this.key=false;}
        }
        
        
    }

