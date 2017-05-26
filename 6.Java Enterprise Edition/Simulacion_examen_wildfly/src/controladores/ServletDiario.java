package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daodiario.DAODiario;
import modelo.Diario;

/**
 * Servlet implementation class ServletDiario
 */
@WebServlet("/ServletDiario")
public class ServletDiario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDiario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vista = "";
		ServletContext contexto=request.getServletContext();

		
		String nombreUsuario = request.getParameter("nombreUsuario");
		request.setAttribute("nombreUsuario",nombreUsuario);
		DAODiario daod = new DAODiario();
		ArrayList<Diario> entradas = daod.listar(nombreUsuario);
		request.setAttribute("entradas", entradas);
		vista = "/mostrarDiario.jsp";
		
		RequestDispatcher dispatcher=contexto.getRequestDispatcher(vista);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
