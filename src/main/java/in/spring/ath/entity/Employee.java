package in.spring.ath.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "dtl_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	
	@NotEmpty(message = "Employee Name Should not be Empty.")
	private String name;

	private String city;
	
	
	public Employee() {

	}
	public Employee(int empid, String name, String city) {
		super();
		this.empid = empid;
		this.name = name;
		this.city = city;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", city=" + city + "]";
	}
	
	
}
