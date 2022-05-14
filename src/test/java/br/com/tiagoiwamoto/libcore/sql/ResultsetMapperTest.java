package br.com.tiagoiwamoto.libcore.sql;

import br.com.tiagoiwamoto.libcore.factory.IwtMapper;
import com.fasterxml.jackson.core.type.TypeReference;
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
        var mapper = new ResultsetMapper<IwtPojo>();
        List<IwtPojo> result = mapper.serialize(rs);
        conn.close();
        var resultConverted = new IwtMapper().build().convertValue(result, new TypeReference<List<IwtPojo>>() {});
        Assertions.assertEquals(2, resultConverted.size());
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
