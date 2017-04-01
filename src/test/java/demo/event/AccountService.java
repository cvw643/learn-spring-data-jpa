package demo.event;

import org.springframework.stereotype.Service;

/**
 * @author YQ.Huang
 */
@Service
public class AccountService {
    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void resetPassword(String username) {
        Account account = accountRepo.findOne(username);
        account.resetPassword();
        accountRepo.save(account);
    }

}
