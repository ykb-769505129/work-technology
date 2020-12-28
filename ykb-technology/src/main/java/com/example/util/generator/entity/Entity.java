package com.example.util.generator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@ToString(callSuper = true)
@Getter
@Setter
public class Entity<T> extends SuperEntity<T> {

    public static final String UPDATE_TIME = "updateTime";
    public static final String UPDATE_USER = "updateUserId";
    private static final long serialVersionUID = 5169873634279173683L;

    @ApiModelProperty(value = "最后修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

    @ApiModelProperty(value = "最后修改人ID")
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    @JsonSerialize(using= ToStringSerializer.class)
    protected T updateUserId;

    public Entity(T id, LocalDateTime createTime, T createUser, LocalDateTime updateTime, T updateUserId) {
        super(id, createTime, createUser);
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
    }

    public Entity() {
    }

}
