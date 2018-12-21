/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

//import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author home
 */
public class pessoa extends Generica{
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
    
    
 
    conexao con = new conexao();
    PreparedStatement stmt;
    //connecting to database
    public void InserirDados(){
    try{	
	stmt = con.conectando().prepareStatement("insert into "+QuemSouEu()+" ("+column()+") values ("+interr()+")");
PreparedStatement ps=con.conectando().prepareStatement("select * from "+QuemSouEu()+"");
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();

        
       for(byte i=0;i<QuantColumn();i++)//{
      for(byte j=0;j<QuantColumn();j++)//{
       if(camposDivididos()[i].equalsIgnoreCase(VarsComBidi()[0][j]))
            if(rsmd.getColumnTypeName(i+1).equalsIgnoreCase("float"))
            stmt.setFloat(i+1,Float.parseFloat(VarsComBidi()[1][j]));
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



 public String[] vars(){
String n[]={nome,produto,url,wpp,bairro};
     String nms[]=n;

            return nms;
 }//fim metodo vars

 /*
teste de valor null,se houver valor null pela posião de cada variavel sete os valores de acordo
 */
  public void VarsComBidimession(){
String n[][]={camposDivididos(),vars()};
     byte t1=(byte)n.length;
     byte t2=0;
     String nms[][]=n;
for(byte i=0;i<QuantColumn();i++)
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
  
  }//fim metodo VarsComBidimession

  
  /*
  coloca os campos e os respectivos valores
  e retorna o valor pela posião indicada
  ex. n[campo]["valor"]
  */
  public String[][] VarsComBidi(){
String n[][]={camposDivididos(),vars()};
     byte t1=(byte)n.length;
     byte t2=0;
     String nms[][]=n;
  return n;
}//fim da classe VarsComBidimen()
/*

/*
  retorna quantidade de attrb na classe
  */
public byte Matriz(){
String n[][]={camposDivididos(),vars()};
byte contador =(byte)vars().length;
return contador;
        }//fim classe matriz
 
/*
retorna variaveis da classe
*/
 public String variaveisDaClasse(){
String var="nome,produto,wpp,url,bairro";
return var;
}


/*
verifica se houve add de campo no banco o resultará na add de novos attrb na classe
*/
 public void VerificarBanco(){
 if(QuantColumn()!=Matriz())
 JOptionPane.showMessageDialog(null,"Mudamos Banco de dados variavéis!");
//for(byte i=0;i<QuantColumn();i++){
//for(byte j=0;j<Matriz();j++){
//    System.out.println("banco:"+camposDivididos()[i]+"variavéis"+camposDivididos2(variaveisDaClasse())[j]);
//}}
 }//fim classe VerificarBanco  
  

}//fim classe pessoa




