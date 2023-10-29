package com.nucsaping;

import com.nucsaping.model.Employee;
import com.nucsaping.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringBootRedisCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeService employeeService) {
		return args -> {

//			saveEmployee(employeeService);

//			getEmployeeById(employeeService);

//			deleteEmployeeById(employeeService);

//			saveMultipleEmployees(employeeService);

			getAllEmployees(employeeService);

//			updateEmployee(employeeService);
		};
	}

	private void updateEmployee(EmployeeService employeeService) {
		// Get employee first
		Employee employee = employeeService.getOneEmployee(1);
		System.out.println("employee before updated: " + employee);

		// update the employee
		employee.setEmployeeName("Mary Doe");
		employeeService.updateEmployee(employee);

		// Display the updated employee
		Employee theUpdatedEmployee = employeeService.getOneEmployee(1);
		System.out.println("employee after updated: " + theUpdatedEmployee);
	}

	private void getAllEmployees(EmployeeService employeeService) {
		Map<Integer, Employee> allEmployees = employeeService.getAllEmployees();
		allEmployees.entrySet()
				.forEach(emp -> System.out.println(emp));
	}

	private void saveMultipleEmployees(EmployeeService employeeService) {
		Map<Integer, Employee> map = Map.of(
				1, new Employee(1, "John Doe", 5000000.0),
				2, new Employee(2, "Steve Vai", 6000000.0),
				3, new Employee(3, "Paul Gilbert", 7000000.0)
		);

		employeeService.saveAllEmployees(map);
	}

	private void deleteEmployeeById(EmployeeService employeeService) {
		employeeService.deleteEmployee(1);
	}

	private void getEmployeeById(EmployeeService employeeService) {
		Employee employee = employeeService.getOneEmployee(1);
		System.out.println(employee);
	}

	private void saveEmployee(EmployeeService employeeService) {

		Employee employee = new Employee(1, "John Doe", 5000000.0);
		employeeService.saveEmployee(employee);
	}

}
