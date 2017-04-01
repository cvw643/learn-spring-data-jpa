package demo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author YQ.Huang
 */
@Component
public class AccountEventHandler {

    @EventListener
    public void onPasswordChanged(AccountPasswordResetEvent event) {
        System.out.println("AccountEventHandler.onPasswordChanged");
        System.out.println("event = [" + event + "]");
    }
}
