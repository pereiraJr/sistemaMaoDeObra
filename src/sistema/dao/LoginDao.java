package sistema.dao;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.util.DBUtil;
import sistema.model.Usuario;


public class LoginDao {
	
	private static  Connection conn;

	public LoginDao() {
		conn = DBUtil.getConnection();
	}
	
	 public static boolean checkUser(String login,String senha) 
     {
      boolean st =false;
      try{
    	  
	 //loading drivers for mysql
      Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/projeto","root","123456");
        PreparedStatement ps =(PreparedStatement) con.prepareStatement
                    ("select * from usuario where login=? and senha=?");
        ps.setString(1, login);
        ps.setString(2, senha);
        ResultSet rs =ps.executeQuery();
        rs =ps.executeQuery();
        
         if(rs.next() == true){
        	 st = true;
         }
         
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//
//	private Connection conn;
//	public LoginDao() {
//		conn = DBUtil.getConnection();
//	}
//
//	public String authenticateUser(Usuario usuario)
//	{
//
//		String userLogin = usuario.getLogin(); //Keeping user entered values in temporary variables.
//		String senha = usuario.getSenha();
//
//		Statement statement = null;
//		ResultSet resultSet = null;
//
//		String userNameDB = "";
//		String passwordDB = "";
//
//		try
//		{
//			//String query = "select * from usuario where login = '"+userLogin+"' and senha ='"+senha+"'";
//			String query = "select login, senha from usuario";
//			conn = DBUtil.getConnection(); //establishing connection
//			statement = conn.createStatement(); //Statement is used to write queries. Read more about it.
//			resultSet = statement.executeQuery(query); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
//
//			while(resultSet.next()) // Until next row is present otherwise it return false
//			{
//				userNameDB = resultSet.getString("login"); //fetch the values present in database
//				passwordDB = resultSet.getString("senha");
//
//				if(userLogin.equals(userNameDB) && senha.equals(passwordDB))
//				{
//					return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
//				}
//			}
//		}
//			catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
//			return "Invalid user credentials"; // Just returning appropriate message otherwise
//		}
	}