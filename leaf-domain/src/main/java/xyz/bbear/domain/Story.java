package xyz.bbear.domain;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Story.
 *
 * @author xiongliu wu 2019-04-18 13:43
 */
@Data
@TableName("story")
public class Story extends BaseModel<Story> {

  /** title. */
  @TableField(value = "title", condition = SqlCondition.LIKE)
  private String title;

  /** story content. */
  @TableField(value = "content", condition = SqlCondition.LIKE)
  private String content;
}
