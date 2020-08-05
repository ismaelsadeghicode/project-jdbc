package com.mapsa.database;

import com.mapsa.persistence.Column;
import com.mapsa.persistence.Table;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Esmaeil Sadeghi, 8/5/20 6:19 PM
 */
public class CRUD {

    DBConnection dbConnection = null;
    Connection connection = null;

    public void save(Object object) throws IllegalAccessException {
        String query = "INSERT INTO ";
        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        query += table.name() + " (";
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                query += column.name() + ",";

            }
        }
        if (query.trim().endsWith(",")) {
            query = query.substring(0, query.length() - 1);
        }
        query += ") VALUES (";
        for (Field field : fields) {
            if (field.getType().getSimpleName().endsWith("String")) {
                query += "'" + field.get(object) + "'" + ",";
            } else {
                query += field.get(object) + ",";
            }
        }
        if (query.trim().endsWith(",")) {
            query = query.substring(0, query.length() - 1);
        }
        query += ")";
        System.out.println(query);
        dbConnection = DBConnection.getInstance();
        try {
            connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
