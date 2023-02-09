package pdp.fliurkevych.rest.api;

import pdp.fliurkevych.rest.dto.Event;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
public interface EventService {

  /**
   * Creates new instance of {@link Event}
   *
   * @param event new instance of {@link Event}
   * @return created instance of {@link Event}
   */
  Event createEvent(Event event);

  /**
   * Updates instance of {@link Event}
   *
   * @param event instance of {@link Event}
   * @return updated instance of {@link Event}
   */
  Event updateEvent(Event event);

  /**
   * Gets instance of {@link Event} by id
   *
   * @param eventId identifier of {@link Event}
   * @return instance of {@link Event}
   */
  Event getEvent(Long eventId);

  /**
   * Deletes instance of {@link Event} by id
   *
   * @param eventId identifier of {@link Event}
   * @return true if instance of {@link Event} deleted, 
   * false if instance of {@link Event}  don't deleted 
   */
  boolean deleteEvent(Long eventId);

  /**
   * Gets all instances of {@link Event}
   *
   * @return collection of {@link Event}
   */
  List<Event> getAllEvents();

  /**
   * Gets all instances of {@link Event} by title
   *
   * @param title title
   * @return collection of {@link Event} by title
   */
  List<Event> getAllEventsByTitle(String title);
}
