package xyz.bbear.leaf.crawler.bear.v2.component.impl;

import xyz.bbear.leaf.crawler.bear.v2.component.IPipeline;

/**
 * ConsolePipeline.
 *
 * @author xiongliu wu 2019-05-29 18:43
 */
public class ConsolePipeline implements IPipeline {

    @Override
    public void pipe(Object result) {
        System.out.println("pipe:"+ result);
    }
}
