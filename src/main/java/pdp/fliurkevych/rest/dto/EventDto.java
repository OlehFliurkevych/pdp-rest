package pdp.fliurkevych.rest.dto;

import lombok.Data;
import pdp.fliurkevych.rest.enums.EventType;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author Oleh Fliurkevych
 */
@Data
public class EventDto {

  private Long id;
  private String title;
  private BigDecimal place;
  private String speaker;
  private EventType eventType;
  private Date dateTime;

}
