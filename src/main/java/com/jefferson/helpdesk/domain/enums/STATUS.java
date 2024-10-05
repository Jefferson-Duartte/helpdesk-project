package com.jefferson.helpdesk.domain.enums;

import lombok.Getter;

@Getter
public enum STATUS {
    OPEN(0, "OPEN"),
    PROGRESS(1, "PROGRESS"),
    CLOSED(2, "CLOSED");

    private final Integer CODE;
    private final String DESCRIPTION;

    STATUS(Integer code, String description) {
        this.CODE = code;
        this.DESCRIPTION = description;
    }

    public static STATUS toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (STATUS p : STATUS.values()) {
            if (code.equals(p.getCODE())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid status");
    }

}
