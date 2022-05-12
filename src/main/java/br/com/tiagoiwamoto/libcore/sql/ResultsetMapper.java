package br.com.tiagoiwamoto.libcore.sql;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 16/02/2021 | 07:20
 */

import com.fasterxml.jackson.core.type.TypeReference;
import br.com.tiagoiwamoto.libcore.exception.ResultsetConvertException;
import br.com.tiagoiwamoto.libcore.factory.IwtMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serial;
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

    @Serial
    private static final long serialVersionUID = -8613892522949576847L;

    Logger log = LogManager.getLogger(ResultsetMapper.class.getName());

    /**
     * Convert a resultset into a list of map or to a list of your object
     * @param resultSet
     * @return a list of map or customized object
     * @throws Exception when the convertion failed
     */
    public List<T> serialize(ResultSet resultSet) throws ResultsetConvertException {

        log.info("starting walking to resultset");

        try{
            List<Map<String, Object>> resultList = new LinkedList<>();
            while(resultSet.next()){
                Map<String, Object> map = new HashMap<>();
                log.info("resultset have {} records", resultList.size());
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
                            log.error("failed to map your resultset because one or more columns type is not supported.");
                            throw new ResultsetConvertException("failed to map your resultset because one or more columns type is not supported.");
                        }
                    }
                }
                resultList.add(map);
            }
            return new IwtMapper().build().convertValue(resultList, new TypeReference<List<T>>(){});
        }catch (Exception e){
            log.error("Failed to convert your object", e);
            throw new ResultsetConvertException("Failed to convert your object", e);
        }

    }

    /**
     * For get a word like 'field_from_data_base' to fieldFromDataBase
     * @param column to be converted
     * @return a string with value converted
     */
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
                    columnToJava += columns[currentWord].substring(0, 1).toUpperCase().concat(
                            columns[currentWord].substring(1)).toLowerCase();
                }
            }

            return columnToJava;
        }
    }
}
