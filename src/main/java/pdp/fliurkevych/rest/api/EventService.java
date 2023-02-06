package pdp.fliurkevych.rest.api;

import pdp.fliurkevych.rest.dto.EventDto;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
public interface EventService {

  EventDto createEvent();

  EventDto updateEvent(EventDto eventDto);

  EventDto getEvent(Long eventId);

  void deleteEvent(Long eventId);

  List<EventDto> getAllEvents();

  List<EventDto> getAllEventsByTitle(String title);
}
