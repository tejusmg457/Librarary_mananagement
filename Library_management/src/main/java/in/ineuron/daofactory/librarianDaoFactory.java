package in.ineuron.daofactory;

import in.ineuron.dao.*;

public class librarianDaoFactory {
	
	private librarianDaoFactory() {}

	private static ILibrarianDao librarianDao = null;

	public static ILibrarianDao getStudentDao() {
		if (librarianDao == null) {
			librarianDao = new LibrarianDaoImpl();
		}
		return librarianDao;	
		}

}
