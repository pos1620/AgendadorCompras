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
  
    public String QuemSouEu(Object ob){
    return ob.getClass().getSimpleName();
    }
    
    
     conexao con = new conexao();
    PreparedStatement stmt;
    
    //GO g = new GO(); 
    //Generica gen = new Generica();
    pessoa p1 = new pessoa();
//connecting to database
    public void InserirDados(pessoa ob){
        try{	
	stmt = con.conectando().prepareStatement("insert into "+QuemSouEu(ob)+" ("+column(QuemSouEu(ob))+") values ("+interr(QuemSouEu(ob))+")");
        
        for(byte i=1;i<=QuantColumn(QuemSouEu(ob));i++)
        stmt.setString(i,ob.SetarDados()[i-1]);
        stmt.execute();
        stmt.close();
	System.out.println("Gravado!");
	con.conectando().close();
    } 
catch (SQLException e) {
}
    }//fim metódo InserirDados
public void InserirDados(produto ob){
        try{	
	stmt = con.conectando().prepareStatement("insert into "+QuemSouEu(ob)+" ("+column(QuemSouEu(ob))+") values ("+interr(QuemSouEu(ob))+")");
        
        for(byte i=1;i<=QuantColumn(QuemSouEu(ob));i++)
        stmt.setString(i,ob.SetarDados()[i-1]);
        stmt.execute();
        stmt.close();
	System.out.println("Gravado!");
	con.conectando().close();
    } 
catch (SQLException e) {
}
    }//fim metódo InserirDados


    
    
    public byte QuantColumn(String tabela){
    byte i=0;
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from "+tabela+"");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();


i=(byte) rsmd.getColumnCount();
            }
    catch(SQLException e){
    }
        return i;
    }//fim metódo QuantColumn
    
    
    
    
    public String column(String tabela){
        String nms="";
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from "+tabela+"");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();

    for(byte j=1;j<=QuantColumn(tabela);j++)
        if(j==QuantColumn(tabela))
    nms+=rsmd.getColumnName(j);
            else
    nms+=rsmd.getColumnName(j)+",";
            }    

            catch(SQLException e){
    }
return nms;
}//fim metódo columns
    

 public String interr(String campo){
 String interr="?";
 
 for(byte j=1;j<=QuantColumn(campo);j++)
        if(j==QuantColumn(campo))
    interr+="";
            else
    interr+=",?";
 return interr;
 }//fim metodo interr   
    
 
 public String[] camposDivididos(String campo){
String[] args=column(campo).split("[,]");
return args;
       //return Arrays.toString(args);
}//fim metódo camposDivididos

 
 public String[] vars(Object ob){
//String n[]=null;
String nms[]=null;
pessoa p1=new pessoa(); 
produto prod=new produto();

System.out.println("obj"+QuemSouEu(ob));
     if(ob.getClass().getSimpleName().equals("pessoa")){
nms=p1.SetarDados();
     }else{
nms=prod.SetarDados();
     }
            return nms;
 }//fim metodo vars
 
  
 public String[] vars(pessoa ob,produto prod){
String nms[]=null;


String n[]={ob.nome,ob.endereco,ob.produto,ob.url,ob.wpp,prod.getDescricao(),Float.toString(prod.getValor())};
nms=n;
            return nms;
 }//fim metodo vars
 
 
 public void imp(pessoa p1){
 for(byte i=0;i<QuantColumn("pessoa");i++)
        System.out.println("pessoa:"+p1.SetarDados()[i]);
        System.out.println("generica:"+vars(p1)[0]);}
    
}//fim class generica