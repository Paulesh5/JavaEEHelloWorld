package com.example.javaeehelloworld;

import jakarta.annotation.Resource;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;

@ApplicationScoped
public class DataSourceProvider {
    @Produces
    @Resource(lookup = "java:app/jdbc/sample")
    private DataSource dataSource;
}
