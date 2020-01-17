package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "TaskSenseValidationServlet", urlPatterns = "/senseValidation.jsp")
public class TaskSenseValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = "/WEB-INF/db/tasks/";
    String example = request.getParameter("example");
    String word = request.getParameter("word");
    String sense = request.getParameter("sense");
    String[] answer = request.getParameterValues("answer");

    File taskFile = new File(request.getServletContext().getRealPath(filePath + "senseValidation.json"));
    TaskManager.saveSenseValidation(taskFile, word, example, sense, answer);
		response.sendRedirect(TaskManager.randomTask("senseValidation.html"));
	}

}
