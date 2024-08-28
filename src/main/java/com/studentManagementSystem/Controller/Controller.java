package com.studentManagementSystem.Controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentManagementSystem.Entity.Admin;
import com.studentManagementSystem.Entity.Student;
import com.studentManagementSystem.Service.IAdminSerivce;
import com.studentManagementSystem.Service.IStudentService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private IStudentService service;
	
	@Autowired
	private IAdminSerivce serviceadmin;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@PostMapping("/checkAdmin")
	public String checkAdmin(@ModelAttribute("admin")Admin admin) {
		if(serviceadmin.checkAdmin(admin)) {
			return "redirect:/students";
		}
		return "InvalidPage";
	}
	
	@GetMapping("/students")
	public String getAllStudent(Map<String, Object>map) {
		map.put("students", service.getAllStudents());
		return "students";
	}
	
	@GetMapping("/addStudent")
	public String createStudentForm(Map<String,Object>map) {
		Student student=new Student();
		map.put("student", student);
		return "form";
	}
	
	@PostMapping("/student")
	public String saveStudent(@ModelAttribute("student")Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/editStudent/{id}")
	public String updateStudentForm(@PathVariable int id,Map<String,Object>map) {
		Student student = service.findByIdStudent(id);
		if (student != null) {
            map.put("updateStudentDetails", student);
            return "editForm";
        }
        return "redirect:/students";
	}
	
	@PostMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("updateStudentDetails")Student student) {
		 Student existing = service.findByIdStudent(id);
		if (existing != null) {
	        existing.setFirstName(student.getFirstName());
	        existing.setLastName(student.getLastName());
	        existing.setEmail(student.getEmail());
	        service.updateStudent(existing);
	        
	        return "wishMessage";
	    }
	    
	    return "redirect:/students";
	}
	
	@GetMapping("/removeStudent/{id}")
	public String removeStudentForm(@PathVariable int id) {
		if(service.deleteStudent(id)) {
			return "wishMessage";
		}
		return "redirect:/students";
        
	}
	
	
	
	
	
	
	
}
