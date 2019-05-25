package xyz.bbear.infra.bizwrap;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Test;
import xyz.bbear.infra.CommonTestBase;

/**
 * PhotoManageServiceTest.
 *
 * @author xiongliu wu 2019-04-18 17:28
 */
public class PhotoManageServiceTest extends CommonTestBase {

  @Autowired private PhotoManageService photoManageService;

  @Test
  public void testUpload() {
    InputStream fin = PhotoManageServiceTest.class.getResourceAsStream("/test.jpeg");
    try {
      this.photoManageService.upload(mockPicture(), fin);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
