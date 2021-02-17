package com.tiagoiwamoto.iwtlibcore.sql;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 16/02/2021 | 07:20
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ResultsetMapper<T> implements Serializable {

    private static final long serialVersionUID = -8613892522949576847L;

    public List<T> serialize(ResultSet resultSet) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());

        try{
            List<Map<String, Object>> resultList = new LinkedList<>();
            while(resultSet.next()){
                Map<String, Object> map = new HashMap<>();

                for(int column = 1; column <= resultSet.getMetaData().getColumnCount(); column++){
                    if(resultSet.getObject(column) != null){
                        final String currentColumnType = resultSet.getObject(column).getClass().getSimpleName();
                        Optional<ResultsetFieldsEnum> optionalSqlEnum = Arrays.stream(ResultsetFieldsEnum.values())
                                .filter((ResultsetFieldsEnum value) -> value.getClassSimpleName().equals(currentColumnType))
                                .findFirst();
                        if(optionalSqlEnum.isPresent()){
                            ResultsetFieldsEnum resultsetFieldsEnum = optionalSqlEnum.get();
                            Method method = resultSet.getClass().getMethod(resultsetFieldsEnum.getMethodToCall(), int.class);
                            map.put(this.convertColumnToJava(resultSet.getMetaData().getColumnLabel(column)),
                                    method.invoke(resultSet, column)
                            );
                        }else{
                            throw new Exception("Unmaped column type");
                        }
                    }
                }
                resultList.add(map);
            }
            List<T> objList = mapper.convertValue(resultList, new TypeReference<List<T>>(){});
            return objList;
        }catch (Exception e){
            throw new Exception("Failed to convert your object", e);
        }

    }

    private String convertColumnToJava(String column) {

        if(column == null || column.isEmpty()){
            return "column";
        }else{
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
}
