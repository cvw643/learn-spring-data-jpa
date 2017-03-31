package demo.inheritance;

import javax.persistence.*;

/**
 * @author YQ.Huang
 */
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // case1
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // case2
@Inheritance(strategy = InheritanceType.JOINED) // case3
@Entity
//@MappedSuperclass
public abstract class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE) // case2
    @GeneratedValue
    private int id;

    private String name;

    Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }
}
