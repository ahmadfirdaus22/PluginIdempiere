package com.red.eventhandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserApiHandler extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder requestData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestData.append(line);
        }

        System.out.println("Request Data: " + requestData.toString());

        response.setContentType("text/plain");
        response.getWriter().write("Response from MyAPIServlet");
    }
}
