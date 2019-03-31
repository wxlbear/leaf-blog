package xyz.bbear.infra.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.bbear.infra.CommonTestBase;

/**
 * LeafServiceTest.
 *
 * @author xiongliu wu 2019-03-31 18:23
 */
public class LeafServiceTest extends CommonTestBase {

  @Autowired private LeafService leafService;

  @Test
  public void testFind() {
    this.leafService.getById(1);
  }
}
