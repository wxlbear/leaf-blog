package xyz.bbear.leaf.crawler.bear;

import lombok.Data;

/**
 * Response.
 *
 * @author xiongliu wu 2019-05-08 15:18
 */
@Data
public class CrawlerResponse {
    private ResponseCode responseCode;
    private String content;
}
