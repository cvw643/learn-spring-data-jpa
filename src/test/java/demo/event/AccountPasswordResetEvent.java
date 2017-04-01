package demo.event;

/**
 * @author YQ.Huang
 */
public class AccountPasswordResetEvent {
    private String username;

    public AccountPasswordResetEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "AccountPasswordChangedEvent{" +
                "username='" + username + '\'' +
                '}';
    }
}
