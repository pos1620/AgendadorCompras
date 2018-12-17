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
public class pessoa {
private String nome;
private String produto;
private String url;
private String wpp;
private String endereco;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWpp() {
        return wpp;
    }

    public void setWpp(String wpp) {
        this.wpp = wpp;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    conexao con = new conexao();
    PreparedStatement stmt;
    //connecting to database
    public void InserirDados(){
    try{	
	stmt = con.conectando().prepareStatement("insert into pessoa ("+column()+") values ("+interr()+")");
        
  
        for(byte i=1;i<=QuantColumn();i++)
        stmt.setString(i,""+camposDivididos()[i-1]+"");
        stmt.execute();
        stmt.close();
	System.out.println("Gravado!");
	con.conectando().close();
/*        
 String x=""+nome+"";
        stmt.setString(1,x);
        stmt.setString(2,produto);
        stmt.setString(3,getWpp());
        stmt.setString(4,getUrl());
        stmt.setString(5,getEndereco());
        stmt.execute();
        stmt.close();
	System.out.println("Gravado!");
	con.conectando().close();
*/
    } 
catch (SQLException e) {
}
    }//fim metodo InserirDados


    
    
    public byte QuantColumn(){
    byte i=0;
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from pessoa");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();
//System.out.println("columns: "+rsmd.getColumnCount());  
//System.out.println("Column Name of 1st column: "+rsmd.getColumnName(2));  
//System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(2)); 
i=(byte) rsmd.getColumnCount();
            }
    catch(SQLException e){
    }
        return i;
    }//fim classe QuantColumn
    
    
    
    
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
}//fim classe columns[]
    

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
}//fim metodo camposDivididos

    
}//fim classe pessoa




