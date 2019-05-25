package by.sobol.contact.book.project.web.controller;

import static by.sobol.contact.book.project.web.action.ActionManager.determineAction;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.REAUEST_PARAM_COMMAND;
import static by.sobol.contact.book.project.web.action.util.WebControllerConstantPool.ERROR_IN_MAIN_SERVLET;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.sobol.contact.book.project.web.action.BaseAction;

public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(MainServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		BaseAction action = determineAction(request.getParameter(REAUEST_PARAM_COMMAND));
		String page;
		try {
			page = action.chooseAction(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException ex) {
			LOG.error(ERROR_IN_MAIN_SERVLET, ex);

		}
	}
}
