package sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.model.Anuncio;
import sistema.util.DBUtil;

public class AnuncioDAOImplementacao implements AnuncioDAO{

	private Connection conn;

	public AnuncioDAOImplementacao() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void adicionarAnuncio(Anuncio anuncio) {
		try {
			String query = "insert into anuncio (titulo, descricao, id_usuario) values (?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, anuncio.getTitulo() );
			preparedStatement.setString( 2, anuncio.getDescricao() );
			preparedStatement.setInt( 3, anuncio.getUsuario().getUsuarioId() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Anuncio> listarTodosAnuncios() {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from anuncio" );
			while( resultSet.next() ) {
				Anuncio anuncio = new Anuncio();
				anuncio.setAnuncioId (resultSet.getInt( "anuncioId" ) );
				anuncio.setTitulo( resultSet.getString( "titulo") );
				anuncio.setDescricao( resultSet.getString( "descricao") );
				anuncios.add(anuncio);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anuncios;
	}

	@Override
	public void alterarAnuncio(Anuncio anuncio) {
		try {
			String query = "update anuncio set titulo=?, descricao=? where anuncioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, anuncio.getTitulo());
			preparedStatement.setString( 2, anuncio.getDescricao());
			preparedStatement.setInt(3, anuncio.getAnuncioId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Anuncio buscarAnuncioPorId(int anuncioId) {
		Anuncio anuncio = new Anuncio();
		try {
			String query = "select * from anuncio where anuncioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, anuncioId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				anuncio.setAnuncioId( resultSet.getInt( "anuncioId" ) );
				anuncio.setTitulo( resultSet.getString( "titulo" ) );
				anuncio.setDescricao( resultSet.getString( "descricao" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anuncio;
	}

	@Override
	public void excluirAnuncio(int anuncioId) {
		try {
			String query = "delete from anuncio where anuncioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, anuncioId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public List<Anuncio>listarAnuncioPorUsuario (int usuarioId){
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from anuncio where id_usuario ='" + usuarioId+ " '" );
			while( resultSet.next() ) {
				Anuncio anuncio = new Anuncio();
				anuncio.setAnuncioId (resultSet.getInt( "anuncioId" ) );
				anuncio.setTitulo( resultSet.getString( "titulo") );
				anuncio.setDescricao( resultSet.getString( "descricao") );
				anuncios.add(anuncio);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anuncios;
		
	}

	@Override
	public List<Anuncio> listarAnuncioPorTitulo(String titulo) {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from anuncio where titulo ='" + titulo + " '" );
			while( resultSet.next() ) {
				Anuncio anuncio = new Anuncio();
				anuncio.setAnuncioId (resultSet.getInt( "anuncioId" ) );
				anuncio.setTitulo( resultSet.getString( "titulo") );
				anuncio.setDescricao( resultSet.getString( "descricao") );
				anuncios.add(anuncio);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anuncios;
	}
}
