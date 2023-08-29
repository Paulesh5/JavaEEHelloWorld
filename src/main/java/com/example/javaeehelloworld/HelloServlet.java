package com.example.javaeehelloworld;

import java.io.*;
import java.sql.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    static final String DB_URL="jdbc:mysql://localhost/FARMACIA";
    static final String USER="root";
    static final String PASS="root_bas3";
    static final String QUERY= "SELECT * FROM ADMINISTRADOR";
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY + " WHERE Usuario='Administrador1'");
            String columnName = resultSet.getString("Usuario");
            out.println("<p>" + "HOLAAAA" + "</p>");
            out.println("<p>" + columnName + "</p>");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        out.println("<p>" + "HOLAAAA2" + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
