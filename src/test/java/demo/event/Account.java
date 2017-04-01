package demo.event;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author YQ.Huang
 */
@Entity
public class Account {
    @Id
    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!Objects.equals(oldPassword, this.password)) {
            throw new RuntimeException("Incorrect password!");
        }
        this.password = newPassword;
    }
}
