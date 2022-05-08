package br.com.tiagoiwamoto.libcore.model.dto;

import br.com.tiagoiwamoto.libcore.sql.PojoTest;
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
        SuccessResponseDto<PojoTest> successResponseDto = new SuccessResponseDto<>();
        successResponseDto = new SuccessResponseDto<>("0", "success", new PojoTest())
        .withCode("1")
        .withMessage("new success")
        .withDetail(new PojoTest());
        Assert.assertNotNull(successResponseDto.getCode());
        Assert.assertNotNull(successResponseDto.getMessage());
        Assert.assertNotNull(successResponseDto.getData());
        Assert.assertNotNull(successResponseDto.getProtocol());
        Assert.assertNotNull(successResponseDto.getTimestamp());
        Assert.assertNotNull(successResponseDto.toString());

    }

}
