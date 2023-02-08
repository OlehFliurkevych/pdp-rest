package pdp.fliurkevych.rest.api;

import pdp.fliurkevych.rest.dto.Event;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
public interface EventService {

  Event createEvent(Event event);

  Event updateEvent(Event event);

  Event getEvent(Long eventId);

  boolean deleteEvent(Long eventId);

  List<Event> getAllEvents();

  List<Event> getAllEventsByTitle(String title);
}
