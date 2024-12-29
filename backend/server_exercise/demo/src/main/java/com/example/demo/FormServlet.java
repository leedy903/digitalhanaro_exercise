package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/form.do")
public class FormServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        System.out.println("FormServlet.init execute");
        message = "Hello World!";
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FormServlet.service execute");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FormServlet.doPost call");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("id: " + id + "<br/>");
        out.print("pwd: " + pwd);
        out.close();
    }

    public void destroy() {
    }
}