package pdp.fliurkevych.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import pdp.fliurkevych.rest.enums.EventType;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Oleh Fliurkevych
 */
@Table
@Setter
@Getter
@Entity(name = "event")
@AllArgsConstructor
@NoArgsConstructor
public class Event extends RepresentationModel<Event> implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Integer place;
  private String speaker;
  private EventType eventType;
  private Date dateTime;

}
