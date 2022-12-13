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
                    break;
                case "/rent":
                	rentBook(request, response);
                    break;
                case "/main%20menu":
                	searchBook(request, response);
                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
//                case "/update":
//                    updateUser(request, response);
//                    break;
                default:
                	searchBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
		
	private void rentBook(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
<<<<<<< HEAD
				String returnDate = request.getParameter("returndate");
		        String bookId = request.getParameter("bkId");
				String userId = request.getParameter("userId");
				String userType = request.getParameter("userType");
				
				System.out.println("data in query listed below: ");
				System.out.println(returnDate + "; "+bookId+ "; "+userId+"; "+userType);
				
=======
		        int id = Integer.parseInt(request.getParameter("returndate"));
		        
//		        String name = request.getParameter("name");
//		        String email = request.getParameter("email");
//		        String country = request.getParameter("country");
>>>>>>> parent of de89cb1 (able to pass userid to anywhere)

		        //User book = new User(id, name, email, country);
		        bookRentalDao.rentBook(book,user);
		        response.sendRedirect("main%20menu.jsp");
		    }
	
//	private void passBean(HttpServletRequest request, HttpServletResponse response)
//		    throws SQLException, IOException {
//		        int id = Integer.parseInt(request.getParameter("returndate"));
//		        
////		        String name = request.getParameter("name");
////		        String email = request.getParameter("email");
////		        String country = request.getParameter("country");
//
//		        //User book = new User(id, name, email, country);
//		        bookRentalDao.rentBook(book,user);
//		        response.sendRedirect("main%20menu.jsp");
//		    }
	
	private void searchBook(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
				// TODO Auto-generated method stub
				LoginBean loginBean = (LoginBean)request.getAttribute("loginBean");
				System.out.println("UserID is: "+ loginBean.getUserid());
				
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
				//RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/BookDetail.jsp");
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/BookDetailNew.jsp");
				requestDispatcher.forward(request,response);

			}

}
