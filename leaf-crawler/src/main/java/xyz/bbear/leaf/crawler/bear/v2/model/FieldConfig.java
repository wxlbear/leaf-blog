package xyz.bbear.leaf.crawler.bear.v2.model;

import java.util.List;
import lombok.Data;
import xyz.bbear.leaf.crawler.bear.v2.enums.SelectorType;

@Data
public class FieldConfig {

  /** 字段名. */
  private String name;

  /** 解析类型. */
  private SelectorType selectorType;

  /** 选择器. */
  private String selector;

  /** 是否是集合. */
  private boolean repeated;

  /** 子字段配置. */
  private List<FieldConfig> children;
}
