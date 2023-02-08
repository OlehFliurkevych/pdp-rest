package pdp.fliurkevych.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pdp.fliurkevych.rest.api.EventService;
import pdp.fliurkevych.rest.dto.Event;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@RestController
@RequestMapping("/events")
public class EventServiceController {

  private final EventService eventService;

  public EventServiceController(EventService eventService) {
    this.eventService = eventService;
  }

  @PostMapping("/")
  public ResponseEntity<Event> createEvent(@RequestBody Event event) {
    return ResponseEntity.ok(eventService.createEvent(event));
  }

  @PutMapping("/")
  public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
    return ResponseEntity.ok(eventService.updateEvent(event));
  }

  @GetMapping("/{eventId}")
  public ResponseEntity<Event> getById(@PathVariable Long eventId) {
    return ResponseEntity.ok(eventService.getEvent(eventId));
  }

  @DeleteMapping("/{eventId}")
  public ResponseEntity<String> delete(@PathVariable Long eventId) {
    return eventService.deleteEvent(eventId)
      ? ResponseEntity.ok(String.format("Successfully deleted event with id: [%s]", eventId))
      : ResponseEntity.ok(String.format("Failed to delete event with id: [%s]", eventId));
  }

  @GetMapping
  public ResponseEntity<List<Event>> getAllEvents() {
    return ResponseEntity.ok(eventService.getAllEvents());
  }

  @GetMapping("/search")
  public ResponseEntity<List<Event>> getEventsByTitle(@RequestParam String title) {
    return ResponseEntity.ok(eventService.getAllEventsByTitle(title));
  }

}
