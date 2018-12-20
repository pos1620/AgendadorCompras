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
public class produto{
    public String descricao;
    public float valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
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
    
  /*
    retorna nome do objeto,classe
    */  
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


    
    /*
    retorna quantidade de campo no banco
    */
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

 
  
  public void VarsComBidimession(){
//pessoa p1 = new pessoa();
//produto prod = new produto();
String n[][]={camposDivididos(),vars()};
     byte t1=(byte)n.length;
     byte t2=0;
     String nms[][]=n;
//  if(QuemSouEu().equalsIgnoreCase("pessoa")){             
for(byte i=0;i<QuantColumn();i++){
// System.out.println("nome do campo:"+n[t2][i]+"----->,valor do campo:"+n[t2+1][i]);
  if(n[t2+1][i]==null||n[t2+1][i].equals(0))
     switch(n[t2][i]){
         case "descricao":
             descricao="";
         //    break;
         case "valor":
             valor=0;
     //break;
     }
  
  }
 /* System.out.println("tamanho:"+t1);  //desnecessário 
 System.out.println("Objeto:"+QuemSouEu());
   for(byte i=0;i<QuantColumn();i++){
 System.out.println("nome do campo:"+n[t2][i]+"----->,valor do campo:"+n[t2+1][i]);
 System.out.println("nome do campo:"+n[t2][i]+"----->,valor do campo:"+vars()[i]);
  }
  }
  else{
  }*/
  }//fim metodo VarsComBidimession
  /*  
    public void imp(){
        try{
PreparedStatement ps=con.conectando().prepareStatement("select * from "+QuemSouEu()+"");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(2));
for(byte i=1;i<=QuantColumn();i++)
        if(rsmd.getColumnTypeName(i).equalsIgnoreCase("float"))
        System.out.println("vc converteu para float"+vars()[i-1]);
        else
        System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(2));

            }
    catch(SQLException e){
    }
    }
    */
 
 /*
    
public void ConverterTipo(String tipo){
String tipo2=tipo;
    if(tipo2.equals("float"))
valor=Float.parseFloat(vars()[1]);


}
*/

 
}//fim classe produto

