package com.tiagoiwamoto.iwtlibcore.sql;

/*
    # Tiago Henrique Iwamoto
    # 60003083
    # tiago.iwamoto@midwayfinanceira.com.br
    # 17/02/2021 - 17:23
*/

import java.time.LocalDateTime;

public class PojoTest {

    private Integer id;
    private String name;
    private String fieldBlob;
    private String fieldDecimal;
    private String fieldBigdecimal;
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldBlob() {
        return fieldBlob;
    }

    public void setFieldBlob(String fieldBlob) {
        this.fieldBlob = fieldBlob;
    }

    public String getFieldDecimal() {
        return fieldDecimal;
    }

    public void setFieldDecimal(String fieldDecimal) {
        this.fieldDecimal = fieldDecimal;
    }

    public String getFieldBigdecimal() {
        return fieldBigdecimal;
    }

    public void setFieldBigdecimal(String fieldBigdecimal) {
        this.fieldBigdecimal = fieldBigdecimal;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
