package br.ucsal.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BancoUtil {

	private static SessionFactory sessionFactory;

	static {

		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures
				.build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	
	}



	public static SessionFactory getFactory() {
		return sessionFactory;
	}

	// private static Connection connection;
	//
	//
	// static {
	// try {
	// Class.forName("org.hsqldb.jdbc.JDBCDriver");
	// //connection =
	// DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/banco", "SA",
	// "");
	// connection = DriverManager.getConnection("jdbc:hsqldb:mem:.", "SA", "");
	//
	// Statement stmt = connection.createStatement();
	// stmt.execute("CREATE TABLE USUARIOS ( USUARIO_ID INTEGER IDENTITY, LOGIN
	// varchar(100) NOT NULL , SENHA varchar(100) NOT NULL ) ;");
	// stmt.execute("INSERT INTO USUARIOS ( \"LOGIN\", \"SENHA\" ) VALUES
	// ('user', '1234');");
	// ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS;");
	// while (rs.next()) {
	// System.out.println(rs.getString(1));
	// System.out.println(rs.getString(2));
	// System.out.println(rs.getString(3));
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//

}