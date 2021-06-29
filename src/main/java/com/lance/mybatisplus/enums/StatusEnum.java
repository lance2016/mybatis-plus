package com.lance.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {

    WORK(0,"休息"),
    REST(1,"工作");

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    @JsonValue
    public String getMsg() {
        return msg;
    }

    @EnumValue
    private Integer code;

    private String msg;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static StatusEnum getItem(Integer code){
        for(StatusEnum item : StatusEnum.values()){
            if(item.getCode().equals(code)){
                return item;
            }
        }
        return null;
    }
}
