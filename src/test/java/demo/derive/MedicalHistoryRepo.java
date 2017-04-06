package demo.derive;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author YQ.Huang
 */
public interface MedicalHistoryRepo extends JpaRepository<MedicalHistory, String> {
}
