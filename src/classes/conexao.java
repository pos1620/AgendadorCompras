package classes;
import java.sql.Connection;
import java.sql.DriverManager;
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
}//fim classe
