package xyz.bbear.infra;

import java.util.Date;
import java.util.UUID;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import xyz.bbear.common.enums.StatusEnum;
import xyz.bbear.domain.Picture;
import xyz.bbear.domain.Story;
import xyz.bbear.infra.config.TestConfig;

/**
 * CommonTestBase.
 *
 * @author xiongliu wu 2019-03-31 18:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = TestConfig.class)
@ActiveProfiles("testing")
public class CommonTestBase {

  protected Story mockStory() {
    Story story = new Story();
    story
        .setContent(UUID.randomUUID().toString())
        .setTitle(UUID.randomUUID().toString().substring(0, 10));
    story.setUpdatedAt(new Date());
    story.setCreatedAt(new Date());
    story.setStatus(StatusEnum.active.code);
    return story;
  }

  protected Picture mockPicture() {
    Picture mock = new Picture();
    mock.setName(UUID.randomUUID().toString().substring(10));
    mock.setFormat("jpg");
    mock.setUpdatedAt(new Date());
    mock.setCreatedAt(new Date());
    mock.setStatus(StatusEnum.active.code);
    return mock;
  }
}
