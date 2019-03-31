package xyz.bbear.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Leaf.
 *
 * @author xiongliu wu 2019-03-30 22:35
 */
@Data
@TableName("leaf")
public class Leaf extends BaseModel<Leaf> {

  private String name;
  private Integer age;
  private String email;
}
