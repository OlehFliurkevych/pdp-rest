package pdp.fliurkevych.rest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static pdp.fliurkevych.rest.hateoas.LinkBuilder.buildSelfLink;

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
import pdp.fliurkevych.rest.dto.EventList;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@RestController
@RequestMapping("/events")
public class EventController {

  private final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @PostMapping
  public ResponseEntity<Event> createEvent(@RequestBody Event event) {
    var created = eventService.createEvent(event);
    created.add(buildSelfLink(created.getId(), EventController.class));
    return ResponseEntity.ok(created);
  }

  @PutMapping
  public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
    var updated = eventService.updateEvent(event);
    updated.add(buildSelfLink(updated.getId(), EventController.class));
    return ResponseEntity.ok(updated);
  }

  @GetMapping("/{eventId}")
  public ResponseEntity<Event> getById(@PathVariable Long eventId) {
    var event = eventService.getEvent(eventId);
    event.add(buildSelfLink(event.getId(), EventController.class));
    return ResponseEntity.ok(event);
  }

  @DeleteMapping("/{eventId}")
  public ResponseEntity<String> delete(@PathVariable Long eventId) {
    return eventService.deleteEvent(eventId)
      ? ResponseEntity.ok(String.format("Successfully deleted event with id: [%s]", eventId))
      : ResponseEntity.ok(String.format("Failed to delete event with id: [%s]", eventId));
  }

  @GetMapping
  public ResponseEntity<EventList> getAllEvents() {
    var eventList = eventService.getAllEvents();
    if (!eventList.getEvents().isEmpty()) {
      for (Event event : eventList.getEvents()) {
        event.add(buildSelfLink(event.getId(), EventController.class));
      }
    }
    eventList.add(linkTo(methodOn(EventController.class).getAllEvents()).withSelfRel());
    return ResponseEntity.ok(eventList);
  }

  @GetMapping("/search")
  public ResponseEntity<EventList> getEventsByTitle(@RequestParam String title) {
    var eventList = eventService.getAllEventsByTitle(title);
    if (!eventList.getEvents().isEmpty()) {
      for (Event event : eventList.getEvents()) {
        event.add(buildSelfLink(event.getId(), EventController.class));
      }
    }
    eventList.add(linkTo(methodOn(EventController.class).getAllEvents()).withSelfRel());
    return ResponseEntity.ok(eventList);
  }

}
