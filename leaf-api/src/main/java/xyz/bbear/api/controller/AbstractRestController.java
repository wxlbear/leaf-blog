package xyz.bbear.api.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import xyz.bbear.api.model.ApiResult;

/**
 * AbstractRestController.
 *
 * @author xiongliu wu 2019/1/2 20:42
 */
public abstract class AbstractRestController<T, S extends IService<T>> {

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
}
