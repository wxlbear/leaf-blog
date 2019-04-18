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

  /** 上次图片到，并且新增一条记录. */
  @Transactional
  public void upload(Picture picture, InputStream picStream) throws Exception {
    this.pictureService.save(picture);
    String path = String.format("test/%s.%s", picture.getName(), picture.getFormat());
    this.ossClient.upload(path, picStream);
  }

  /** 删除oss上的图片，并且logic删除一条记录. */
  @Transactional
  public void delete(long id, String objectName) {
    this.pictureService.removeById(id);
    this.ossClient.remove(objectName);
  }
}
