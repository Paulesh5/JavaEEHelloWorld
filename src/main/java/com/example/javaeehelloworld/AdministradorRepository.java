package com.example.javaeehelloworld;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class AdministradorRepository {
    @Inject
    private DataSource  dataSource;
    private static final Logger LOG = Logger.getLogger(AdministradorRepository.class.getName());
    public List<Administrador> getAdministradorList(){
        List<Administrador> administradoresList = new ArrayList<>();
        try(Connection conn= dataSource.getConnection()) {
            try(Statement stnt=conn.createStatement()) {
                try (ResultSet rs = stnt.executeQuery("select * from ADMINISTRADOR")) {
                    while (rs.next()) {
                        administradoresList.add(
                                new Administrador(rs.getString("Usuario"),
                                        rs.getString("Password"))
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return administradoresList;
    }
}
