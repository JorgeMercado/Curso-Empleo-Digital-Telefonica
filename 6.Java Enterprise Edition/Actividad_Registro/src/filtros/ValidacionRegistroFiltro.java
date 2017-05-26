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

/**
 * Filtro para validacion de datos de registroo
 */
@WebFilter("/registro.jsp")
public class ValidacionRegistroFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public ValidacionRegistroFiltro() {
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
		ServletContext contexto=request.getServletContext();
		String nombre=request.getParameter("nombre");
		String password=request.getParameter("password");
		String stEdad=request.getParameter("edad");
		
		if(nombre==null || password==null || stEdad==null){
			RequestDispatcher dispatcher=contexto.getRequestDispatcher("/faltandatos.jsp");
			dispatcher.forward(request, response);
		}
		else{
			nombre=nombre.trim();
			stEdad=stEdad.trim();
			if(nombre.equals("")){
				RequestDispatcher dispatcher=contexto.getRequestDispatcher("/faltandatos.jsp");
				dispatcher.forward(request, response);
			}
			else{
				int edad=0;
				boolean error=false;
				try{
					edad=Integer.parseInt(stEdad);
				}
				catch(NumberFormatException nfe){
					RequestDispatcher dispatcher=contexto.getRequestDispatcher("/edadincorrecta.jsp");
					dispatcher.forward(request, response);
					error=true;
				}
				if(!error){
					if(edad==0){
						RequestDispatcher dispatcher=contexto.getRequestDispatcher("/edadincorrecta.jsp");
						dispatcher.forward(request, response);
					}
					else{
						request.setAttribute("edad",edad);
						chain.doFilter(request, response);
					}
				}
			}
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
