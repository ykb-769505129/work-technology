package com.example.util.generator.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 76950
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString(callSuper = true)
public class TreeEntity<E, T extends Serializable> {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    protected T id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    protected String label;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    protected T parentId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序号")
    protected Integer sortValue;

    @ApiModelProperty(value = "子节点", hidden = true)
    protected List<E> children;

    /**
     * 初始化子类
     */
    public void initChildren(){
        if (getChildren() == null){
            this.setChildren(new ArrayList<>());
        }
    }

}
