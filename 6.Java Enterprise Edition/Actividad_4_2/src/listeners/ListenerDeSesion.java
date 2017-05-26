package listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * Listener que reacciona a la creacion de sesion y a su destrucción y mantiene la cuenta de
 * usuarios de la aplicacion. la cuenta se almacena en el contexto del servlet.
 * 
 * @author Jose
 *
 */
public class ListenerDeSesion implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext context=se.getSession().getServletContext();
		System.out.println("Contexto en listener "+context);
		
		synchronized(context){
			Integer numeroUsuarios=(Integer)context.getAttribute("numeroUsuarios");
			System.out.println("Listener de sesion "+numeroUsuarios);
			System.out.println(numeroUsuarios);
			numeroUsuarios++;
			System.out.println(numeroUsuarios);
			context.setAttribute("numeroUsuarios", numeroUsuarios);
		}
		
		se.getSession().setMaxInactiveInterval(10);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context=se.getSession().getServletContext();
		
		synchronized(context){
			Integer numeroUsuarios=(Integer)context.getAttribute("numeroUsuarios");
			numeroUsuarios--;
			context.setAttribute("numeroUsuarios", numeroUsuarios);
		}
	}

	
	
}
