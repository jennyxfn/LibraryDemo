package BookRental;
import java.io.Serializable;

public class RentalBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bkName;
	private String bkAuthor;
	private String bkTopic;

	public String getBkName() {
		if (this.bkName == null) {
			return null;
		}
		return bkName;
	}

	public void setBkName(String bkName) {
		this.bkName = bkName;
	}

	public String getBkAuthor() {
		if (this.bkAuthor == null) {
			return null;
		}
		return bkAuthor;
	}

	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}
		
	public String getBkTopic() {
		if (this.bkTopic == null) {
			return null;
		}
		return bkTopic;
	}

	public void setBkTopic(String bkTopic) {
		this.bkTopic = bkTopic;
	}
	

}
