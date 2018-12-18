/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author home
 */
public class Generica extends produto{
public class GO extends pessoa{
  
    public Object QuemSouEu(Object ob){
    Object ob2 = ob;
    return ob2;
    }
    
    
     conexao con = new conexao();
    PreparedStatement stmt;
    pessoa p1 = new pessoa();
    //GO g = new GO(); 
    //Generica gen = new Generica();
//connecting to database
    public void InserirDados(Object ob){
    try{	
	stmt = con.conectando().prepareStatement("insert into "+this.QuemSouEu(ob).getClass().getSimpleName()+" ("+this.column(ob)+") values ("+this.interr(ob)+")");
        
        
        for(byte i=1;i<=QuantColumn(ob);i++)
        stmt.setString(i,this.vars(ob)[i-1]);
        stmt.execute();
        stmt.close();
	System.out.println("Gravado!");
	con.conectando().close();
    } 
catch (SQLException e) {
}
    }//fim metódo InserirDados


    
    
    public byte QuantColumn(Object ob){
    byte i=0;
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from "+QuemSouEu(ob).getClass().getSimpleName()+"");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();


i=(byte) rsmd.getColumnCount();
            }
    catch(SQLException e){
    }
        return i;
    }//fim metódo QuantColumn
    
    
    
    
    public String column(Object ob){
        String nms="";
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from "+QuemSouEu(ob).getClass().getSimpleName()+"");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();

    for(byte j=1;j<=QuantColumn(ob);j++)
        if(j==QuantColumn(ob))
    nms+=rsmd.getColumnName(j);
            else
    nms+=rsmd.getColumnName(j)+",";
            }    

            catch(SQLException e){
    }
return nms;
}//fim metódo columns
    

 public String interr(Object ob){
 String interr="?";
 
 for(byte j=1;j<=QuantColumn(ob);j++)
        if(j==QuantColumn(ob))
    interr+="";
            else
    interr+=",?";
 return interr;
 }//fim metodo interr   
    
 
 public String[] camposDivididos(Object ob){
String[] args=column(ob).split("[,]");
return args;
       //return Arrays.toString(args);
}//fim metódo camposDivididos

 
 public String[] vars(Object ob){
//String n[]=null;
String nms[]=null;
     if(QuemSouEu(ob).getClass().getSimpleName()=="pessoa"){
String n[]={nome,produto,url,wpp,endereco};
nms=n;
     }else{
String n[]={descricao,"valor"};
nms=n;
     }
            return nms;
 }//fim metodo vars 
    
}//fim classe GP
}//fim class generica