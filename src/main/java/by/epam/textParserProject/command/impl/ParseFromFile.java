package by.epam.textParserProject.command.impl;

import by.epam.textParserProject.command.BaseCommand;
import by.epam.textParserProject.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParseFromFile extends BaseCommand implements Command {
    /**
     * Method parse the text onto Composite object based on Composite pattern.
     *
     * @param request
     * @param response
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("parse text from file command");
        String text = textFileService.uploadFile(request);
        System.out.println("whole text->" + text);
    }
}
