package xyz.bbear.api.cache;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import org.springframework.stereotype.Service;

/**
 * CacheService.
 *
 * @author xiongliu wu 2019-04-02 00:23
 */
@Service
public class CacheService {

  @Cached(name = "cache", key = "#name", cacheType = CacheType.REMOTE)
  public String get(String name) {
    return "ok";
  }

  @CacheInvalidate(name = "get", key = "#name+.*")
  public void delete(String name) {}
}
