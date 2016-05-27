package sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BancoUtil {

	private static Connection conn;
	private static SessionFactory sessionFactory;

	static {

		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures
				.build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	
	}
	
	public static Connection getConnection() {    
		return conn;
	}
	
	public static void closeConnection( Connection toBeClosed ) {
        if( toBeClosed == null )
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static SessionFactory getFactory() {
		return sessionFactory;
	}
}