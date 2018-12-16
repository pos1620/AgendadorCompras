package classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class conexao {
    private String user="root";
    private String pass="";
    private Connection con=null;
    private String urldb="127.0.0.1/AgendamentoCompras";
    public static String nome="luk";

    public Connection conectando(){
 //Connection con2=null;
         try{
        //Class.forName("com.mysql.jdbc.Driver");
System.setProperty("jdbc.Drivers","com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(urldb,pass,user);
    }
    
    catch(SQLException e){
    }    
    return con;
        
    }//fim metódo conectando
}//fim classe
