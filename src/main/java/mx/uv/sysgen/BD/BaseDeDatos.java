/*    */ package MeroBueno;
/*    */ 
/*    */ import com.mysql.jdbc.Driver;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ 
/*    */ public class BaseDeDatos
/*    */ {
/* 22 */   private Connection conexion = null;
/*    */ 
/*    */   public void estableceConexion()
/*    */   {
/* 27 */     if (this.conexion != null) {
/* 28 */       return;
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 33 */       DriverManager.registerDriver(new Driver());
/*    */ 
/* 38 */       this.conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.3/bodas", "root", "Gamblert77");
/*    */     }
/*    */     catch (Exception e) {
/* 41 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public ResultSet consultaGeneral(String a, String cond)
/*    */   {
/* 52 */     ResultSet rs = null;
/*    */     try
/*    */     {
/* 56 */       Statement s = this.conexion.createStatement();
/*    */ 
/* 60 */       String b = "select * from " + a + cond;
/* 61 */       System.out.println(b);
/* 62 */       rs = s.executeQuery(b);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 67 */       e.printStackTrace();
/*    */     }
/* 69 */     return rs;
/*    */   }
/*    */ 
/*    */   public void insertar(String a) {
/*    */     try {
/* 74 */       Statement s = this.conexion.createStatement();
/* 75 */       String sql = a;
/* 76 */       s.executeUpdate(sql);
/*    */     }
/*    */     catch (Exception e) {
/* 79 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void cierraConexion()
/*    */   {
/*    */     try
/*    */     {
/* 89 */       this.conexion.close();
/*    */     }
/*    */     catch (Exception e) {
/* 92 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Kavrom\Documents\ProyectosIndie\BDD-Replicación\
 * Qualified Name:     MeroBueno.BaseDeDatos
 * JD-Core Version:    0.6.0
 */