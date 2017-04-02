package demo.bypass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author YQ.Huang
 */
public interface ToDoRepo extends JpaRepository<ToDo, Integer> {

    @Modifying//(clearAutomatically = true)
    @Query("update ToDo t set t.completed=true where t.id=:id")
    void bypassComplete(@Param("id") int id);
}
