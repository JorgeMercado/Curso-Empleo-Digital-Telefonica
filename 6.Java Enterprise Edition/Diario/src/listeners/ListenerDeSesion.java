package listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerDeSesion
 *
 */
@WebListener
public class ListenerDeSesion implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ListenerDeSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession sesion=se.getSession();
        ServletContext contexto=sesion.getServletContext();
        synchronized(contexto){
        	Integer n=(Integer)contexto.getAttribute("numeroUsuarios");
        	n++;
        	contexto.setAttribute("numeroUsuarios", n);
        }

    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession sesion=se.getSession();
        ServletContext contexto=sesion.getServletContext();
       
        synchronized(contexto){
        	Integer n=(Integer)contexto.getAttribute("numeroUsuarios");
        	n--;
        	contexto.setAttribute("numeroUsuarios", n);
        }
    }
	
}
