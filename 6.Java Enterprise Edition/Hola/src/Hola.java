

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hola
 */
@WebServlet(description = "Servlet basica que saluda", urlPatterns = { "/HolaMundo" })
public class Hola extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hola() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s="<html>"
				+"<head>"
				+"</head>"
				+"<body>"
				+"<p style='background:yellow;color:blue;'>Hola m&aacute;s sofisticado</p>"
				+"</body>"
				+"</html>";
		response.getWriter().append(s);
	}
}
