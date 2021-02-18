package com.tiagoiwamoto.iwtlibcore.factory;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 18/02/2021 | 07:38
 */

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.Serializable;

public class IwtMapper implements Serializable {
    private static final long serialVersionUID = -2545229936090673379L;

    private ObjectMapper mapper;

    public IwtMapper() {
        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
    }

    public ObjectMapper build(){
        return this.mapper;
    }
}
