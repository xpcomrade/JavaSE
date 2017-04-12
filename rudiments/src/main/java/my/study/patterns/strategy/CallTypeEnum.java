package my.study.patterns.strategy;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (通话类型). <br/>
 */
public enum CallTypeEnum {

    LOCAL_CALL(1, "本地通话"),
    PROVINCIAL_CALL(2, "省际通话"),
    INTERNATIONAL_CALL(3, "国际电话");

    private int type;
    private String description;

    public static CallTypeEnum valueOf(int type){
        for (CallTypeEnum callType : CallTypeEnum.values()) {
            if (callType.type == type) {
                return callType;
            }
        }

        return null;
    }

    private CallTypeEnum(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public int type () {
        return type;
    }
    public String description() {
        return description;
    }


}
