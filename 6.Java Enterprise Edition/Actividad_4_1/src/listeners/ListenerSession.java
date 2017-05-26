package listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;


public class ListenerSession implements HttpSessionListener {

	Connection conexion = null;

	@Override
	public void sessionCreated(HttpSessionEvent evento) {
		try {
			System.out.println("=== CREACION SESION =====");
			DataSource dataSource;
			
			Context initContext  = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/Actividad_4_1_DB");
			conexion=dataSource.getConnection();
			System.out.println("=== CREACION SESION: " + conexion);
			evento.getSession().setAttribute("mensaje", "Éxito al cargar la conexin ");
			
			
		    
		} catch (NamingException exclass) {
			System.out.println("Error al cargar el recurso --" + exclass.getMessage());
			evento.getSession().setAttribute("mensaje", "Fallo cargar recurso ");
		} catch (SQLException exsql) {
			System.out.println("Error al abrir la conexión --" + exsql.getMessage());
			evento.getSession().setAttribute("mensaje", "Fallo en la conexión ");
		}
		evento.getSession().setAttribute("conexion", conexion);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evento) {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException exsql) {
				System.out.println("Error al cerrar la conexion --" + exsql.getMessage());
			}
		}
		evento.getSession().removeAttribute("conexion");
		evento.getSession().removeAttribute("mensaje");
	}

}
