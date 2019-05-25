package xyz.bbear.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.bbear.api.cache.CacheService;

/**
 * CacheController.
 *
 * @author xiongliu wu 2019-04-02 00:27
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

  @Autowired private CacheService cacheService;

  @GetMapping("get")
  public String get(String name) {
    return this.cacheService.get(name);
  }

  @GetMapping("delete")
  public String delete(String name) {
    this.cacheService.delete(name);
    return "deleted";
  }
}
