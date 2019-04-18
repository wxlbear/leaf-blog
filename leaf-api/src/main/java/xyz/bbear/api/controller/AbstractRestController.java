package xyz.bbear.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import xyz.bbear.common.enums.StatusEnum;
import xyz.bbear.domain.BaseModel;

/**
 * AbstractRestController.
 *
 * @author xiongliu wu 2019/1/2 20:42
 */
public abstract class AbstractRestController<T extends BaseModel, S extends IService<T>> {

  protected S service;

  public AbstractRestController(S service) {
    this.service = service;
  }

  /**
   * create.
   *
   * @param t t
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody T t) {
    t.setCreatedAt(new Date());
    t.setUpdatedAt(new Date());
    t.setStatus(StatusEnum.active.code);
    service.save(t);
  }

  /**
   * update.
   *
   * @param t t
   */
  @PutMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void update(@RequestBody T t) {
    t.setUpdatedAt(new Date());
    service.updateById(t);
  }

  /**
   * delete.
   *
   * @param id id
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Serializable id) {
    service.removeById(id);
  }

  /**
   * get.
   *
   * @param id id
   * @return T t
   */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public T get(@PathVariable Serializable id) {
    return service.getById(id);
  }

  /**
   * pager.
   *
   * @param page page
   * @param size size
   * @param param param
   * @return IPage
   */
  @GetMapping("/pager")
  @ResponseStatus(HttpStatus.OK)
  public IPage<T> pager(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      T param) {
    Page<T> pager = new Page<>(page, size);
    QueryWrapper<T> queryWrapper = new QueryWrapper<>(param);
    return this.service.page(pager, queryWrapper);
  }
}
