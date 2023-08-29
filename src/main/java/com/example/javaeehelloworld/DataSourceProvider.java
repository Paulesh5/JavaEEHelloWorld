package com.example.javaeehelloworld;

import jakarta.annotation.Resource;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;

@DataSourceDefinition(
        name = "java:app/jdbc/administrador-sample",
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        databaseName = "ADMINISTRADOR",
        user = "root",
        password = "root_bas3",
        portNumber = 23306,
        properties = {
                "allowPublicKeyRetrieval=true",
                "serverTimezone=America/Lima",
                "useSSL=false"
        }
)
@ApplicationScoped
public class DataSourceProvider {
    @Produces
    @Resource(lookup = "java:app/jdbc/administrador-sample")
    private DataSource dataSource;
}
