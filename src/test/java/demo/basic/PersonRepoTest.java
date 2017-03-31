package demo.basic;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepoTest {

    @Autowired
    private PersonRepo personRepository;

    @Test
    public void simple() throws Exception {
        Person person = new Person("cvw643", "hyq@payingcloud.cn", DateUtils.parseDate("1979-05-22", "yyyy-MM-dd"),"1", "2");
        person.setAddress("China", "Beijing", "ChaoYang", "RiTan");
        person.addCourse("1", "Java");
        person.addCourse("2", "Python");
        personRepository.save(person);

        Person person1 = personRepository.findOne(person.getId());
        assertEquals(person.getName(), person1.getName());
        assertEquals(person.getAddress(), person1.getAddress());
        assertEquals(person.getPhoneNumbers(), person1.getPhoneNumbers());
        assertEquals(person.getCourses(), person1.getCourses());
    }

    @Test
    public void compareSet() throws Exception {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Collections.addAll(set1, "1", "2");
        Collections.addAll(set2, "1", "2");
        assertEquals(set1, set2);
        Collections.addAll(set1, "1", "2");
        Collections.addAll(set2, "2", "1");
        assertEquals(set1, set2);
    }

    @Test
    public void compareList() throws Exception {
        List<String> list1 = Arrays.asList("1", "2");
        List<String> list2 = Arrays.asList("1", "2");
        assertEquals(list1, list2);

        list1 = Arrays.asList("1", "2");
        list2 = Arrays.asList("2", "1");
        assertNotEquals(list1, list2);
    }
}