package xyz.bbear.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Application ApiApplication.
 *
 * @author xiongliu wu 2019-03-30 22:07
 */
@SpringBootApplication(scanBasePackages = {"xyz.bbear"})
@MapperScan("xyz.bbear.*.mapper")
@EnableMethodCache(basePackages = "xyz.bbear.api.cache")
@EnableCreateCacheAnnotation
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  /**
   * mybatis-plus 分页插件.
   *
   * @return PaginationInterceptor
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    return paginationInterceptor;
  }

  /**
   * logic delete plugin.
   *
   * @return ISqlInjector
   */
  @Bean
  public ISqlInjector sqlInjector() {
    return new LogicSqlInjector();
  }
}
