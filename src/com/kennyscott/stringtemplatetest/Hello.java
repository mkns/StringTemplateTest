package com.kennyscott.stringtemplatetest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Hello extends HttpServlet {

	private static final long serialVersionUID = -746481950154671767L;
	private Logger log = Logger.getLogger(com.kennyscott.stringtemplatetest.Hello.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("Hello!");
		log.info("Hello...");
	}

}
