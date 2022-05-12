package br.com.tiagoiwamoto.libcore.sql;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 17/02/2021 - 17:23
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IwtPojo {

    private Integer id;
    private String name;
    private String fieldBlob;
    private String fieldDecimal;
    private String fieldBigdecimal;
    private LocalDateTime createdAt;

}
