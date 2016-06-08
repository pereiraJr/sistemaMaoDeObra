package sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.model.Usuario;
import sistema.util.DBUtil;

public class UsuarioDAOImplementacao implements UsuarioDAO{

	private Connection conn;

	public UsuarioDAOImplementacao() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void adicionarUsuario(Usuario usuario) {
		try {
			String query = "insert into usuario (nome, email, telefone, endereco, login, senha) values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, usuario.getNome() );
			preparedStatement.setString( 2, usuario.getEmail() );
			preparedStatement.setString( 3, usuario.getTelefone() );
			preparedStatement.setString( 4, usuario.getEndereco());
			preparedStatement.setString( 5, usuario.getLogin());
			preparedStatement.setString( 6, usuario.getSenha());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Usuario> listarTodosUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from usuario" );
			while( resultSet.next() ) {
				Usuario usuario = new Usuario();
				usuario.setUsuarioId (resultSet.getInt( "usuarioId" ) );
				usuario.setNome( resultSet.getString( "nome" ) );
				usuario.setEmail( resultSet.getString( "email" ) );
				usuario.setTelefone( resultSet.getString( "telefone" ) );
				usuario.setEndereco( resultSet.getString( "endereco" ) );
				usuario.setLogin( resultSet.getString( "login" ) );
				usuario.setSenha( resultSet.getString( "senha" ) );
				usuarios.add(usuario);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		try {
			String query = "update usuario set nome=?, email=?, telefone=?, endereco=?, login=?, senha=? where usuarioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, usuario.getNome());
			preparedStatement.setString( 2, usuario.getEmail());
			preparedStatement.setString( 3, usuario.getTelefone() );
			preparedStatement.setString( 4, usuario.getEndereco() );
			preparedStatement.setString(5, usuario.getLogin());
			preparedStatement.setString(6, usuario.getSenha());
			preparedStatement.setInt(7, usuario.getUsuarioId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario buscarUsuarioPorId(int usuarioId) {
		Usuario usuario = new Usuario();
		try {
			String query = "select * from usuario where usuarioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, usuarioId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				usuario.setUsuarioId( resultSet.getInt( "usuarioId" ) );
				usuario.setNome( resultSet.getString( "nome" ) );
				usuario.setEmail( resultSet.getString( "email" ) );
				usuario.setTelefone( resultSet.getString( "telefone" ) );
				usuario.setEndereco( resultSet.getString( "endereco" ) );
				usuario.setLogin( resultSet.getString( "login" ) );
				usuario.setSenha( resultSet.getString( "senha" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public void excluirUsuario(int usuarioId) {
		try {
			String query = "delete from usuario where usuarioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, usuarioId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Usuario buscarUsuarioPorLogin(String login) {
		Usuario usuario = new Usuario();
		try {
			String query = "select * from usuario where login=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				usuario.setUsuarioId( resultSet.getInt( "usuarioId" ) );
				usuario.setNome( resultSet.getString( "nome" ) );
				usuario.setEmail( resultSet.getString( "email" ) );
				usuario.setTelefone( resultSet.getString( "telefone" ) );
				usuario.setEndereco( resultSet.getString( "endereco" ) );
				usuario.setLogin( resultSet.getString( "login" ) );
				usuario.setSenha( resultSet.getString( "senha" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	
}
