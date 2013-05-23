/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.Logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Luis Enrique
 */


public class Configuraci�n implements java.io.Serializable{

private String ruta_Reportes="reportes";  //por defecto, aunque deber�a ser personalizado
private String usuario="root";
private String contrase�a="";
private String esquema="";
private int manejador= 1; //MySQL
                      // = 2; //Oracle
                      // = 3; //el otro;    


//gets de los atributos
public String getRuta_Reportes(){
    return ruta_Reportes;
}
public String getUsuario(){
    return usuario;
}
public String getContrase�a(){
    return contrase�a;
}
public String getEsquema(){
    return esquema;
}
public int getManejador(){
    return manejador;
}

public Configuraci�n abrirArchivo(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Configuraci�n a = null;
        try
        {
          fis=new FileInputStream("conf.bin");
		  ois=new ObjectInputStream(fis);
		  a=(Configuraci�n) ois.readObject();
    	  ois.close();
        }catch( Exception e ){ 
        	//e.printStackTrace();
                
                mostrarMensaje(e.getMessage());
        	mostrarMensaje("Error con la ruta o el archivo indicados");
        }
        return a;
    }

public void guardarArchivo(Configuraci�n nueva){
    try{ 
              FileOutputStream fos=new FileOutputStream("conf.bin");
	      ObjectOutputStream oos=new ObjectOutputStream(fos);
              oos.writeObject(nueva);
	      oos.close();
          }catch (Exception ex){ 
              mostrarMensaje(ex.getMessage());
          }
}
public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
}

    

    public void actualizar(String u, String c, String e, int man, String r) {
        usuario=u;
        contrase�a=c;
        esquema=e;
        manejador=man;
        ruta_Reportes=r;
    }

}

/*
 if( manejadorArchivo == null ) manejadorArchivo = new JFileChooser();
	            manejadorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
 int seleccion = manejadorArchivo.showOpenDialog( mntmAbrir );
	            if( seleccion == JFileChooser.APPROVE_OPTION )
	            {
	                File f = manejadorArchivo.getSelectedFile();
	                
	                    String nombre = f.getName();
	                    String path = f.getAbsolutePath();
	                    conf=getArchivo(path);
 */