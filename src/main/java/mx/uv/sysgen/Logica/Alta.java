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
 * Clase que maneja la lógica de las altas a los catálogos
 * @author Santi
 */

/** modulo lógico de altas **/

public class Alta {
    LinkedList<String> campos;
    BD bdmanager;
    
    
    
    //----------------------CONSTRUCTOR------------------//
    /**
     * Constructor por defecto.
     */
    public Alta(){
        bdmanager= new BD();
        bdmanager.configuraBD("root", "123", "entrar", 1);
        bdmanager.conectar(1);//
        campos = new LinkedList<String>();                    
    }
    
    
    // ---------------AGREGAR-------------------------------------//
/**
 * Agrega los campos de la tabla especificada a la base de datos.
 * @param campos Lista de campos de la tabla.
 * @param tabla Tabla a la que pertenecen los campos.
 */    
    public void Agregar(LinkedList<String> campos, String tabla){        
        String sql="insert into "+tabla+" values('"+campos.pop();
        for(String s:campos){
            sql = sql + "','"+s;
        }
        sql = sql + "');";
        System.out.println(sql);
        System.out.println(tabla);
        bdmanager.insertar(sql);
        
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
    
    // ------------------- OBTENER CAMPOS ----------------------//
    /**
     * Obtiene los campos de la tabla especificada.
     * @param tabla tabla de la que se quieren extraer los campos.
     * @return Lista ligada de nombres de campos.
     */
    public LinkedList<String> getCampos(String tabla){
        try{
            campos = bdmanager.getCampos(tabla);
        }catch (SQLException ex) {
            Logger.getLogger(Alta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return campos;
    }
}
