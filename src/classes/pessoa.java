/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author home
 */
public class pessoa{
String nome;
String produto;
 String url;
 String wpp;
 String bairro;
 
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

//Inicio    
    
    public String[] SetarDados(){

        String nms[]={nome,url,bairro,wpp,produto};
    return nms;
    }
    
    
    
 public String QuemSouEu(){
    return this.getClass().getSimpleName();
    }
    
    
    conexao con = new conexao();
    PreparedStatement stmt;
    //connecting to database
    public void InserirDados(){
    try{	
	stmt = con.conectando().prepareStatement("insert into "+QuemSouEu()+" ("+column()+") values ("+interr()+")");
PreparedStatement ps=con.conectando().prepareStatement("select * from "+QuemSouEu()+"");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();

        
       for(byte i=1;i<=QuantColumn();i++)
            if(rsmd.getColumnTypeName(i).equalsIgnoreCase("float"))
            stmt.setFloat(i,Float.parseFloat(vars()[i-1]));
        else
            stmt.setString(i,vars()[i-1]);
        stmt.execute();
        stmt.close();
	System.out.println(QuemSouEu()+":Gravado!");
	con.conectando().close();   
    }

catch (SQLException e) {
}
    }//fim metódo InserirDados


    
    
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
    

 public String interr(){
 String interr="?";
 
 for(byte j=1;j<=QuantColumn();j++)
        if(j==QuantColumn())
    interr+="";
            else
    interr+=",?";
 return interr;
 }//fim metodo interr   
    

 public String[] vars(){
//String x="\"nome\"".replace("\""," ");
String n[]={nome,produto,url,wpp,bairro};
     String nms[]=n;

            return nms;
 }//fim metodo vars
 
  public void VarsComBidimession(){
//pessoa p1 = new pessoa();
//produto prod = new produto();
String n[][]={camposDivididos(),vars()};
     byte t1=(byte)n.length;
     byte t2=0;
     String nms[][]=n;
//  if(QuemSouEu().equalsIgnoreCase("pessoa")){             
for(byte i=0;i<QuantColumn();i++){
 //System.out.println("nome do campo:"+n[t2][i]+"----->,valor do campo:"+n[t2+1][i]);
  if(n[t2+1][i]==null)
     switch(n[t2][i]){
         case "nome":
             nome="";
         //   break;
         case "produto":
             produto="";
            break;
         case "wpp":
             wpp="";
         //   break;
         case "url":
                url="";
         //   break;
         case "bairro":
             bairro="";
         //   break; 
     }
  
  }
 // System.out.println("tamanho:"+t1);
 System.out.println("Objeto:"+QuemSouEu());
   for(byte i=0;i<QuantColumn();i++){
 System.out.println("nome do campo:"+n[t2][i]+"----->,valor do campo:"+n[t2+1][i]);
 System.out.println("nome do campo:"+n[t2][i]+"----->,valor do campo:"+vars()[i]);
  }
  //}
  //else{
 // }
  }//fim metodo VarsComBidimession

  
  
  
   //testes
 
 public String[] camposDivididos(){
String[] args=column().split("[,]");
return args;
 
       //return Arrays.toString(args);
}//fim metódo camposDivididos


  
  
  /*
 public Field[] vars2(){
//String x="\"nome\"".replace("\""," ");
Field[] fields = pessoa.class.getDeclaredFields();
     Field nms[]=fields;

            return nms;
 }//fim metodo vars2
 */
/*
public void imp(){
Field[] fields = pessoa.class.getDeclaredFields();
    System.out.println(fields.length);         
//for (Field field : fields)
    for(byte i=0;i<QuantColumn();i++){
    System.out.println(fields[i].getGenericType().getTypeName()+","+camposDivididos()[i]);
    //System.out.println(fields[i].get(i)+","+camposDivididos()[i]);
    System.out.println(fields[i].getGenericType().getTypeName().equalsIgnoreCase(vars()[i])?"igual":"dff");
}
}
 */

public void imp(){
    String x[][] = {{"nome","produto"},{nome,produto}};
    Field[] fields = pessoa.class.getDeclaredFields();

  //  for(byte i=0;i<QuantColumn();i++)
//    System.out.println("nome do campo"+x[i][i]);
   System.out.println("nome do campo"+x[1-1][1]+"valor do campo"+x[1][1]);
    
}


}//fim classe pessoa




