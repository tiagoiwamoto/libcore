package com.tiagoiwamoto.iwtlibcore.sql;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 16/02/2021 | 20:10
 */

public enum SqlEnum {
    STRING("String", "getString"),
    INTEGER("Integer", "getInt"),
    LONG("Long", "getLong"),
    DOUBLE("Double", "getDouble"),
    FLOAT("Float", "getFloat"),
    BOOLEAN("Boolean", "getBoolean"),
    BIG_DECIMAL("BigDecimal", "getBigDecimal"),
    TIMESTAMP("Timestamp", "getTimestamp"),
    DATE("Date", "getDate"),
    TIME("Time", "getTime");

    private String classSimpleName;
    private String methodToCall;

    SqlEnum(String classSimpleName, String methodToCall) {
        this.classSimpleName = classSimpleName;
        this.methodToCall = methodToCall;
    }

    public String getClassSimpleName() {
        return classSimpleName;
    }

    public String getMethodToCall() {
        return methodToCall;
    }
}
