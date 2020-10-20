package com.softexpansion.searchlibrary.enums;

public enum Role{
    USER("User"), LIBRARIAN("Librarian");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
