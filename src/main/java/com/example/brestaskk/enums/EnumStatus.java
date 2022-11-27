package com.example.brestaskk.enums;

import lombok.Getter;

@Getter
public enum EnumStatus {

    FIZIKI_SHEXS(1,"Fiziki shexs"),
    HUQUQI_SHEXS(2,"Huquqi shexs"),
    ONLINE(1,"Online"),
    OFFLINE(2,"Offline");


    private int code;
    private String  status;

    EnumStatus(int code, String  status) {
        this.code = code;
        this.status = status;
    }
}
