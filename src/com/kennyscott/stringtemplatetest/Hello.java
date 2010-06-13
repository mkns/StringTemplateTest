package com.kennyscott.stringtemplatetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;

public class Hello extends HttpServlet {

	private static final long serialVersionUID = -746481950154671767L;
	private Logger log = Logger.getLogger(com.kennyscott.stringtemplatetest.Hello.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			StringTemplate template = new StringTemplate(getTemplate("templates/hello.txt"));
			template.setAttribute("text", "Ooo arrrr! (poor pirate impression, granted)");
			pw.println(template);
		} catch (Exception e) {
			log.error(e);
			return;
		}
	}

	private String getTemplate(String templateLocation) throws Exception {
		InputStream is = Hello.class.getClassLoader().getResourceAsStream(templateLocation);
        StringBuilder sb = new StringBuilder();
		if (is != null) {
			log.info("OK, it's not null, at least");
            String line;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }
            return sb.toString();
        }
		else {
			log.info("Aye, it was null.  Fuck.");
		}
		return null;
	}
}
