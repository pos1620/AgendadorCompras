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
public class produto {
    public String descricao;
    public float valor;

    public String getDescricao() {
        return descricao;
    }

    public void setTipo(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    //Inicio
    public  String[] SetarDados(){
    String nms[]={descricao,Float.toString(valor)};
    return nms;
    }
    
    
    
     public String QuemSouEu(Object ob){
    return ob.getClass().getSimpleName();
    }

    
    conexao con = new conexao();
    PreparedStatement stmt;
    //connecting to database
    public void InserirDados(){
    try{	
	stmt = con.conectando().prepareStatement("insert into pessoa ("+column()+") values ("+interr()+")");
        
        
        for(byte i=1;i<=QuantColumn();i++)
        stmt.setString(i,vars()[i-1]);
        stmt.execute();
        stmt.close();
	System.out.println("Gravado!");
	con.conectando().close();
    } 
catch (SQLException e) {
}
    }//fim metódo InserirDados


    
    
    public byte QuantColumn(){
    byte i=0;
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from pessoa");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();


i=(byte) rsmd.getColumnCount();
            }
    catch(SQLException e){
    }
        return i;
    }//fim metódo QuantColumn
    
    
    
    
    public String column(){
        String nms="";
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from pessoa");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();

    for(byte j=1;j<=QuantColumn();j++)
        if(j==QuantColumn())
    nms+=rsmd.getColumnName(j);
            else
    nms+=rsmd.getColumnName(j)+",";
            }    

            catch(SQLException e){
    }
return nms;
}//fim metódo columns
    

 public String interr(){
 String interr="?";
 
 for(byte j=1;j<=QuantColumn();j++)
        if(j==QuantColumn())
    interr+="";
            else
    interr+=",?";
 return interr;
 }//fim metodo interr   
    
 
 public String[] camposDivididos(){
String[] args=column().split("[,]");
return args;
       //return Arrays.toString(args);
}//fim metódo camposDivididos

 
 public String[] vars(){
//String x="\"nome\"".replace("\""," ");
String n[]={descricao,Float.toString(valor)};
 return n;
 }//fim metodo vars 

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//fim classe produto

