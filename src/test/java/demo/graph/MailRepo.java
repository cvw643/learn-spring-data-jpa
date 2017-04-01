package demo.graph;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YQ.Huang
 */
@Repository
public interface MailRepo extends JpaRepository<Mail, Integer> {

    @EntityGraph(value = "mail.full", type = EntityGraph.EntityGraphType.FETCH)
    Mail findById(int id);

    MailSubject findMailById(int id);

}
