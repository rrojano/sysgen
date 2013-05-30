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
public String bd;//nombre_bd
public String login;//usuario
public String password;//contraseÃ±a
public String url;
public int manejador = 1; //MySQL
                      // = 2; //Oracle
                      // = 3; //el otro
Connection conexion = null;

//Conecta la base de datos, usen 1 porque ahora sólo funciona SQL o 2 con Oracle
/**
 * 
 * @param i indica qué manejador se usará, 1=MySQL, 2=Oracle, 3=Otro 
 * @return regresa la conexion
 */
public Connection conectar(int i) {

try {
  manejador=i;
  if (manejador==1){//MySQL
  Class.forName("com.mysql.jdbc.Driver");  
  conexion = DriverManager.getConnection(url, login, password);}
  else if (manejador==2){//Oracle
         bd=login;
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conexion = DriverManager.getConnection(url,login,password);
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
/**
 * 
 * @param u usuario
 * @param c contraseña
 * @param e esquema
 */
public void configuraBD(String u, String c, String e, int m){
    login=u;
    password=c;
    bd=e;
    if (m==1)
    url="jdbc:mysql://localhost/"+e;
    else if (m==2)
      url = "jdbc:oracle:thin:@localhost:1521:XE";  
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
    	  mostrarMensaje("error en la inserciÃ³n");
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
//llámenlo así 
//JTable miTabla=new JTable();
//.....código de la tabla
// DefaultTableModel modelo=consultaAmodelo(consulta);
// miTabla.setModel(modelo);
/**
 * 
 * @param consulta Objeto String que contiene una consulta SQL
 * @return  Un modelo de datos de tabla, que se asignará a una tabla
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
 * @throws SQLException error en la conexión
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
//regresa las tablas de un esquema o BD, en el que se hizo la conexión    
/**
 * 
 * @return una lista ligada que contiene Strings de las tablas existentes en un esquema o base
 * de datos
 * @throws SQLException  error con la conexion
 */
public LinkedList<String> getCampos(String tabla, int columna) throws SQLException{
     ResultSet rs=this.consulta("select * from "+tabla);
     rs.next();
     System.out.println("select * from "+tabla);
        
     try{
           ResultSetMetaData metaDatos = rs.getMetaData();
           int numeroColumnas = metaDatos.getColumnCount();
           LinkedList<String> etiquetas = new LinkedList<String> ();
           switch(columna){
               case 1: {for (int i = 0; i < numeroColumnas; i++){
               etiquetas.add(metaDatos.getColumnTypeName(i + 1));
               }break;}
               case 2: {for (int i = 0; i < numeroColumnas; i++){
               etiquetas.add(""+metaDatos.getColumnDisplaySize(i+1));
               }break;}
               case 3: {for (int i = 0; i < numeroColumnas; i++){
               etiquetas.add(metaDatos.getColumnLabel(i+1));
               }break;}
           }
           return etiquetas;}
     
     catch (Exception e) {
           e.printStackTrace();
           return null;
     }

}    


public LinkedList <String> getTablas() throws SQLException{
     LinkedList<String> arr= new LinkedList<String>();
      String[] es={"TABLE"};
      DatabaseMetaData md = this.conexion.getMetaData();
      
      if (this.manejador==2)//Oracle
          bd=this.bd.toUpperCase();
      ResultSet rs = md.getTables(null, bd, "%", es);
      
      
            System.out.println("TABLAS");
      while (rs.next()) {
            System.out.println("||"+"||"+rs.getString(1)+"||"
                    +"||"+rs.getString(2)+"||"
                    +"||"+rs.getString(3)+"||");
            arr.add((rs.getString(3)));       
      }
      return arr;
 }
/**
 * 
 * @param mensaje String que se mostrará en el mensaje
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
        System.out.println("salió bien");
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
        System.out.println("salió bien");
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
}
//después se evaluará si los tipos son correctos y se devolverán

public boolean esLlavePrimaria(String tabla, String columna){
         boolean bandera=false;     
    try {
        DatabaseMetaData meta= conexion.getMetaData();
        ResultSet rs=meta.getPrimaryKeys(conexion.getCatalog(), this.bd, tabla);
        while (rs.next()){
           String fkColumnName = rs.getNString(4);           
            if (fkColumnName.equals(columna)){
                bandera= true;
            }    
        }
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return bandera;
}

    public boolean esLLaveForanea(String tabla, String columna) {
         String algo="";
         boolean bandera=false;
         
    try {
        
        
        DatabaseMetaData meta= conexion.getMetaData();
        ResultSet rs=meta.getImportedKeys(conexion.getCatalog(), this.bd, tabla);
        while (rs.next()){
           String fkColumnName = rs.getString("FKCOLUMN_NAME");
            if (fkColumnName.equals(columna)){
                System.out.println("la columna: "+columna+" de la tabla: "+ tabla+" es LLAVE FORÁNEA");
                bandera= true;
            }
                    
        }
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
         System.out.println("//"+algo);
         
        return bandera;
    }
    /**
     * 
     * @param tabla String que indica la tabla sobre que se efectuará el alter
     * @param columna String que refiere al campo o columna  que sufrirá la 
     * alteración
     * @param tipoDato String que contiene el tipo de dato que se especifica 
     * para alter add y alter modify
     * @param opción int que refleja el tipo de alteración que se realizará en 
     * la tabla: adición, borrado o modificación  de columnas
     */
    public void alterarTabla(String tabla,String columna,String tipoDato, int opción){
            
        String sentencia="alter table "+tabla;
        if (opción==1){//modificar el tipo de dato de un campo
            sentencia+=" modify "+columna+" "+tipoDato;
        }
        else if (opción==2){//agregar un campo a la tabla
            sentencia+=" add "+columna+" "+tipoDato;
        }
        else{//borrar un campo de la tabla
            sentencia+=" drop "+columna;
        }
        try{
        Statement st = conexion.createStatement();
        st.executeUpdate(sentencia);
        }catch (Exception e){
            System.out.println("error");
        }
    }
    
}
