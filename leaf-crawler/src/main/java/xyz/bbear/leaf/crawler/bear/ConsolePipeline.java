package xyz.bbear.leaf.crawler.bear;

/**
 * ConsolePipeline.
 *
 * @author xiongliu wu 2019-05-08 15:34
 */
public class ConsolePipeline implements Pipeline {

  @Override
  public void pipeline(Result result) {
    System.out.println("pipeline result: " + result);
  }
}
