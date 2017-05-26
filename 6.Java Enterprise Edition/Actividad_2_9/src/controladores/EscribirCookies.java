package controladores;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EscribirCookies
 */
@WebServlet("/EscribirCookies")
public class EscribirCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EscribirCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		Enumeration<String> parametrosContexto = sc.getInitParameterNames();
		response.setContentType("text/html");
		
		System.out.println("Escribe Cookies");
		System.out.println("===========================");
		Random rnd = new Random(System.currentTimeMillis());
		
		while (parametrosContexto.hasMoreElements()){
			String nombre = parametrosContexto.nextElement();
			String valor = sc.getInitParameter(nombre)+"--"+new Date().toString();
			valor = valor.replace(" ", "_");
			System.out.println(nombre + ":->"+valor+"<-");
			Cookie cookie = new Cookie(nombre,valor);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			
			nombre = "numero" + rnd.nextInt(1000)+1;
			valor = (rnd.nextInt(10)+1)+" ";
			cookie = new Cookie(nombre,valor);
			cookie.setMaxAge(360);
			response.addCookie(cookie);
			System.out.println(nombre + ": "+valor);
			
		}
		request.getServletContext().getRequestDispatcher("/EscribirCookies.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
