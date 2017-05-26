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

import dao.DAOAnuncio;
import modelos.Anuncio;

/**
 * Servlet implementation class AnyadirFavorito
 */
@WebServlet("/AnyadirFavorito")
public class AnyadirFavorito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnyadirFavorito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=request.getServletContext();
		HttpSession sesion=request.getSession();
		ArrayList<Anuncio> favoritos=(ArrayList<Anuncio>)sesion.getAttribute("favoritos");
		if(favoritos==null){
			favoritos=new ArrayList<Anuncio>();
			sesion.setAttribute("favoritos",favoritos);
		}
		String stId=request.getParameter("id");
		int id=Integer.parseInt(stId);
		DAOAnuncio dao=new DAOAnuncio();
		Anuncio Anuncio=dao.getAnuncio(id);
		
		boolean existe=false;
		for(Anuncio v : favoritos){
			if(v.equals(Anuncio)){
				existe=true;
				break;
			}
		}
		if(!existe){
			favoritos.add(Anuncio);
		}
		
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/anyadirFavorito.jsp");
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
