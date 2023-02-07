package pdp.fliurkevych.rest.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import pdp.fliurkevych.rest.enums.EventType;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author Oleh Fliurkevych
 */
@Data
@Entity
@AllArgsConstructor
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private BigDecimal place;
  private String speaker;
  private EventType eventType;
  private Date dateTime;

}
