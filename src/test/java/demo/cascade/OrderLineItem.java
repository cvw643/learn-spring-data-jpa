package demo.cascade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author YQ.Huang
 */
@Entity
public class OrderLineItem {
    @Id
    @GeneratedValue
    private int id;

    private String product;

    OrderLineItem() {
    }

    public OrderLineItem(String product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }
}
