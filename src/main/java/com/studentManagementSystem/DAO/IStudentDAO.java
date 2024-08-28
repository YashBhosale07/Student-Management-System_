package com.studentManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.studentManagementSystem.Entity.Student;

@Repository
public interface IStudentDAO extends JpaRepository<Student, Integer> {
	
	
	

}
