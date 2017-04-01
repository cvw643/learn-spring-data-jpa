package demo.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YQ.Huang
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
}
