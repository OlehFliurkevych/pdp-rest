package pdp.fliurkevych.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.fliurkevych.rest.dto.Event;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

  List<Event> findAllByTitle(String title);

}
