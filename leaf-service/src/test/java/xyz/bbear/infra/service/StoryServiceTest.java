package xyz.bbear.infra.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Assert;
import org.junit.Test;
import xyz.bbear.domain.Story;
import xyz.bbear.infra.CommonTestBase;

/**
 * StoryServiceTest.
 *
 * @author xiongliu wu 2019-04-18 14:00
 */
public class StoryServiceTest extends CommonTestBase {

  @Autowired private StoryService storyService;

  @Test
  public void testGet() {

    Story mock = mockStory();
    this.storyService.save(mock);
    Assert.assertNotNull(mock.getId());
    Story story = this.storyService.getById(mock.getId());
    Assert.assertNotNull(story);
  }
}
