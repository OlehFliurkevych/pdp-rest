package pdp.fliurkevych.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EventList extends RepresentationModel<EventList> implements Serializable {

  private List<Event> events;

}
