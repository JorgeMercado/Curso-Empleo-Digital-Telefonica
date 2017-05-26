package controladores;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOUsuario;
import db.DB;
import modelos.Usuario;

/**
 * Dirige la interacción con el usuario de la aplicación
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServletContext context=config.getServletContext();
		System.out.println("Contexto de Index "+context);
		Integer i=new Integer(0);
		System.out.println("Init: "+i.hashCode());
		context.setAttribute("numeroUsuarios",i);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession sesion=request.getSession();
		Usuario u=(Usuario)sesion.getAttribute("usuario");
		String vista="";
		if(u!=null){
			vista="dentro.jsp";
		}
		else{
			String nombre=request.getParameter("nombre");
			String password=request.getParameter("password");
			if(nombre!=null && password!=null){
				DAOUsuario dao=new DAOUsuario();
				if(DB.estaOK()){
					u=dao.leer(nombre, password);
					if(u!=null){
						sesion.setAttribute("usuario", u);
						vista="loginHecho.jsp";
					}
					else{
						vista="loginIncorrecto.jsp";
					}
				}
				else{
					vista="error.jsp";
				}
			}
			else{
				vista="formularioLogin.jsp";
			}
		}
		request.setAttribute("numeroLogados", Usuario.getNumeroLogados());
		request.setAttribute("numeroUsuarios", getNumeroUsuarios(request));
		
		request.getRequestDispatcher("/"+vista).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * Devuelve el numero de Usuarios que estan usando la aplicacion aunque no hayan hecho login
	 * @param request 
	 * @return Numero de usuarios usando la aplicación.
	 */
	private int getNumeroUsuarios(HttpServletRequest request){
		int nu=0;
		ServletContext context=request.getServletContext();
		synchronized(context){
			nu=(Integer)context.getAttribute("numeroUsuarios");
		}
		return nu;
	}

}
