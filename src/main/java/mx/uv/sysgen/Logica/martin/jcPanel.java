package mx.uv.sysgen.Logica.martin;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;

/**
 *
 * @author GON
 */
public class jcPanel extends JScrollPane implements ActionListener{
    //private JScrollPane scrollpane = new JScrollPane();
    private int index = 1;
    //Nos sirve para almacenar a los objetos creados
    private Map nota = new HashMap();
    public JPanel co = new ScrollablePanel();
    private JScrollPane spp;
    
    public jcPanel()
    {
       this.add(co);
       this.setSize(314, 400);
       this.setVisible(true);
       co.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
       co.setSize(314, 400);
       co.setVisible(true);
       
       /*JScrollPane sp = new JScrollPane(co);
       setPreferredSize(new Dimension(314,400));
       //, BorderLayout.CENTER);
       //co.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
       //this.setSize(50, 40);
       this.setVisible(true);
       /*this.setLayout(new ScrollPaneLayout());
       this.setBorder(BorderFactory.createLineBorder( Color.RED ));
       this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        */
    }

      public void Mi_Componente()
    {        
        //instancia nueva a componente
        jpComponente jpc = new jpComponente(index);
        jpc.jButton1.addActionListener(this);//escucha eventos
                     co.setBorder(BorderFactory.createLineBorder(Color.RED));
                    co.setPreferredSize(new Dimension(50, 50));
        co.add(jpc);//se añade al jpanel
        co.validate();
        //se añade al MAP
        this.nota.put("key_" + index, jpc );
        //se incrementa contador de componentes
        index++;
    }

    public void actionPerformed(ActionEvent e) {
        //se obtiene el comando ejecutado
        String comando = e.getActionCommand();
        //se recorre el MAP
        Iterator it = nota.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            //se obtiene el KEY -> identificador unico
            String itm = entry.getKey().toString();
            //si comando de componente es igual a comando pulsado
            if( itm.equals(comando))
            {
                //se recupera el contenido del JTextfield
                String name = ((jpComponente) entry.getValue()).jTextField1.getText();
                //mostramos resultado
                JOptionPane.showMessageDialog(null, "Se presiono boton " + itm + " \n Hola " + name);
            }
        }
    }

}
