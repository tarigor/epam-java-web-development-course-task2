package by.epam.textparserproject.controller;

import by.epam.textparserproject.command.Command;
import by.epam.textparserproject.command.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class provides front controller of Web application which is handlers the http requests from the client and
 * processes this request.
 * @author Igor Taren
 */
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    /**
     * Method processes the http request received from the web page.
     *
     * @param request  Provides request information for HTTP servlets.
     * @param response Provides HTTP-specific functionality in sending a response.
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty.
     * @throws IOException      Class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.selectCommand(request);
        command.execute(request, response);
    }
}
