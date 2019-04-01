package xyz.bbear.infra;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import xyz.bbear.infra.config.TestConfig;

/**
 * CommonTestBase.
 *
 * @author xiongliu wu 2019-03-31 18:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = TestConfig.class)
@ActiveProfiles("testing")
public class CommonTestBase {}
