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
 * Servlet implementation class AddFavoritos
 */
@WebServlet("/AddFavoritos")
public class AddFavoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFavoritos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=request.getServletContext();
		HttpSession sesion=request.getSession();
		ArrayList<Viaje> favoritos=(ArrayList<Viaje>)sesion.getAttribute("favoritos");
		if(favoritos==null){
			favoritos=new ArrayList<Viaje>();
			sesion.setAttribute("favoritos",favoritos);
		}
		String stId=request.getParameter("id");
		int id=Integer.parseInt(stId);
		

		
		DAOAgenciaViajes daofavoritos=new DAOAgenciaViajes();
		Viaje viaje=daofavoritos.getViaje(id);
		
		boolean existe=false;
		for(Viaje v : favoritos){
			if(v.equals(viaje)){
				existe=true;
				break;
			}
		}
		if(!existe){
			favoritos.add(viaje);
		}
		
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/addFavorito.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
