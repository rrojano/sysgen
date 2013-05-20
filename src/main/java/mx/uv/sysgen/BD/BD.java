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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BD {
    
public String bd = "algo";//nombre_bd
public String login = "root";//usuario
public String password = "Gamblert77";//contraseña
public String url = "jdbc:mysql://localhost/"+bd;
public int manejador = 1; //MySQL
                      // = 2; //Oracle
                      // = 3; //el otro
Connection conexion = null;

//Conecta la base de datos, usen 1 porque ahora s�lo funciona SQL
/**
 * 
 * @param i indica qu� manejador se usar�, 1=MySQL, 2=Oracle, 3=Otro 
 * @return regresa la conexion
 */
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
      //System.out.println("Conexión a base de datos "+url+" ... Ok");
      //mostrarMensaje("Conexión a base de datos "+url+" ... Ok");
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

public void setBD(String nomb,String pass,String user){
    this.login=user;
    this.password=pass;
    this.bd=nomb;
}
//Cierra la conexi�n, cuando cierren su ventana llamen a este m�todo

public void desconectar(){
    try
    {
      this.conexion.close();
    }
    catch (Exception e) {
    	mostrarMensaje("error al cerrar la conexión");
    }
}
/**
 * 
 * @param u usuario
 * @param c contrase�a
 * @param e esquema
 */
public void configuraBD(String u, String c, String e, int m){
    login=u;
    password=c;
    bd=e;
    url="jdbc:mysql://localhost/"+e;
    conectar(m);
}
//a partir de una sentencia SQL se pueden insertar o eliminar tuplas
/**
 * 
 * @param a sentencia sql, un insert, update o delete
 */
public void insertar(String a) {
      try {
        Statement s = this.conexion.createStatement();
        String sql = a;
        s.executeUpdate(sql);
      }
      catch (Exception e) {
    	  mostrarMensaje("error en la inserción");
        }
}


//hace una consulta a partir de una cadena y la devuelve a un ResultSet
/**
 * 
 * @param a consulta en lenguaje sql ej: "select * from tabla where id=1"
 * @return una tabla de resultados, este objeto contiene todas las tuplas encontradas a partir de la consulta
 */
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
//ll�menlo as� 
//JTable miTabla=new JTable();
//.....c�digo de la tabla
// DefaultTableModel modelo=consultaAmodelo(consulta);
// miTabla.setModel(modelo);
/**
 * 
 * @param consulta Objeto String que contiene una consulta SQL
 * @return  Un modelo de datos de tabla, que se asignar� a una tabla
 */
public DefaultTableModel consultaAmodelo(String consulta){    
    ResultSet rs=this.consulta(consulta);
    DefaultTableModel modelo=new DefaultTableModel();
    ConversorResultSetADefaultTableModel.rellena(rs, modelo);
    return modelo;
}

//regresa los campos de una tabla en una lista ligada
/**
 * 
 * @param tabla String que contiene el nombre de la tabla
 * @return una lista ligada que contiene Strings de los campos existentes en una tabla
 * @throws SQLException error en la conexi�n
 */
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
//regresa las tablas de un esquema o BD, en el que se hizo la conexi�n    
/**
 * 
 * @return una lista ligada que contiene Strings de las tablas existentes en un esquema o base
 * de datos
 * @throws SQLException  error con la conexion
 */
public LinkedList <String> getTablas() throws SQLException{
     LinkedList<String> arr= new LinkedList<String>();
    
      DatabaseMetaData md = this.conexion.getMetaData();
      ResultSet rs = md.getTables(null, null, "%", null);
      
      while (rs.next()) {
            arr.add((rs.getString(3)));       
      }
      return arr;
 }
/**
 * 
 * @param mensaje String que se mostrar� en el mensaje
 */
public void mostrarMensaje(String mensaje) {
    JOptionPane.showMessageDialog(null, mensaje, "Advertencia",JOptionPane.WARNING_MESSAGE);
 }


/**
 * 
 * @param nombre nombre de la tabla
 * @param campos lista ligada de objetos CampoSQL
 */
public void crearTabla(String nombre, LinkedList<CampoSQL> campos){
   String sentencia="create table "+nombre+" (";
   for (int i=0;i<campos.size();i++){         
       sentencia=sentencia+campos.get(i).campo+" "+campos.get(i).tipo;
       if (campos.get(i).llavePrim==true)
           sentencia=sentencia +" primary key ";
       if (campos.get(i).nulleable==true)
           sentencia=sentencia +" not null ";
       if(i<campos.size()-1)
           sentencia=sentencia+",";
   } 
   sentencia=sentencia+")";
   System.out.println(sentencia); 
    try {
        System.out.println("---------------------------------");
        Statement st = conexion.createStatement();
        st.executeUpdate(sentencia);
        System.out.println("sali� bien");
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
   
}

public void llaveForanea(String uno,String dos,String campuno,String campdos){
    String sentencia="alter table "+uno+" add constraint fk_"+dos+" foreign key ";
    sentencia=sentencia+" ("+campuno+") references "+dos+" ("+campdos+")";
    System.out.println(sentencia); 
    try {
        System.out.println("---------------------------------");
        Statement st = conexion.createStatement();
        st.executeUpdate(sentencia);
        System.out.println("sali� bien");
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
}
//despu�s se evaluar� si los tipos son correctos y se devolver�n


    public boolean esLLaveForanea(String tabla, String columna) {
         String algo="";
         boolean bandera=false;
         
    try {
        
        
        DatabaseMetaData meta= conexion.getMetaData();
        ResultSet rs=meta.getImportedKeys(conexion.getCatalog(), "algo", tabla);
        while (rs.next()){
           String fkColumnName = rs.getString("FKCOLUMN_NAME");
           /*
            String fkTableName = rs.getString("FKTABLE_NAME");
            
            String pkTableName = rs.getString("PKTABLE_NAME");
            String pkColumnName = rs.getString("PKCOLUMN_NAME");
            int fkSequence = rs.getInt("KEY_SEQ");
            algo=algo+"getExportedKeys(): fkTabbleName="+fkTableName+"\n";
            algo=algo+"getExportedKeys(): fkColumnName="+fkColumnName+"\n";
            algo=algo+"getExportedKeys(): pkTabbleName="+pkTableName+"\n";
            algo=algo+"getExportedKeys(): pkColumnName="+pkColumnName+"\n";
            algo=algo+"getExportedKeys(): fkSequence="+fkSequence+"\n";
            */
            if (fkColumnName.equals(columna)){
                System.out.println("la columna: "+columna+" de la tabla: "+ tabla+" es LLAVE FOR�NEA");
                bandera= true;
            }
                    
        }
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
         System.out.println("//"+algo);
         
        return bandera;
    }


}