package demo.inheritance;

import javax.persistence.Entity;

/**
 * @author YQ.Huang
 */
@Entity
public class Manager extends FullTimeEmployee {
    private String department;

    public String getDepartment() {
        return department;
    }
}
