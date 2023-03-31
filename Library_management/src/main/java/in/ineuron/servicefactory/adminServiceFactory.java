package in.ineuron.servicefactory;

import in.ineuron.dto.*;
import in.ineuron.service.*;

public class adminServiceFactory {

	private adminServiceFactory() {}

	private static IAdminService adminService = null;

	public static IAdminService getadminService() {
		
		//singleton pattern code
		if (adminService == null) {
			adminService = new adminServiceImpl();
		}
		return adminService;
	}
}
