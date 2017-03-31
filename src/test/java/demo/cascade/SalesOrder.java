package demo.cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YQ.Huang
 */
@Entity
public class SalesOrder {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderLineItem> items = new HashSet<>();

    private Date createdAt = new Date();

    public SalesOrder() {
    }

    public void addItem(String product) {
        items.add(new OrderLineItem(product));
    }

    public Set<OrderLineItem> getItems() {
        return items;
    }

    public int getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
