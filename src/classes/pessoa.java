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
	stmt = con.conectando().prepareStatement("insert into pessoa (nome,produto,url,wpp,bairro) values (?,?,?,?,?)");
        /*
byte inicio=1;
interr c = '?';
char virg = ',';
        
for(byte i=1;i<=QuantColumn();i++){
PreparedStatement stmt = con.prepareStatement("insert into pessoa (nome,produto,url,wpp,bairro) values ()");
        }
        */
        stmt.setString(1,getNome());
        stmt.setString(2,getProduto());
        stmt.setString(3,getWpp());
        stmt.setString(4,getUrl());
        stmt.setString(5,getEndereco());
        stmt.execute();
        stmt.close();
	System.out.println("Gravado!");
	con.conectando().close();
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
    
    
    
    
    public String[] column(){
        String[] nms=null;
            try{
PreparedStatement ps=con.conectando().prepareStatement("select * from pessoa");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();
//System.out.println("columns: "+rsmd.getColumnCount());  
for(byte i=0;i<QuantColumn();i++){
    System.out.println("Column Name of 1st column: "+rsmd.getColumnName(i+1));  
 //   System.out.println(i);  
    nms[i]=rsmd.getColumnName(i+1);
}
//System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(2)); 
            }
    catch(SQLException e){
    }
return nms;

}//fim classe columns[]
    
    
}//fim classe pessoa




