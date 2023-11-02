package in.spring.ath.controller;

import in.spring.ath.Repositories.EmployeeRepo;
import in.spring.ath.Repositories.UserRepo;
import in.spring.ath.entity.Employee;
import in.spring.ath.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("a1")
public class RestController {

	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@GetMapping(path = "getEmployeeByName",consumes = {"application/json"})
	public List<Employee> getEmployeeByName(@RequestBody Employee emp) {
		return repo.findByNameOrEmpidOrderByEmpidDesc(emp.getName(),emp.getEmpid()); // Query DSL :- Domain Specific Language...
	}

	@GetMapping(path="employee/{page}",produces = {"application/xml","application/json"})
	public List<Employee> getAllEmployee(@PathVariable("page") int page) {

		Sort srt=Sort.by("name").ascending();
		Pageable pageable= PageRequest.of(page,10,srt);

		return repo.findAll(pageable).toList();
	}

	@GetMapping("employee/{emp_id}")
	public Employee employee(@PathVariable("emp_id") int empid) {
		return repo.findById(empid).orElse(new Employee(empid,"",""));
	}

	@PostMapping(path = "employee")
	public Employee addEmployee(@ModelAttribute Employee emp) {
		return repo.save(emp);
	}

	@PutMapping(path = "employee",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Employee updateEmployee(@RequestBody Employee emp) {
		return repo.save(emp);
	}
	
	@DeleteMapping("deleteEmployee/{emp_id}")
	public void deleteEmployee(@PathVariable("emp_id") int emp_id) {
		repo.deleteById(emp_id);
	}

	@GetMapping("getCurrentDate")
	public String getCurrentDate(){
		return repo.getCurrentDate();
	}
	
	@GetMapping(value = "user")
	public User addUser() {
		User user=new User();
		user.setUserName("Faizal");
		user.setPassword(encoder.encode("Faizal@123"));
		return userRepo.save(user);
	}
}
