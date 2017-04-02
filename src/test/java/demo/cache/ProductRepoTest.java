package demo.cache;

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
public class ProductRepoTest {
    @Autowired
    private ProductRepo productRepo;

    @Test
    public void case1() throws Exception {
        Product product = productRepo.save(new Product("Bed"));

        productRepo.findOneCached(product.getId());
        productRepo.findOneCached(product.getId());
    }
}