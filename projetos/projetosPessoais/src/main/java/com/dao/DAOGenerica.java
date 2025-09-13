package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public abstract class DAOGenerica {

    private static DataSource dataSource;

    public static void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    protected DataSource getDataSource() {
        if (dataSource == null) {
            throw new IllegalStateException("DataSource não configurado!");
        }
        return dataSource;
    }

    protected Connection getConexao() throws SQLException {
        return getDataSource().getConnection();
    }

    protected void fechaConexao(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
