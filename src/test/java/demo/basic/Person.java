package demo.basic;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.*;

/**
 * @author YQ.Huang
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> phoneNumbers;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> courses;

    private Address address;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    Person() {
    }

    public Person(String name, String email, Date birthday, String... phoneNumbers) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.phoneNumbers = new LinkedHashSet<>();
        Collections.addAll(this.phoneNumbers, phoneNumbers);
    }

    public void addPhoneNumber(String phoneNumber) {
        if (this.phoneNumbers == null)
            this.phoneNumbers = new LinkedHashSet<>();
        phoneNumbers.add(phoneNumber);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String country, String province, String city, String street) {
        address = new Address();
        address.setCountry(country);
        address.setProvince(province);
        address.setCity(city);
        address.setStreet(street);
    }

    public void addCourse(String code, String name) {
        if (courses == null)
            courses = new HashMap<>();
        courses.put(code, name);
    }

    public Map<String, String> getCourses() {
        return courses;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }
}
