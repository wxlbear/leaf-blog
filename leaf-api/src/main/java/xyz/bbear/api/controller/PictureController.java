package xyz.bbear.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.bbear.domain.Picture;
import xyz.bbear.infra.service.PictureService;

/**
 * PictureController.
 *
 * @author xiongliu wu 2019-03-31 20:18
 */
@RestController
@RequestMapping("/pictures")
public class PictureController extends AbstractRestController<Picture, PictureService> {

  public PictureController(PictureService service) {
    super(service);
  }

  @Override
  public IPage<Picture> pager(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      Picture param) {
    return this.service.pager(new Page<>(page, size), param);
  }

  @GetMapping("echo")
  public String echo(@RequestParam(required = false) String echo) {
    return echo;
  }
}
