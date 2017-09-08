package com.acedemand.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.StatementCallback;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by Pamir on 4/14/2015.
 */
public class TestDao implements InitializingBean{

    private static final String INSERT_SQL = "insert into test_table(id) values(?)";

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void insert(final Long id){
        jdbcTemplate.execute(INSERT_SQL, new PreparedStatementCallback<Boolean>(){

            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setLong(1,id);
                return preparedStatement.execute();
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
