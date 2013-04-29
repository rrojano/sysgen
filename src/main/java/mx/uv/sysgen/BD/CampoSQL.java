/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.BD;

/**
 *
 * @author Luis Enrique
 */
class CampoSQL{
    String campo;
    String tipo="varchar(20)";
    boolean llavePrim=false;
    boolean nulleable=false;
    
    
    
    public CampoSQL(String c, String t,boolean prim,boolean nullear){
        campo=c;
        tipo=t;
        llavePrim=prim;
        nulleable=nullear;
    }
}
