package demo.cascade;

import javax.persistence.*;
import java.util.Date;
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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<OrderLineItem> items = new HashSet<>();

    private Date createdAt = new Date();

    public SalesOrder() {
    }

    public void addItem(String product) {
        OrderLineItem orderLineItem = new OrderLineItem(this, product);
        items.add(orderLineItem);
    }

    public void clearItems() {
        for (OrderLineItem item:items) {
            item.resetOrder();
        }
        items.clear();
    }

    public int nextItemId() {
        return items.size() + 1;
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
