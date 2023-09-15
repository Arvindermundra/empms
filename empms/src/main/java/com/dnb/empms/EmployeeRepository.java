package com.dnb.empms;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	//Select * from employee where dept=''
	//List<Employee> findByDept(String dept);
	//Select 8 from employee where salary>?
	List<Employee> findBySalaryGreaterThan(int salary);
	//Select * from employee where dept=? and salary<?
	List<Employee> findByDeptAndSalaryLessThan(String dept, int salary);
	
	Optional<Employee> findTopByOrderBySalaryDesc();
	
	Employee findTopByOrderBySalaryAsc();
	
	List<Employee> findTop3ByOrderBySalaryAsc();

	List<Employee> findTop3ByOrderBySalaryDesc();
	
	List<Employee> findFirst2BySalary(int salary);
	
	List<Employee> findFirst2ByDeptOrderBySalaryDesc(String dept);
	
	List<Employee> findBy();
	
	List<Employee> findBySalaryBetween(int salaryMin, int salaryMax);	
	
	List<Employee> findByDept(String likeString); // select (maxsalary) from employee group by dept // op:List:instance// input: NA
	@Query("SELECT e.dept, MAX(e.salary) FROM Employee e GROUP BY e.dept")
	List<Object[]> findMaxSalaryByDept();// holding result into list
	long countByDept(String Dept);
}// list of max sal in respective department
// ask for repo confirm the bean.
