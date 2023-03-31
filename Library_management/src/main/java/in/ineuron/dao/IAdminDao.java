package in.ineuron.dao;

import java.util.ArrayList;

import in.ineuron.dto.*;

public interface IAdminDao {

	public String addLib(Librarian eldata);
	
	public Librarian searchLib(String lid);
	
	public ArrayList<Librarian> allLibrarianDetails();
	
	public String UpdateLib(Librarian eldata);
	
	public String deleteLib(String lid);
		
}
