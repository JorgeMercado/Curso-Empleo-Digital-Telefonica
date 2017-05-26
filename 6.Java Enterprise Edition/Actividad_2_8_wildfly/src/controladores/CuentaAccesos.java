package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.DAOPeticion;
import dao.DAOSesion;
import dao.DAOUsuario;
import dao.ResultadoCRUD;
import modelos.Peticion;
import modelos.Sesion;
import modelos.Usuario;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.naming.Context;

/**
 * Servlet implementation class CuentaAccesos
 */
@WebServlet(description = "Cuenta los accesos", urlPatterns = { "/CuentaAccesos" })
public class CuentaAccesos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
	private String strServer;

	@Singleton //Instancia un objeto de la clase DAO. (INYECCION DE DEPENDENCIAS)
	private DAOPeticion daop;
	
	@Singleton
	private DAOUsuario daou;
	
	@Singleton
	private DAOSesion daos;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CuentaAccesos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		strServer = "Servidor: " + context.getServerInfo() + " Servlet: " + config.getServletName();
		context.setAttribute("servidor", strServer);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		Peticion p = new Peticion();
		//DAOPeticion daop = new DAOPeticion();
		daop.update(p);
		request.setAttribute("totalPeticiones", p.getN());

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String vista = "error.jsp";
		HttpSession sesion = request.getSession();
		if (sesion.getAttribute("usuario") != null) {
			Usuario u=(Usuario)sesion.getAttribute("usuario");
			incrementarSesion(sesion,request);
			vista="muestraCuenta.jsp";
		} else {
			if (usuario != null && password != null) {
				usuario = usuario.trim();
				Usuario u = new Usuario(usuario);
				//DAOUsuario daou = new DAOUsuario();
				ResultadoCRUD r = daou.comprobar(u, password);

				switch (r) {
				case OK:
					sesion.setAttribute("usuario", u);
					incrementarSesion(sesion,request);
					vista="muestraCuenta.jsp";
					break;

				case NO_EXISTE:
					vista = "usuarioNoExiste.jsp";
					request.setAttribute("totalPeticiones", p.getN());
					break;
				}
			}
			else{
				vista = "usuarioNoExiste.jsp";
				request.setAttribute("totalPeticiones", p.getN());
				
			}
		}

		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/" + vista);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	public void incrementarSesion(HttpSession sesion,HttpServletRequest request){
		Sesion s=new Sesion(sesion.getId());
		//DAOSesion dao = new DAOSesion();
		ResultadoCRUD r = daos.update(s);
		switch (r) {
		case OK:
			request.setAttribute("id", s.getId());
			request.setAttribute("nSesion", s.getN());
			
			break;

		}
		
	}

}
