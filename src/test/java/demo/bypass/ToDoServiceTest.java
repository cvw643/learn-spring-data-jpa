package demo.bypass;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author YQ.Huang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoService toDoService;
    @Autowired
    private ToDoRepo toDoRepo;

    @Before
    public void setUp() throws Exception {
        toDoService.setUp();
    }

    @Test
    public void case1() throws Exception {
        ToDo toDo1 = toDoService.get(1);
        assertEquals("Eat", toDo1.getTitle());
        toDoService.updateTitle(toDo1.getId(), "Dance");
        toDo1 = toDoService.get(toDo1.getId());
        assertEquals("Dance", toDo1.getTitle());
        assertEquals(false, toDo1.isCompleted());

        toDoService.bypassComplete(toDo1);
        toDo1 = toDoService.get(toDo1.getId());
        assertEquals("Dance", toDo1.getTitle());
        assertEquals(true, toDo1.isCompleted());
    }

}