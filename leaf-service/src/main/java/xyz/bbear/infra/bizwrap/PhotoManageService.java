package xyz.bbear.infra.bizwrap;

import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.bbear.domain.Picture;
import xyz.bbear.infra.client.OssClient;
import xyz.bbear.infra.service.PictureService;

/**
 * PhotoManageService.
 *
 * @author xiongliu wu 2019-04-18 15:46
 */
@Service
public class PhotoManageService {

  @Autowired private OssClient ossClient;

  @Autowired private PictureService pictureService;

  /** 上传图片到oss，并且db新增一条记录. */
  @Transactional
  public void upload(Picture picture, InputStream picStream) throws Exception {
    this.pictureService.save(picture);
    String path =
        String.format("%s/%s.%s", picture.getPath(), picture.getOssName(), picture.getFormat());
    this.ossClient.upload(path, picStream);
  }
}
