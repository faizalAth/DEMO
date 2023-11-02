package in.spring.ath.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.spring.ath.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer> {

	List<Employee> findByNameOrEmpidOrderByEmpidDesc(String name,int empid); // Query DSL -> Query Domain Specific Language

	@Query("from Employee where empid=?1")
	Employee employee(int empid);

	@Query(value = "select date_format(sysdate(),'%d-%m-%Y %h:%i:%s') from dual",nativeQuery = true)
	String getCurrentDate();

}
