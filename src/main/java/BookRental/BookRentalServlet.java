package BookRental;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
@WebServlet("/")
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
	    String action = request.getServletPath();
		
	    try {
            switch (action) {
                case "/BookRental":
                	searchBook(request, response);
                	System.out.println("from book rental");
                    break;
                case "/rent":
                	rentBook(request, response);
                	System.out.println("from rent");
                    break;
                case "/main%20menu":
                	searchBook(request, response);
                	System.out.println("from main menu");
                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
//                case "/update":
//                    updateUser(request, response);
//                    break;
                default:
                	searchBook(request, response);
                	System.out.println("from default");
                	System.out.println(action);
                    break;
                    }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
		
	private void rentBook(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
				String returnDate = request.getParameter("returndate");
		        String bookId = request.getParameter("bkId");
				String userId = request.getParameter("userId");
				String userType = request.getParameter("userType");
				
				System.out.println("data in query listed below: ");
				System.out.println(returnDate + "; "+bookId+ "; "+userId+"; "+userType);
				
		        bookRentalDao.rentBook(returnDate, bookId, userId);
		        response.sendRedirect("main%20menu.jsp");
		    }
	
	private void searchBook(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
				// TODO Auto-generated method stub
				String userId = request.getParameter("UserId");
				String userType = request.getParameter("UserType");
				
				System.out.println("decomposed userId is: "+userId);
				System.out.println("decomposed userType is: "+userType);

				String bkName = request.getParameter("bkName");
				String bkAuthor = request.getParameter("bkAuthor");
				String bkTopic = request.getParameter("bkTopic");

				
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
				request.setAttribute("userId", userId);
				request.setAttribute("userType", userType);
				//RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/BookDetail.jsp");
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/BookDetailNew.jsp");
				requestDispatcher.forward(request,response);

			}

}
