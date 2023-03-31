package in.ineuron.daofactory;

import in.ineuron.dao.*;

public class adminDaoFactory {
	
	private adminDaoFactory() {}

	private static IAdminDao adminDao = null;

	public static IAdminDao getStudentDao() {
		if (adminDao == null) {
			adminDao = new adminDaoImpl();
		}
		return adminDao;	}

}
