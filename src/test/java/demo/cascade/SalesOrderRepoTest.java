package demo.cascade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesOrderRepoTest {

    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void case1_place() throws Exception {
        SalesOrder order = new SalesOrder();
        order.addItem("iPhone");
        orderRepo.save(order);
    }

    @Test
    public void case1_addLineItem() throws Exception {
        SalesOrder order = new SalesOrder();
        order.addItem("iPhone");
        orderRepo.save(order);

        order.addItem("Mac");
        orderRepo.save(order);

        SalesOrder order1 = orderRepo.findOne(order.getId());
        order1.addItem("Watch");
        orderRepo.save(order1);
    }
}