package demo.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Map;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void case1() throws Exception {
        Product product = productRepo.save(new Product("Bed"));

        productRepo.findOneCached(product.getId());
        productRepo.findOneCached(product.getId());
    }

    @Test
    public void case2() throws Exception {
        entityManager.setProperty("javax.persistence.sharedCache.mode", "ENABLE_SELECTIVE");
        Product product = entityManager.find(Product.class, 1);
        product = entityManager.find(Product.class, 1);
    }
}