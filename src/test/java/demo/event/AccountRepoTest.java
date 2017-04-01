package demo.event;

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
public class AccountRepoTest {
    @Autowired
    private AccountRepo accountRepo;

    @Test
    public void case1() throws Exception {
        Account account = new Account("cvw643", "old");
        accountRepo.save(account);

        Account account1 = accountRepo.findOne("cvw643");
        account1.changePassword("old", "new");
        accountRepo.save(account1);
    }
}