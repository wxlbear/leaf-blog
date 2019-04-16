package xyz.bbear.infra.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.InputStream;
import xyz.bbear.domain.Picture;

public interface PictureService extends IService<Picture> {

  /**
   * 分页查询.
   *
   * @param page page
   * @param param param
   * @return IPage
   */
  IPage<Picture> pager(Page<Picture> page, Picture param);

  /**
   * upload picture to oss.
   *
   * @param path path
   * @param name name
   * @param fin fin
   */
  void upload(String path, String name, InputStream fin);
}
