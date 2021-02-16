package com.tiagoiwamoto.iwalibcore.sql;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 16/02/2021 | 07:20
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SqlMap implements Serializable {

    private static final long serialVersionUID = -8613892522949576847L;

    public List<Map<String, Object>> serialize(ResultSet resultSet) throws Exception {

        try{
            List<Map<String, Object>> resultList = new LinkedList<>();
            while(resultSet.next()){
                Map<String, Object> map = new HashMap<>();

                for(int column = 1; column <= resultSet.getMetaData().getColumnCount(); column++){
                    if (resultSet.getObject(column).getClass() == String.class) {
                        map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                resultSet.getString(column)
                        );
                    } else if (resultSet.getObject(column).getClass() == Integer.class) {
                        map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                resultSet.getInt(column)
                        );
                    } else if (resultSet.getObject(column).getClass() == Long.class) {
                        map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                resultSet.getLong(column)
                        );
                    } else if (resultSet.getObject(column).getClass() == Double.class) {
                        map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                resultSet.getDouble(column)
                        );
                    } else if (resultSet.getObject(column).getClass() == Float.class) {
                        map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                resultSet.getFloat(column)
                        );
                    } else if (resultSet.getObject(column).getClass() == Boolean.class) {
                        map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                resultSet.getBoolean(column)
                        );
                    } else if (resultSet.getObject(column).getClass() == BigDecimal.class) {
                        map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                resultSet.getBigDecimal(column)
                        );
                    } else if (resultSet.getObject(column).getClass() == Timestamp.class) {
                        try {
                            map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                    resultSet.getTimestamp(column)
                            );
                        } catch (Exception e) {
                            map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                    resultSet.getObject(column)
                            );
                        }
                    } else if (resultSet.getObject(column).getClass() == Date.class) {
                        try {
                            map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                    resultSet.getDate(column)
                            );
                        } catch (Exception e) {
                            map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                    resultSet.getObject(column)
                            );
                        }
                    } else if (resultSet.getObject(column).getClass() == Time.class) {
                        try {
                            map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                    resultSet.getTime(column)
                            );
                        } catch (Exception e) {
                            map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                    resultSet.getObject(column)
                            );
                        }
                    } else {
                        map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                resultSet.getObject(column)
                        );
                    }
                }
                resultList.add(map);
            }
            return resultList;
        }catch (Exception e){
            throw new Exception("Failed to convert your object", e);
        }

    }

    private String convertColumnToJava(String column) throws Exception {

        if(column == null){
            return "column";
        }

        if(column.isEmpty()){
            throw new Exception("Column name is empty");
        }

        /*Starting the variable*/
        String columnToJava = "";

        /* Replace whitespace for '_' */
        column = column.replaceAll("\\s","_");

        /*Split by '_' to create a array of words*/
        String[] columns = column.split("_");

        for(int currentWord = 0; currentWord < columns.length; currentWord++){
            if(currentWord == 0){
                /*Convert the first word to lowercase*/
                columnToJava += columns[currentWord].toLowerCase();
            }else{
                /*Convert the first char to uppercase*/
                columnToJava += columns[currentWord].substring(0, 1).toUpperCase() +
                        columns[currentWord].substring(1).toLowerCase();
            }
        }

        return columnToJava;
    }
}
