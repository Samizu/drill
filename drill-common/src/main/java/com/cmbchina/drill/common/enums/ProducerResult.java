package com.cmbchina.drill.common.enums;

public enum ProducerResult {

    SUCCESS("成功"),
    FAILURE("失败"),
    ;

    private String desc;

    ProducerResult(String desc) {
        this.desc = desc;
    }

    public String desc() {
        return desc;
    }

}
