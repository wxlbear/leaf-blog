package xyz.bbear.domain;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Picture.
 *
 * @author xiongliu wu 2019-03-31 19:44
 */
@Data
@TableName("picture")
@Accessors(chain = true)
public class Picture extends BaseModel<Picture> {

  /** 图片名称. */
  @TableField(value = "name", condition = SqlCondition.LIKE)
  private String name;

  /** ossName. */
  private String ossName;

  /** 图片格式. */
  private String format;

  /** picture path. */
  @TableField(value = "path", condition = SqlCondition.LIKE)
  private String path;

  /** 图片宽度. */
  private Integer width;

  /** 图片高度. */
  private Integer height;

  /** 图片描述. */
  @TableField(value = "description", condition = SqlCondition.LIKE)
  private String description;
}
