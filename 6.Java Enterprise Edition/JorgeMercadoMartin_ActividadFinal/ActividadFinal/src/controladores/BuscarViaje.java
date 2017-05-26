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
import javax.servlet.http.HttpSession;

import dao.DAOAgenciaViajes;
import modelo.Viaje;

/**
 * Servlet implementation class BuscarViaje
 */
@WebServlet("/BuscarViaje")
public class BuscarViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarViaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=request.getServletContext();
		HttpSession sesion=request.getSession();
		
		String destino=(String)request.getParameter("destino");
		
		DAOAgenciaViajes daobuscar=new DAOAgenciaViajes();
		ArrayList<Viaje> lista=daobuscar.buscar(destino);
				
		request.setAttribute("listado",lista);
		
		if(lista.size()>0){
			RequestDispatcher dispatcher=contexto.getRequestDispatcher("/buscar.jsp");
			dispatcher.forward(request,response);

		}else{
			RequestDispatcher dispatcher=contexto.getRequestDispatcher("/errordatos.jsp");
			dispatcher.forward(request,response);
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
