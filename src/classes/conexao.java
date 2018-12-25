package classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class conexao {
    private String user="root";
    private String pass="12345678";
    private Connection con=null;
    private String urldb="jdbc:mysql://localhost/agendamentocompras";

    public Connection conectando(){
         try{
//        Class.forName("com.mysql.jdbc.Driver");
System.setProperty("jdbc.Drivers","com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(urldb, user, pass);
         
         }
    
    catch(SQLException e){
    }    
    return con;
        
    }//fim metódo conectando


public void CriarTables(){
    Connection con2=conectando();
    try{
        
    PreparedStatement cs = conectando().prepareStatement("create table nm(nome varchar(99),produto varchar(99),url varchar(99),wpp varchar(99),bairro varchar(99))");
    PreparedStatement cs2 = conectando().prepareStatement("create table nm(nome varchar(99),produto varchar(99),url varchar(99),wpp varchar(99),bairro varchar(99))");
    cs.execute();
  }
catch(SQLException e){}
}//fim classe CriarTable

public void CriarDb(String db){
    Connection con2=conectando();
    try{
        
    PreparedStatement cs = conectando().prepareStatement("create database "+db+"");
    cs.execute();
  }
catch(SQLException e){}
}//fim classe CriarDb

public void DropDb(String db){
    Connection con2=conectando();
    try{
        
    PreparedStatement cs = conectando().prepareStatement("drop database "+db+"");
    cs.execute();
  }
catch(SQLException e){}
}//fim classe DropDb



public void DropTables(){
    Connection con2=conectando();
    try{
  PreparedStatement cs = conectando().prepareStatement("drop table nm");
    cs.execute();
  }
catch(SQLException e){}
}//fim DropTables

}//fim classe


