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
public class Generica{

    
    public String QuemSouEu(){
    return this.getClass().getSimpleName();
    }
    
    
     conexao con = new conexao();
    PreparedStatement stmt;
    
    

    
    
    public byte QuantColumn(){
    byte i=0;
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from "+QuemSouEu()+"");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();


i=(byte) rsmd.getColumnCount();
            }
    catch(SQLException e){
    }
        return i;
    }//fim metódo QuantColumn
    

    
    
    /*
    prenenche  nom edos campos para insera~~o dos dados.
    ex. (nome,prod,desc)
    */
    public String column(){
        String nms="";
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from "+QuemSouEu()+"");
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
    
/*
    quantidade de parametro correspondente ao qquantiddae de campo no banco
    ex. vlues(?,?,?)
    */
 public String interr(){
 String interr="?";
 
 for(byte j=1;j<=QuantColumn();j++)
        if(j==QuantColumn())
    interr+="";
            else
    interr+=",?";
 return interr;
 }//fim metodo interr   
    
 //do banco para consulta
 public String[] camposDivididos(){
String[] args=column().split("[,]");
return args;
       //return Arrays.toString(args);
}//fim metódo camposDivididos

 //da classe para consulta
public String[] camposDivididos2(String vars){
String[] args=vars.split(",");
return args;
}//fim da classe camposDivididos2


public String[] camposDivididos3(String[] vars){
String[] args=vars;
return args;
}

}//fim class generica