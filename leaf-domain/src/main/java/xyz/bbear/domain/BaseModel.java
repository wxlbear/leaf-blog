package xyz.bbear.domain;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import lombok.Data;

/**
 * BaseModel.
 *
 * @author xiongliu wu 2019/1/2 18:39
 */
@Data
public class BaseModel<T> extends Model {

  /** id. * */
  @TableField(value = "id", condition = SqlCondition.EQUAL)
  @TableId
  private Long id;

  /** created_at. */
  @TableField(value = "created_at")
  private Date createdAt;

  /** updated_at. */
  @TableField(value = "updated_at")
  private Date updatedAt;

  /** status. */
  @TableField(value = "status", condition = SqlCondition.EQUAL)
  @TableLogic(delval = "0", value = "1")
  private Integer status;

  /** 排序字段. */
  @JsonIgnore
  @TableField(exist = false)
  private String sort = "id";

  /** 排序规则. */
  @JsonIgnore
  @TableField(exist = false)
  private boolean isAsc;
}
