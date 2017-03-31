package demo.cascade;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author YQ.Huang
 */
public interface OrderRepo extends JpaRepository<SalesOrder, Integer> {
}
