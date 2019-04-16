package xyz.bbear.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Date;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.bbear.api.model.ApiResult;
import xyz.bbear.common.enums.StatusEnum;
import xyz.bbear.domain.BaseModel;

/**
 * AbstractRestController.
 *
 * @author xiongliu wu 2019/1/2 20:42
 */
public abstract class AbstractRestController<T extends BaseModel, S extends IService<T>> {

  private S service;

  public AbstractRestController(S service) {
    this.service = service;
  }

  /**
   * create.
   *
   * @param t t
   * @return ApiResult
   */
  @PostMapping
  public ApiResult create(T t) {
    t.setCreatedAt(new Date());
    t.setUpdatedAt(new Date());
    t.setStatus(StatusEnum.active.code);
    service.save(t);
    return new ApiResult();
  }

  /**
   * update.
   *
   * @param t t
   * @return ApiResult
   */
  @PutMapping
  public ApiResult update(T t) {
    t.setUpdatedAt(new Date());
    service.updateById(t);
    return new ApiResult();
  }

  /**
   * delete.
   *
   * @param id id
   * @return ApiResult
   */
  @DeleteMapping("/{id}")
  public ApiResult delete(@PathVariable Serializable id) {
    service.removeById(id);
    return new ApiResult();
  }

  /**
   * get.
   *
   * @param id id
   * @return ApiResult
   */
  @GetMapping("/{id}")
  public ApiResult get(@PathVariable Serializable id) {
    T entity = service.getById(id);
    return ApiResult.resultWith(entity);
  }

  /**
   * pager.
   *
   * @param page page
   * @param size size
   * @param param param
   * @return ApiResult
   */
  @GetMapping("/pager")
  public ApiResult pager(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      T param) {
    Page<T> pager = new Page<>(page, size);

    QueryWrapper<T> queryWrapper = new QueryWrapper<>(param);
    return ApiResult.resultWith(this.service.page(pager, queryWrapper));
  }
}
