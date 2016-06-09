package sistema.dao;

import java.sql.ResultSet;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import sistema.util.DBUtil;
import sistema.model.Usuario;

public class LoginDao {

	public static Usuario checkUser(String login, String senha) {
		ResultSet rs = null;
		boolean st = false;
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");
		Usuario usuario = null;

		Properties properties = new Properties();
		try {

			properties.load(inputStream);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");

			// loading drivers for mysql
			Class.forName(driver);

			// creating connection with the database
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from usuario where login=? and senha=?");
			ps.setString(1, login);
			ps.setString(2, senha);
			
//			ps.setString( 1, usuario.getNome() );
//			ps.setString( 2, usuario.getEmail() );
//			ps.setString( 3, usuario.getTelefone() );
//			ps.setString( 4, usuario.getEndereco());
//			ps.gString( 5, usuario.getLogin());
//			ps.getString(6, usuario.getSenha());
			rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setUsuarioId(rs.getInt("usuarioId"));
				usuario.setNome(rs.getString("nome"));
//				rs.setString( 1, usuario.getNome() );
//				rs.setString( 2, usuario.getEmail() );
//				rs.setString( 3, usuario.getTelefone() );
//				rs.setString( 4, usuario.getEndereco());
//				rs.getString( 5, usuario.getLogin());
//				st = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

}