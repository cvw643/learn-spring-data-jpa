package demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SomethingRepositoryTest {

    @Autowired
    private SomethingRepository repository;

    @Before
    public void setup() {
        repository.deleteAll();
    }

    @Test(expected = DuplicateKeyException.class)
    public void insertSame() {
        Something something = new Something("1", "1");
        repository.insert(something);
        repository.insert(something);
    }

    @Test
    public void saveSame() {
        Something something = new Something("1", "1");
        repository.save(something);
        repository.save(something);
    }

    @Test(expected = DuplicateKeyException.class)
    public void saveDuplicate() {
        Something something1 = new Something("1", "1");
        repository.save(something1);
        Something something2 = new Something("1", "1");
        repository.save(something2);
    }

    @Test
    public void update_canUseSave() {
        Something something1 = new Something("1", "1");
        repository.insert(something1);
        Assert.assertNotNull(something1.getId());
        something1.setContent("c");
        repository.save(something1);
    }

    @Test(expected = DuplicateKeyException.class)
    public void update_cannotUseInsert() {
        Something something1 = new Something("1", "1");
        repository.insert(something1);
        Assert.assertNotNull(something1.getId());
        something1.setContent("c");
        repository.insert(something1);
    }
}