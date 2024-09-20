package com.jefferson.helpdesk.domain.enums;

public enum PRIORITY {
    LOW(0, "LOW"),
    NORMAL(1, "NORMAL"),
    HIGH(2, "HIGH");

    private Integer code;
    private String description;

    PRIORITY(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static PRIORITY toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (PRIORITY p : PRIORITY.values()) {
            if (code.equals(p.getCode())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid priority");
    }

}
