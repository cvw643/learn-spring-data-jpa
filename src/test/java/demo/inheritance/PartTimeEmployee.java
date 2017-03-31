package demo.inheritance;

import javax.persistence.Entity;

/**
 * @author YQ.Huang
 */
@Entity
public class PartTimeEmployee extends Employee {

    private int wage;

    PartTimeEmployee() {
    }

    public PartTimeEmployee(String name) {
        super(name);
    }

    public int getWage() {
        return wage;
    }

    public PartTimeEmployee setWage(int wage) {
        this.wage = wage;
        return this;
    }
}
