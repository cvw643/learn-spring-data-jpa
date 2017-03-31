package demo.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void case1() throws Exception {
        Course course = new Course("OOA");
        courseRepo.save(course);
    }

    @Test
    public void case2() throws Exception {
        Course course = courseRepo.findOne(1);
        course.setDescription("Object oriented design");
        courseRepo.save(course);
    }
}