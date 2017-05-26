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
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter("/HacerLogin")
public class FiltroLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLogin() {
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
		
		if(nombre!=null && password !=null){
			nombre=nombre.trim();
			if(!nombre.equals("") && !password.equals("")){
				request.setAttribute("nombre",nombre);
				chain.doFilter(request, response);
			}
			else{
				RequestDispatcher dispatcher=contexto.getRequestDispatcher("/datoserroneos.jsp");
				dispatcher.forward(request,response);
			}
		}
		else{
			
			RequestDispatcher dispatcher=contexto.getRequestDispatcher("/datoserroneos.jsp");
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
