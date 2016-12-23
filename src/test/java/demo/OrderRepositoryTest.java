package demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Before
    public void before() {
        orderRepository.deleteAll();
    }

    @Test
    public void compositeId() {
        Order order = new Order("app1", "order1", 1);
        orderRepository.save(order);

        Order saved = orderRepository.findOne(Order.id("app1", "order1"));
        Assert.assertEquals(1, saved.getAmount());

        orderRepository.delete(Order.id("app1", "order1"));
        Assert.assertNull(orderRepository.findOne(Order.id("app1", "order1")));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void cannotAutoGenerateCompositeId() {
        Order order = new Order(1);
        orderRepository.save(order);
    }

    @Test
    public void saveDuplicateWillUpdate() {
        Order order = new Order("app1", "order1", 1);
        orderRepository.save(order);
        order.setAmount(2);
        orderRepository.save(order);
        Assert.assertEquals(1, orderRepository.count());
    }

    @Test(expected = DuplicateKeyException.class)
    public void insertDuplicateWillFail() {
        Order order = new Order("app1", "order1", 1);
        orderRepository.insert(order);
        order.setAmount(2);
        orderRepository.insert(order);
    }

    @Test
    public void findBySubId() {
        Order order = new Order("app1", "order1", 1);
        orderRepository.save(order);
        List<Order> found = orderRepository.findByIdAppId("app1");
        Assert.assertTrue(found.size() > 0);
    }
}