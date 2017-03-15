package demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YQ.Huang
 */
// NOTE: @Repository is not mandatory, but add it explicitly would enable DataAccessException conversion.
@Repository
public interface SomethingRepository extends MongoRepository<Something, String> {
}
