package ds.dsknowledges.repository;

import ds.dsknowledges.model.Emailing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailingRepository extends JpaRepository<Emailing, Long> {
}
