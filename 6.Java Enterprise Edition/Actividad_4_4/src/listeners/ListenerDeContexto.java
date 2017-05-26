package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * El listener inicializa la propiedad de contexto accesosPaginas
 *
 */
public class ListenerDeContexto  implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerDeContexto() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        
    }

	/**
	 * Inicializa la propiedad de contexto accesosPaginas
	 * 
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext context=sce.getServletContext();
         context.setAttribute("accesosPaginas",new Integer(0));
    }
	
}
