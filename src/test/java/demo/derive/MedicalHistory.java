package demo.derive;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author YQ.Huang
 */
@Entity
public class MedicalHistory implements Serializable {
    @Id
    private String id;

    @MapsId
    @OneToOne
    private Patient patient;

    private Date time;

    public Patient getPatient() {
        return patient;
    }

    public MedicalHistory setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public MedicalHistory setTime(Date time) {
        this.time = time;
        return this;
    }
}
