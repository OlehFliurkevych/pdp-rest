package pdp.fliurkevych.rest.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

/**
 * @author Oleh Fliurkevych
 */
public final class LinkBuilder {

  public static Link buildSelfLink(Long id, Class<?> controller) {
    return WebMvcLinkBuilder.linkTo(controller).slash(id).withSelfRel();
  }

}
