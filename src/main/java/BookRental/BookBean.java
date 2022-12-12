package BookRental;
import java.io.Serializable;

public class BookBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bkId;
	private String bkName;
	private String bkTopic;
	private String bkAuthor;
	private String bkStatus;

	public String getBkid() {
		return bkId;
	}

	public void setBkid(String bkId) {
		this.bkId = bkId;
	}
	
	public String getBkname() {
		return bkName;
	}

	public void setBkname(String bkName) {
		this.bkName = bkName;
	}

	public String getBkauthor() {
		return bkAuthor;
	}

	public void setBkauthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}
		
	public String getBktopic() {
		return bkTopic;
	}

	public void setBktopic(String bkTopic) {
		this.bkTopic = bkTopic;
	}
	
	public String getBkstatus() {
		return bkStatus;
	}

	public void setBkstatus(String bkStatus) {
		this.bkStatus = bkStatus;
	}

}
