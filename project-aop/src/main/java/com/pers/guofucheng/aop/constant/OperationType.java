package com.pers.guofucheng.aop.constant;

/**
 * @author guofucheng
 */

public enum OperationType {
    INSERT(1,"新增"),
    DELETE(2,"删除"),
    SELECT(3,"查询"),
    UPDATE(4,"修改");
    private Integer index;
    private String name;

    OperationType(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
