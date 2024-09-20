package com.jefferson.helpdesk.domain.enums;

public enum PROFILE {
    ADMIN(0, "ROLE_ADMIN"),
    CLIENT(1, "ROLE_CLIENT"),
    TECHNICAL(2, "ROLE_TECHNICAL");

    private Integer code;
    private String description;

    PROFILE(Integer code, String description) {
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

    public static PROFILE toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (PROFILE p : PROFILE.values()) {
            if (code.equals(p.getCode())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid profile");
    }

}
