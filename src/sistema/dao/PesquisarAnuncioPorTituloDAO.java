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
import sistema.model.Anuncio;
import sistema.model.Usuario;

public class PesquisarAnuncioPorTituloDAO {

	public static List<Anuncio> anuncioPorTitulo(String titulo) {
		ResultSet rs = null;
		boolean st = false;
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");
		Usuario usuario = null;
		

		Properties properties = new Properties();
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
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
					.prepareStatement("select * from anuncio where titulo=?");
			ps.setString(1, titulo);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Anuncio anuncio = new Anuncio();
				anuncio.setTitulo( rs.getString( "titulo") );
				anuncio.setDescricao( rs.getString( "descricao") );
				anuncios.add(anuncio);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return anuncios;
	}

}