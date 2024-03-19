package Shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Shop.Dao.ProductDaoImpl;
import Shop.model.Bill;
import Shop.model.Product;

/**
 * Servlet implementation class Billcontroller
 */
@WebServlet("/Billcontroller")
public class Billcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Billcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				HttpSession session=request.getSession(true);
//				List<Product> lstProd=(List)session.getAttribute("prod");
				ProductDaoImpl pdao=new ProductDaoImpl();
				List<Product> lstProd = pdao.getAllProduct();
//				List<Cart> lstCart = pdao.getAllCart();
				float total=0,finaltotal=0,cgst=0,sgst=0;
				for(Product p:lstProd) //lstCart
				{		
					total=total+p.getProdPrice()*p.getProdQty();
				}
				cgst=total*0.06f;
				sgst=total*0.06f;
				finaltotal=total+cgst+sgst;
				Bill bill=new Bill(0,total,cgst,sgst,finaltotal);
//				bill.setLstProduct(lstProd); 
				session.setAttribute("bill", bill);
				response.sendRedirect("Bill.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
