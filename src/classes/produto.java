/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

//import com.mysql.jdbc.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author home
 */
public class produto extends Generica{
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
            //    if(camposDivididos()[j].equalsIgnoreCase(VarsComBidimen()[j].toString()))
            stmt.setString(i+1,VarsComBidi()[1][j]);
        stmt.execute();
        stmt.close();
	System.out.println(QuemSouEu()+":Gravado!");
	con.conectando().close();   
   // }
    //    }
    }
    catch (SQLException e) {
}
    }//fim metódo InserirDados


 
 public String[] camposDivididos(){
String[] args=column().split("[,]");
Arrays.sort(args);
return args;
       //return Arrays.toString(args);
}//fim metódo camposDivididos

  
 /*
 retorna os valores dos gets e seters
 */
 public String[] vars(){
String n[]={descricao,Float.toString(valor)};
 return n;
 }//fim metodo vars 

 
  /*
teste de valor null,se houver valor null pela posião de cada variavel sete os valores de acordo
 */ 
  public void VarsComBidimession(){
String n[][]={camposDivididos(),vars()};
     byte t1=(byte)n.length;
     byte t2=0;
     String nms[][]=n;
for(byte i=0;i<QuantColumn();i++){
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
  retorna quantidade de valores/vetores na classe
  */
public byte Matriz(){
    //Field[] fields = pessoa.class.getDeclaredFields();
    //fields.length;
String n[][]={camposDivididos(),vars()};
byte contador =(byte)vars().length;
return contador;
        }//fim classe matriz
 

/*
retorna variaveis da classe
*/
public String variaveisDaClasse(){
String var="descricao,valor";
return var;
}//fim da classe variaveisDaClasse




 public void VerificarBanco(){
 if(QuantColumn()!=Matriz())
 JOptionPane.showMessageDialog(null,"Mudamos Banco de dados variavéis!");
//for(byte i=0;i<QuantColumn();i++){
//for(byte j=0;j<Matriz();j++){
   // System.out.println("banco:"+camposDivididos()[i]+"variavéis"+camposDivididos2(variaveisDaClasse())[j]);
//}
//}
 }//fim classe VerificarBanco 

 
}//fim classe produto

