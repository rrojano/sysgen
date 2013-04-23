/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.BD;

/**
 *
 * @author Luis Enrique
 */

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Driver;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class BD {
public String bd = "algo";//nombre_bd
public String login = "root";//usuario
public String password = "Gamblert77";//contraseÃ±a
public String url = "jdbc:mysql://localhost/"+bd;
public int manejador = 1; //MySQL
                      // = 2; //Oracle
                      // = 3; //el otro
Connection conexion = null;

//Conecta la base de datos, usen 1 porque ahora sólo funciona SQL
public Connection conectar(int i) {

try {
  manejador=i;
  if (manejador==1){//MySQL
  Class.forName("com.mysql.jdbc.Driver");  
  conexion = DriverManager.getConnection(url, login, password);}
  else if (manejador==2){//Oracle
  //DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
    //conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "PROYECTOBD", password);
  }
  else if (manejador==3){
      //IMPLEMENTAR OTRO
  }
  
  if (conexion != null){
      //System.out.println("ConexiÃ³n a base de datos "+url+" ... Ok");
      //mostrarMensaje("ConexiÃ³n a base de datos "+url+" ... Ok");
      //conexion.close();
      }
  }
  catch(SQLException ex) {
        System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
        mostrarMensaje("Hubo un problema al intentar conectarse con la base de datos "+url);
  }
  catch(ClassNotFoundException ex) {
        System.out.println(ex);
        mostrarMensaje(ex.getMessage());
        }
return conexion;
}
//Cierra la conexión, cuando cierren su ventana llamen a este método
public void desconectar(){
    try
    {
      this.conexion.close();
    }
    catch (Exception e) {
    	mostrarMensaje("error al cerrar la conexiÃ³n");
    }
}
//a partir de una sentencia SQL se pueden insertar o eliminar tuplas
public void insertar(String a) {
      try {
        Statement s = this.conexion.createStatement();
        String sql = a;
        s.executeUpdate(sql);
      }
      catch (Exception e) {
    	  mostrarMensaje("error en la inserciÃ³n");
        }
}


//hace una consulta a partir de una cadena y la devuelve a un ResultSet
public ResultSet consulta(String a){
     ResultSet rs = null;
     try
     {
         Statement s = conexion.createStatement(); 
        //String b = "select * from " + a + cond;
        
        System.out.println(a);
        rs = s.executeQuery(a);
     }
     catch (Exception e)
     {
         //String b;
         e.printStackTrace();
        // b = e.getMessage();
    	 mostrarMensaje("Error en la sintaxis de la consulta");
     }
     return rs;
}

//crea un modelo de tabla, para JTable, a partir de una cadena
//llámenlo así 
//JTable miTabla=new JTable();
//.....código de la tabla
// DefaultTableModel modelo=consultaAmodelo(consulta);
// miTabla.setModel(modelo);
public DefaultTableModel consultaAmodelo(String consulta){    
    ResultSet rs=this.consulta(consulta);
    DefaultTableModel modelo=new DefaultTableModel();
    ConversorResultSetADefaultTableModel.rellena(rs, modelo);
    return modelo;
}

//regresa los campos de una tabla en una lista ligada
public LinkedList<String> getCampos(String tabla) throws SQLException{
     ResultSet rs=this.consulta("select * from "+tabla);
     rs.next();
     System.out.println("select * from "+tabla);
        
     try{
           ResultSetMetaData metaDatos = rs.getMetaData();
           int numeroColumnas = metaDatos.getColumnCount();
           LinkedList<String> etiquetas = new LinkedList<String> ();
           for (int i = 0; i < numeroColumnas; i++){
               etiquetas.add(metaDatos.getColumnLabel(i + 1));
               System.out.println(metaDatos.getColumnLabel(i + 1));
           }
           return etiquetas;
     }catch (Exception e) {
           e.printStackTrace();
           return null;
     }

}    
//regresa las tablas de un esquema o BD, en el que se hizo la conexión    
public LinkedList <String> getTablas() throws SQLException{
     LinkedList<String> arr= new LinkedList<String>();
    
      DatabaseMetaData md = this.conexion.getMetaData();
      ResultSet rs = md.getTables(null, null, "%", null);
      
      while (rs.next()) {
            arr.add((rs.getString(3)));       
      }
      return arr;
 }

public void mostrarMensaje(String mensaje) {
    JOptionPane.showMessageDialog(null, mensaje, "Advertencia",JOptionPane.WARNING_MESSAGE);
 }
}