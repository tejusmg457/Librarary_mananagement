package in.ineuron.dto;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String SFirstName;
	private String SLatstName;
	private String SRegNo;
	private int SSem;
	private String SDep;

	
	public String getSFirstName() {
		return SFirstName;
	}
	public void setSFirstName(String sFirstName) {
		SFirstName = sFirstName;
	}
	public String getSLatstName() {
		return SLatstName;
	}
	public void setSLatstName(String sLatstName) {
		SLatstName = sLatstName;
	}
	public String getSRegNo() {
		return SRegNo;
	}
	public void setSRegNo(String sRegNo) {
		SRegNo = sRegNo;
	}
	public int getSSem() {
		return SSem;
	}
	public void setSSem(int sSem) {
		SSem = sSem;
	}
	public String getSDep() {
		return SDep;
	}
	public void setSDep(String sDep) {
		SDep = sDep;
	}
	
	
	@Override
	public String toString() {
		return "Student [SFirstName=" + SFirstName + ", SLatstName=" + SLatstName + ", SRegNo=" + SRegNo + ", SSem="
				+ SSem + ", SDep=" + SDep + "]";
	}
	
	

}
