package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOProductos;
import modelos.Producto;

/**
 * Servlet implementation class ServletTienda
 */
@WebServlet("/ServletTienda")
public class ServletTienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTienda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoge el parametro opcion que le mandamos desde el jsp, pero como lo coge como un string
		String stOpcion = request.getParameter("opcion");
		int opcion = Integer.parseInt(stOpcion);
		String vista = null;
		DAOProductos dao = new DAOProductos();
		switch (opcion) {
		case 1:
			ArrayList<Producto> productos = dao.getTodos();
			request.setAttribute("TodosProductos", productos);
			vista = "mostrarTodos.jsp";
			break;
		case 2:
		
			vista = "mostrarUno.jsp";
			break;
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/"+ vista);
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
