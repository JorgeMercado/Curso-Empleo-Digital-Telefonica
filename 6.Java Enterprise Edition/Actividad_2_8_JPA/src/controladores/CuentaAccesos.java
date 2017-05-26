package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

import model.Peticione;
import model.Sesione;
import model.Usuario;

import javax.naming.Context;

/**
 * Servlet implementation class CuentaAccesos
 */
@WebServlet(description = "Cuenta los accesos", urlPatterns = { "/CuentaAccesos" })
public class CuentaAccesos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
	private String strServer;

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
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPA");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
			Query q=em.createNativeQuery("insert into peticiones (id,n) values (1,1)"
					+ " on duplicate key update n=n+1");
			q.executeUpdate();
			
			Peticione p = em.find(Peticione.class,new Integer(1));
			request.setAttribute("totalPeticiones", p.getN());
		et.commit();
		
		

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
				et=em.getTransaction();
				et.begin();
			    	Usuario u=em.find(Usuario.class, usuario);
			    et.commit();
			    if(u!=null){
				    if(u.getPassword().equals(password)){
				    	sesion.setAttribute("usuario", u);
						incrementarSesion(sesion,request);
						vista="muestraCuenta.jsp";
				    }
			    }
			    else{
			    	vista = "usuarioNoExiste.jsp";
					request.setAttribute("totalPeticiones", p.getN());
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
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPA");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			Sesione s=em.find(Sesione.class,sesion.getId());
			if(s!=null){
				s.setN(s.getN()+1);
				em.persist(s);
				request.setAttribute("id", s.getId());
				request.setAttribute("nSesion", s.getN());
			}
			else{
				Sesione t=new Sesione();
				t.setId(sesion.getId());
				t.setN(0);
				em.persist(t);
				request.setAttribute("id", t.getId());
				request.setAttribute("nSesion", t.getN());
			}
			
		et.commit();
		
		
	}

}
