package com.chestnut.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Chestnut
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

    private String message;

    @Override
    public void init() {
        message = "Hello ";
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println(message);
        System.out.println("doget");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }
}
