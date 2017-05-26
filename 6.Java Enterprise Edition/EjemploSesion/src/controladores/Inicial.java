package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Inicial
 */
@WebServlet("/Inicial")
public class Inicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer n=new Integer(0);
		HttpSession sesion=request.getSession();
		
		n=(Integer)sesion.getAttribute("numero");
		if(n==null){
			n=new Integer(0);
		}
		n++;
		
		PrintWriter pw=response.getWriter();
		if(sesion.isNew()){
			pw.println("Es una sesion nueva<br/>");
		}
		pw.println("Veces: "+n);
		if(n<10){
			sesion.setAttribute("numero",n );
		}
		else{
			sesion.invalidate();
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
