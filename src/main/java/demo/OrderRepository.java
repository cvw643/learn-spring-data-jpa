package demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YQ.Huang
 */
//@Repository
public interface OrderRepository extends MongoRepository<Order, Order.Id> {
    List<Order> findByIdAppId(String appId);
}
