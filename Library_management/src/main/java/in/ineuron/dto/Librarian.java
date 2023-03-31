package in.ineuron.dto;

import java.io.Serializable;

public class Librarian implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String LibFirstName;
	private String LibLastName;
	private String LibID;
	private String Lpassword;
	
	
	public String getLibFirstName() {
		return LibFirstName;
	}
	public void setLibFirstName(String libFirstName) {
		LibFirstName = libFirstName;
	}
	public String getLibLastName() {
		return LibLastName;
	}
	public void setLibLastName(String libLastName) {
		LibLastName = libLastName;
	}
	
	public String getLpassword() {
		return Lpassword;
	}
	public void setLpassword(String lpassword) {
		Lpassword = lpassword;
	}
	public String getLibID() {
		return LibID;
	}
	public void setLibID(String libID) {
		LibID = libID;
	}
	
	@Override
	public String toString() {
		return "Librarian [LibFirstName=" + LibFirstName + ", LibLastName=" + LibLastName + ", Lpassword=" + Lpassword + ", LibID="
				+ LibID + "]";
	}
	
	
	
	
	

}
