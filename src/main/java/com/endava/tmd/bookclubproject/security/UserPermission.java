package com.endava.tmd.bookclubproject.security;

public enum UserPermission {
    USER_ADDBOOK("user:addbook"),
    USER_BORROWBOOK("user:borrowbook");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}