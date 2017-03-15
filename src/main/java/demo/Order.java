package demo;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

/**
 * @author YQ.Huang
 */
public class Order {

    public static Id id(String appId, String orderNo) {
        return new Id(appId, orderNo);
    }

    public static class Id implements Serializable {
        private final String appId;
        private final String orderNo;

        public Id(String appId, String orderNo) {
            this.appId = appId;
            this.orderNo = orderNo;
        }
    }

    private Id id;
    private int amount;

    public Order() {
    }

    public Order(String appId, String orderNo, int amount) {
        this.id = new Id(appId, orderNo);
        this.amount = amount;
    }

    public Order(int amount) {
        this.id = null;
        this.amount = amount;
    }

    public Id getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @DomainEvents
    public Collection<Object> domainEvents() {
        System.out.println("Publishing domain events");
        return Collections.singleton("domain event");
    }

    @AfterDomainEventPublication
    public void afterDomainEventPublication() {
        System.out.println("Published domain events");
    }
}
