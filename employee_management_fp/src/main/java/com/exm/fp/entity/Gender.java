package com.exm.fp.entity;


public enum Gender {
    MALE, FEMALE, NOT_DISCLOSED;
    private static Gender[] allValues = values();

    public static Gender fromOrdinal(int n) {
        return allValues[n];
    }
}
