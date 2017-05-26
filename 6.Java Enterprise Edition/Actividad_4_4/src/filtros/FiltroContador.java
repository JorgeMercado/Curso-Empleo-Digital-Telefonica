package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filtro que cuenta los accesos a todas las paginas
 */
public class FiltroContador implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroContador() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * Actualiza la propiedad de contexto accesosPaginas y carga su valor
	 *  en la propiedad de request nAccesosPaginas
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext context=request.getServletContext();
		int nAccesosPaginas=0;
		synchronized(context){
			Integer accesosPaginas=(Integer)context.getAttribute("accesosPaginas");
			accesosPaginas++;
			context.setAttribute("accesosPaginas",accesosPaginas);
			nAccesosPaginas=accesosPaginas;
		}
		request.setAttribute("nAccesosPaginas",nAccesosPaginas);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
