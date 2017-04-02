package demo.bypass;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author YQ.Huang
 */
@Service
public class ToDoService {
    private final ToDoRepo toDoRepo;

    public ToDoService(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    @Transactional
    public void setUp() throws Exception {
        toDoRepo.deleteAllInBatch();
        Collection<ToDo> data = Arrays.asList(
                new ToDo(1, "Eat")
        );
        toDoRepo.save(data);
        toDoRepo.flush();
    }

    @Transactional
    public void updateTitle(int id, String title) {
        ToDo toDo = toDoRepo.findOne(id);
        toDo.updateTitle(title);
        toDoRepo.save(toDo);
    }

    @Transactional
    public void bypassComplete(ToDo toDo) {
        ToDo toDo1 = get(toDo.getId());
        assertEquals(false, toDo1.isCompleted());

        toDoRepo.bypassComplete(toDo.getId());

        toDo1 = get(toDo.getId());
        assertEquals("stale read", false, toDo1.isCompleted());
    }

    public ToDo get(int id) {
        return toDoRepo.findOne(id);
    }

}
