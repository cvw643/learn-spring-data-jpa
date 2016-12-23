package demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YQ.Huang
 */
@Repository
public interface SomethingRepository extends MongoRepository<Something, String> {
}
