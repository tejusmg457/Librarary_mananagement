package in.ineuron.servicefactory;

import in.ineuron.service.ILibrarianService;
import in.ineuron.service.LibrarianServiceImpl;

public class librarianServiceFactory {
	
	private librarianServiceFactory() {}

	private static ILibrarianService librarianService = null;

	public static ILibrarianService getLibrarianService() {
		
		//singleton pattern code
		if (librarianService == null) {
			librarianService = new LibrarianServiceImpl();
		}
		return librarianService;
	}

}
