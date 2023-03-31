package in.ineuron.service;

import in.ineuron.dto.*;
import in.ineuron.daofactory.adminDaoFactory;

import java.util.ArrayList;

import in.ineuron.dao.IAdminDao;

public class adminServiceImpl implements IAdminService {

	private IAdminDao adminDao;
	
	@Override
	public String addLib(Librarian eldata) {
		adminDao = adminDaoFactory.getStudentDao();
		return adminDao.addLib(eldata);
	}

	@Override
	public Librarian searchLib(String lid) {
		adminDao = adminDaoFactory.getStudentDao();
		return adminDao.searchLib(lid);
	}
	
	@Override
	public ArrayList<Librarian> allLibrarianDetails() {
		adminDao = adminDaoFactory.getStudentDao();
		return adminDao.allLibrarianDetails();
	}

	@Override
	public String UpdateLib(Librarian eldata) {
		adminDao = adminDaoFactory.getStudentDao();
		return adminDao.UpdateLib(eldata);
	}

	@Override
	public String deleteLib(String lid) {
		adminDao = adminDaoFactory.getStudentDao();
		return adminDao.deleteLib(lid);
	}

}
