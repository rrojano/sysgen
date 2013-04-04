/*     */ package MeroBueno;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class ConversorResultSetADefaultTableModel
/*     */ {
/*     */   public static void rellena(ResultSet rs, DefaultTableModel modelo)
/*     */   {
/*  28 */     configuraColumnas(rs, modelo);
/*  29 */     vaciaFilasModelo(modelo);
/*  30 */     anhadeFilasDeDatos(rs, modelo);
/*     */   }
/*     */ 
/*     */   private static void anhadeFilasDeDatos(ResultSet rs, DefaultTableModel modelo)
/*     */   {
/*  41 */     int numeroFila = 0;
/*     */     try
/*     */     {
/*  45 */       while (rs.next())
/*     */       {
/*  48 */         Object[] datosFila = new Object[modelo.getColumnCount()];
/*  49 */         for (int i = 0; i < modelo.getColumnCount(); i++)
/*  50 */           datosFila[i] = rs.getObject(i + 1);
/*  51 */         modelo.addRow(datosFila);
/*  52 */         numeroFila++;
/*     */       }
/*  54 */       rs.close();
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void vaciaFilasModelo(DefaultTableModel modelo)
/*     */   {
/*     */     try
/*     */     {
/*  77 */       while (modelo.getRowCount() > 0) {
/*  78 */         modelo.removeRow(0);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  84 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void configuraColumnas(ResultSet rs, DefaultTableModel modelo)
/*     */   {
/*     */     try
/*     */     {
/*     */       try
/*     */       {
/* 112 */         ResultSetMetaData metaDatos = rs.getMetaData();
/*     */ 
/* 115 */         int numeroColumnas = metaDatos.getColumnCount();
/*     */ 
/* 118 */         Object[] etiquetas = new Object[numeroColumnas];
/* 119 */         for (int i = 0; i < numeroColumnas; i++)
/*     */         {
/* 121 */           etiquetas[i] = metaDatos.getColumnLabel(i + 1);
/*     */         }
/*     */ 
/* 126 */         modelo.setColumnIdentifiers(etiquetas);
/*     */       }
/*     */       catch (Exception e) {
/* 129 */         e.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 137 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Kavrom\Documents\ProyectosIndie\BDD-Replicación\
 * Qualified Name:     MeroBueno.ConversorResultSetADefaultTableModel
 * JD-Core Version:    0.6.0
 */