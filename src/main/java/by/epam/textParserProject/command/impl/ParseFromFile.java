package by.epam.textParserProject.command.impl;

import by.epam.textParserProject.command.BaseCommand;
import by.epam.textParserProject.command.Command;
import by.epam.textParserProject.service.factory.ServiceFactory;

public class ParseFromFile extends BaseCommand implements Command {
    @Override
    public void execute() {
        System.out.println("here");
        for (int i = 0; i < textInListLineByLine.size(); i++) {
            if (ServiceFactory.getInstance().getParserService().checkIfLineBeginningOfParagraph(textInListLineByLine.get(i))) {
                System.out.println("is beginning of paragraph->" + textInListLineByLine.get(i));
            }
        }
    }
}
