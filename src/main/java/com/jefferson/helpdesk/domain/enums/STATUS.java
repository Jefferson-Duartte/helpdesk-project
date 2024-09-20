package com.jefferson.helpdesk.domain.enums;

public enum STATUS {
    OPEN(0, "OPEN"),
    PROGRESS(1, "PROGRESS"),
    CLOSED(2, "CLOSED");

    private Integer code;
    private String description;

    STATUS(Integer code, String description) {
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

    public static STATUS toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (STATUS p : STATUS.values()) {
            if (code.equals(p.getCode())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid status");
    }

}
