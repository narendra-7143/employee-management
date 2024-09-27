package com.exm.fp.enums;

public enum StatusType {

    ACTIVE, INACTIVE, DELETED;
    private static StatusType[] allValues = values();

    public static StatusType fromOrdinal(int n) {
        return allValues[n];
    }
}
