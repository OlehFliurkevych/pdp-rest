package pdp.fliurkevych.rest.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pdp.fliurkevych.rest.api.EventService;
import pdp.fliurkevych.rest.dto.EventDto;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Service
public class EventServiceImpl implements EventService {

  @Override
  public EventDto createEvent() {
    return null;
  }

  @Override
  public EventDto updateEvent(EventDto eventDto) {
    return null;
  }

  @Override
  public EventDto getEvent(Long eventId) {
    return null;
  }

  @Override
  public void deleteEvent(Long eventId) {

  }

  @Override
  public List<EventDto> getAllEvents() {
    return null;
  }

  @Override
  public List<EventDto> getAllEventsByTitle(String title) {
    return null;
  }
}
