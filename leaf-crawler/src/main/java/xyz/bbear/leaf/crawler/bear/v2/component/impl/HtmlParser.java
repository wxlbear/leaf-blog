package xyz.bbear.leaf.crawler.bear.v2.component.impl;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.seimicrawler.xpath.JXDocument;
import org.springframework.util.CollectionUtils;
import xyz.bbear.leaf.crawler.bear.v2.model.FieldConfig;

public class HtmlParser {

  public Map<String, Object> parser(Object content, List<FieldConfig> configList) {
    Map<String, Object> resMap = new HashMap<>();
    for (FieldConfig fieldConfig : configList) {

      if (content == null) {
        return null;
      }

      if (fieldConfig.isRepeated() && CollectionUtils.isEmpty(fieldConfig.getChildren())) {
        List<Object> list = parseArray(content.toString(), fieldConfig.getSelector());
        resMap.put(fieldConfig.getName(), list);

      } else if (fieldConfig.isRepeated() && !CollectionUtils.isEmpty(fieldConfig.getChildren())) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        List<Object> list = parseArray(content.toString(), fieldConfig.getSelector());
        System.out.println(list);

        for (Object item : list) {
          Map<String, Object> parser = parser(item, fieldConfig.getChildren());
          resultList.add(parser);
        }
        resMap.put(fieldConfig.getName(), resultList);

      } else if (!fieldConfig.isRepeated() && CollectionUtils.isEmpty(fieldConfig.getChildren())) {
        resMap.put(fieldConfig.getName(), parseObject(content, fieldConfig.getSelector()));
      } else if (!fieldConfig.isRepeated()
          && !CollectionUtils.isEmpty(fieldConfig.getChildren())) { // 不合法

      }
    }
    return resMap;
  }

  private Object parseObject(Object data, String selector) {
    JXDocument jxDocument = JXDocument.create(data.toString());
    return jxDocument.selOne(selector);
  }

  private List<Object> parseArray(String data, String selector) {
    JXDocument jxDocument = JXDocument.create(data);
    return jxDocument.sel(selector);
  }

  public static String configStr =
      "[{\n"
          + "\t\"name\": \"list\",\n"
          + "\t\"selector\": \"//ul/li\",\n"
          + "\t\"repeated\": true,\n"
          + "\t\"children\": [{\n"
          + "\t\t\"name\": \"span\",\n"
          + "\t\t\"selector\": \"//span/text()\"\n"
          + "\t}]\n"
          + "}]";

  public static String doc =
      "<!doctype html>\n"
          + "<html lang=\"en\">\n"
          + "<head>\n"
          + "    <meta charset=\"UTF-8\">\n"
          + "    <meta name=\"viewport\"\n"
          + "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
          + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
          + "    <title>Document</title>\n"
          + "</head>\n"
          + "<body>\n"
          + "<ul>\n"
          + "    <li>\n"
          + "        <span>name</span>\n"
          + "    </li>\n"
          + "    <li><span>age</span></li>\n"
          + "    <li><span>gender</span></li>\n"
          + "    <li><span>friends</span></li>\n"
          + "</ul>\n"
          + "</body>\n"
          + "</html>";

  public static void main(String[] args) {
    HtmlParser htmlParser = new HtmlParser();
    Map<String, Object> parser =
        htmlParser.parser(doc, JSON.parseArray(configStr, FieldConfig.class));
    System.out.println(JSON.toJSONString(parser));
  }
}
