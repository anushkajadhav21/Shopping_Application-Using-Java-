package Shop.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import Shop.Dao.ProductDaoImpl;
import Shop.model.Product;

/**
 * Servlet implementation class Productcontroller
 */
@WebServlet("/Productcontroller")
public class Productcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<Product> prodList = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
        int prodId = Integer.parseInt(request.getParameter("pid"));
        String prodName = request.getParameter("pname");
        float prodPrice = Float.parseFloat(request.getParameter("pprice"));
        int prodQty = Integer.parseInt(request.getParameter("pqty"));

        Product prod = new Product(prodId, prodName, prodPrice, prodQty);
        prodList.add(prod);
        ProductDaoImpl pdao=new ProductDaoImpl();
        int i = pdao.ProductRecord(prodList);
//        if(i>0) {
//        	System.out.println("Product added");
//        	response.sendRedirect("YES.html");
//        }
//        Product product= prodList.get(0);
//		List
////  		PrintWriter pw = response.getWriter();
        List<Product> lstprod= pdao.getAllProduct();
        HttpSession session = request.getSession();
//        session.setAttribute("data", product);
        session.setAttribute("data", lstprod);
        response.sendRedirect("Display.jsp");
//        List<Product> lstProd=(List)session.getAttribute("prod"); 
//        HttpSession session = request.getSession(true);
//        session.setAttribute("prod", prodList);
//        response.sendRedirect("YES.html");
        /*pw.print("Do you want to add more products to the cart?");
        pw.print("<a href='product.html'>Yes</a>");
        
        pw.print("To confirm the products, click here: ");
        pw.print("<a href='CartServlet'>Yes</a>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
