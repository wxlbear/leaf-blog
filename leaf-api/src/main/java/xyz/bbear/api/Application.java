package xyz.bbear.api;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application.
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
}
