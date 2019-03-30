package xyz.bbear.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;

/**
 * BaseModel.
 *
 * @author xiongliu wu 2019/1/2 18:39
 */
@Data
public class BaseModel<T> extends Model {

  @TableId private Long id;

  private Date createdAt;

  private Date updatedAt;

  private Integer status;
}
