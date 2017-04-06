package demo.derive;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author YQ.Huang
 */
@Entity
public class Patient implements Serializable {
    @Id
    private String ssn;
    private String name;

    public String getSsn() {
        return ssn;
    }

    public Patient setSsn(String ssn) {
        this.ssn = ssn;
        return this;
    }

    public String getName() {
        return name;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }
}
