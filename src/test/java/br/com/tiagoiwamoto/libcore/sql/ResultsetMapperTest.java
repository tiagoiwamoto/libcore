package br.com.tiagoiwamoto.libcore.sql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 17/02/2021 - 16:26
*/

public class ResultsetMapperTest {

    @Test
    public void serialize() throws Exception {
        String url = "jdbc:sqlite:src/test/resources/teste-db.db";
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tb_teste_types");
        List<IwtPojo> result = new ResultsetMapper<IwtPojo>().serialize(rs);
        conn.close();
//        Assertions.assertEquals(result.get(0).getId(), 1);
//        Assertions.assertEquals(result.get(0).getName(), "Nome completo");
//        Assertions.assertEquals(result.get(0).getFieldBigdecimal(), 12345678965432112L);
//        Assertions.assertEquals(result.get(0).getFieldDecimal(), 10.2);
//        Assertions.assertEquals(result.get(0).getCreatedAt(), LocalDateTime.of(2021, 2, 16, 23, 52, 36));
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void serializeError() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.next()).thenReturn(true);

        Assertions.assertThrows(
                Exception.class, () -> new ResultsetMapper<>().serialize(resultSet)
        );
    }

}
