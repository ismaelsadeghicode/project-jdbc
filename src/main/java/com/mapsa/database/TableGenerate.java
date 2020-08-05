package com.mapsa.database;

import com.mapsa.persistence.Column;
import com.mapsa.persistence.Table;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Esmaeil Sadeghi, 8/5/20 4:31 PM
 */
public class TableGenerate {
    public void create(Object object) throws SQLException {
        DBConnection dbConnection = DBConnection.getInstance();
        Connection connection = null;
        try {
            connection = dbConnection.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        String query = "CREATE TABLE " + table.name() + " (";
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Column) {
                    Column column = field.getAnnotation(Column.class);
                    query += column.name() + " " + column.dataType() + "(" + column.length() + "),";
                }
            }
        }
        if (query.trim().endsWith(",")) {
            query = query.substring(0, query.length() - 1);
        }
        query += ")";
        System.out.println(query);
        assert connection != null;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
    }
}
