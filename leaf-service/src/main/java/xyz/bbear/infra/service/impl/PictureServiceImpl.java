package xyz.bbear.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.bbear.domain.Picture;
import xyz.bbear.infra.client.OssClient;
import xyz.bbear.infra.mapper.PictureMapper;
import xyz.bbear.infra.service.PictureService;

@Slf4j
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture>
    implements PictureService {

  @Autowired private OssClient ossClient;

  @Override
  public void upload(String path, String name, InputStream fin) {
    try {
      this.ossClient.upload(path + "/" + name, fin);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
}
