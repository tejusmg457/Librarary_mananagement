package in.ineuron.service;

import java.util.ArrayList;

import in.ineuron.dto.*;

public interface IAdminService {

	public String addLib(Librarian eldata);
	
	public Librarian searchLib(String lid);
	
	public ArrayList<Librarian> allLibrarianDetails();
	
	public String UpdateLib(Librarian eldata);
	
	public String deleteLib(String lid);
}
