package mx.uv.sysgen.Logica.martin;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;




/**
 *
 * @author GON
 */
public class PanelClass extends JPanel implements ActionListener, MouseListener{

    public JPanel cont = new JPanel();
    private int index=0;
    private int y=174;
    private int key=1;
    public ArrayList<Object> arreglo = new ArrayList<Object>();

//Constructor de la clase panel
public PanelClass (){
                 cont.setPreferredSize(new Dimension(637, 174));
                 cont.setVisible(true);
                 cont.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); 
                }

//Regresa el panel contenedor
public JPanel getPanel (){
return cont;
}

//Cambia el tamaño del panel conetedor al agregar un nuevo panel
public void setSizeAdd(){
if(arreglo.size()>6){
y=y+29;
    cont.setPreferredSize(new Dimension(748, y));
    cont.validate();
}
}

//Cambia el tamaño del panel contenedor al eliminar un panel interno
public void setSizeElm(){
 if(arreglo.size()>=6){
 y=y-29;
 cont.setPreferredSize(new Dimension(748, y));
 cont.validate();
 }
}

//Agrega un nuevo elemento al panel contenedor
public void addelement(){
//Se crea un nuevo componente
    jpComponente comp = new jpComponente(index+1);
//Se asigna el tamaño del componente
    comp.setPreferredSize(new Dimension( 635,29));
//Si key es 0 no hay un componente seleccionado como llave primaria
    if (this.key==0){comp.setChbxoff();} //si es 0 desactiva el checkbox del componente que se cree

// se agrega este elemento como escucha de eventos a los  elementos en el componente CheckBox y cerrar
    comp.Llave.addActionListener(this);
    comp.cerrar.addMouseListener(this);
//Se agrega el componente al arreglo y al panel contenedor
    
    arreglo.add(comp);
    cont.add(comp);
    setSizeAdd();
    cont.validate();
    index++;
}
public void addelement(String id, int tipo){
    jpComponente comp = new jpComponente(index+1);
    comp.setPreferredSize(new Dimension( 635,29));
    if (this.key==0){comp.setChbxoff();}
    //comp.jCheckBox1.setVisible(false);
    comp.idAtributo.setText(id);
    comp.tipoVar.setSelectedIndex(tipo);
    //comp.foraneo.setText("Foraneo");
    comp.cerrar.addMouseListener(this);
    arreglo.add(comp);
    cont.add(comp);
    setSizeAdd();
    cont.validate();
    index++;
}

public int tipodevar(String tipo){
int i=0;
    if(tipo.equals("VARCHAR")){i=0;}
    if(tipo.equals("INT")){i=1;}
    if(tipo.equals("DECIMAL")){i=2;}
    if(tipo.equals("TIME")){i=3;}
    if(tipo.equals("DATE")){i=4;}
    return i;
}

public void addelement(String id, String tipo, String tamanio, boolean llave){
    jpComponente comp = new jpComponente(index+1);
    comp.setPreferredSize(new Dimension( 635,29));
    
    if (this.key==0){comp.setChbxoff();}
    if (llave=true){comp.setSelected();key=0;}
    comp.idAtributo.setText(id);
    comp.tipoVar.setSelectedIndex(tipodevar(tipo));
    comp.tamanio.setText(tamanio);
    // se agrega este elemento como escucha de eventos a los  elementos en el componente CheckBox y cerrar
    comp.Llave.addActionListener(this);
    comp.cerrar.addMouseListener(this);
    //Se agrega el componente al arreglo y al panel contenedor
    
    arreglo.add(comp);
    cont.add(comp);
    setSizeAdd();
    cont.validate();
    index++;
}

    public void actionPerformed(ActionEvent e) {
    if(key==1){key=0;}else{key=1;}
    for(int i=0; i<arreglo.size();i++){
            jpComponente jpc = (jpComponente) arreglo.get(i);
            switch (key){
                case 0:
                    if(jpc.Llave.isSelected()== false){
                    jpc.setChbxoff();
                    }else{
                    jpc.bloqueado=true;
                    }
                    break;    
                case 1:
                    jpc.setChbxon();
                    jpc.bloqueado=false;
                    break;
            }
        }
    }

    
    public void mouseClicked(MouseEvent e) {
       int i=0;
       int j=arreglo.size();
       while (i<j){
        jpComponente jpc = (jpComponente) arreglo.get(i);
        if (jpc.nombre.equalsIgnoreCase(e.getComponent().getName())){
        if (jpc.bloqueado == false){
        jpc.setVisible(false);
        arreglo.remove(i);
        setSizeElm();
        j--;}}
        i++;
    
       }  
    }

    
    public void mousePressed(MouseEvent e) {

    }

    
    public void mouseReleased(MouseEvent e) {
    }

    
    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }
        
        
    }

