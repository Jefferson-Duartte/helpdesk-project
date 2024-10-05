package com.jefferson.helpdesk.domain.enums;

import lombok.Getter;

@Getter
public enum PRIORITY {
    LOW(0, "LOW"),
    NORMAL(1, "NORMAL"),
    HIGH(2, "HIGH");

    private final Integer CODE;
    private final String DESCRIPTION;

    PRIORITY(Integer code, String description) {
        this.CODE = code;
        this.DESCRIPTION = description;
    }

    public static PRIORITY toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (PRIORITY p : PRIORITY.values()) {
            if (code.equals(p.getCODE())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid priority");
    }

}
