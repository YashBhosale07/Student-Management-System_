package com.studentManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagementSystem.DAO.IAdminDAO;
import com.studentManagementSystem.Entity.Admin;

@Service
public class AdminServiceImpl implements IAdminSerivce {
	@Autowired
	private IAdminDAO dao;

	@Override
	public boolean checkAdmin(Admin admin) {
		if(dao.existsByUsernameAndPassword(admin.getUsername(),admin.getPassword())) {
			return true;
		}
		return false;
	}

}
