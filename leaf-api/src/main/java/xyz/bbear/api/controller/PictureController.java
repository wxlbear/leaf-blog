package xyz.bbear.api.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.bbear.api.model.ApiResult;
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

  @Override
  public ApiResult pager(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      Picture param) {
    return ApiResult.resultWith(this.service.pager(new Page<>(page, size), param));
  }
}
