package pdp.fliurkevych.rest.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pdp.fliurkevych.rest.api.EventService;
import pdp.fliurkevych.rest.dto.Event;
import pdp.fliurkevych.rest.repository.EventRepository;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Service
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;

  public EventServiceImpl(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Event createEvent(Event event) {
    log.info("Saving new event");
    var saved = eventRepository.save(event);
    log.info("Saved new event with id: [{}]", event.getId());
    return saved;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Event updateEvent(Event event) {
    log.info("Updating event with id: [{}]", event.getId());
    var updated = eventRepository.save(event);
    log.info("Updated event with id: [{}]", event.getId());
    return updated;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Event getEvent(Long eventId) {
    log.info("Fetching event with id: [{}]", eventId);
    var event = eventRepository.findById(eventId)
      .orElseThrow(() -> new RuntimeException(
        String.format("Not found event with id: [%s]", eventId)));
    log.info("Fetched event with id: [{}]", event.getId());
    return event;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean deleteEvent(Long eventId) {
    log.info("Deleting event with id: [{}]", eventId);
    eventRepository.deleteById(eventId);
    if (!eventRepository.existsById(eventId)) {
      log.info("Deleted event with id: [{}]", eventId);
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Event> getAllEvents() {
    log.info("Fetching all events");
    var events = eventRepository.findAll();
    log.info("Fetched [{}] records of event", events.size());
    return events;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Event> getAllEventsByTitle(String title) {
    log.info("Fetching events by title: [{}]", title);
    var events = eventRepository.findAllByTitle(title);
    log.info("Fetched [{}] records of event by title: [{}]", events.size(), title);
    return events;
  }
}
