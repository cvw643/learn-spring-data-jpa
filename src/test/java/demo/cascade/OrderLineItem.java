package demo.cascade;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author YQ.Huang
 */
@IdClass(OrderLineItem.Key.class)
@Entity
public class OrderLineItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private SalesOrder order;

    @Id
    private int itemId;

    private String product;

    OrderLineItem() {
    }

    public OrderLineItem(SalesOrder order, String product) {
        this.order = order;
        this.itemId = order.nextItemId();
        this.product = product;
    }

    public int getItemId() {
        return itemId;
    }

    public String getProduct() {
        return product;
    }

    public SalesOrder getOrder() {
        return order;
    }

    public void setOrder(SalesOrder order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLineItem that = (OrderLineItem) o;

        if (itemId != that.itemId) return false;
        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        int result = order != null ? order.hashCode() : 0;
        result = 31 * result + itemId;
        return result;
    }

    public static class Key implements Serializable {
        private int order;
        private int itemId;

        public int getOrder() {
            return order;
        }

        public Key setOrder(int order) {
            this.order = order;
            return this;
        }

        public int getItemId() {
            return itemId;
        }

        public Key setItemId(int itemId) {
            this.itemId = itemId;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (order != key.order) return false;
            return itemId == key.itemId;
        }

        @Override
        public int hashCode() {
            int result = order;
            result = 31 * result + itemId;
            return result;
        }
    }
}
