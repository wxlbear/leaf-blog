package xyz.bbear.leaf.crawler.bear.v2.component.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.bbear.leaf.crawler.bear.v2.model.FieldConfig;

public class JsonParser {

  public Map<String, Object> parser(Object root, List<FieldConfig> configList) {

    Map<String, Object> resMap = new HashMap<>();

    System.out.println("----root begin---");
    System.out.println(root);
    System.out.println("----root end---");

    for (FieldConfig fieldConfig : configList) {
      if (fieldConfig.getChildren() != null && fieldConfig.getChildren().size() > 0) {
        Object data = parseObject(root, fieldConfig.getSelector());
        if (data == null) {
          return null;
        }
        if (fieldConfig.isRepeated()) { // 表面是数组
          System.out.println(fieldConfig.getName());
          List<Map<String, Object>> resultList = new ArrayList<>();

          JSONArray jsonArray = (JSONArray) data;
          for (Object item : jsonArray) {
            Map<String, Object> parser = parser(item, fieldConfig.getChildren());
            resultList.add(parser);
          }
          resMap.put(fieldConfig.getName(), resultList);
        } else {
          Map<String, Object> parser = parser(data, fieldConfig.getChildren());
          resMap.put(fieldConfig.getName(), parser);
          System.out.println("---------parser begin------");
          System.out.println(data);
          System.out.println(parser);
          System.out.println("---------parser end------");
        }

      } else {
        resMap.put(fieldConfig.getName(), parseObject(root, fieldConfig.getSelector()));
      }
    }
    return resMap;
  }

  public Object parseObject(Object data, String path) {
    Object result = JSONPath.eval(data, path);
    return result;
  }
}
