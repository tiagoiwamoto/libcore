package com.tiagoiwamoto.iwtlibcore.tdd;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 16/02/2021 | 20:30
 */

import com.tiagoiwamoto.iwtlibcore.sql.SqlMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class SqliteJdbcTDD {


    public static void main(String[] args) throws Exception {
        String url = "jdbc:sqlite:src/main/resources/teste-db.db";
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tb_teste_types");
        List<Map<String, Object>> result = new SqlMap().serialize(rs);
        conn.close();
    }

}
