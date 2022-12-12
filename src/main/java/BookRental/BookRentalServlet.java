package BookRental;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;

import BookRental.RentalBean;
import Login.LoginBean;
import Login.LoginDao;
import BookRental.BookRentalDao;
/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/BookRentalServlet")
public class BookRentalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookRentalDao bookRentalDao;  

    /**
     * Default constructor. 
     */
	public void init() {
		bookRentalDao = new BookRentalDao();
    }
	
    public BookRentalServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		String bkName = request.getParameter("bkName");
		//System.out.println(bkName);
		request.setAttribute("bkName", bkName); // This will be available as ${id}
		request.getRequestDispatcher("BookDetail.jsp").forward(request, response);
		
	}
	*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bkName = request.getParameter("bkName");
		String bkAuthor = request.getParameter("bkAuthor");
		String bkTopic = request.getParameter("bkTopic");
		System.out.println("bkName is: "+ bkName);
		System.out.println("bkAuthor is: "+ bkAuthor);
		System.out.println("bkTopic is: "+ bkTopic);
		
		RentalBean rentalBean = new RentalBean();
		rentalBean.setBkName(bkName);
		rentalBean.setBkAuthor(bkAuthor);
		rentalBean.setBkTopic(bkTopic);
	
		ArrayList Rows = new ArrayList();
		try {
			Rows = bookRentalDao.search(rentalBean);
			
			System.out.println(Rows);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("Rows", Rows);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/BookDetail.jsp");
		requestDispatcher.forward(request,response);
		//request.getRequestDispatcher("BookDetail.jsp").forward(request, response); 
		
//		try {
//			if (bookRentalDao.search(rentalBean)) {
//				//HttpSession session = request.getSession();
//				// session.setAttribute("username",username);
//				response.sendRedirect("main menu.html");
//				System.out.println("chengg");
//			} else {
//				HttpSession session = request.getSession();
//				System.out.println("ShiBai");
//				//session.setAttribute("user", username);
//				//response.sendRedirect("login.jsp");
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}

}
