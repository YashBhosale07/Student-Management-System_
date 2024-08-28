package com.studentManagementSystem.Service;

import java.util.List;


import com.studentManagementSystem.Entity.Student;

public interface IStudentService {
	
	public List<Student>getAllStudents();
	public  Student saveStudent(Student s);
	public Student findByIdStudent(int id);
	public Student updateStudent(Student s);
	public boolean deleteStudent(int id);
	
	

}
