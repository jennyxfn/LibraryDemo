package BookRental;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BookRental.RentalBean;
import BookRental.BookBean;

public class BookRentalDao {
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
