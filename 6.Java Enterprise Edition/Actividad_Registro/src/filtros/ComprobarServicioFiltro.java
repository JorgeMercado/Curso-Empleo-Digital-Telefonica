package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import db.DB;

/**
 * Filtro que comprueba que la conexion a la BD está en pie.
 */
@WebFilter("/*")
public class ComprobarServicioFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public ComprobarServicioFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(DB.estaOK()){
			chain.doFilter(request, response);
		}
		else{
			ServletContext contexto=request.getServletContext();
			RequestDispatcher dispatcher=contexto.getRequestDispatcher("/fueradeservicio.jsp");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
