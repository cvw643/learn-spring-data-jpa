package demo.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YQ.Huang
 */
@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    Person findByName(String name);
}
