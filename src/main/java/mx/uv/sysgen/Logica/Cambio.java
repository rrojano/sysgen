/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.Logica;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import mx.uv.sysgen.BD.BD;

/**
 *
 * @author Santiu
 */
public class Cambio {
    LinkedList<String> campos;
    BD bdmanager; 
    
    public Cambio(){
        bdmanager= new BD();
        bdmanager.configuraBD("root", "123", "taller2", 1);
        bdmanager.conectar(1);//
        campos = new LinkedList<String>();                    
    }
    
    //----------OBTENER TABLAS-------------------//
    /**
     * Accede a la base de datos configurada previamente y agrega los registros.
     * @return Regresa una lista ligada de nombres de tablas
     */
    public LinkedList<String> getTablas(){        
        LinkedList<String> n = new LinkedList<String>();        
        try {
            n = bdmanager.getTablas();
        } catch (SQLException ex) {
            Logger.getLogger(Alta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public DefaultTableModel obtenerDatos(String tabla){
        String query;
        query = "select * from "+tabla+";";
        System.out.println(query);
        return bdmanager.consultaAmodelo(query);
    }
    
    public boolean cambiar(String tabla, LinkedList<String> tupla, LinkedList<String> campos){
        String id = campos.pop();
        String id_value  = tupla.pop();
        String query = "update "+tabla+" set ";        
        for(String s:campos){
        query = query + s + "="+"'"+ tupla.pop() + "' ";    
        }
        query = query + " where "+ id +"='"+ id_value +"';";
        System.out.println(query);
        bdmanager.insertar(query);
        return true;
    }
}
