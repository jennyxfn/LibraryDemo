package Login;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.LoginBean;
import Login.LoginDao;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao loginDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() {
    	loginDao = new LoginDao();
    }
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String userEmail = request.getParameter("userEmail");
		//String userPassword = request.getParameter("userPassword");
		//String userType = request.getParameter("userType");
		

		//request.setAttribute("userEmail", userEmail); // This will be available as ${id}
		//request.setAttribute("userPassword", userPassword); // This will be available as ${id}
		//request.setAttribute("userType", userType); // This will be available as ${id}
		
		//request.getRequestDispatcher("main menu.html").forward(request, response);
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
	    try {
            switch (action) {
                case "/Login2":
                	valUser(request, response);
                    break;
//                case "/rent":
//                	rentBook(request, response);
//                    break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
//                case "/update":
//                    updateUser(request, response);
//                    break;
                default:
                	valUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void valUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		System.out.println("User name is: "+ username);
		System.out.println("User password is: "+ password);
		System.out.println("User type is: "+ usertype);
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		loginBean.setUsertype(usertype);
		
		try {
			if (loginDao.validate(loginBean)) {

				// pass LoginBean to main menu

				loginBean.setUserid(loginDao.getId(loginBean));
				request.setAttribute("loginBean", loginBean);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/main menu.jsp");
				requestDispatcher.forward(request,response);
				System.out.println("chengg");
			} else {
				HttpSession session = request.getSession();
				System.out.println("ShiBai");
				//session.setAttribute("user", username);
				//response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
