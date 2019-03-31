package xyz.bbear.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.bbear.domain.Picture;
import xyz.bbear.infra.service.PictureService;

/**
 * PictureController.
 *
 * @author xiongliu wu 2019-03-31 20:18
 */
@RestController
@RequestMapping("/picture")
public class PictureController extends AbstractRestController<Picture, PictureService> {

  public PictureController(PictureService service) {
    super(service);
  }
}
