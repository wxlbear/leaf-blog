package xyz.bbear.infra.client;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketReferer;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * OssClient.
 *
 * @author xiongliu wu 2019-04-16 18:45
 */
@Slf4j
@Component
public class OssClient {

  private static final String OSS_KEY = "LTAI9UTBpR7rcr7R";
  private static final String OSS_SECRET = "lctVkO2haNg86XUhqQ7gUtehsVtGkt";
  private static final String END_POINT = "http://oss-cn-beijing.aliyuncs.com";
  private static final String BUCKET_NAME = "bear-picture";

  /**
   * upload picture to oss.
   *
   * @param path path
   * @param fin fin
   * @return picture url
   * @throws Exception upload exception
   */
  public String upload(String path, InputStream fin) throws Exception {

    List<String> refererList = new ArrayList<>();
    refererList.add("https://*.console.aliyun.com");
    refererList.add("http://bbear.xyz");
    refererList.add("http://oss-cn-beijing.aliyuncs.com");
    refererList.add("https://oss-cn-beijing.aliyuncs.com");

    OSSClient ossClient = new OSSClient(END_POINT, OSS_KEY, OSS_SECRET);
    BucketReferer br = new BucketReferer(true, refererList);
    ossClient.setBucketReferer(BUCKET_NAME, br);

    ossClient.putObject(BUCKET_NAME, path, fin);

    ossClient.shutdown();
    log.debug("url -> {}", END_POINT + "/" + path);
    return null;
  }

  public void remove(String objectName) {
    OSSClient ossClient = new OSSClient(END_POINT, OSS_KEY, OSS_SECRET);
    ossClient.deleteObject(BUCKET_NAME, objectName);
  }
}
