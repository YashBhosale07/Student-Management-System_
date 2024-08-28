package com.studentManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagementSystem.DAO.IStudentDAO;

import com.studentManagementSystem.Entity.Student;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDAO dao;

	@Override
	public List<Student> getAllStudents() {
		
		return dao.findAll();
	}

	@Override
	public Student saveStudent(Student s) {
		return dao.save(s);
	}

	@Override
	public Student findByIdStudent(int id) {
		return dao.findById(id).get();
	}

	@Override
	public Student updateStudent(Student s) {		
		return dao.save(s);
	}

	@Override
	public boolean deleteStudent(int id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		return false;
		
	}

	
}
