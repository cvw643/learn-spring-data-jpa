package demo.inheritance;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author YQ.Huang
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    FullTimeEmployee findFullTimeEmployeeById(int id);

    PartTimeEmployee findPartTimeEmployeeById(int id);
}
