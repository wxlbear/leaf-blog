package xyz.bbear.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Picture.
 *
 * @author xiongliu wu 2019-03-31 19:44
 */
@Data
@TableName("picture")
public class Picture extends BaseModel<Picture> {

  /** picture path. */
  private String path;

  /** 图片名称. */
  private String fileName;

  /** 图片宽度. */
  private Integer width;

  /** 图片高度. */
  private Integer height;

  /** 图片描述. */
  private String description;
}
