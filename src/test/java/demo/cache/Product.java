package demo.cache;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author YQ.Huang
 */
@Cacheable
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
