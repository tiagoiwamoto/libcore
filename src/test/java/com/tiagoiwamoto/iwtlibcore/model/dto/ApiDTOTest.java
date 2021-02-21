package com.tiagoiwamoto.iwtlibcore.model.dto;

import com.tiagoiwamoto.iwtlibcore.sql.PojoTest;
import org.junit.Assert;
import org.junit.Test;


/*
    # Tiago Henrique Iwamoto
    # 60003083
    # tiago.iwamoto@midwayfinanceira.com.br
    # 19/02/2021 - 16:54
*/

public class ApiDTOTest {

    @Test
    public void testApiDto(){
        ApiDTO<PojoTest> apiDTO = new ApiDTO<>();
        apiDTO = new ApiDTO<>("0", "success", new PojoTest())
        .withCode("1")
        .withMessage("new success")
        .withDetail(new PojoTest());
        Assert.assertNotNull(apiDTO.getCode());
        Assert.assertNotNull(apiDTO.getMessage());
        Assert.assertNotNull(apiDTO.getDetails());
        Assert.assertNotNull(apiDTO.getProtocol());
        Assert.assertNotNull(apiDTO.getTimestamp());
        Assert.assertNotNull(apiDTO.toString());

    }

}
