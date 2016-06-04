package sistema.dao;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import sistema.util.DBUtil;
import sistema.model.Usuario;


public class LoginDao {
	

	private Connection conn;
	public LoginDao() {
		conn = DBUtil.getConnection();
	}

	public String authenticateUser(Usuario usuario)
	{

		String userLogin = usuario.getLogin(); //Keeping user entered values in temporary variables.
		String senha = usuario.getSenha();

		Statement statement = null;
		ResultSet resultSet = null;

		String userNameDB = "";
		String passwordDB = "";

		try
		{
			String query = "select * from usuario where login=? and senha=?";
			conn = DBUtil.getConnection(); //establishing connection
			statement = conn.createStatement(); //Statement is used to write queries. Read more about it.
			resultSet = statement.executeQuery(query); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.

			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				userNameDB = resultSet.getString("login"); //fetch the values present in database
				passwordDB = resultSet.getString("senha");

				if(userLogin.equals(userNameDB) && senha.equals(passwordDB))
				{
					return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
				}
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return "Invalid user credentials"; // Just returning appropriate message otherwise
		}
	}