package br.com.tiagoiwamoto.iwtlibcore.sql;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        List<PojoTest> result = new ResultsetMapper<PojoTest>().serialize(rs);
        conn.close();
        Assert.assertNotNull(result);
    }

    @Test(expected = Exception.class)
    public void serializeError() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.next()).thenReturn(true);
        new ResultsetMapper<>().serialize(resultSet);
    }

}
