package demo.lock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YQ.Huang
 */
@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
}
