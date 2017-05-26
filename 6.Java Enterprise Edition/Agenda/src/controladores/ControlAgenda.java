package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPersona;
import modelo.Persona;

/**
 * Servlet implementation class ControlAgenda
 */
@WebServlet(description = "Agenda de teléfono", 
urlPatterns = {"/ControlAgenda"})
public class ControlAgenda extends HttpServlet {
	
	private static final String CONTENT_TYPE = "text/html";
	private static final long serialVersionUID = 1L;
	private String strServer;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlAgenda() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException{
    	ServletContext context = config.getServletContext();
    	strServer = "Servidor: " + context.getServerInfo() 
    	+ "Servlet: " + config.getServletName();
    	context.setAttribute("servidor", strServer);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = request.getServletContext();
		String nombre = request.getParameter("nombre");
		String number = request.getParameter("number");
		
		ArrayList<Persona> arrayp = new ArrayList<Persona>();
		DAOPersona daop = new DAOPersona();
		if(nombre != null && number != null){
			nombre = nombre.trim();
			number = number.trim();
			if(!nombre.equals("") && (!number.equals(""))){
				
				Persona p = new Persona(nombre, number);
				try {
					daop.Create(p);
					
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}	
			}
		}
		arrayp = daop.getPersonas();
		request.setAttribute("listado", arrayp);
		RequestDispatcher disp = context.getRequestDispatcher("/index.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
