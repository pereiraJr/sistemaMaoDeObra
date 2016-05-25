package sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;

import sistema.model.Usuario;
import sistema.util.BancoUtil;

public class UsuarioDAO {
	
	public boolean autenticar(Usuario user) {
		
		String query = "select u from Usuario as u where " 
				+ "u.login=:login and u.senha=:senha";
		
		Session session = BancoUtil.getFactory().openSession();
		session.beginTransaction();
		
		Usuario usuario = (Usuario) session
				.createQuery(query)
				.setString("login", user.getLogin())
				.setString("senha", user.getSenha()).uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		return usuario	 != null;
		
		/*boolean autenticado = false;
		Connection con = BancoUtil.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from usuarios where login=? and senha=? ;");
			stmt.setString(1, user.getLogin().trim());
			stmt.setString(2, user.getSenha().trim());
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				autenticado = true;
			}
			resultSet.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autenticado; */ 
	}

}
