package br.com.tiagoiwamoto.libcore.factory;

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

import java.io.Serial;
import java.io.Serializable;

public class IwtMapper implements Serializable {

    @Serial
    private static final long serialVersionUID = -2545229936090673379L;

    private final ObjectMapper mapper;

    public IwtMapper() {
        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.findAndRegisterModules();
    }

    /**
     *
     * @return a mapper configured to ignore unknown properties and javatime module registered
     */
    public ObjectMapper build(){
        return this.mapper;
    }
}
