package com.studentManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentManagementSystem.Entity.Admin;

@Repository
public interface IAdminDAO extends JpaRepository<Admin, Integer> {

	boolean existsByUsernameAndPassword(String username,String password);
}
