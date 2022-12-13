package BookRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BookRental.RentalBean;
import BookRental.BookBean;

import Login.LoginBean;

public class BookRentalDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/project1";
    private String jdbcUsername = "root";
    private String jdbcPassword = "971228";

    private static final String SEARCH_BOOKS_SQL = "SELECT book.book_id,book_name,topics_name,authors_lname,book_status "+ 
			      "FROM project1.book book "+
			      "left join book_author ba "+
			      "on book.book_id = ba.book_id "+
			      "left join author a "+
			      "on ba.authors_id = a.authors_id "+
			      "left join topic t "+
			      "on t.topics_id = book.topics_id "+
			      "where book_name = IF(?='', book_name, ?) and authors_lname = IF(?='', authors_lname, ?) and topics_name = IF(?='', topics_name, ?)";
    
    //insert Book ID; Book Name; Topics; Author; Status.
    private static final String INSERT_BOOKS_SQL = "";
    
    //Needs to be changed to correct table
    private static final String DELETE_BOOKS_SQL = "delete from book where book_id = ?;";
    
    //INSERT in rental table
    private static final String RENT_BOOKS_SQL = "insert into rental "
    		+ "values ((select max(rental_id) from rental)+1,'Borrowed',current_timestamp(),?,null,?,?)";
    
  //Update book status
    private static final String UPDATE_BOOKS_SQL = "update book set book_status = 'NotA' "
    		+ "where book_id = ?";
    		
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
	public ArrayList search(RentalBean rentalBean) throws ClassNotFoundException {
		//boolean status = false;
		ArrayList<BookBean> Rows = new ArrayList();

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/project1", "root", "971228");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT book.book_id,book_name,topics_name,authors_lname,book_status "+ 
			   				      "FROM project1.book book "+
			   				      "left join book_author ba "+
			   				      "on book.book_id = ba.book_id "+
			   				      "left join author a "+
			   				      "on ba.authors_id = a.authors_id "+
			   				      "left join topic t "+
			   				      "on t.topics_id = book.topics_id "+
			   				      "where book_name = IF(?='', book_name, ?) and authors_lname = IF(?='', authors_lname, ?) and topics_name = IF(?='', topics_name, ?)")
						
				) {
			preparedStatement.setString(1, rentalBean.getBkName());
			preparedStatement.setString(2, rentalBean.getBkName());
			preparedStatement.setString(3, rentalBean.getBkAuthor());
			preparedStatement.setString(4, rentalBean.getBkAuthor());
			preparedStatement.setString(5, rentalBean.getBkTopic());
			preparedStatement.setString(6, rentalBean.getBkTopic());
			

			

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			//create book bean and set data into them
			
			   while (rs.next()){
				   BookBean bookBean = new BookBean();
			       for (int i = 1; i <= 5 ; i++){
			    	   bookBean.setBkid(rs.getString(1));
			    	   bookBean.setBkname(rs.getString(2));
			    	   bookBean.setBktopic(rs.getString(3));
			    	   bookBean.setBkauthor(rs.getString(4));
			    	   bookBean.setBkstatus(rs.getString(5));
			       }
			       Rows.add(bookBean);
			   }
			//status = rs.next();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return Rows;
	}

	public void insertBook(BookBean book) throws SQLException {
        System.out.println(INSERT_BOOKS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
            preparedStatement.setString(1, book.getBkid());
            preparedStatement.setString(2, book.getBkname());
            preparedStatement.setString(3, book.getBktopic());
            preparedStatement.setString(4, book.getBkauthor());
            preparedStatement.setString(5, book.getBkstatus());
            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

	public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
	
	//not finish
	public boolean rentBook(BookBean book, LoginBean user ) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(RENT_BOOKS_SQL);
        		PreparedStatement statement1 = connection.prepareStatement(UPDATE_BOOKS_SQL);) {
        	//statement.setString(1, book.getBkid());// get from max(id) +1
            statement.setString(1, "expected_returndate");//grab from user input in rental page
            statement.setString(2, book.getBkid());
            statement.setString(3, user.getUserid());
            
            statement1.setString(1, book.getBkid());
            
            statement1.executeUpdate();
            rowUpdated = statement.executeUpdate() > 0;
            
            
        }
        return rowUpdated;
    }
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
