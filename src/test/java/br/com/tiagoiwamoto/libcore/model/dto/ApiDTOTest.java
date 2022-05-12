package br.com.tiagoiwamoto.libcore.model.dto;

import br.com.tiagoiwamoto.libcore.sql.IwtPojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


/*
    # Tiago Henrique Iwamoto
    # 60003083
    # tiago.iwamoto@midwayfinanceira.com.br
    # 19/02/2021 - 16:54
*/

public class ApiDTOTest {

    @Test
    public void testApiDto(){
        var pojoTest = new IwtPojo();
        SuccessResponseDto<IwtPojo> successResponseDto = SuccessResponseDto.of("0", "success", pojoTest);
        Assertions.assertEquals("0", successResponseDto.getCode());
        Assertions.assertEquals("success", successResponseDto.getMessage());
        Assertions.assertEquals(pojoTest, successResponseDto.getData());
        Assertions.assertEquals(32, successResponseDto.getProtocol().length());
        Assertions.assertEquals(LocalDateTime.now().getYear(), successResponseDto.getTimestamp().getYear());
        Assertions.assertNotNull(successResponseDto.toString());

    }

}
