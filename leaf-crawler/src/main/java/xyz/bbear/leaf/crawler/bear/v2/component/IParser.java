package xyz.bbear.leaf.crawler.bear.v2.component;

import xyz.bbear.leaf.crawler.bear.v2.model.FieldConfig;

/**
 * Parser 解析组件.
 *
 * @author xiongliu wu 2019-05-29 16:43
 */
public interface IParser {
  String parse(Page page, FieldConfig fieldConfig);
}
