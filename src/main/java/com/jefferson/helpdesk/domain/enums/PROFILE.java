package com.jefferson.helpdesk.domain.enums;

import lombok.Getter;

@Getter
public enum PROFILE {
    ADMIN(0, "ROLE_ADMIN"),
    CLIENT(1, "ROLE_CLIENT"),
    TECHNICAL(2, "ROLE_TECHNICAL");

    private final Integer CODE;
    private final String DESCRIPTION;

    PROFILE(Integer code, String description) {
        this.CODE = code;
        this.DESCRIPTION = description;
    }

    public static PROFILE toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (PROFILE p : PROFILE.values()) {
            if (code.equals(p.getCODE())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid profile");
    }

}
