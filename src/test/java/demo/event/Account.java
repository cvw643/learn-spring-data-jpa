package demo.event;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author YQ.Huang
 */
@Entity
public class Account extends AbstractAggregateRoot {
    @Id
    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void resetPassword() {
        this.password = new Date().toString();
        registerEvent(new AccountPasswordResetEvent(username));
    }
}
