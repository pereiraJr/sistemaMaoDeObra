package sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;

import sistema.model.Usuario;
import sistema.util.BancoUtil;

public class AutenticadorDAO {
	
	public boolean autenticar(Usuario user) {
		
		String query = "select u from Usuario as u where " + "u.login=:login and u.senha=:senha";
		
		Session session = BancoUtil.getFactory().openSession();
		session.beginTransaction();
		
		Usuario usuario = (Usuario) session
				.createQuery(query)
				.setString("login", user.getLogin())
				.setString("senha", user.getSenha()).uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		return usuario	 != null;
		
	}
}
