package Shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cartcontroller
 */
@WebServlet("/Cartcontroller")
public class Cartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=response.getWriter();
		pw.print("Hello...your products list is ready");
		response.sendRedirect("List.html");
		
		/*HttpSession session=request.getSession(true);
		List<Product> lstProd=(List)session.getAttribute("prod");
		pw.print("<table border='4' bgcolor='blue'>");
		for(Product p:lstProd)
		{		
			pw.print("<tr><td>"+p.getProdId()+"</td>");
			pw.print("<td>"+p.getProdName()+"</td>");
			pw.print("<td>"+p.getProdPrice()+"</td>");
			pw.print("<td>"+p.getProdQty()+"</td></tr>");
		}
		pw.print("</table>");
		
		pw.print("Click here for bill");
		pw.print("<a href='BillServlet'>Yes</a>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
