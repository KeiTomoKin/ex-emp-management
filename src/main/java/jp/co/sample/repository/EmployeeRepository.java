package jp.co.sample.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {
	private RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setMailAddress("mail_address");
		employee.setPassword(rs.getString("password"));
		return employee;
	};
}
