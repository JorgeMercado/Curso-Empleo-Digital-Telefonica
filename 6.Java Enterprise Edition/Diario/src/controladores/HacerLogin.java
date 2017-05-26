package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOUsuario;
import modelos.Usuario;

/**
 * Servlet implementation class HacerLogin
 */
@WebServlet("/HacerLogin")
public class HacerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HacerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String nombreUsuario=(String)request.getAttribute("nombre");
		String password=request.getParameter("password");
		
		Usuario u=new Usuario(nombreUsuario);
		DAOUsuario daou=new DAOUsuario();
		
		if(daou.autenticar(u, password)){
			HttpSession sesion=request.getSession();
			sesion.setAttribute("usuario",u);
			response.sendRedirect("Principal");
		}
		else{
			response.sendRedirect("loginfallido.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
