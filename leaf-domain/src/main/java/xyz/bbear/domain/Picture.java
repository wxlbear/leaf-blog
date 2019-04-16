package xyz.bbear.domain;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
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
  @TableField(value = "path", condition = SqlCondition.LIKE)
  private String path;

  /** 图片名称. */
  @TableField(value = "name", condition = SqlCondition.LIKE)
  private String name;

  /** 图片宽度. */
  private Integer width;

  /** 图片高度. */
  private Integer height;

  /** 图片描述. */
  @TableField(value = "description", condition = SqlCondition.LIKE)
  private String description;
}
