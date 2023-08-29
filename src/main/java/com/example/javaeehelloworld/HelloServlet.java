package com.example.javaeehelloworld;

import java.io.*;

import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Inject
    private AdministradorRepository repository;
    @Override
    public void init() {
        message = "Hello World!";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        repository.getAdministradorList()
                        .forEach(administrador -> out.println(String.format("%d - %s<br/>", administrador.getUsuario(), administrador.getPassword())));
        out.println("</body></html>");
    }
    @Override
    public void destroy() {
    }
}