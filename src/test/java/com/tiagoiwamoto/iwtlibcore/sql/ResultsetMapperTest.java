package com.tiagoiwamoto.iwtlibcore.sql;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;


/*
    # Tiago Henrique Iwamoto
    # 60003083
    # tiago.iwamoto@midwayfinanceira.com.br
    # 17/02/2021 - 16:26
*/

public class ResultsetMapperTest {

    @Test
    public void serialize() throws Exception {
        String url = "jdbc:sqlite:src/test/resources/teste-db.db";
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tb_teste_types");
        List<Map<String, Object>> result = new ResultsetMapper().serialize(rs);
        conn.close();
        Assert.assertNotNull(result);
    }

    @Test(expected = Exception.class)
    public void serializeError() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.next()).thenReturn(true);
        new ResultsetMapper().serialize(resultSet);
    }

}
