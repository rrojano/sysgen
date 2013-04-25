/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.uv.sysgen.BD.BD;
import mx.uv.sysgen.BD.FConsultas1;

/**
 *
 * @author Santi
 */

//** modulo l�gico de altas **//

public class Alta {
    LinkedList<String> campos;
    BD bdmanager;
    
    
    //** Constructor; agrego campos ficticios para que despliegue algo en pantalla **//
    public Alta(){
        bdmanager= new BD();
        bdmanager.conectar(1);//
        campos = new LinkedList<String>();
        campos.add("Campo1");
        campos.add("Campo2");
        campos.add("Campo3");
        campos.add("Campo4");
        campos.add("Campo5");
        campos.add("Campo6");
                
    }
    
    //** Agrega los campos de los componentes a la tabla especificada **//
    public void Agregar(LinkedList<String> campos, String tabla){
        
        bdmanager.consulta(tabla);
    }
    
    //**regresa las tablas de la bd**//
    public LinkedList<String> getTablas(){
        //obtener tablas con BD
        LinkedList<String> n = new LinkedList<String>();
        try {
            n = bdmanager.getTablas();
        } catch (SQLException ex) {
            Logger.getLogger(Alta.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*n.add("Tabla1");
        n.add("Tabla2");
        n.add("Tabla3");
        n.add("Tabla4");
        n.add("Tabla5");
        n.add("Tabla6");
        n.add("mysql");*/
        return n;
    }
    
    //** Obtiene los campos de una tabla usando la clase BD **//
    public LinkedList<String> getCampos(String tabla){
        /*try{
            campos = bdmanager.getCampos(tabla);
        }catch (SQLException ex) {
            Logger.getLogger(Alta.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return campos;
    }
}
