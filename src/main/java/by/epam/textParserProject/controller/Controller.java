package by.epam.textParserProject.controller;

import by.epam.textParserProject.command.Commands;
import by.epam.textParserProject.command.Command;
import by.epam.textParserProject.command.factory.CommandDefiner;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget");
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost");
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest request, HttpServletResponse response) {
        String commandName;
        if (ServletFileUpload.isMultipartContent(request)) {
            commandName = Commands.PARSE_FROM_FILE.toString();
        } else {
            commandName = request.getParameter("command").toUpperCase();
        }
        System.out.println("command->" + commandName);
        Command command = CommandDefiner.getInstance().selectCommand(Commands.valueOf(commandName));
        command.execute(request,response);
    }
}
