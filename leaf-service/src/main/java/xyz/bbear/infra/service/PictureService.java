package xyz.bbear.infra.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.io.InputStream;
import xyz.bbear.domain.Picture;

public interface PictureService extends IService<Picture> {

  void upload(String path, String name, InputStream fin);
}
